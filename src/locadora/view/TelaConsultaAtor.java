/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.view;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import locadora.controller.AtorController;
import locadora.dao.ExceptionDAO;
import locadora.model.Ator;

/**
 *
 *
 */
public class TelaConsultaAtor extends javax.swing.JFrame {
    
    private TelaCadastroAtor telaCadastroAtor;
    
    public TelaConsultaAtor() {
        initComponents();
    }
    
    public TelaConsultaAtor(TelaCadastroAtor telaCadastroAtor) {
        this.telaCadastroAtor = telaCadastroAtor;
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelConsultaAtor = new javax.swing.JPanel();
        javax.swing.JLabel jLabelNomeAtor = new javax.swing.JLabel();
        jTextFieldNomeAtor = new javax.swing.JTextField();
        jButtonConsultaAtor = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableConsultaAtor = new javax.swing.JTable();
        jLabelTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Video Locadora Hora da Pipoca");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                fecharJanela(evt);
            }
        });

        jPanelConsultaAtor.setBackground(new java.awt.Color(102, 102, 102));

        jLabelNomeAtor.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelNomeAtor.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNomeAtor.setText("Informe o nome do ator:");

        jTextFieldNomeAtor.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jTextFieldNomeAtor.setToolTipText("Informe o nome do ator que deseja consultar.");

        jButtonConsultaAtor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/lupa.png"))); // NOI18N
        jButtonConsultaAtor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarAtor(evt);
            }
        });

        jTableConsultaAtor.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jTableConsultaAtor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Nacionalidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableConsultaAtor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableConsultaAtorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableConsultaAtor);

        javax.swing.GroupLayout jPanelConsultaAtorLayout = new javax.swing.GroupLayout(jPanelConsultaAtor);
        jPanelConsultaAtor.setLayout(jPanelConsultaAtorLayout);
        jPanelConsultaAtorLayout.setHorizontalGroup(
            jPanelConsultaAtorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConsultaAtorLayout.createSequentialGroup()
                .addGroup(jPanelConsultaAtorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelConsultaAtorLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabelNomeAtor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldNomeAtor, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelConsultaAtorLayout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonConsultaAtor, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanelConsultaAtorLayout.setVerticalGroup(
            jPanelConsultaAtorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConsultaAtorLayout.createSequentialGroup()
                .addGroup(jPanelConsultaAtorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelConsultaAtorLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanelConsultaAtorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldNomeAtor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNomeAtor)))
                    .addGroup(jPanelConsultaAtorLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jButtonConsultaAtor, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        jLabelTitulo.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabelTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon.png"))); // NOI18N
        jLabelTitulo.setText("Consulta de Ator");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(279, 279, 279)
                        .addComponent(jLabelTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jPanelConsultaAtor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelConsultaAtor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void consultarAtor(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarAtor
        String nome = jTextFieldNomeAtor.getText();
        DefaultTableModel tableModel = (DefaultTableModel) jTableConsultaAtor.getModel();
        tableModel.setRowCount(0);
        AtorController atorController = new AtorController();
        
        try {
            ArrayList<Ator> atores = atorController.listarAtores(nome);
            atores.forEach((Ator ator) -> {
            tableModel.addRow(new Object[] {ator.getCodAtor(),
                                            ator.getName(),
                                            ator.getNacionalidade()});
            });
            jTableConsultaAtor.setModel(tableModel);
        } catch (ExceptionDAO e) {
            Logger.getLogger(TelaCadastroAtor.class.getName()).log(Level.SEVERE, null, e);
        }   
        
    }//GEN-LAST:event_consultarAtor

    private void fecharJanela(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_fecharJanela
        this.dispose();
        this.telaCadastroAtor.setVisible(true);
    }//GEN-LAST:event_fecharJanela

    private void jTableConsultaAtorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableConsultaAtorMouseClicked
        if(evt.getClickCount() == 2) {
            Integer codAtor = (Integer) jTableConsultaAtor.getModel().getValueAt(jTableConsultaAtor.getSelectedRow(), 0);
            String nome = (String) jTableConsultaAtor.getModel().getValueAt(jTableConsultaAtor.getSelectedRow(), 1);
            String nacionalidade = (String) jTableConsultaAtor.getModel().getValueAt(jTableConsultaAtor.getSelectedRow(), 2);
        
            this.telaCadastroAtor.buscarAtor(codAtor, nome, nacionalidade);
            this.telaCadastroAtor.setVisible(true);
            this.dispose();        
        }
    }//GEN-LAST:event_jTableConsultaAtorMouseClicked

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
            java.util.logging.Logger.getLogger(TelaConsultaAtor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaConsultaAtor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaConsultaAtor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaConsultaAtor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaConsultaAtor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConsultaAtor;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanelConsultaAtor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableConsultaAtor;
    private javax.swing.JTextField jTextFieldNomeAtor;
    // End of variables declaration//GEN-END:variables

}
