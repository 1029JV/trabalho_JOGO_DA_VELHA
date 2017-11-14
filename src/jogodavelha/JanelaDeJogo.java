/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelha;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import tcp.*;

/**
 *
 * @author João Vitor
 */
public class JanelaDeJogo extends javax.swing.JFrame {

    Integer vez = 0;
    ClienteTCP cliente = new ClienteTCP();
    String ipParaConectar = "192.168.0.101";
    List<Integer> verificaJogada = new ArrayList<>();

    private static JanelaDeJogo instance = null;

    private JanelaDeJogo() {
        initComponents();
    }

    public static JanelaDeJogo getInstance() {
        if (instance == null) {
            instance = new JanelaDeJogo();
        }
        return instance;
    }

    public void pegouIp(String ip) {
        ipParaConectar = ip;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        btnSete = new javax.swing.JButton();
        btnUm = new javax.swing.JButton();
        btnQuatro = new javax.swing.JButton();
        btnOito = new javax.swing.JButton();
        btnDois = new javax.swing.JButton();
        btnCinco = new javax.swing.JButton();
        btnNove = new javax.swing.JButton();
        btnSeis = new javax.swing.JButton();
        btnTres = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Jogo da Velha");
        setResizable(false);

        btnSete.setText("       ");
        btnSete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeteActionPerformed(evt);
            }
        });

        btnUm.setText(" ");
        btnUm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUmActionPerformed(evt);
            }
        });

        btnQuatro.setText("    ");
        btnQuatro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuatroActionPerformed(evt);
            }
        });

        btnOito.setText("        ");
        btnOito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOitoActionPerformed(evt);
            }
        });

        btnDois.setText("  ");
        btnDois.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoisActionPerformed(evt);
            }
        });

        btnCinco.setText("     ");
        btnCinco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCincoActionPerformed(evt);
            }
        });

        btnNove.setText("         ");
        btnNove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoveActionPerformed(evt);
            }
        });

        btnSeis.setText("      ");
        btnSeis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeisActionPerformed(evt);
            }
        });

        btnTres.setText("   ");
        btnTres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUm, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuatro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDois, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOito, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCinco, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTres, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNove, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeis, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTres, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSeis, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNove, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDois, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCinco, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOito, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnUm, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuatro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="Botões">  
    private void btnTresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTresActionPerformed
        desativaBtn(3);
    }//GEN-LAST:event_btnTresActionPerformed

    private void btnUmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUmActionPerformed
        desativaBtn(1);
    }//GEN-LAST:event_btnUmActionPerformed

    private void btnDoisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoisActionPerformed
        desativaBtn(2);
    }//GEN-LAST:event_btnDoisActionPerformed

    private void btnQuatroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuatroActionPerformed
        desativaBtn(4);
    }//GEN-LAST:event_btnQuatroActionPerformed

    private void btnCincoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCincoActionPerformed
        desativaBtn(5);
    }//GEN-LAST:event_btnCincoActionPerformed

    private void btnSeisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeisActionPerformed
        desativaBtn(6);
    }//GEN-LAST:event_btnSeisActionPerformed

    private void btnSeteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeteActionPerformed
        desativaBtn(7);
    }//GEN-LAST:event_btnSeteActionPerformed

    private void btnOitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOitoActionPerformed
        desativaBtn(8);
    }//GEN-LAST:event_btnOitoActionPerformed

    private void btnNoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoveActionPerformed
        desativaBtn(9);
    }//GEN-LAST:event_btnNoveActionPerformed
    // </editor-fold>   

    public void desativaBtn(Integer i) {
        System.out.println(i);
        if (!(verificaJogada.contains(i))) {
            verificaJogada.add(i);
            vez += 1;
            switch (i) {
                case 1:
                    btnUm.setEnabled(false);
                    if (vez % 2 == 0) {
                        btnUm.setText("X");
                    } else {
                        btnUm.setText("O");
                    }
                    break;
                case 2:
                    btnDois.setEnabled(false);
                    if (vez % 2 == 0) {
                        btnDois.setText("X");
                    } else {
                        btnDois.setText("O");
                    }
                    break;
                case 3:
                    btnTres.setEnabled(false);
                    if (vez % 2 == 0) {
                        btnTres.setText("X");
                    } else {
                        btnTres.setText("O");
                    }
                    break;
                case 4:
                    btnQuatro.setEnabled(false);
                    if (vez % 2 == 0) {
                        btnQuatro.setText("X");
                    } else {
                        btnQuatro.setText("O");
                    }
                    break;
                case 5:
                    btnCinco.setEnabled(false);
                    if (vez % 2 == 0) {
                        btnCinco.setText("X");
                    } else {
                        btnCinco.setText("O");
                    }
                    break;
                case 6:
                    btnSeis.setEnabled(false);
                    if (vez % 2 == 0) {
                        btnSeis.setText("X");
                    } else {
                        btnSeis.setText("O");
                    }
                    break;
                case 7:
                    btnSete.setEnabled(false);
                    if (vez % 2 == 0) {
                        btnSete.setText("X");
                    } else {
                        btnSete.setText("O");
                    }
                    break;
                case 8:
                    btnOito.setEnabled(false);
                    if (vez % 2 == 0) {
                        btnOito.setText("X");
                    } else {
                        btnOito.setText("O");
                    }
                    break;
                case 9:
                    btnNove.setEnabled(false);
                    if (vez % 2 == 0) {
                        btnNove.setText("X");
                    } else {
                        btnNove.setText("O");
                    }
                    break;
                default:
                    System.out.println("nenhum");
            }
            cliente.enviar(ipParaConectar, i.toString());
            JanelaDeJogo.getInstance().setVisible(false);
            JanelaDeJogo.getInstance().setVisible(true);
            partidaGanha();
        }
    }

    private void partidaGanha() {
        if ((btnUm.getText().equals(btnDois.getText())) && (btnDois.getText().equals(btnTres.getText()))) {
            ganhadorFoi();
        } else if ((btnQuatro.getText().equals(btnCinco.getText())) && (btnCinco.getText().equals(btnSeis.getText()))) {
            ganhadorFoi();
        } else if ((btnSete.getText().equals(btnOito.getText())) && (btnOito.getText().equals(btnNove.getText()))) {
            ganhadorFoi();
        } else if ((btnUm.getText().equals(btnCinco.getText())) && (btnCinco.getText().equals(btnNove.getText()))) {
            ganhadorFoi();
        } else if ((btnTres.getText().equals(btnCinco.getText())) && (btnCinco.getText().equals(btnSete.getText()))) {
            ganhadorFoi();
        } else if ((btnUm.getText().equals(btnQuatro.getText())) && (btnQuatro.getText().equals(btnSete.getText()))) {
            ganhadorFoi();
        } else if ((btnDois.getText().equals(btnCinco.getText())) && (btnCinco.getText().equals(btnOito.getText()))) {
            ganhadorFoi();
        } else if ((btnTres.getText().equals(btnSeis.getText())) && (btnSeis.getText().equals(btnNove.getText()))) {
            ganhadorFoi();
        } else if (vez >= 8) {
            JOptionPane.showMessageDialog(null, "Nenhum dos dois jogadores ganhou!");
            this.dispose();
        }
    }

    private void ganhadorFoi() {
        if ((vez % 2) == 0) {
            JOptionPane.showMessageDialog(null, "Jogador X, ganhou a partida!");
            ServidorTCP servidor = new ServidorTCP(JanelaDeJogo.getInstance());
            Thread t = new Thread(servidor);
            t.interrupt();
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Jogador O, ganhou a partida!");
            ServidorTCP servidor = new ServidorTCP(JanelaDeJogo.getInstance());
            Thread t = new Thread(servidor);
            t.interrupt();
            this.dispose();
        }
    }

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
            java.util.logging.Logger.getLogger(JanelaDeJogo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaDeJogo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaDeJogo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaDeJogo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JanelaDeJogo.getInstance().setVisible(true);
            }
        });
        ServidorTCP servidor = new ServidorTCP(JanelaDeJogo.getInstance());
        Thread t = new Thread(servidor);
        t.run();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCinco;
    private javax.swing.JButton btnDois;
    private javax.swing.JButton btnNove;
    private javax.swing.JButton btnOito;
    private javax.swing.JButton btnQuatro;
    private javax.swing.JButton btnSeis;
    private javax.swing.JButton btnSete;
    private javax.swing.JButton btnTres;
    private javax.swing.JButton btnUm;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
