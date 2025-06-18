
package visao;

/**
 *
 * @author Vitor
 */


import dao.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class GerenciamentoProduto extends javax.swing.JInternalFrame {


    Connection conexao;
    PreparedStatement pst;
    ResultSet rs;
    
    public GerenciamentoProduto() {
        initComponents();
        
        conexao = null;
        pst = null;
        rs = null;

        conexao = ModuloConexao.conector();
        
    }
    
    private void consultar(){
        String sql="select * from tb_estoques where id=?";
        
        try{
            pst=conexao.prepareStatement(sql);
            pst.setString(1, txtGPID.getText());
            rs=pst.executeQuery();
            if (rs.next()) {
                txtGPNomeProduto.setText(rs.getString(2));
                comBoxGPCategorias.setSelectedItem(rs.getString(3));
                txtGPQtd.setText(rs.getString(4));
                txtGPQtdMin.setText(rs.getString(5));
                txtGPQtdMax.setText(rs.getString(6));
            } else {
               JOptionPane.showMessageDialog(null, "Produto não encontrado"); 
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void adicionar(){
        String sql = "insert into tb_estoques(id,nome,categoria,quantidade,"
                + "quantidadeMin,quantidadeMax) values (?,?,?,?,?,?)";
        
        try{
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtGPID.getText());
            pst.setString(2, txtGPNomeProduto.getText());
            pst.setString(3, comBoxGPCategorias.getSelectedItem().toString());
            pst.setString(4, txtGPQtd.getText());
            pst.setString(5, txtGPQtdMin.getText());
            pst.setString(6, txtGPQtdMax.getText());
            //28
           if((txtGPNomeProduto.getText().isEmpty() ||
                comBoxGPCategorias.getSelectedItem().toString().isEmpty() ||
                txtGPQtd.getText().isEmpty() ||
                txtGPQtdMin.getText().isEmpty() ||
                txtGPQtdMax.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos");
            } else {
                int adicionado = pst.executeUpdate();
                if(adicionado > 0){
                    JOptionPane.showMessageDialog(null,"Produto Cadastrado com Sucesso!");
                    txtGPID.setText(null);
                    txtGPNomeProduto.setText(null);  
                    comBoxGPCategorias.setSelectedIndex(0);
                    txtGPQtd.setText(null);
                    txtGPQtdMin.setText(null);
                    txtGPQtdMax.setText(null);
                }
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void editar(){
        String sql ="update tb_estoques set nome=?,categoria=?,quantidade=?,"
                + "quantidadeMin=?,quantidadeMax=? where id=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtGPNomeProduto.getText());
            pst.setString(2, comBoxGPCategorias.getSelectedItem().toString());
            pst.setString(3, txtGPQtd.getText());
            pst.setString(4, txtGPQtdMin.getText());
            pst.setString(5, txtGPQtdMax.getText());
            pst.setString(6, txtGPID.getText());
            
            if((txtGPNomeProduto.getText().isEmpty() ||
                comBoxGPCategorias.getSelectedItem().toString().startsWith("00 - Selecione")) ||
                txtGPQtd.getText().isEmpty() ||
                txtGPQtdMin.getText().isEmpty() ||
                txtGPQtdMax.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos");               
            } else {
                int adicionado = pst.executeUpdate();
                
                if(adicionado > 0){
                    JOptionPane.showMessageDialog(null,"Produto Alterado com Sucesso!");
                    txtGPID.setText(null);
                    txtGPNomeProduto.setText(null);  
                    comBoxGPCategorias.setSelectedIndex(0);
                    txtGPQtd.setText(null);
                    txtGPQtdMin.setText(null);
                    txtGPQtdMax.setText(null);
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
            String sql ="delete from tb_estoques where id=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1,txtGPID.getText());
                int apagado = pst.executeUpdate();
                if(apagado > 0){
                    JOptionPane.showMessageDialog(null,"Produto Removido com Sucesso!");
                    txtGPID.setText(null);
                    txtGPNomeProduto.setText(null);  
                    comBoxGPCategorias.setSelectedIndex(0);
                    txtGPQtd.setText(null);
                    txtGPQtdMin.setText(null);
                    txtGPQtdMax.setText(null);
                }
                
            } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, e);
            }
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
        btnGPAdicionar = new javax.swing.JButton();

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

        comBoxGPCategorias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00 - Selecione", "01 - Alimentos Perecíveis", "02 - Alimentos Não Perecíveis", "03 - Bazar e Utilidades", "04 - Bebidas", "05 - Congelados", "06 - Higiene Pessoal", "07 - Limpeza e Utilidades Domésticas", "08 - Mercearia", "09 - Padaria e Confeitaria", "10 - Pet Shop" }));
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

        tabGP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nome", "Categoria"
            }
        ));
        tabGP.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tabGP);
        tabGP.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        btnGPAdicionar.setText("Adicionar Produto");
        btnGPAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGPAdicionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGPQtdMax, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtGPQtdMin, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtGPNomeProduto)
                                    .addComponent(comBoxGPCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtGPQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtGPID)))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnGPDeletar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGPAdicionar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(btnGPPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnGPEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtGPID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtGPNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(comBoxGPCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtGPQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtGPQtdMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtGPQtdMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGPPesquisar)
                            .addComponent(btnGPEditar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGPAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGPDeletar)
                        .addGap(0, 117, Short.MAX_VALUE)))
                .addContainerGap())
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
        consultar();
    }//GEN-LAST:event_btnGPPesquisarActionPerformed

    private void btnGPAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGPAdicionarActionPerformed
        // TODO add your handling code here:
        adicionar();
    }//GEN-LAST:event_btnGPAdicionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGPAdicionar;
    private javax.swing.JButton btnGPDeletar;
    private javax.swing.JButton btnGPEditar;
    private javax.swing.JButton btnGPPesquisar;
    private javax.swing.JComboBox<String> comBoxGPCategorias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabGP;
    private javax.swing.JTextField txtGPID;
    private javax.swing.JTextField txtGPNomeProduto;
    private javax.swing.JTextField txtGPQtd;
    private javax.swing.JTextField txtGPQtdMax;
    private javax.swing.JTextField txtGPQtdMin;
    // End of variables declaration//GEN-END:variables
}
