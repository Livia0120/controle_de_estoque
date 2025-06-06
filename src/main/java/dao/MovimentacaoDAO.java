
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
    public static boolean adicionarEstoque (Movimentacao m) {
         String sql = "INSERT INTO Movimentacoes (produto_id, tipo, quantidade, observacoes) VALUES (?, ?, ?, ?)";

        Connection conexao = null;
        PreparedStatement pst = null;

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
    

    // Método para saída de estoque
    public boolean removerEstoque(saida s) {
        String sql = "UPDATE produtos SET quantidade = quantidade - ? WHERE id = ?";

        Connection conexao = null;
        PreparedStatement pst = null;
boolean sucesso = false;
        try {
            conexao = ModuloConexao.conector();
            if (conexao != null) {
                pst = conexao.prepareStatement(sql);
                pst.setInt(1, s.getProdutoId());
                pst.setString(2, "saida"); 
                pst.setInt(3, s.getQuantidade());
                pst.setString(4, s.getObservacoes() );

                int linhasAfetadas = pst.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Saída de estoque registrada para o produto ID: " );
                } else {
                    System.out.println("Nenhuma saída de estoque registrada para o produto ID: " );
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
        return sucesso;
    }

}
