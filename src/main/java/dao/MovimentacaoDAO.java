
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import modelo.Movimentacao;

/**
 *
 * @author Livia0120
 */
public class MovimentacaoDAO {

    // Método para entrada de estoque
    public static boolean adicionarEstoque (Movimentacao m)  throws SQLException {
         String sql = "INSERT INTO Movimentacoes (produto_id, tipo, quantidade, observacoes) VALUES (?, ?, ?, ?)";

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
                pst.setString(4, m.getObservacoes() );

                int linhasAfetadas = pst.executeUpdate();
                if (linhasAfetadas > 0) {
                    
                    System.out.println("Movimentação registrada com sucesso ");
                } else {
                    System.out.println("Falha ao registrar movimentação  " );
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
        String sqlAtualizaEstoque = "UPDATE produtos SET quantidade = quantidade - ? WHERE id = ?";
        String sqlRegistraMovimentacao = "INSERT INTO Movimentacoes (produto_id, tipo, quantidade, observacoes) VALUES (?, ?, ?, ?)";

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
                        System.out.println("Movimentação de saída registrada com sucesso para o produto ID: " + m.getProdutoId());
                        conexao.commit(); // Confirma as duas operações se ambas foram bem-sucedidas
                        sucesso = true;
                    } else {
                        System.out.println("Falha ao registrar movimentação de saída para o produto ID: " + m.getProdutoId());
                        conexao.rollback(); // Desfaz a atualização do estoque se o registro da movimentação falhar
                    }
                } else {
                    System.out.println("Nenhuma atualização de estoque para o produto ID: " + m.getProdutoId() + " (produto não encontrado ou quantidade insuficiente).");
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
}
