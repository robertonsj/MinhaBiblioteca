/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import javax.swing.JOptionPane;

/**
 *
 * @author rober
 */
public class FrmMenu extends javax.swing.JFrame {

    /**
     * Creates new form FrmMenu
     */
    public FrmMenu() {
        initComponents();
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
        jMenuBar1 = new javax.swing.JMenuBar();
        MnLivros = new javax.swing.JMenu();
        MnItemListarLivros = new javax.swing.JMenuItem();
        MnItemAtualizarAcervo = new javax.swing.JMenuItem();
        MnAutores = new javax.swing.JMenu();
        MnItemListarAutores = new javax.swing.JMenuItem();
        MnItemAtualizarAutores = new javax.swing.JMenuItem();
        MnEditoras = new javax.swing.JMenu();
        MnItemListarEditoras = new javax.swing.JMenuItem();
        MnItemAtualizarEditoras = new javax.swing.JMenuItem();
        MnAssuntos = new javax.swing.JMenu();
        MnItemListarAssuntos = new javax.swing.JMenuItem();
        MnItemAtualizarAssuntos = new javax.swing.JMenuItem();
        MnSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Biblioteca Pessoal");
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/fundoBiblioteca.png"))); // NOI18N

        jMenuBar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        MnLivros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/livro.png"))); // NOI18N
        MnLivros.setText("Livros");
        MnLivros.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        MnItemListarLivros.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MnItemListarLivros.setText("Listar");
        MnItemListarLivros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnItemListarLivrosActionPerformed(evt);
            }
        });
        MnLivros.add(MnItemListarLivros);

        MnItemAtualizarAcervo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MnItemAtualizarAcervo.setText("Atualizar Acervo");
        MnItemAtualizarAcervo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnItemAtualizarAcervoActionPerformed(evt);
            }
        });
        MnLivros.add(MnItemAtualizarAcervo);

        jMenuBar1.add(MnLivros);

        MnAutores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/autores.png"))); // NOI18N
        MnAutores.setText("Autores");
        MnAutores.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        MnItemListarAutores.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MnItemListarAutores.setText("Listar");
        MnItemListarAutores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnItemListarAutoresActionPerformed(evt);
            }
        });
        MnAutores.add(MnItemListarAutores);

        MnItemAtualizarAutores.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MnItemAtualizarAutores.setText("Atualizar Registro");
        MnItemAtualizarAutores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnItemAtualizarAutoresActionPerformed(evt);
            }
        });
        MnAutores.add(MnItemAtualizarAutores);

        jMenuBar1.add(MnAutores);

        MnEditoras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/editora.png"))); // NOI18N
        MnEditoras.setText("Editoras");
        MnEditoras.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        MnItemListarEditoras.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MnItemListarEditoras.setText("Listar");
        MnItemListarEditoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnItemListarEditorasActionPerformed(evt);
            }
        });
        MnEditoras.add(MnItemListarEditoras);

        MnItemAtualizarEditoras.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MnItemAtualizarEditoras.setText("Atualizar Registro");
        MnItemAtualizarEditoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnItemAtualizarEditorasActionPerformed(evt);
            }
        });
        MnEditoras.add(MnItemAtualizarEditoras);

        jMenuBar1.add(MnEditoras);

        MnAssuntos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/assunto.png"))); // NOI18N
        MnAssuntos.setText("Assuntos");
        MnAssuntos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        MnItemListarAssuntos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MnItemListarAssuntos.setText("Listar");
        MnItemListarAssuntos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnItemListarAssuntosActionPerformed(evt);
            }
        });
        MnAssuntos.add(MnItemListarAssuntos);

        MnItemAtualizarAssuntos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MnItemAtualizarAssuntos.setText("Atualizar Registro");
        MnItemAtualizarAssuntos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnItemAtualizarAssuntosActionPerformed(evt);
            }
        });
        MnAssuntos.add(MnItemAtualizarAssuntos);

        jMenuBar1.add(MnAssuntos);

        MnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sair.png"))); // NOI18N
        MnSair.setText("Sair");
        MnSair.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MnSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MnSairMouseClicked(evt);
            }
        });
        jMenuBar1.add(MnSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MnItemListarLivrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnItemListarLivrosActionPerformed
        // TODO add your handling code here:
        FrmListarLivros tela = new FrmListarLivros();
        tela.setVisible(true);
        
    }//GEN-LAST:event_MnItemListarLivrosActionPerformed

    private void MnItemAtualizarAcervoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnItemAtualizarAcervoActionPerformed
        // TODO add your handling code here:
        FrmAtualizarLivros telas = new FrmAtualizarLivros();
        telas.setVisible(true);
    }//GEN-LAST:event_MnItemAtualizarAcervoActionPerformed

    private void MnItemListarAutoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnItemListarAutoresActionPerformed
        // TODO add your handling code here:
        FrmListarAutores tela = new FrmListarAutores();
        tela.setVisible(true);
    }//GEN-LAST:event_MnItemListarAutoresActionPerformed

    private void MnItemAtualizarAutoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnItemAtualizarAutoresActionPerformed
        // TODO add your handling code here:
        FrmAtualizarAutores tela = new FrmAtualizarAutores();
        tela.setVisible(true);
    }//GEN-LAST:event_MnItemAtualizarAutoresActionPerformed

    private void MnItemListarEditorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnItemListarEditorasActionPerformed
        // TODO add your handling code here:
        FrmListarEditoras tela = new FrmListarEditoras();
        tela.setVisible(true);
    }//GEN-LAST:event_MnItemListarEditorasActionPerformed

    private void MnItemAtualizarEditorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnItemAtualizarEditorasActionPerformed
        // TODO add your handling code here:
        FrmAtualizarEditoras tela = new FrmAtualizarEditoras();
        tela.setVisible(true);
    }//GEN-LAST:event_MnItemAtualizarEditorasActionPerformed

    private void MnItemListarAssuntosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnItemListarAssuntosActionPerformed
        // TODO add your handling code here:
        FrmListaAssuntos tela = new FrmListaAssuntos();
        tela.setVisible(true);
    }//GEN-LAST:event_MnItemListarAssuntosActionPerformed

    private void MnItemAtualizarAssuntosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnItemAtualizarAssuntosActionPerformed
        // TODO add your handling code here:
        FrmAtualizarAssuntos tela = new FrmAtualizarAssuntos();
        tela.setVisible(true);
    }//GEN-LAST:event_MnItemAtualizarAssuntosActionPerformed

    private void MnSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MnSairMouseClicked
        // TODO add your handling code here:
        int opcao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair ?");
        
        if(opcao == 0){            
            System.exit(0);
        }
    }//GEN-LAST:event_MnSairMouseClicked

    /**
     * @param args the command line arguments
     */
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MnAssuntos;
    private javax.swing.JMenu MnAutores;
    private javax.swing.JMenu MnEditoras;
    private javax.swing.JMenuItem MnItemAtualizarAcervo;
    private javax.swing.JMenuItem MnItemAtualizarAssuntos;
    private javax.swing.JMenuItem MnItemAtualizarAutores;
    private javax.swing.JMenuItem MnItemAtualizarEditoras;
    private javax.swing.JMenuItem MnItemListarAssuntos;
    private javax.swing.JMenuItem MnItemListarAutores;
    private javax.swing.JMenuItem MnItemListarEditoras;
    private javax.swing.JMenuItem MnItemListarLivros;
    private javax.swing.JMenu MnLivros;
    private javax.swing.JMenu MnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
