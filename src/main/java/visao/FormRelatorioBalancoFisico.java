package visao;

import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import dao.ModuloConexao;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 *
 * @author Ana Luiza
 */
public class FormRelatorioBalancoFisico extends javax.swing.JFrame {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormRelatorioBalancoFisico.class.getName());
    
    //O método abaixo é o construtor da classe
    public FormRelatorioBalancoFisico() {
        initComponents();
        carregarProdutos();
        setDefaultCloseOperation(FormRelatorioBalancoFisico.DISPOSE_ON_CLOSE);
        JTable tblProdutos = new JTable();
    }
    //O método abaixo carrega os dados nome, quantidade e preço do banco de dados, além de quantificar o valorTotal do estoque. E também
    //adiciona esses dados nas linhas da tabela enquanto realiza a conexão com o banco de dados
    private void carregarProdutos() {
        try (Connection conexao = ModuloConexao.conector(); PreparedStatement pst = conexao.prepareStatement(
                "SELECT nome, quantidade, preco FROM produtos"
        ); ResultSet rs = pst.executeQuery()) {

            DefaultTableModel modelo = new DefaultTableModel(
                    new Object[][]{},
                    new String[]{"Produto", "Qtd Estoque", "Valor Unit.", "Valor Total"}
            ) {
                public boolean isCellEditable(int row, int column) {
                    return column == 1 || column == 2;
                }
            };

            double totalEstoque = 0.0;
            
            while (rs.next()) {
                String nome = rs.getString("nome");
                int qtd = rs.getInt("quantidade");
                double valorUnit = rs.getDouble("preco");
                double valorTotal = qtd * valorUnit;

                totalEstoque += valorTotal;

                modelo.addRow(new Object[]{nome, qtd, valorUnit, valorTotal});
            }

            tblProdutos.setModel(modelo);
            
            modelo.addTableModelListener(e -> {
                if (e.getType() == TableModelEvent.UPDATE) {
                    int row = e.getFirstRow();
                    int column = e.getColumn();

                    if (column == 1 || column == 2) {
                        try {
                            int qtd = Integer.parseInt(modelo.getValueAt(row, 1).toString());
                            double valorUnit = Double.parseDouble(modelo.getValueAt(row, 2).toString());
                            double valorTotal = qtd * valorUnit;
                            modelo.setValueAt(valorTotal, row, 3);
                            atualizarTotalEstoque();
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Valores inválidos. Insira números válidos.");
                        }
                    }
                }
            });
            
            lblTotalEstoque.setText("Valor Total do Estoque: R$ " + String.format("%.2f", totalEstoque));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar produtos: " + e.getMessage());
        }
    }
    //O método abaixo insere na JLabel o valor da soma de TODOS os produtos em estoque
    private void atualizarTotalEstoque() {
        double totalEstoque = 0.0;
        DefaultTableModel modelo = (DefaultTableModel) tblProdutos.getModel();
        for (int i = 0; i < modelo.getRowCount(); i++) {
            double valorTotal = Double.parseDouble(modelo.getValueAt(i, 3).toString());
            totalEstoque += valorTotal;
        }
        
        lblTotalEstoque.setText("Valor Total do Estoque: R$ " + String.format("%.2f", totalEstoque));
    }
    


@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        lblTotalEstoque = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Produto", "Quantidade Estoque", "Valor Unitario", "Valor Total"
            }
        ));
        tblProdutos.setToolTipText("");
        jScrollPane1.setViewportView(tblProdutos);

        lblTotalEstoque.setText("Valor Total do Estoque: R$ 0,00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(274, 274, 274)
                        .addComponent(lblTotalEstoque)))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblTotalEstoque)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(123, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new FormRelatorioBalancoFisico().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotalEstoque;
    private javax.swing.JTable tblProdutos;
    // End of variables declaration//GEN-END:variables
}
