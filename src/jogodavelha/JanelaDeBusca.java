package jogodavelha;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import jogodavelha.GetIP;
import tcp.MulticastReceiver;
import tcp.MulticastSender;

public class JanelaDeBusca extends javax.swing.JFrame {

    GetIP pegandoIP = new GetIP();
    private static JanelaDeBusca instance = null;
    Boolean clicouEmEntrar, clicouEmCriar = false;

    public JanelaDeBusca() {
        initComponents();
        btnCancelar.setVisible(false);
    }

    public static JanelaDeBusca getInstance() {
        if (instance == null) {
            instance = new JanelaDeBusca();
        }
        return instance;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblInfo = new javax.swing.JLabel();
        btnCriarSala = new javax.swing.JButton();
        btnEntrarSala = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Buscar Jogador - Jogo da Velha");
        setResizable(false);

        lblInfo.setText("Escolha se você quer criar ou entrar em uma sala!");

        btnCriarSala.setText("Criar sala");
        btnCriarSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarSalaActionPerformed(evt);
            }
        });

        btnEntrarSala.setText("Entrar em sala");
        btnEntrarSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarSalaActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(lblInfo)
                .addGap(32, 32, 32))
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(btnCancelar))
                        .addComponent(btnEntrarSala))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCriarSala)
                        .addGap(14, 14, 14)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInfo)
                .addGap(37, 37, 37)
                .addComponent(btnCriarSala)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEntrarSala)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCriarSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarSalaActionPerformed
        desativandoBotoes(false);
        clicouEmCriar = true;
        MulticastSender enviandoDados = new MulticastSender();
        Thread t = new Thread(enviandoDados);
        t.run();
    }//GEN-LAST:event_btnCriarSalaActionPerformed

    private void btnEntrarSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarSalaActionPerformed
        desativandoBotoes(false);
        clicouEmEntrar = true;
        MulticastReceiver recebendoDoMulticast = new MulticastReceiver();
        Thread t = new Thread(recebendoDoMulticast);
        t.run();
    }//GEN-LAST:event_btnEntrarSalaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        desativandoBotoes(true);
        if (clicouEmEntrar) {
            MulticastReceiver recebendoDoMulticast = new MulticastReceiver();
            Thread t = new Thread(recebendoDoMulticast);
            t.interrupt();
        } else if (clicouEmCriar) {
            MulticastSender enviandoDados = new MulticastSender();
            Thread t = new Thread(enviandoDados);
            t.interrupt();
        }
        clicouEmCriar = false;
        clicouEmEntrar = false;

    }//GEN-LAST:event_btnCancelarActionPerformed

    public void desativandoBotoes(Boolean opt) {
        btnCriarSala.setVisible(opt);
        btnEntrarSala.setVisible(opt);
        btnCancelar.setVisible(!opt);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*  teste Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(JanelaDeBusca.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaDeBusca.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaDeBusca.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaDeBusca.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JanelaDeBusca.getInstance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCriarSala;
    private javax.swing.JButton btnEntrarSala;
    private javax.swing.JLabel lblInfo;
    // End of variables declaration//GEN-END:variables
}
