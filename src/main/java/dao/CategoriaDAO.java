package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Categoria;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Beatriz Arevalo Freitas E Ana Luiza
 */
public class CategoriaDAO {
    public static List<Categoria> listarCategorias() {
        String sql = "SELECT * FROM categorias";
        List<Categoria> lista = new ArrayList<>();

        try (Connection conexao = ModuloConexao.conector();
                PreparedStatement pst = conexao.prepareStatement(sql);
                ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Categoria c = new Categoria();
                c.setEmbalagem(rs.getString("embalagem"));
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setTamanho(rs.getString("tamanho"));

                lista.add(c);
            }

        } catch (SQLException e) {
            System.out.println("Não foi possível listar as categorias: " + e.getMessage());
        }

        return lista;
    }

    public static Categoria buscarCategoriaPorID(int id) {
        String sql = "SELECT * FROM categorias WHERE id = ?";

        try (Connection conexao = ModuloConexao.conector();
                PreparedStatement pst = conexao.prepareStatement(sql)) {

            pst.setInt(1, id); // ✅ define o parâmetro ANTES da execução
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                Categoria c = new Categoria();
                c.setEmbalagem(rs.getString("embalagem"));
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setTamanho(rs.getString("tamanho"));
                return c;
            }

        } catch (SQLException e) {
            System.out.println("Não foi possível listar as categorias: " + e.getMessage());
        }

        return null;
    }

 public static boolean updateCategoria(Categoria categoria) {
    String sql = "UPDATE categorias SET nome = ?, tamanho = ?, embalagem = ? WHERE id = ?";

    try (Connection conexao = ModuloConexao.conector();
         PreparedStatement pst = conexao.prepareStatement(sql)) {

        pst.setString(1, categoria.getNome());
        pst.setString(2, categoria.getTamanho());
        pst.setString(3, categoria.getEmbalagem());
        pst.setInt(4, categoria.getId());

        int rowsAffected = pst.executeUpdate();
        return rowsAffected > 0;

    } catch (SQLException e) {
        System.out.println("Erro ao atualizar categoria: " + e.getMessage());
    }

    return false;
}

    public static boolean excluirCategoria(int id) {
        String sql = "DELETE FROM categorias WHERE id = ?";

        try (Connection con = ModuloConexao.conector();
                PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, id);
            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao excluir categoria: " + e.getMessage());
            return false;
        }
    }

    public static boolean inserirCategoria(Categoria categoria) {
        String sql = "INSERT INTO categorias (nome, tamanho, embalagem) VALUES (?, ?, ?)";

        try (Connection con = ModuloConexao.conector();
                PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, categoria.getNome());
            pst.setString(2, categoria.getTamanho());
            pst.setString(3, categoria.getEmbalagem());

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir categoria: " + e.getMessage());
            return false;
        }
    }
}
