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
public class FormRelatorioMaximo extends javax.swing.JFrame {

    public FormRelatorioMaximo() {
        initComponents();
        setDefaultCloseOperation(FormRelatorioMaximo.DISPOSE_ON_CLOSE);
        carregarProdutos();
    }

    private void carregarProdutos() {
        DefaultTableModel modelo = (DefaultTableModel) tblMaximo.getModel();
        modelo.setRowCount(0);

        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "SELECT nome, quantidade, qtd_maxima FROM produtos WHERE quantidade > qtd_maxima";

        try {
            conexao = ModuloConexao.conector();
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                int quantidade = rs.getInt("quantidade");
                int qtdMaxima = rs.getInt("qtd_maxima");
                modelo.addRow(new Object[]{nome, quantidade, qtdMaxima});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao carregar produtos acima do limite máximo: " + e.getMessage(),
                    "Erro de Banco de Dados", JOptionPane.ERROR_MESSAGE);
        } finally {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblMaximo = new javax.swing.JTable();
        MaximoTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblMaximo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Produto", "Quantidade", "Quantidade Maxima"
            }
        ));
        jScrollPane1.setViewportView(tblMaximo);

        MaximoTitulo.setText("Produtos Acima da Quantidade Máxima");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(MaximoTitulo)))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(MaximoTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormRelatorioMaximo().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel MaximoTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMaximo;
    // End of variables declaration//GEN-END:variables
}
