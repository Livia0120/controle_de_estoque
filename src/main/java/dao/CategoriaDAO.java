package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Categoria;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Beatriz Arevalo Freitas
 */
public class CategoriaDAO {
    public static boolean inserirCategoria(Categoria categoria) {
        String sql = "INSERT INTO categoria (nome, tamanho, embalagem) VALUES (?, ?, ?)";

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
