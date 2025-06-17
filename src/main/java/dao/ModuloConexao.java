
package dao;
import java.sql.*;

/**
 *
 * @author Vitor
 */
public class ModuloConexao {
    public static Connection conector(){
        
      //informações do banco de dados
      java.sql.Connection conexao = null;
      String driver = "com.mysql.cj.jdbc.Driver";
      String url = "jdbc:mysql://127.0.0.1:3306/controle_de_estoque";
      String user = "root";
      String password = "48991385316Gu."; 

       //String password = "1Qaz2wsx@";
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
