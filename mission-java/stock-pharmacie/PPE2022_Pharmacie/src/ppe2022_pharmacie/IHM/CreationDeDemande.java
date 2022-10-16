/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppe2022_pharmacie.IHM;

import ppe2022_pharmacie.metiers.*;
import ppe2022_pharmacie.pkgDAO.MedicamentDAO;
import ppe2022_pharmacie.pkgDAO.DemandeDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author sio2021
 */
public class CreationDeDemande extends javax.swing.JFrame {

    /**
     * Creates new form CreationDeDemande
     */
    private int idService;
    private int idDemande;

    MedicamentDAO passerelleMedicament = new MedicamentDAO();
    DemandeDAO passerelleDemande = new DemandeDAO();

    public CreationDeDemande(Utilisateur unUser) {
        idService = unUser.getService().getIdService();
        this.setResizable(false);
        initComponents();
        btnModifier.setVisible(false);
        DefaultComboBoxModel<Medicament> lisModel = new DefaultComboBoxModel<>();

        for (Medicament pdt : passerelleMedicament.findAll()) {
            lisModel.addElement(pdt);
        }
        cbxMedicament.setModel(lisModel);

        lblService.setText(unUser.getService().getLibelle());
    }

    public CreationDeDemande(Utilisateur unUser, Demande uneDemande) {
        idService = unUser.getService().getIdService();
        idDemande = uneDemande.getIdD();
        this.setResizable(false);
        initComponents();
        DefaultComboBoxModel<Medicament> lisModel = new DefaultComboBoxModel<>();
        btnV.setVisible(false);

        for (Medicament pdt : passerelleMedicament.findAll()) {
            lisModel.addElement(pdt);
        }
        cbxMedicament.setModel(lisModel);

        cbxMedicament.setSelectedItem(uneDemande.getMedicament());

        txtQtte.setText(String.valueOf(uneDemande.getQtte()));

        lblService.setText(uneDemande.getService().getLibelle());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnV = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtQtte = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnAnnuler = new javax.swing.JButton();
        cbxMedicament = new javax.swing.JComboBox<>();
        lblService = new javax.swing.JLabel();
        btnModifier = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Création d'une Demande");

        btnV.setText("Valider");
        btnV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVMouseClicked(evt);
            }
        });
        btnV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVActionPerformed(evt);
            }
        });

        jLabel3.setText("Entrer l'id du Service:");

        jLabel4.setText("Entrer l'id du Médicament:");

        jLabel5.setText("Entrer la Quantitée:");

        btnAnnuler.setText("Annuler");
        btnAnnuler.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAnnulerMouseClicked(evt);
            }
        });
        btnAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnnulerActionPerformed(evt);
            }
        });

        cbxMedicament.setModel(new javax.swing.DefaultComboBoxModel<>());
        cbxMedicament.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMedicamentActionPerformed(evt);
            }
        });

        lblService.setText(".");

        btnModifier.setText("Modifier");
        btnModifier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModifierMouseClicked(evt);
            }
        });
        btnModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtQtte, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(cbxMedicament, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblService, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 675, Short.MAX_VALUE)
                        .addComponent(btnModifier))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAnnuler)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnV)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblService))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbxMedicament, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQtte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(btnModifier))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnV)
                    .addComponent(btnAnnuler))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVActionPerformed
        // TODO add your handling code here:
        Medicament med = (Medicament) cbxMedicament.getSelectedItem();
        int idMed = med.getId();
        String Sqtte = txtQtte.getText();

        int idServ = idService;

        // GO : Voir explications dans btnModifierMouseClicked
        //int qtte = Integer.parseInt(Sqtte);

        Demande uneDemande = null;

        // GO : Voir explications dans btnModifierMouseClicked
        if (Sqtte.isEmpty() || !isNumber(Sqtte) || Integer.parseInt(Sqtte) <= 0) {
            JOptionPane.showMessageDialog(null, "Erreur de saisie");

        } else {
            // GO : Création d'une requête pour récupérer le dernier ID et faire +1 pour la création (pas d'id en double)
            try {
                String requete = "SELECT max(iddemande) FROM demande";
                // GO : DemandeDAO.getPdo() pour récupérer l'attribut pdo de la classe DAO
                Statement stmt = DemandeDAO.getPdo().createStatement();
                ResultSet demandeResultat = stmt.executeQuery(requete);
                if (demandeResultat.next()) {
                    idDemande = demandeResultat.getInt(1) + 1;
                    uneDemande = new Demande(idDemande, idServ, idMed, Integer.parseInt(Sqtte));

                    passerelleDemande.create(uneDemande);
                    JOptionPane.showMessageDialog(null, "Demande créée");
                    //ajout julien
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Erreur lors de la demande");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erreur lors de la demande");
            }
        }
    }//GEN-LAST:event_btnVActionPerformed
// ajout julien : Création d'une méthode pour verif si integer

    public static boolean isNumber(String in) {
        try {
            Integer.parseInt(in);
            return true;
        } catch (Exception E) {
            return false;
        }
    }
    private void btnAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnnulerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAnnulerActionPerformed

    private void btnAnnulerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnnulerMouseClicked
        dispose();
    }//GEN-LAST:event_btnAnnulerMouseClicked

    private void cbxMedicamentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMedicamentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxMedicamentActionPerformed

    private void btnVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVMouseClicked

        /*Medicament med = (Medicament) cbxMedicament.getSelectedItem();
        int idMed = med.getId();
        String Sqtte = txtQtte.getText();

        int idServ = idService;

        int qtte = Integer.parseInt(Sqtte);
        // Rechercher id et ajouter la demande (créer une une méthode create pour DemandeDAO)
        try {
            String requete = "SELECT max(id) FROM demande";
            // GO : DemandeDAO.getPdo() pour récupérer l'attribut pdo de la classe DAO
            PreparedStatement prepare = DemandeDAO.getPdo().prepareStatement(requete);

            prepare.setInt(1, idService);
            ResultSet demandeResultat = prepare.executeQuery();
            demandeResultat.next();
            idDemande = demandeResultat.getInt(0) + 1;
            Demande uneDemande = new Demande(idDemande, idServ, idMed, qtte);

            passerelleDemande.create(uneDemande);
            JOptionPane.showMessageDialog(null, "Demande créée");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Prout");
            JOptionPane.showMessageDialog(null, "Erreur lors de la demande");
        }*/

    }//GEN-LAST:event_btnVMouseClicked

    private void txtQtteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtteActionPerformed

    private void txtMedicamentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMedicamentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMedicamentActionPerformed

    private void btnModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModifierActionPerformed

    private void btnModifierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModifierMouseClicked
        // TODO add your handling code here:
        Medicament med = (Medicament) cbxMedicament.getSelectedItem();
        int idMed = med.getId();
        String Sqtte = txtQtte.getText();

        int idServ = idService;
        
        // GO : Ne peut pas être mis ici car :
        // Si c'est vide => Erreur
        // Si c'est une chaine de caractère => Erreur
        
        // int qtte = Integer.parseInt(Sqtte);
        
        // Verif si nombre valide
        // GO : J'ai déplacé Integer.parseInt(Sqtte) en dernière condition car :
        // Si ce n'est pas un nombre ou si c'est vide on obtient une erreur.
        // Déplacer en dernière condition permet de faire ces premières vérifications 
        // et si la condition est fausse : on ne vérifie pas la prochaine
        // Ainsi on a jamais d'erreur
        if (Sqtte.isEmpty() || !isNumber(Sqtte) || Integer.parseInt(Sqtte) <= 0) {
            JOptionPane.showMessageDialog(null, "Erreur de saisie");
        } else {

            Demande uneDemande = new Demande(idDemande, idServ, idMed, Integer.parseInt(Sqtte));

            passerelleDemande.update(uneDemande);

            JOptionPane.showMessageDialog(null, "Demande modifiée");
            //ajout julien
            dispose();
        }
    }//GEN-LAST:event_btnModifierMouseClicked

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
            java.util.logging.Logger.getLogger(CreationDeDemande.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreationDeDemande.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreationDeDemande.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreationDeDemande.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnnuler;
    private javax.swing.JButton btnModifier;
    private javax.swing.JButton btnV;
    private javax.swing.JComboBox<Medicament> cbxMedicament;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblService;
    private javax.swing.JTextField txtQtte;
    // End of variables declaration//GEN-END:variables
}
