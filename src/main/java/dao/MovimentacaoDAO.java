
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Livia0120
 */
public class MovimentacaoDAO {

    // Método para entrada de estoque
    public void adicionarEstoque(int produtoId, int quantidade) {
        String sql = "UPDATE produtos SET quantidade = quantidade + ? WHERE id = ?";

        Connection conexao = null;
        PreparedStatement pst = null;

        try {
            conexao = ModuloConexao.conector();
            if (conexao != null) {
                pst = conexao.prepareStatement(sql);
                pst.setInt(1, produtoId);
                pst.setInt(2, quantidade);

                int linhasAfetadas = pst.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Entrada de estoque registrada para o produto ID: " + produtoId);
                } else {
                    System.out.println("Nenhuma entrada de estoque registrada para o produto ID: " + produtoId);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar estoque: " + e.getMessage());
        } finally {

            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar PreparedStatement: " + e.getMessage());
            }
        }
    }

    // Método para saída de estoque
    public void removerEstoque(int produtoId, int quantidade) {
        String sql = "UPDATE produtos SET quantidade = quantidade - ? WHERE id = ?";

        Connection conexao = null;
        PreparedStatement pst = null;

        try {
            conexao = ModuloConexao.conector();
            if (conexao != null) {
                pst = conexao.prepareStatement(sql);
                pst.setInt(1, quantidade);
                pst.setInt(2, produtoId);

                int linhasAfetadas = pst.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Saída de estoque registrada para o produto ID: " + produtoId);
                } else {
                    System.out.println("Nenhuma saída de estoque registrada para o produto ID: " + produtoId);
                }
            }
        } catch (Exception e) {
            System.err.println("Erro ao remover estoque: " + e.getMessage());
        } finally {

            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
                System.err.println("Erro ao fechar PreparedStatement: " + e.getMessage());
            }
        }
    }

}
