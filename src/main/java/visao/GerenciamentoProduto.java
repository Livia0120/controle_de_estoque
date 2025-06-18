
package visao;

/**
 *
 * @author Vitor
 */

import java.sql.*;
import dao.ModuloConexao;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;


public class GerenciamentoProduto extends javax.swing.JInternalFrame {

    /**
     * Creates new form GerenciamentoProduto
     */
    Connection conexao;
    PreparedStatement pst;
    ResultSet rs;
    
    public GerenciamentoProduto() {
        initComponents();
        
        conexao = null;
        pst = null;
        rs = null;

        conexao = ModuloConexao.conector();
        pesquisarProduto();
        adicionarItensLista();
        
    }
      
    private void editar(){
        String sql ="UPDATE Produtos SET nome =?, quantidade =?, preco =?, qtd_minima =?, qtd_maxima =?, unidade_medida = ?, categoria_id = (SELECT id FROM Categorias WHERE nome = ? "
                + "LIMIT 1) WHERE id = ? ";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtGPNomeProduto.getText());
            pst.setString(2, txtGPQtd.getText());
            pst.setString(3, txtGPPreco.getText());
            pst.setString(4, txtGPQtdMin.getText());
            pst.setString(5, txtGPQtdMax.getText());
           
            pst.setString(6, txtGPUnidade.getText());
            pst.setString(7, comBoxGPCategorias.getSelectedItem().toString());
            pst.setString(8, txtGPID.getText());
            
            if((txtGPNomeProduto.getText().isEmpty()) ||
                (comBoxGPCategorias.getSelectedIndex() ==0) ||
                (txtGPQtd.getText().isEmpty()) ||
                (txtGPQtdMin.getText().isEmpty()) ||
                (txtGPQtdMax.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos");               
            } else {
                int adicionado = pst.executeUpdate();
                
                if(adicionado > 0){
                    JOptionPane.showMessageDialog(null,"Produto Alterado com Sucesso!");
                    limparCampos();
                }
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);           
        }
    }
    
    private void deletar(){
        int confirma = JOptionPane.showConfirmDialog(null, 
                "Tem certeza que deseja deletar este produto?",
                "atenção", JOptionPane.YES_NO_OPTION);
        
        if(confirma==JOptionPane.YES_OPTION){
            String sql ="delete from Produtos where id=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1,txtGPID.getText());
                int apagado = pst.executeUpdate();
                if(apagado > 0){
                    JOptionPane.showMessageDialog(null,"Produto Removido com Sucesso!");
                    limparCampos();
                }
                
            } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, e);
            }
        }
        
    }
    
    private void pesquisarProduto(){
        String sql = "SELECT p.id as ID, p.nome as Nome, c.nome AS Categoria, p.preco as Preço, p.unidade_medida as Unidade_de_Medida,p.quantidade as Quantidade,  p.qtd_minima as Quantidade_Minima, p.qtd_maxima as Quantidade_Maxima FROM Produtos p JOIN Categorias c ON p.categoria_id = c.id where p.nome like ?";
        
        try {
            pst = conexao.prepareStatement(sql);
            
            //passando o conteudo da caixa de pesquisa para o "?"
            pst.setString(1, txtGPPesquisar.getText()+"%");
            rs = pst.executeQuery();
            
            //utilizando a biblioteca rs2xml para preencher a tabela
            tabGP.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    //ao clicar em um campo da tabela, ira preencher os campos da tela
    public void setarCampos(){
        int setar = tabGP.getSelectedRow();
        txtGPID.setText(tabGP.getModel().getValueAt(setar,0).toString());
        txtGPNomeProduto.setText(tabGP.getModel().getValueAt(setar,1).toString());
        comBoxGPCategorias.setSelectedItem(tabGP.getModel().getValueAt(setar,2).            toString());
        txtGPPreco.setText(tabGP.getModel().getValueAt(setar,3).toString());
        txtGPUnidade.setText(tabGP.getModel().getValueAt(setar,4).toString());
        txtGPQtd.setText(tabGP.getModel().getValueAt(setar,5).toString());
        txtGPQtdMin.setText(tabGP.getModel().getValueAt(setar,6).toString());
        txtGPQtdMax.setText(tabGP.getModel().getValueAt(setar,7).toString());
        
    }
    
    private void limparCampos(){
        txtGPID.setText(null);
        txtGPNomeProduto.setText(null);  
        comBoxGPCategorias.setSelectedIndex(0);
        txtGPPreco.setText(null);
        txtGPUnidade.setText(null);
        txtGPQtd.setText(null);
        txtGPQtdMin.setText(null);
        txtGPQtdMax.setText(null);
    }
    private void adicionarItensLista(){
	String sql = "SELECT nome FROM categorias";
        PreparedStatement stmt;
        try {
      
            stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
        	String nomeCategoria = rs.getString("nome");
        	comBoxGPCategorias.addItem(nomeCategoria);
        }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,ex);
        }
        
}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtGPID = new javax.swing.JTextField();
        txtGPNomeProduto = new javax.swing.JTextField();
        txtGPQtd = new javax.swing.JTextField();
        txtGPQtdMin = new javax.swing.JTextField();
        txtGPQtdMax = new javax.swing.JTextField();
        comBoxGPCategorias = new javax.swing.JComboBox<>();
        btnGPDeletar = new javax.swing.JButton();
        btnGPEditar = new javax.swing.JButton();
        btnGPPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabGP = new javax.swing.JTable();
        txtGPPesquisar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtGPPreco = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtGPUnidade = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Gerenciamento de Produto");
        setMinimumSize(new java.awt.Dimension(610, 330));
        setPreferredSize(new java.awt.Dimension(680, 480));

        jLabel1.setText("ID:");

        jLabel2.setText("Nome:");

        jLabel3.setText("Categoria:");

        jLabel4.setText("Quantidade:");

        jLabel5.setText("Quantidade Máxima:");

        jLabel6.setText("Quantidade Mínima:");

        txtGPID.setEditable(false);
        txtGPID.setEnabled(false);

        txtGPNomeProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGPNomeProdutoActionPerformed(evt);
            }
        });

        txtGPQtd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGPQtdActionPerformed(evt);
            }
        });

        txtGPQtdMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGPQtdMinActionPerformed(evt);
            }
        });

        comBoxGPCategorias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        comBoxGPCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comBoxGPCategoriasActionPerformed(evt);
            }
        });

        btnGPDeletar.setText("Deletar Produto");
        btnGPDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGPDeletarActionPerformed(evt);
            }
        });

        btnGPEditar.setText("Salvar Aterações");
        btnGPEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGPEditarActionPerformed(evt);
            }
        });

        btnGPPesquisar.setText("Pesquisar");
        btnGPPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGPPesquisarActionPerformed(evt);
            }
        });

        tabGP = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tabGP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Categoria", "Preço", "Quantidade", "Quantidade Minima", "Quantidade Maxima", "Unidade de Medida"
            }
        ));
        tabGP.setColumnSelectionAllowed(true);
        tabGP.setFocusable(false);
        tabGP.getTableHeader().setReorderingAllowed(false);
        tabGP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabGPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabGP);
        tabGP.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        txtGPPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGPPesquisarKeyReleased(evt);
            }
        });

        jLabel7.setText("Preço:");

        jButton1.setText("Limpar Campos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel8.setText("Unidade de Medida");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4))
                                .addGap(41, 41, 41))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtGPID, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtGPQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtGPQtdMin, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtGPPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(txtGPUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtGPQtdMax)
                            .addComponent(txtGPNomeProduto, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(comBoxGPCategorias, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtGPPesquisar)
                                .addGap(18, 18, 18)
                                .addComponent(btnGPPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnGPDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGPEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGPPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGPPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtGPID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtGPNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comBoxGPCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGPPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtGPUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtGPQtdMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGPQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtGPQtdMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGPEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGPDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71))
        );

        setBounds(0, 0, 640, 450);
    }// </editor-fold>//GEN-END:initComponents

    private void txtGPNomeProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGPNomeProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGPNomeProdutoActionPerformed

    private void txtGPQtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGPQtdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGPQtdActionPerformed

    private void comBoxGPCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comBoxGPCategoriasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comBoxGPCategoriasActionPerformed

    private void txtGPQtdMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGPQtdMinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGPQtdMinActionPerformed
    
    private void btnGPDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGPDeletarActionPerformed
        // TODO add your handling code here:
         deletar();
    }//GEN-LAST:event_btnGPDeletarActionPerformed

    private void btnGPEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGPEditarActionPerformed
        // TODO add your handling code here:
        editar();
    }//GEN-LAST:event_btnGPEditarActionPerformed

    private void btnGPPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGPPesquisarActionPerformed
        // TODO add your handling code here:
        pesquisarProduto();
    }//GEN-LAST:event_btnGPPesquisarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        limparCampos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtGPPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGPPesquisarKeyReleased
        // TODO add your handling code here:
        pesquisarProduto();
    }//GEN-LAST:event_txtGPPesquisarKeyReleased

    private void tabGPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabGPMouseClicked
        setarCampos();
    }//GEN-LAST:event_tabGPMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGPDeletar;
    private javax.swing.JButton btnGPEditar;
    private javax.swing.JButton btnGPPesquisar;
    private javax.swing.JComboBox<String> comBoxGPCategorias;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabGP;
    private javax.swing.JTextField txtGPID;
    private javax.swing.JTextField txtGPNomeProduto;
    private javax.swing.JTextField txtGPPesquisar;
    private javax.swing.JTextField txtGPPreco;
    private javax.swing.JTextField txtGPQtd;
    private javax.swing.JTextField txtGPQtdMax;
    private javax.swing.JTextField txtGPQtdMin;
    private javax.swing.JTextField txtGPUnidade;
    // End of variables declaration//GEN-END:variables
}
