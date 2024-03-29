/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppe2022_pharmacie.IHM;

import ppe2022_pharmacie.metiers.*;
import ppe2022_pharmacie.pkgDAO.ServiceDAO;
import ppe2022_pharmacie.pkgDAO.UtilisateurDAO;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.xml.bind.DatatypeConverter;
import jakarta.xml.bind.DatatypeConverter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author hbana
 */
public class Authentification extends javax.swing.JFrame implements KeyListener {

    private static final UtilisateurDAO passerelleUser = new UtilisateurDAO();
    private static final ServiceDAO passerelleService = new ServiceDAO();

    /**
     * Creates new form Authentification
     */
    public Authentification() {
        initComponents();
        this.setTitle("Se connecter");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtLogin = new java.awt.TextField();
        btnConnexion = new javax.swing.JButton();
        lblOutput = new javax.swing.JLabel();
        pwdPasse = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        txtLogin.setText("Login");
        txtLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtLoginMouseClicked(evt);
            }
        });
        txtLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoginActionPerformed(evt);
            }
        });

        btnConnexion.setText("Se connecter");
        btnConnexion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConnexionMouseClicked(evt);
            }
        });

        pwdPasse.setText("jPasswordField1");
        pwdPasse.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pwdPasseFocusGained(evt);
            }
        });
        pwdPasse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pwdPasseMouseClicked(evt);
            }
        });
        pwdPasse.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pwdPasseKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblOutput, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnConnexion, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(pwdPasse))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pwdPasse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConnexion)
                    .addComponent(lblOutput))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLoginActionPerformed

    private void btnConnexionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConnexionMouseClicked
        if (pwdPasse.getPassword().length != 0 && !txtLogin.getText().equals("")) {
            String login = txtLogin.getText();
            String passe = "";
            char[] passeChar = pwdPasse.getPassword();
            for (char unChar : passeChar) {
                passe += unChar;
            }
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte raw[] = md.digest(passe.getBytes("UTF-8"));
                String hash;
                hash = DatatypeConverter.printHexBinary(raw);

                int[] info = passerelleUser.Authentification(login, hash);
                Service service = passerelleService.find(info[1]);
                System.out.println(info[0]);
                System.out.println(info[1]);
                System.out.println(info[2]);
                Utilisateur unUtilisateur = new Utilisateur(login, service, info[2], hash);

                if (info[0] == 0) {
                    lblOutput.setText("Erreur dans le couple Login/mdp");
                } else {
                    lblOutput.setText("Connexion Effectuee");
                    switch (info[1]) {
                        case 0:
                            break;
                        case 1:
                            new AfficherLesUsers().setVisible(true);
                            this.dispose();
                            break;
                        case 2:
                            new AfficherTousLesStock(unUtilisateur).setVisible(true);
                            this.dispose();
                            break;
                        default:
                            System.out.println(unUtilisateur.getService().getLibelle());
                            new AfficherDemandes(false, unUtilisateur).setVisible(true);
                            this.dispose();
                            break;
                    }
                }
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Authentification.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Authentification.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Champs login et/ou mot de passe vide");
        }
    }//GEN-LAST:event_btnConnexionMouseClicked

    private void txtLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtLoginMouseClicked
        txtLogin.setText("");
    }//GEN-LAST:event_txtLoginMouseClicked

    private void pwdPasseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pwdPasseMouseClicked
        pwdPasse.setText("");
    }//GEN-LAST:event_pwdPasseMouseClicked
// Quand on press enter ça valide le form
    private void pwdPasseKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pwdPasseKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            if (pwdPasse.getPassword().length != 0 && !txtLogin.getText().equals("")) {
                String login = txtLogin.getText();

                String passe = "";
                char[] passeChar = pwdPasse.getPassword();
                for (char unChar : passeChar) {
                    passe += unChar;
                }
                try {
                    MessageDigest md = MessageDigest.getInstance("MD5");
                    byte raw[] = md.digest(passe.getBytes("UTF-8"));
                    String hash;
                    hash = DatatypeConverter.printHexBinary(raw);

                    int[] info = passerelleUser.Authentification(login, hash);
                    Service service = passerelleService.find(info[1]);
                    System.out.println(info[0]);
                    System.out.println(info[1]);
                    System.out.println(info[2]);
                    Utilisateur unUtilisateur = new Utilisateur(login, service, info[2], hash);

                    if (info[0] == 0) {
                        lblOutput.setText("Erreur dans le couple Login/mdp");
                    } else {
                        lblOutput.setText("Connexion Effectuee");
                        switch (info[1]) {
                            case 0:
                                break;
                            case 1:
                                new AfficherLesUsers().setVisible(true);
                                this.dispose();
                                break;
                            case 2:
                                new AfficherTousLesStock(unUtilisateur).setVisible(true);
                                this.dispose();
                                break;
                            default:
                                System.out.println(unUtilisateur.getService().getLibelle());
                                new AfficherDemandes(false, unUtilisateur).setVisible(true);
                                this.dispose();
                                break;
                        }
                    }
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(Authentification.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(Authentification.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Champs login et/ou mot de passe vide");
            }
        }
    }//GEN-LAST:event_pwdPasseKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

    }//GEN-LAST:event_formKeyPressed

    private void pwdPasseFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pwdPasseFocusGained

        pwdPasse.setText("");
    }//GEN-LAST:event_pwdPasseFocusGained

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
            java.util.logging.Logger.getLogger(Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Authentification().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConnexion;
    private javax.swing.JLabel lblOutput;
    private javax.swing.JPasswordField pwdPasse;
    private java.awt.TextField txtLogin;
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
