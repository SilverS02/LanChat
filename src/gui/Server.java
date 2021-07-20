/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.JButton;

/**
 *
 * @author Larry Finol y Alejandro
 */
public class Server extends javax.swing.JFrame {

    JButton createButtonServer;
    
    /**
     * Creates new form Server
     */
    public Server(JButton createButtonServer) {
        initComponents();
        setLocationRelativeTo(null);
        
        this.createButtonServer = createButtonServer;
        this.createButtonServer.setEnabled(false);
        
        try {
            ipLabel.setText("IP: " + InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException ex) {
            ipLabel.setText("Error al encontrar la ip local");
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

        jPanel1 = new javax.swing.JPanel();
        ipLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("LanChat - Server");
        setMaximumSize(new java.awt.Dimension(360, 112));
        setMinimumSize(new java.awt.Dimension(360, 112));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(19, 24, 30));

        ipLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ipLabel.setForeground(new java.awt.Color(255, 255, 255));
        ipLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ipLabel.setText("IP: 000.000.000.000");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ipLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ipLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.createButtonServer.setEnabled(true);
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ipLabel;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
