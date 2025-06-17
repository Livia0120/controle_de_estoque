
package principal;

import dao.ProdutoDAO;
import modelo.Categoria;
import modelo.Produto;
import visao.FormMenuPrincipal;

/**
 *
 * @author Beatriz Arevalo Freitas
 */
public class Principal {
    public static void main(String[] args) {
           
//        ProdutoDAO teste = new ProdutoDAO();
//        Produto produto_1 = new Produto();
        
        FormMenuPrincipal objetoScreen = new FormMenuPrincipal(); // Instancia a interface gráfica
        objetoScreen.setVisible(true); // Torna a janela visível
}
    
}
