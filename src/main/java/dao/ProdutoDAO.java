
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Produto;
import javax.swing.JOptionPane;

/**
 * @author 
 * Beatriz Arevalo Freitas & Ana Luiza Seemann Felisbino
 */
public class ProdutoDAO {

    public static boolean insertProduto(Produto p) {
        String sql = "INSERT INTO produtos (nome, preco, quantidade, categoria_id, qtd_minima, qtd_maxima, unidade_medida) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexao = ModuloConexao.conector();
             PreparedStatement pst = conexao.prepareStatement(sql)) {

            pst.setString(1, p.getNome());
            pst.setDouble(2, p.getPreco());
            pst.setInt(3, p.getQuantidade());
            pst.setInt(4, p.getCategoriaId());
            pst.setInt(5, p.getQtd_minima());
            pst.setInt(6, p.getQtd_maxima());
            pst.setString(7, p.getUni_medida());

            pst.executeUpdate();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog( null, "Não foi possível cadastrar o produto: " + e.getMessage());
            System.out.println("Não foi possível cadastrar o produto: " + e.getMessage());
            return false;
        }
    }

    public static List<Produto> listarProdutos() {
        String sql = "SELECT * FROM produtos";
        List<Produto> lista = new ArrayList<>();

        try (Connection conexao = ModuloConexao.conector();
             PreparedStatement pst = conexao.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getDouble("preco"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setCategoriaId(rs.getInt("categoria_id"));
                p.setQtd_minima(rs.getInt("qtd_minima"));
                p.setQtd_maxima(rs.getInt("qtd_maxima"));
                p.setUni_medida(rs.getString("unidade_medida"));

                lista.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Não foi possível listar os produtos: " + e.getMessage());
        }

        return lista;
    }

    public static Produto buscarProdutoPorId(int id) {
        String sql = "SELECT * FROM produtos WHERE id = ?";
        Produto p = null;

        try (Connection conexao = ModuloConexao.conector();
             PreparedStatement pst = conexao.prepareStatement(sql)) {

            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                p = new Produto();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getDouble("preco"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setCategoriaId(rs.getInt("categoria_id"));
                p.setQtd_minima(rs.getInt("qtd_minima"));
                p.setQtd_maxima(rs.getInt("qtd_maxima"));
                p.setUni_medida(rs.getString("unidade_medida"));
            }

        } catch (SQLException e) {
            System.out.println("Não foi possível buscar o produto: " + e.getMessage());
        }

        return p;
    }

    public static boolean atualizarProduto(Produto p) {
        String sql = "UPDATE produtos SET nome = ?, preco = ?, quantidade = ?, categoria_id = ?, "
                   + "qtd_minima = ?, qtd_maxima = ?, unidade_medida = ? WHERE id = ?";

        try (Connection conexao = ModuloConexao.conector();
             PreparedStatement pst = conexao.prepareStatement(sql)) {

            pst.setString(1, p.getNome());
            pst.setDouble(2, p.getPreco());
            pst.setInt(3, p.getQuantidade());
            pst.setInt(4, p.getCategoriaId());
            pst.setInt(5, p.getQtd_minima());
            pst.setInt(6, p.getQtd_maxima());
            pst.setString(7, p.getUni_medida());
            pst.setInt(8, p.getId());

            pst.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Não foi possível atualizar o produto: " + e.getMessage());
            return false;
        }
    }

    public static boolean excluirProduto(int id) {
        String sql = "DELETE FROM produtos WHERE id = ?";

        try (Connection conexao = ModuloConexao.conector();
             PreparedStatement pst = conexao.prepareStatement(sql)) {

            pst.setInt(1, id);
            pst.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Não foi possível excluir o produto: " + e.getMessage());
            return false;
        }
    }

    public static boolean reajustarPrecos(double percentual) {
        String sql = "UPDATE produtos SET preco = preco * (1 + ? / 100)";

        try (Connection conexao = ModuloConexao.conector();
             PreparedStatement pst = conexao.prepareStatement(sql)) {

            pst.setDouble(1, percentual);
            pst.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Não foi possível reajustar os preços: " + e.getMessage());
            return false;
        }
    }

    public static List<Object[]> listarQuantidadePorCategoria() {
        String sql = "SELECT c.nome, COUNT(p.id) as quantidade "
                   + "FROM categorias c LEFT JOIN produtos p ON c.id = p.categoria_id "
                   + "GROUP BY c.nome";

        List<Object[]> lista = new ArrayList<>();

        try (Connection conexao = ModuloConexao.conector();
             PreparedStatement pst = conexao.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new Object[]{rs.getString("nome"), rs.getInt("quantidade")});
            }

        } catch (SQLException e) {
            System.out.println("Não foi possível listar a quantidade por categoria: " + e.getMessage());
        }

        return lista;
    }
}
