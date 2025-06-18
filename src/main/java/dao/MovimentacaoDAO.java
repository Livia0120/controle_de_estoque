
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import modelo.Movimentacao;

/**
 *
 * @author Livia0120
 */
public class MovimentacaoDAO {

    // Método para entrada de estoque
    public static boolean adicionarEstoque(Movimentacao m) throws SQLException {

        try {
            // Verifica se a quantidade é positiva
            if (m.getQuantidade() <= 0) {
                System.out.println("Quantidade deve ser maior que zero.");
                return false;
            }
        } catch (NullPointerException e) {
            System.out.println("Erro: A quantidade não pode ser nula.");
            return false;
        }

        // Verifica se o produtoId é válido
        try {
            ProdutoDAO produtoDAO = new ProdutoDAO();
            if (produtoDAO.buscarProdutoPorId(m.getProdutoId()) == null) {
                System.out.println("Produto não encontrado.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Erro ao verificar produto: " + e.getMessage());
            return false;
        }

        String sql = "INSERT INTO movimentacoes (produto_id, tipo, quantidade, observacoes) VALUES (?, ?, ?, ?)";

        Connection conexao = null;
        PreparedStatement pst = null;
        boolean sucesso = false;

        try {
            conexao = ModuloConexao.conector();
            if (conexao != null) {
                pst = conexao.prepareStatement(sql);
                pst.setInt(1, m.getProdutoId());
                pst.setString(2, "entrada");
                pst.setInt(3, m.getQuantidade());
                pst.setString(4, m.getObservacoes());

                int linhasAfetadas = pst.executeUpdate();
                if (linhasAfetadas > 0) {

                    System.out.println("Movimentação registrada com sucesso ");
                } else {
                    System.out.println("Falha ao registrar movimentação  ");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao registrar movimentação: " + e.getMessage());
        } finally {

            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar PreparedStatement: " + e.getMessage());
            }
        }
        return false;
    }

    // Método para saída de estoque
    public static boolean removerEstoque(Movimentacao m) throws SQLException {
        try {
            ProdutoDAO produtoDAO = new ProdutoDAO();
            if (produtoDAO.buscarProdutoPorId(m.getProdutoId()) == null) {
                System.out.println("Produto não encontrado.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Erro ao verificar produto: " + e.getMessage());
            return false;
        }

        String sqlAtualizaEstoque = "UPDATE produtos SET quantidade = quantidade - ? WHERE id = ?";
        String sqlRegistraMovimentacao = "INSERT INTO movimentacoes (produto_id, tipo, quantidade, observacoes) VALUES (?, ?, ?, ?)";

        Connection conexao = null;
        PreparedStatement pstAtualiza = null;
        PreparedStatement pstRegistra = null;
        boolean sucesso = false;
        try {
            conexao = ModuloConexao.conector();
            if (conexao != null) {
                // Desabilita o auto-commit para garantir que ambas as operações sejam atômicas
                conexao.setAutoCommit(false);

                // 1. Atualiza o estoque do produto
                pstAtualiza = conexao.prepareStatement(sqlAtualizaEstoque);
                pstAtualiza.setInt(1, m.getQuantidade());
                pstAtualiza.setInt(2, m.getProdutoId());

                int linhasAfetadasAtualizacao = pstAtualiza.executeUpdate();

                if (linhasAfetadasAtualizacao > 0) {
                    System.out.println("Estoque do produto ID " + m.getProdutoId() + " atualizado.");

                    // 2. Registra a movimentação de saída
                    pstRegistra = conexao.prepareStatement(sqlRegistraMovimentacao);
                    pstRegistra.setInt(1, m.getProdutoId());
                    pstRegistra.setString(2, "saida"); // Tipo 'saida'
                    pstRegistra.setInt(3, m.getQuantidade());
                    pstRegistra.setString(4, m.getObservacoes());

                    int linhasAfetadasRegistro = pstRegistra.executeUpdate();

                    if (linhasAfetadasRegistro > 0) {
                        System.out.println(
                                "Movimentação de saída registrada com sucesso para o produto ID: " + m.getProdutoId());
                        conexao.commit(); // Confirma as duas operações se ambas foram bem-sucedidas
                        sucesso = true;
                    } else {
                        System.out.println(
                                "Falha ao registrar movimentação de saída para o produto ID: " + m.getProdutoId());
                        conexao.rollback(); // Desfaz a atualização do estoque se o registro da movimentação falhar
                    }
                } else {
                    System.out.println("Nenhuma atualização de estoque para o produto ID: " + m.getProdutoId()
                            + " (produto não encontrado ou quantidade insuficiente).");
                    conexao.rollback(); // Desfaz qualquer alteração se a atualização do estoque falhar
                }
            }
        } catch (SQLException e) { // Use SQLException para lidar com erros de banco de dados
            System.err.println("Erro ao remover estoque ou registrar movimentação: " + e.getMessage());
            try {
                if (conexao != null) {
                    conexao.rollback(); // Garante o rollback em caso de exceção
                }
            } catch (SQLException rbEx) {
                System.err.println("Erro ao realizar rollback: " + rbEx.getMessage());
            }
        } finally {
            try {
                if (pstAtualiza != null) {
                    pstAtualiza.close();
                }
                if (pstRegistra != null) {
                    pstRegistra.close();
                }
                if (conexao != null) {
                    conexao.setAutoCommit(true); // Volta ao auto-commit padrão
                    conexao.close();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
        return sucesso;
    }

    public static List<Movimentacao> listarmovimentacoes() {
        String sql = "SELECT * FROM movimentacoes";
        List<Movimentacao> lista = new ArrayList<>();

        try (Connection conexao = ModuloConexao.conector();
                PreparedStatement pst = conexao.prepareStatement(sql);
                ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Movimentacao m = new Movimentacao();
                m.setId(rs.getInt("id"));
                m.setProdutoId(rs.getInt("produto_id"));
                m.setTipo(rs.getString("tipo"));
                m.setQuantidade(rs.getInt("quantidade"));
                m.setObservacoes(rs.getString("observacoes"));
                Timestamp dataHora = Timestamp.valueOf(rs.getString("data_movimentacao"));
                if (dataHora != null) {
                    m.setDataMovimentacao(dataHora);
                }

                lista.add(m);
            }

        } catch (SQLException e) {
            System.out.println("Não foi possível listar as movimentações: " + e.getMessage());
        }

        return lista;
    }

    public static List<Movimentacao> buscarmovimentacoesPorProdutoId(int produtoId) {
        String sql = "SELECT * FROM movimentacoes WHERE produto_id = ?";
        List<Movimentacao> lista = new ArrayList<>();

        try (Connection conexao = ModuloConexao.conector();
                PreparedStatement pst = conexao.prepareStatement(sql)) {

            pst.setInt(1, produtoId);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Movimentacao m = new Movimentacao();
                m.setId(rs.getInt("id"));
                m.setProdutoId(rs.getInt("produto_id"));
                m.setTipo(rs.getString("tipo"));
                m.setQuantidade(rs.getInt("quantidade"));
                m.setObservacoes(rs.getString("observacoes"));
                Timestamp dataHora = Timestamp.valueOf(rs.getString("data_movimentacao"));
                if (dataHora != null) {
                    m.setDataMovimentacao(dataHora);
                }

                lista.add(m);
            }

        } catch (SQLException e) {
            System.out.println("Não foi possível buscar as movimentações: " + e.getMessage());
        }

        return lista;
    }

    public static List<Movimentacao> listarmovimentacoesPorTipo(String tipo) {
        String sql = "SELECT * FROM movimentacoes WHERE tipo = ?";
        List<Movimentacao> lista = new ArrayList<>();

        try (Connection conexao = ModuloConexao.conector();
                PreparedStatement pst = conexao.prepareStatement(sql)) {

            pst.setString(1, tipo);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Movimentacao m = new Movimentacao();
                m.setId(rs.getInt("id"));
                m.setProdutoId(rs.getInt("produto_id"));
                m.setTipo(rs.getString("tipo"));
                m.setQuantidade(rs.getInt("quantidade"));
                m.setObservacoes(rs.getString("observacoes"));
                Timestamp dataHora = Timestamp.valueOf(rs.getString("data_movimentacao"));
                if (dataHora != null) {
                    m.setDataMovimentacao(dataHora);
                }

                lista.add(m);
            }

        } catch (SQLException e) {
            System.out.println("Não foi possível listar as movimentações por tipo: " + e.getMessage());
        }

        return lista;
    }

    public static Movimentacao buscarMovimentacaoPorId(int id) {
        String sql = "SELECT * FROM movimentacoes WHERE id = ?";
        Movimentacao m = null;

        try (Connection conexao = ModuloConexao.conector();
                PreparedStatement pst = conexao.prepareStatement(sql)) {

            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                m = new Movimentacao();
                m.setId(rs.getInt("id"));
                m.setProdutoId(rs.getInt("produto_id"));
                m.setTipo(rs.getString("tipo"));
                m.setQuantidade(rs.getInt("quantidade"));
                m.setObservacoes(rs.getString("observacoes"));
                Timestamp dataHora = Timestamp.valueOf(rs.getString("data_movimentacao"));
                if (dataHora != null) {
                    m.setDataMovimentacao(dataHora);
                }
            }

        } catch (SQLException e) {
            System.out.println("Não foi possível buscar a movimentação: " + e.getMessage());
        }

        return m;
    }

    public static boolean atualizarMovimentacao(Movimentacao m) {
        String sql = "UPDATE movimentacoes SET produto_id = ?, tipo = ?, quantidade = ?, observacoes = ? WHERE id = ?";

        try (Connection conexao = ModuloConexao.conector();
                PreparedStatement pst = conexao.prepareStatement(sql)) {

            pst.setInt(1, m.getProdutoId());
            pst.setString(2, m.getTipo());
            pst.setInt(3, m.getQuantidade());
            pst.setString(4, m.getObservacoes());
            pst.setInt(5, m.getId());

            int linhasAfetadas = pst.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            System.out.println("Não foi possível atualizar a movimentação: " + e.getMessage());
            return false;
        }
    }

    public static boolean excluirMovimentacao(int id) {
        String sql = "DELETE FROM movimentacoes WHERE id = ?";

        try (Connection conexao = ModuloConexao.conector();
                PreparedStatement pst = conexao.prepareStatement(sql)) {

            pst.setInt(1, id);
            int linhasAfetadas = pst.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            System.out.println("Não foi possível excluir a movimentação: " + e.getMessage());
            return false;
        }
    }
}
