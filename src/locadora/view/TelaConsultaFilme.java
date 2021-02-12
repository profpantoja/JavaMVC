/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.view;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import locadora.controller.FilmeController;
import locadora.dao.ExceptionDAO;
import locadora.model.Filme;

public class TelaConsultaFilme extends javax.swing.JFrame {

    private JFrame telaCadastro;
    
    public TelaConsultaFilme() {
        initComponents();
    }

    public TelaConsultaFilme(JFrame telaCadastro) {
        this.telaCadastro = telaCadastro;
        initComponents();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelConsultaFilme = new javax.swing.JPanel();
        jLabelTituloFilme = new javax.swing.JLabel();
        jTextFieldTituloFilme = new javax.swing.JTextField();
        jButtonConsultarFilme = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableConsultaFilme = new javax.swing.JTable();
        jLabelTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Video Locadora Hora da Pipoca");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                fecharJanela(evt);
            }
        });

        jPanelConsultaFilme.setBackground(new java.awt.Color(102, 102, 102));

        jLabelTituloFilme.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelTituloFilme.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTituloFilme.setText("Informe o título do filme:");
        jLabelTituloFilme.setToolTipText("");

        jTextFieldTituloFilme.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jTextFieldTituloFilme.setToolTipText("Informe o título do filme que deseja consultar.");

        jButtonConsultarFilme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/lupa.png"))); // NOI18N
        jButtonConsultarFilme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarFilme(evt);
            }
        });

        jTableConsultaFilme.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jTableConsultaFilme.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Título", "Gênero", "Sinopse", "Duração"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableConsultaFilme.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableConsultaFilmeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableConsultaFilme);

        javax.swing.GroupLayout jPanelConsultaFilmeLayout = new javax.swing.GroupLayout(jPanelConsultaFilme);
        jPanelConsultaFilme.setLayout(jPanelConsultaFilmeLayout);
        jPanelConsultaFilmeLayout.setHorizontalGroup(
            jPanelConsultaFilmeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConsultaFilmeLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanelConsultaFilmeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanelConsultaFilmeLayout.createSequentialGroup()
                        .addComponent(jLabelTituloFilme)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldTituloFilme, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonConsultarFilme, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanelConsultaFilmeLayout.setVerticalGroup(
            jPanelConsultaFilmeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConsultaFilmeLayout.createSequentialGroup()
                .addGroup(jPanelConsultaFilmeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelConsultaFilmeLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabelTituloFilme))
                    .addGroup(jPanelConsultaFilmeLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jButtonConsultarFilme, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelConsultaFilmeLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jTextFieldTituloFilme)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        jLabelTitulo.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabelTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon.png"))); // NOI18N
        jLabelTitulo.setText("Consulta de Filme");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(jLabelTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jPanelConsultaFilme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelConsultaFilme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void consultarFilme(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarFilme
        String nome = jTextFieldTituloFilme.getText();
        DefaultTableModel tableModel = (DefaultTableModel) jTableConsultaFilme.getModel();
        tableModel.setRowCount(0);
        FilmeController filmeController = new FilmeController();
        try {
            ArrayList<Filme> filmes = filmeController.listarFilmes(nome);
            filmes.forEach((Filme filme) -> {
                tableModel.addRow(new Object[] {filme.getCodFilme(),
                                                filme.getTitulo(),
                                                filme.getGenero(),
                                                filme.getSinopse(),
                                                filme.getDuração()});
            });
            jTableConsultaFilme.setModel(tableModel);
        } catch (ExceptionDAO e) {
            Logger.getLogger(TelaCadastroFilme.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_consultarFilme

    private void fecharJanela(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_fecharJanela
        this.dispose();
        this.telaCadastro.setVisible(true);
    }//GEN-LAST:event_fecharJanela

    private void jTableConsultaFilmeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableConsultaFilmeMouseClicked
        if(evt.getClickCount()==2){
            Integer codFilme = (Integer) jTableConsultaFilme.getModel().getValueAt(jTableConsultaFilme.getSelectedRow(), 0);
            String titulo = (String) jTableConsultaFilme.getModel().getValueAt(jTableConsultaFilme.getSelectedRow(), 1);
            String genero = (String) jTableConsultaFilme.getModel().getValueAt(jTableConsultaFilme.getSelectedRow(), 2);
            String sinopse = (String) jTableConsultaFilme.getModel().getValueAt(jTableConsultaFilme.getSelectedRow(), 3);
            Integer duração = (Integer) jTableConsultaFilme.getModel().getValueAt(jTableConsultaFilme.getSelectedRow(), 4);          
            
            String tipoTela = this.telaCadastro.getClass().getSimpleName();

            if (tipoTela.equals("TelaCadastroFilme")) {
                TelaCadastroFilme telaCadastroFilme = (TelaCadastroFilme) this.telaCadastro;
                telaCadastroFilme.buscarFilme(codFilme, titulo, genero, sinopse, duração);
                telaCadastroFilme.setVisible(true);
            } else {
                TelaCadastroItem telaCadastroItem = (TelaCadastroItem) this.telaCadastro;
                telaCadastroItem.buscarFilme(codFilme, titulo);
                telaCadastroItem.setVisible(true);
            }
            this.dispose();
        }
    }//GEN-LAST:event_jTableConsultaFilmeMouseClicked

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
            java.util.logging.Logger.getLogger(TelaConsultaFilme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaConsultaFilme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaConsultaFilme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaConsultaFilme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaConsultaFilme().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConsultarFilme;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelTituloFilme;
    private javax.swing.JPanel jPanelConsultaFilme;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableConsultaFilme;
    private javax.swing.JTextField jTextFieldTituloFilme;
    // End of variables declaration//GEN-END:variables
}
