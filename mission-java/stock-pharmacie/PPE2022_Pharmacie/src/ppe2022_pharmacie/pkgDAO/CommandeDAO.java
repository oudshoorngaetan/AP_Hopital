package ppe2022_pharmacie.pkgDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import ppe2022_pharmacie.metiers.Commandes;
import static ppe2022_pharmacie.pkgDAO.DAO.pdo;

public class CommandeDAO extends DAO<Commandes>{
    // Create
    // Créer dans la table commande une commande
    // Paramètre :
    // Commandes uneCommande : objet Commandes qui est ajouté dans la table
    // Retour :
    // true si la commande est ajoutée avec succès
    // false sinon
    @Override
    public Boolean create(Commandes uneCommande) {
        boolean result = false;
        if (pdo == null) {
            Connection();
        }
        int id = uneCommande.getIdc();
        String fournisseur = uneCommande.getFournisseur();
        String medicament = uneCommande.getMedicament();
        int qtte = uneCommande.getQtte();
        String requete = "Insert Into commandes values (?,?,?,?)";

        try {
            PreparedStatement prepare = pdo.prepareStatement(requete);
            prepare.setInt(1, id);
            prepare.setString(2, fournisseur);
            prepare.setString(3, medicament);
            prepare.setInt(4, qtte);
            prepare.executeUpdate();
            result = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    // Read
    // Récupère une commande de la bdd
    // Paramètre :
    // int pId : id de la commande qui permet de récupérer les données d'une commande
    // (toutes les commandes ont un id différents => clé primaire)
    // Retour :
    // un objet Commandes (null si aucune commande trouvée)
    @Override
    public Commandes find(int pId) {
        if (pdo == null) {
            Connection();
        }
        Commandes uneCommande = null;
        String requete = "Select fournisseur,medicament,qtte From commandes Where idc=?";
        try {
            PreparedStatement prepare = pdo.prepareStatement(requete);
            prepare.setInt(1, pId);
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                String fournisseur = result.getString(1);
                String medicament = result.getString(2);
                int qtte = result.getInt(3);
                uneCommande = new Commandes(pId, fournisseur, medicament, qtte);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return uneCommande;
    }

    // Update
    // Modifie une commande de la bdd
    // Paramètre :
    // Commandes uneCommande : objet Commandes qui est modifiée dans la table d'après l'ID
    // Retour :
    // true si la commande est modifiée avec succès
    // false sinon
    @Override
    public Boolean update(Commandes uneCommande) {
        boolean result = false;
        if (pdo == null) {
            Connection();
        }
        
        int id = uneCommande.getIdc();
        String fournisseur = uneCommande.getFournisseur();
        String medicament = uneCommande.getMedicament();
        int qtte = uneCommande.getQtte();
        String requete = "Update commandes Set fournisseur=?,medicament=?,qtte=? Where idc=?";

        try {
            PreparedStatement prepare = pdo.prepareStatement(requete);
            prepare.setString(1, fournisseur);
            prepare.setString(2, medicament);
            prepare.setInt(3, qtte);
            prepare.setInt(4, id);
            prepare.executeUpdate();
            result = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    
    // Delete
    // Supprime une commande de la bdd
    // Paramètre :
    // Commandes uneCommande : objet Commandes qui est supprimée selon l'ID
    // Retour :
    // true si la commande est supprimée avec succès
    // false sinon
    @Override
    public Boolean delete(Commandes uneCommande){
        boolean result = false;
        if (pdo == null) {
            Connection();
        }
        int id = uneCommande.getIdc();
        String requete = "Delete From commandes where idc=?";
        try {
            PreparedStatement prepare = pdo.prepareStatement(requete);
            prepare.setInt(1, id);
            prepare.executeUpdate();
            result = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return result;
    }

    // FindALL
    // Récupère toutes les commandes de la table commandes
    // Paramètre : Aucun
    // Retour :
    // ArrayList de commandes où on obtient tous les objets commandes de la table commandes
    @Override
    public ArrayList<Commandes> findAll() {
        // meme chose que la methodes donnerToutesLesCommades()
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    // Donne toutes les commandes de la table commande
    // Paramètre : Aucun
    // Retour : 
    // ArrayList de commandes où on obtient tous les objets commandes de la table commandes
    public  static ArrayList<Commandes> donnerToutesLesCommandes() {
        if (pdo == null) {
            Connection();
        }
        ArrayList<Commandes> lesCommandes = new ArrayList<Commandes>();
        try {
            Statement state = pdo.createStatement();
            String requete = "select * from commandes";
            ResultSet commandesResultat = state.executeQuery(requete);
            while (commandesResultat.next()) {
                int idc = commandesResultat.getInt(1);
                String fournisseur = commandesResultat.getString(2);
                String medicament = commandesResultat.getString(3);
                int qtte = commandesResultat.getInt(4);
                Commandes uneCommande = new Commandes(idc, fournisseur, medicament, qtte);
                lesCommandes.add(uneCommande);
            }
            commandesResultat.close();
            state.close();

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erreur donner toutes les commandes");
        }
        return lesCommandes;
    }
    
    // Ajoute une commande dans la table commandes
    // Paramètres :
    // String fournisseur : Le fournisseur des médicaments à ajouter dans le stock
    // String medicament  : Le nom du médicament ajouté
    // int qtte : La quantité de médicaments ajoutée au stock
    public static boolean ajouterCommande(String fournisseur, String medicament, int qtte) {
        boolean result = false;
        if (pdo == null) {
            DAO.Connection();
        }
        try {
            Statement state = pdo.createStatement();
            String requete1 = "select max(idc) from commandes";
            ResultSet stockResultat = state.executeQuery(requete1);
            if (stockResultat.next()) {
                int idc = stockResultat.getInt(1) + 1;
                String requete2 = "insert into commandes (idc,fournisseur, medicament, qtte) values(?, ?, ?, ?)";
                PreparedStatement prepare = pdo.prepareStatement(requete2);
                prepare.setInt(1, idc);
                prepare.setString(2, fournisseur);
                prepare.setString(3, medicament);
                prepare.setInt(4, qtte);
                prepare.executeUpdate();
                result = true;
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erreur dans l'ajout de la commande");
        }
        return result;
    }
    
    // Récupère tous les fournisseurs de la table fournisseur
    // Paramètre : Aucun
    // Retour :
    // Une ArrayList du nom de chaque fournisseur provenant de la table fournisseur
    public static ArrayList<String> donnerFournisseur() {
        if (pdo == null) {
            DAO.Connection();
        }
        ArrayList ArrayFournisseur = new ArrayList();
        try {
            Statement state = pdo.createStatement();
            String requete = "select distinct nom from fournisseur";
            ResultSet stockResultat = state.executeQuery(requete);
            while (stockResultat.next()) {
                String fournisseur = stockResultat.getString(1);
//                Medicament unStock = new Medicament(categorie);
                ArrayFournisseur.add(fournisseur);
            }
            stockResultat.close();
            state.close();

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erreur donner tous les stocks");
        }
        return ArrayFournisseur;
    }
}
