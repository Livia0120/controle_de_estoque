
package visao;

import java.text.DateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Ana Luiza
 */
public class MenuPrincipal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MenuPrincipal.class.getName());

 
    public MenuPrincipal() {
        initComponents();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop = new javax.swing.JDesktopPane();
        principalUsuarioLBL = new javax.swing.JLabel();
        principalDataLBL = new javax.swing.JLabel();
        Menu = new javax.swing.JMenuBar();
        menCad = new javax.swing.JMenu();
        menCadGP = new javax.swing.JMenuItem();
        menCadCadProd = new javax.swing.JMenuItem();
        menMov = new javax.swing.JMenu();
        menMovEn = new javax.swing.JMenuItem();
        menMovSai = new javax.swing.JMenuItem();
        menRel = new javax.swing.JMenu();
        menRelLis = new javax.swing.JMenuItem();
        menRelBal = new javax.swing.JMenuItem();
        MenAj = new javax.swing.JMenu();
        menAjSobre = new javax.swing.JMenuItem();
        menOp = new javax.swing.JMenu();
        menOpSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Controle de Estoque");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        principalUsuarioLBL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        principalUsuarioLBL.setText("Usuário");

        principalDataLBL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        principalDataLBL.setText("Data");

        menCad.setText("Cadastros");

        menCadGP.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menCadGP.setText("Gerenciar Produtos");
        menCadGP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menCadGPActionPerformed(evt);
            }
        });
        menCad.add(menCadGP);

        menCadCadProd.setText("Cadastrar Produto");
        menCadCadProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menCadCadProdActionPerformed(evt);
            }
        });
        menCad.add(menCadCadProd);

        Menu.add(menCad);

        menMov.setText("Movimentação");

        menMovEn.setText("Entradas");
        menMovEn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menMovEnActionPerformed(evt);
            }
        });
        menMov.add(menMovEn);

        menMovSai.setText("Saídas");
        menMovSai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menMovSaiActionPerformed(evt);
            }
        });
        menMov.add(menMovSai);

        Menu.add(menMov);

        menRel.setText("Relatórios");

        menRelLis.setText("Lista de Preços");
        menRel.add(menRelLis);

        menRelBal.setText("Balanço Físico e Financeiro");
        menRelBal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menRelBalActionPerformed(evt);
            }
        });
        menRel.add(menRelBal);

        Menu.add(menRel);

        MenAj.setText("Ajuda");

        menAjSobre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menAjSobre.setText("Sobre");
        menAjSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menAjSobreActionPerformed(evt);
            }
        });
        MenAj.add(menAjSobre);

        Menu.add(MenAj);

        menOp.setText("Opções");

        menOpSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menOpSair.setText("Sair");
        menOpSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menOpSairActionPerformed(evt);
            }
        });
        menOp.add(menOpSair);

        Menu.add(menOp);

        setJMenuBar(Menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(principalUsuarioLBL)
                    .addComponent(principalDataLBL))
                .addGap(0, 63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(principalUsuarioLBL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(principalDataLBL))
        );

        setSize(new java.awt.Dimension(796, 482));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menCadGPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menCadGPActionPerformed
        GerenciamentoProduto objeto = new GerenciamentoProduto();
        objeto.setVisible(true);
        //Menu.add(objeto);
        desktop.add(objeto);
    }//GEN-LAST:event_menCadGPActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        //data principalDataLBL
        Date data = new Date();
        DateFormat formatar = DateFormat.getDateInstance(DateFormat.SHORT);
        principalDataLBL.setText(formatar.format(data));
    }//GEN-LAST:event_formWindowActivated

    private void menOpSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menOpSairActionPerformed
        // TODO add your handling code here:
        int sair = JOptionPane.showConfirmDialog(null, 
                "Tem certeza que deseja sair?",
                "atenção", JOptionPane.YES_NO_OPTION);
        if(sair == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_menOpSairActionPerformed

    private void menAjSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menAjSobreActionPerformed
        // TODO add your handling code here:
        FormSobre sobre = new FormSobre();
        sobre.setVisible(true);
        desktop.add(sobre);
    }//GEN-LAST:event_menAjSobreActionPerformed

    private void menCadCadProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menCadCadProdActionPerformed
        // TODO add your handling code here:
        FormCadastrodeProduto objeto = new FormCadastrodeProduto();
        objeto.setVisible(true);
    }//GEN-LAST:event_menCadCadProdActionPerformed

    private void menMovEnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menMovEnActionPerformed
        // TODO add your handling code here:
        FormEntradaEstoque objeto = new FormEntradaEstoque();
        objeto.setVisible(true);
    }//GEN-LAST:event_menMovEnActionPerformed

    private void menMovSaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menMovSaiActionPerformed
        // TODO add your handling code here:
        FormSaidaEstoque objeto = new FormSaidaEstoque();
        objeto.setVisible(true);
    }//GEN-LAST:event_menMovSaiActionPerformed

    private void menRelBalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menRelBalActionPerformed
        // TODO add your handling code here:
        FormRelatorioBalancoFisico objeto = new FormRelatorioBalancoFisico();
        objeto.setVisible(true);
    }//GEN-LAST:event_menRelBalActionPerformed

 
    public static void main(String args[]) {
       
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
        java.awt.EventQueue.invokeLater(() -> new MenuPrincipal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenAj;
    private javax.swing.JMenuBar Menu;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JMenuItem menAjSobre;
    private javax.swing.JMenu menCad;
    private javax.swing.JMenuItem menCadCadProd;
    private javax.swing.JMenuItem menCadGP;
    private javax.swing.JMenu menMov;
    private javax.swing.JMenuItem menMovEn;
    private javax.swing.JMenuItem menMovSai;
    private javax.swing.JMenu menOp;
    private javax.swing.JMenuItem menOpSair;
    private javax.swing.JMenu menRel;
    private javax.swing.JMenuItem menRelBal;
    private javax.swing.JMenuItem menRelLis;
    private javax.swing.JLabel principalDataLBL;
    private javax.swing.JLabel principalUsuarioLBL;
    // End of variables declaration//GEN-END:variables
}
