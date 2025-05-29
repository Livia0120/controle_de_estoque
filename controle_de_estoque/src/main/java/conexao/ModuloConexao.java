/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;
import java.sql.*;

/**
 *
 * @author Vitor
 */
public class ModuloConexao {
    public static Connection conector(){
        
      //informações do banco de dados
      java.sql.Connection conexao = null;
      String driver = "com.mysql.jdbc.Driver";
      String url = "jdbc:mysql://127.0.0.0:3306/controle_de_estoque";
      String user = "root";
      String password = "root";

      try{
          Class.forName(driver);
          conexao = DriverManager.getConnection(url, user, password);
          return conexao;

      } catch (Exception e) {
          System.out.println(e);
          return null;
      }
    }
    
    /*
    Para utilizar a conexão:
    
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        conexao = ModuloConexao.conector();
    */
}
