package ppe2022_pharmacie.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import ppe2022_pharmacie.Demande;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sio2021
 */
public class DemandeDAO extends DAO<Demande>{

    // Create
    // Créer dans la table demande une demande de livraison de médicaments
    // Paramètre :
    // Demande unObjet: objet Demande qui est ajouté dans la table
    // Retour :
    // true si la commande est ajoutée avec succès
    // false sinon
    @Override
    public Boolean create(Demande unObjet) {
        if (pdo == null) {
            Connection();
        }
        boolean Check=false;
        try {
            String requete = "insert into demande (idservice, idmedicament, quantite) values (?, ?, ?)";
            PreparedStatement prepare = pdo.prepareStatement(requete);
            prepare.setInt(1, unObjet.getIdD());
            prepare.setInt(2, unObjet.getService().getIdService());
            prepare.setInt(3, unObjet.getMedicament().getId());
            prepare.setInt(4, unObjet.getQtte());
            int res = prepare.executeUpdate();
            Check=true;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erreur insertion demande");
        }
        return Check;
    }

    // Read
    // Récupère une demande de livraison de la bdd
    // Paramètre :
    // int pId : id de la demande qui permet de récupérer les données d'une demande
    // (toutes les demandes ont un id différents => clé primaire)
    // Retour :
    // un objet Demande (null si aucune commande trouvée)
    @Override
    public Demande find(int id) {
        if (pdo == null) {
            Connection();
        }
        Demande uneDemande=null;
        try {
            Statement state = pdo.createStatement();
            String requete = "SELECT * FROM demande where iddemande=?";
            PreparedStatement prepare = pdo.prepareStatement(requete);
            prepare.setInt(1, id);
            ResultSet userResultat = prepare.executeQuery();

            while (userResultat.next()) {
                int idD = userResultat.getInt(1);
                int idS = userResultat.getInt(2);
                int idM = userResultat.getInt(3);
                int qtte = userResultat.getInt(4);
                uneDemande = new Demande(idD,idS,idM,qtte);
            }
            userResultat.close();
            state.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Aucun User / id");
        }
        return uneDemande;
    }

    // Update
    // Modifie une demande de la bdd
    // Paramètre :
    // Demande unObjet : objet Demande qui est modifiée dans la table d'après l'IdDemande
    // Retour :
    // true si la Demande est modifiée avec succès
    // false sinon
    @Override
    public Boolean update(Demande unObjet) {
        String requete = "Update demande set idservice=?, idmedicament=?, quantite=? where iddemande=?";
        boolean check=false;
        try {
            PreparedStatement prepare = pdo.prepareStatement(requete);
            prepare.setInt(1, unObjet.getService().getIdService());
            prepare.setInt(2, unObjet.getMedicament().getId());
            prepare.setInt(3, unObjet.getQtte());
            prepare.setInt(4, unObjet.getIdD());
            prepare.executeUpdate();
            check=true;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erreur dans la modification de la Demande");
        }
        return check;
    }

    // Delete
    // Supprime une demande de la bdd
    // Paramètre :
    // Demande unObjet : objet Demande qui est supprimée selon l'IdDemande
    // Retour :
    // true si la demande est supprimée avec succès
    // false sinon
    @Override
    public Boolean delete(Demande unObjet) {
        if (pdo == null) {
            Connection();
        }
        boolean check=false;
        try {
            String requete = "delete from demande where iddemande=?";
            PreparedStatement prepare = pdo.prepareStatement(requete);
            prepare.setInt(1, unObjet.getIdD());
            prepare.executeUpdate();
            check=true;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erreur dans la suppression d'une Demande");
        }
        return check;
    }

    // FindALL
    // Récupère toutes les demandes de la table demande
    // Paramètre : Aucun
    // Retour :
    // ArrayList de demande où on obtient tous les objets Demande de la table demande
    @Override
    public ArrayList<Demande> findAll() {
        if (pdo == null) {
            Connection();
        }
        ArrayList<Demande> lesDemandes = new ArrayList<Demande>();
        try {
            Statement state = pdo.createStatement();
            String requete = "SELECT * FROM demande";
            ResultSet demandeResultat = state.executeQuery(requete);

            while (demandeResultat.next()) {
                int idD = demandeResultat.getInt(1);
                int idS = demandeResultat.getInt(2);
                int idM = demandeResultat.getInt(3);
                int qtte = demandeResultat.getInt(4);
                Demande uneDemande = new Demande(idD, idS, idM, qtte);
                lesDemandes.add(uneDemande);
            }
            demandeResultat.close();
            state.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Aucune Demande ou id");
        }
        return lesDemandes;
    }
    
    // Récupère dans une liste toutes les demandes par rapport à un service
    // Paramètre :
    // int idService : l'id d'un service dont on veut toutes les demandes
    // Retour :
    // ArrayList d'objets Demande d'un service
    public ArrayList<Demande> AfficherDemandeParService(int idService) {
        if (pdo == null) {
            Connection();
        }
        ArrayList<Demande> lesDemandes = new ArrayList<Demande>();
        try {
            String requete = "SELECT * FROM demande where idservice=?";
            PreparedStatement prepare = pdo.prepareStatement(requete);
            
            prepare.setInt(1, idService);
            
            
            ResultSet demandeResultat = prepare.executeQuery();

            while (demandeResultat.next()) {
                int idD = demandeResultat.getInt(1);
                int idS = demandeResultat.getInt(2);
                int idM = demandeResultat.getInt(3);
                int qtte = demandeResultat.getInt(4);
                Demande uneDemande = new Demande(idD, idS, idM, qtte);
                lesDemandes.add(uneDemande);
            }
            demandeResultat.close();
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Aucune Demande ou id");
        }
        return lesDemandes;
    }
    
}
