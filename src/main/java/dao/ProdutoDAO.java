/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Produto;

/**
 *
 * @author Beatriz Arevalo Freitas
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
            System.err.println("Erro ao inserir produto: " + e.getMessage());
            return false;
        }
    }
    
}
