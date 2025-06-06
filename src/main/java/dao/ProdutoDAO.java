/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Produto;

/**
 *
 * @author Beatriz Arevalo Freitas & Ana Luiza Seemann Felisbino
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
            System.out.println("Não foi possivel cadastrar seu produto: " + e.getMessage());
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
            System.out.println("Não foi possivel listar seu produto: " + e.getMessage());
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
            System.out.println("Não foi possivel buscar seu produto: " + e.getMessage());
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
            System.out.println("Não foi possivel atualizar seu produto: " + e.getMessage());
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
            System.out.println("Não foi possivel excluir seu produto: " + e.getMessage());
            return false;
        }
    }
}