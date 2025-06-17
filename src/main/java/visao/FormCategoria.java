
package visao;

import dao.CategoriaDAO;
import javax.swing.JOptionPane;
import modelo.Categoria;

/**
 *
 * @author Beatriz Arevalo Freitas
 */
public class FormCategoria extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormCategoria.class.getName());

   
    public FormCategoria() {
        initComponents();
                setDefaultCloseOperation(FormCategoria.DISPOSE_ON_CLOSE);

    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxEmbalagem = new javax.swing.JComboBox<>();
        jComboBoxTamanho = new javax.swing.JComboBox<>();
        jInputTextNomeCateg = new javax.swing.JTextField();
        CadProdutos = new javax.swing.JLabel();
        botaoCancelar = new javax.swing.JButton();
        botaoCadastrarCategoria = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome:");

        jLabel2.setText("Tamanho:");

        jLabel4.setText("Embalagem:");

        jComboBoxEmbalagem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lata", "Vidro", "Plastico", " " }));
        jComboBoxEmbalagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEmbalagemActionPerformed(evt);
            }
        });

        jComboBoxTamanho.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pequeno", "Médio", "Grande", " " }));
        jComboBoxTamanho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTamanhoActionPerformed(evt);
            }
        });

        jInputTextNomeCateg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jInputTextNomeCategActionPerformed(evt);
            }
        });

        CadProdutos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        CadProdutos.setText("Cadastro de Categoria");

        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        botaoCadastrarCategoria.setText("Cadastrar");
        botaoCadastrarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarCategoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxTamanho, 0, 132, Short.MAX_VALUE)
                            .addComponent(jInputTextNomeCateg)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botaoCadastrarCategoria)
                            .addComponent(jComboBoxEmbalagem, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(47, 47, 47))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(CadProdutos))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(botaoCancelar)))
                .addContainerGap(119, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(CadProdutos)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jInputTextNomeCateg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBoxEmbalagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCancelar)
                    .addComponent(botaoCadastrarCategoria))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jInputTextNomeCategActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jInputTextNomeCategActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jInputTextNomeCategActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
         this.dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void jComboBoxTamanhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTamanhoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTamanhoActionPerformed

    private void jComboBoxEmbalagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEmbalagemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxEmbalagemActionPerformed

    private void botaoCadastrarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarCategoriaActionPerformed
        String nome = jInputTextNomeCateg.getText().trim();
        String tamanho = jComboBoxTamanho.getSelectedItem().toString();
        String embalagem = jComboBoxEmbalagem.getSelectedItem().toString();
        
        if (!nome.isEmpty()) {
        Categoria categoria = new Categoria(nome, tamanho, embalagem);
        boolean sucesso = CategoriaDAO.inserirCategoria(categoria);

        if (sucesso) {
            JOptionPane.showMessageDialog(this, "Categoria cadastrada com sucesso!");
            jInputTextNomeCateg.setText("");
            jComboBoxTamanho.setSelectedIndex(0);
            jComboBoxEmbalagem.setSelectedIndex(0);
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar categoria.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "O campo nome é obrigatório.");
    }
    }//GEN-LAST:event_botaoCadastrarCategoriaActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FormCategoria().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CadProdutos;
    private javax.swing.JButton botaoCadastrarCategoria;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JComboBox<String> jComboBoxEmbalagem;
    private javax.swing.JComboBox<String> jComboBoxTamanho;
    private javax.swing.JTextField jInputTextNomeCateg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
