
package visao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import dao.ModuloConexao;
import java.sql.SQLException;
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
        carregarProdutos();
        
    }
    //O método abaixo carrega os dados do banco enquanto prepara a conexão com o banco de dados
    private void carregarProdutos() {
    DefaultTableModel modelo = (DefaultTableModel) tblMinimo.getModel();
    modelo.setRowCount(0);

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    String sql = "SELECT nome, quantidade, qtd_minima FROM produtos WHERE quantidade < qtd_minima";

    try {
        conexao = ModuloConexao.conector();
        pst = conexao.prepareStatement(sql);
        rs = pst.executeQuery();

        while (rs.next()) {
            String nome = rs.getString("nome");
            int quantidade = rs.getInt("quantidade");
            int qtdMinima = rs.getInt("qtd_minima");
            modelo.addRow(new Object[]{nome, quantidade, qtdMinima});
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this,
                "Erro ao carregar produtos abaixo do limite mínimo: " + e.getMessage(),
                "Erro no Banco de Dados", JOptionPane.ERROR_MESSAGE);
    } finally {
        // O try abaixo garante que o programa feche devidamente se ocorrer algum problema durante a execução do programa
        try {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao fechar recursos do banco de dados: " + e.getMessage(),
                    "Erro de Fechamento", JOptionPane.ERROR_MESSAGE);
        }
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
                "Nome", "Quantidade", "Quantidade Minima"
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