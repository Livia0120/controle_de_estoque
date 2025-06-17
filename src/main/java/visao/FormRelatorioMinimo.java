
package visao;

import java.sql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import dao.ModuloConexao;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author gusta
 */
public class FormRelatorioMinimo extends javax.swing.JFrame {


    public FormRelatorioMinimo() {
        initComponents();
        setDefaultCloseOperation(FormRelatorioMinimo.DISPOSE_ON_CLOSE);
    }

   private void minimoProdutos(){
         Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        conexao = ModuloConexao.conector();
        try{
        rs = pst.executeQuery();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
                }
    }
    private void carregarDadosEstoque() {

    DefaultTableModel modeloMaximo = (DefaultTableModel) tblMinimo.getModel(); 
    modeloMaximo.setRowCount(0);

    try (Connection conexao = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/controle_de_estoque", "root", "48991385316Gu.");
         Statement stmt = conexao.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT nome, quantidade, qtd_maxima FROM controle_de_estoque where quantidade > qtd_maxima")) {
        while (rs.next()) {
            String nome = rs.getString("nome");
            int quantidade = rs.getInt("quantidade");
            int qtdMaxima = rs.getInt("qtd_maxima");

            // Adiciona uma nova linha ao modelo da tabela
            modeloMaximo.addRow(new Object[]{nome, quantidade, qtdMaxima});
        }
    } catch (SQLException e) {

        JOptionPane.showMessageDialog(this, "Erro ao carregar dados: " + e.getMessage(), "Erro de Banco de Dados", JOptionPane.ERROR_MESSAGE);

        e.printStackTrace();
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMinimo = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Produtos Abaixo da Quantidade Mínima");

        tblMinimo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome", "Quantidade", "Quantidade Máxima"
            }
        ));
        jScrollPane1.setViewportView(tblMinimo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(109, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(221, 221, 221))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormRelatorioMinimo().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMinimo;
    // End of variables declaration//GEN-END:variables
}
