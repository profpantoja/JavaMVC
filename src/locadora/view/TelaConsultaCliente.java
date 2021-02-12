/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import locadora.controller.ClienteController;
import locadora.dao.ExceptionDAO;
import locadora.model.Cliente;

/**
 *
 *
 */
public class TelaConsultaCliente extends javax.swing.JFrame {

    private TelaCadastroCliente telaCadastroCliente;

    public TelaConsultaCliente() {
        initComponents();
    }

    public TelaConsultaCliente(TelaCadastroCliente telaCadastroCliente) {
        this.telaCadastroCliente = telaCadastroCliente;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelConsultaCliente = new javax.swing.JPanel();
        jLabelNome = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jButtonConsultarCliente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableConsultaCliente = new javax.swing.JTable();
        jLabelTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Video Locadora Hora da Pipoca");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                fecharJanela(evt);
            }
        });

        jPanelConsultaCliente.setBackground(new java.awt.Color(102, 102, 102));
        jPanelConsultaCliente.setToolTipText("");

        jLabelNome.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelNome.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNome.setText("Informe o nome do cliente:");
        jLabelNome.setToolTipText("");

        jTextFieldNome.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jTextFieldNome.setToolTipText("Informe o nome do cliente que deseja consultar.");

        jButtonConsultarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/lupa.png"))); // NOI18N
        jButtonConsultarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarCliente(evt);
            }
        });

        jTableConsultaCliente.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jTableConsultaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "CPF", "E-mail", "Endereço", "Nascimento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableConsultaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableConsultaClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableConsultaCliente);

        javax.swing.GroupLayout jPanelConsultaClienteLayout = new javax.swing.GroupLayout(jPanelConsultaCliente);
        jPanelConsultaCliente.setLayout(jPanelConsultaClienteLayout);
        jPanelConsultaClienteLayout.setHorizontalGroup(
            jPanelConsultaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConsultaClienteLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanelConsultaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanelConsultaClienteLayout.createSequentialGroup()
                        .addComponent(jLabelNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonConsultarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanelConsultaClienteLayout.setVerticalGroup(
            jPanelConsultaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConsultaClienteLayout.createSequentialGroup()
                .addGroup(jPanelConsultaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelConsultaClienteLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanelConsultaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNome, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)))
                    .addGroup(jPanelConsultaClienteLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jButtonConsultarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        jLabelTitulo.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabelTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon.png"))); // NOI18N
        jLabelTitulo.setText("Consulta de Cliente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jPanelConsultaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(jLabelTitulo)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelConsultaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void consultarCliente(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarCliente
        String nome = jTextFieldNome.getText();
        DefaultTableModel tableModel = (DefaultTableModel) jTableConsultaCliente.getModel();
        tableModel.setRowCount(0);
        ClienteController clienteController = new ClienteController();
        
        try {         
            ArrayList<Cliente> clientes = clienteController.listarClientes(nome);
            clientes.forEach((Cliente cliente) -> {
                tableModel.addRow(new Object[] {cliente.getCodCliente(),
                                                cliente.getNome(),
                                                cliente.getCpf(),
                                                cliente.getEmail(),
                                                cliente.getEndereço(),
                                                cliente.getDtNascimento()});
            });
            jTableConsultaCliente.setModel(tableModel);
        } catch (ExceptionDAO e) {
            Logger.getLogger(TelaCadastroCliente.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }//GEN-LAST:event_consultarCliente

    private void fecharJanela(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_fecharJanela
        this.dispose();
        this.telaCadastroCliente.setVisible(true);
    }//GEN-LAST:event_fecharJanela

    private void jTableConsultaClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableConsultaClienteMouseClicked
        if(evt.getClickCount()==2) {
            Integer codCliente = (Integer) jTableConsultaCliente.getModel().getValueAt(jTableConsultaCliente.getSelectedRow(), 0);
            String nome = (String) jTableConsultaCliente.getModel().getValueAt(jTableConsultaCliente.getSelectedRow(), 1);
            String cpf = (String) jTableConsultaCliente.getModel().getValueAt(jTableConsultaCliente.getSelectedRow(), 2);
            String email = (String) jTableConsultaCliente.getModel().getValueAt(jTableConsultaCliente.getSelectedRow(), 3);
            String endereço = (String) jTableConsultaCliente.getModel().getValueAt(jTableConsultaCliente.getSelectedRow(), 4);
            Date dtNascimento = (Date) jTableConsultaCliente.getModel().getValueAt(jTableConsultaCliente.getSelectedRow(), 5);
          
            this.telaCadastroCliente.buscarCliente(codCliente, nome, cpf, email, endereço, dtNascimento);
            this.telaCadastroCliente.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jTableConsultaClienteMouseClicked

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
            java.util.logging.Logger.getLogger(TelaConsultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaConsultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaConsultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaConsultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaConsultaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConsultarCliente;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanelConsultaCliente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableConsultaCliente;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables

}
