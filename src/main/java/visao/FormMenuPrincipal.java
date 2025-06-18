
package visao;

/**
 *
 * @author be062997
 */
public class FormMenuPrincipal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormMenuPrincipal.class.getName());


    public FormMenuPrincipal() {
        initComponents();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCadastros = new javax.swing.JMenu();
        jMenuItemCadastroCategoria = new javax.swing.JMenuItem();
        jMenuItemCadastroProduto = new javax.swing.JMenuItem();
        jMenuMovimentacoes = new javax.swing.JMenu();
        jMenuItemEntradas = new javax.swing.JMenuItem();
        jMenuItemSaidas = new javax.swing.JMenuItem();
        jMenuRelatorioProd = new javax.swing.JMenu();
        jMenuItemRelatListaPreco = new javax.swing.JMenuItem();
        jMenuItemRelatBalanco = new javax.swing.JMenuItem();
        jMenuItemRelatMinima = new javax.swing.JMenuItem();
        jMenuItemRelatMaxima = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenu5.setText("File");
        jMenuBar2.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar2.add(jMenu6);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenuCadastros.setText("Cadastros");

        jMenuItemCadastroCategoria.setText("Cadastrar Categoria");
        jMenuItemCadastroCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroCategoriaActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemCadastroCategoria);

        jMenuItemCadastroProduto.setText("Cadastrar Produto");
        jMenuItemCadastroProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroProdutoActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemCadastroProduto);

        jMenuBar1.add(jMenuCadastros);

        jMenuMovimentacoes.setText("Movimentações");

        jMenuItemEntradas.setText("Entradas");
        jMenuItemEntradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEntradasActionPerformed(evt);
            }
        });
        jMenuMovimentacoes.add(jMenuItemEntradas);

        jMenuItemSaidas.setText("Saídas");
        jMenuItemSaidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSaidasActionPerformed(evt);
            }
        });
        jMenuMovimentacoes.add(jMenuItemSaidas);

        jMenuBar1.add(jMenuMovimentacoes);

        jMenuRelatorioProd.setText("Relatórios");
        jMenuRelatorioProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRelatorioProdActionPerformed(evt);
            }
        });

        jMenuItemRelatListaPreco.setText("Lista de Preços");
        jMenuItemRelatListaPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRelatListaPrecoActionPerformed(evt);
            }
        });
        jMenuRelatorioProd.add(jMenuItemRelatListaPreco);

        jMenuItemRelatBalanco.setText("Balanço Físico e Financeiro");
        jMenuItemRelatBalanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRelatBalancoActionPerformed(evt);
            }
        });
        jMenuRelatorioProd.add(jMenuItemRelatBalanco);

        jMenuItemRelatMinima.setText("Controle de Mínima");
        jMenuItemRelatMinima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRelatMinimaActionPerformed(evt);
            }
        });
        jMenuRelatorioProd.add(jMenuItemRelatMinima);

        jMenuItemRelatMaxima.setText("Controle de Máxima");
        jMenuItemRelatMaxima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRelatMaximaActionPerformed(evt);
            }
        });
        jMenuRelatorioProd.add(jMenuItemRelatMaxima);

        jMenuBar1.add(jMenuRelatorioProd);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemCadastroProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroProdutoActionPerformed
        FormCadastrodeProduto objeto = new FormCadastrodeProduto();
        objeto.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastroProdutoActionPerformed

    private void jMenuItemRelatBalancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRelatBalancoActionPerformed
       FormRelatorioBalancoFisico objeto = new FormRelatorioBalancoFisico();
       objeto.setVisible(true);
    }//GEN-LAST:event_jMenuItemRelatBalancoActionPerformed

    private void jMenuItemCadastroCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroCategoriaActionPerformed
        FormCategoria objeto = new FormCategoria();
        objeto.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastroCategoriaActionPerformed

    private void jMenuItemSaidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSaidasActionPerformed
        FormSaidaEstoque objeto = new FormSaidaEstoque();
        objeto.setVisible(true);
    }//GEN-LAST:event_jMenuItemSaidasActionPerformed

    private void jMenuItemEntradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEntradasActionPerformed
        FormEntradaEstoque objeto = new FormEntradaEstoque();
        objeto.setVisible(true);
    }//GEN-LAST:event_jMenuItemEntradasActionPerformed

    private void jMenuRelatorioProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRelatorioProdActionPerformed

    }//GEN-LAST:event_jMenuRelatorioProdActionPerformed

    private void jMenuItemRelatMaximaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRelatMaximaActionPerformed
        FormRelatorioMaximo objeto = new FormRelatorioMaximo();
        objeto.setVisible(true);
    }//GEN-LAST:event_jMenuItemRelatMaximaActionPerformed

    private void jMenuItemRelatMinimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRelatMinimaActionPerformed
        FormRelatorioMinimo objeto = new FormRelatorioMinimo();
        objeto.setVisible(true);
    }//GEN-LAST:event_jMenuItemRelatMinimaActionPerformed

    private void jMenuItemRelatListaPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRelatListaPrecoActionPerformed
       FormRelatorioListadePreco objeto = new FormRelatorioListadePreco();
       objeto.setVisible(true);
    }//GEN-LAST:event_jMenuItemRelatListaPrecoActionPerformed


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
        java.awt.EventQueue.invokeLater(() -> new FormMenuPrincipal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenu jMenuCadastros;
    private javax.swing.JMenuItem jMenuItemCadastroCategoria;
    private javax.swing.JMenuItem jMenuItemCadastroProduto;
    private javax.swing.JMenuItem jMenuItemEntradas;
    private javax.swing.JMenuItem jMenuItemRelatBalanco;
    private javax.swing.JMenuItem jMenuItemRelatListaPreco;
    private javax.swing.JMenuItem jMenuItemRelatMaxima;
    private javax.swing.JMenuItem jMenuItemRelatMinima;
    private javax.swing.JMenuItem jMenuItemSaidas;
    private javax.swing.JMenu jMenuMovimentacoes;
    private javax.swing.JMenu jMenuRelatorioProd;
    // End of variables declaration//GEN-END:variables
}
