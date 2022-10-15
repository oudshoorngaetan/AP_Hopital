/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ppe2022_pharmacie.pkgDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import ppe2022_pharmacie.metiers.Utilisateur;
import ppe2022_pharmacie.metiers.Service;

/**
 *
 * @author sio2021
 */
public class UtilisateurDAO extends DAO<Utilisateur> {

    /* méthode qui crée un utilisateur
    PARAMETRES : OBJ Utilisateur = login, passe, service 
    
    RETURN : true si l'insertion a été correctement effectuée;
             false si l'insertion dans la bdd n'a pas pu être réalisée.*/
    @Override
    public Boolean create(Utilisateur unObjet) {
        boolean estFonctionnel = false;
        try {
            String requete = "insert into authentification (login, passe, service) values(?, ?, ?)";
            PreparedStatement prepare = pdo.prepareStatement(requete);
            prepare.setString(1, unObjet.getLogin());
            prepare.setString(2, unObjet.getHash());
            System.out.println(unObjet.getHash());
            prepare.setInt(3, unObjet.getService().getIdService());
            prepare.executeUpdate();
            estFonctionnel = true;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erreur dans l'ajout d'un utilisateur");
        }
        return estFonctionnel;
    }

    @Override
    public Utilisateur find(int id) {
        throw new UnsupportedOperationException("Not supported."); //To change body of generated methods, choose Tools | Templates.
    }

    /* méthode qui met à jour un utilisateur dans la bdd
    PARAMETRES : OBJ Utilisateur = login, passe, service 
    
    RETURN : true si la modification a été correctement effectuée;
             false si la modification dans la bdd n'a pas pu être réalisée.*/
    @Override
    public Boolean update(Utilisateur unUser) {
        boolean estFonctionnel = false;
        String requete = "Update authentification set login = ?, passe=?, service=? where idpersonnel=?";
        try {
            PreparedStatement prepare = pdo.prepareStatement(requete);
            prepare.setString(1, unUser.getLogin());
            prepare.setString(2, unUser.getHash());
            prepare.setInt(3, unUser.getService().getIdService());
            prepare.setInt(4, unUser.getIdUser());
            prepare.executeUpdate();

            estFonctionnel = true;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erreur dans la modification de l'utilisateur");
        }

        return estFonctionnel;
    }

    /* méthode qui supprime un utilisateur dans la bdd
    PARAMETRES : OBJ Utilisateur = login, passe, service 
    
    RETURN : true si la suppression a été correctement effectuée;
             false si la suppression dans la bdd n'a pas pu être réalisée.*/
    @Override
    public Boolean delete(Utilisateur unObjet) {
        boolean estFonctionnel = false;
        String requete = "delete from authentification where idpersonnel=?";
        try {
            PreparedStatement prepare = pdo.prepareStatement(requete);
            prepare.setInt(1, unObjet.getIdUser());
            prepare.executeUpdate();

            estFonctionnel = true;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erreur dans la suppression d'un utilisateur");
        }
        return estFonctionnel;
    }

    /* méthode qui affiche les utilisateurs
    PARAMETRES : aucun
    
    RETURN : une collection des utilisateurs */
    @Override
    public ArrayList<Utilisateur> findAll() {
        if (pdo == null) {
            Connection();
        }
        String requete = "select login, service.libelle, service, idpersonnel, passe from"
                + " authentification join service on authentification.service = service.idservice";
        ArrayList<Utilisateur> lesUsers = new ArrayList<>();
        try {
            Statement state = pdo.createStatement();
            ResultSet userResultat = state.executeQuery(requete);
            while (userResultat.next()) {
                String login = userResultat.getString(1);
                String service = userResultat.getString(2);
                int idService = userResultat.getInt(3);
                int idUser = userResultat.getInt(4);
                String passe = userResultat.getString(5);

                lesUsers.add(new Utilisateur(login, new Service(idService, service), idUser, passe));
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erreur dans la récupération des users");
        }
        return lesUsers;
    }

    /* méthode qui affiche un tableau des utilisateurs 
    PARAMETRES : login, password 
    
    RETURN : un tableau de int qui comprend le nombres d'utilisateurs */
    public int[] Authentification(String login, String password) {
        int[] infos = new int[3];
        if (pdo == null) {
            Connection();
        }
        try {
            //Statement state = pdo.createStatement();
            String requete = "Select count(idpersonnel), service, idpersonnel from "
                    + "authentification where login =? and passe=? group by service, idpersonnel";
            //ResultSet authResultat = state.executeQuery(requete);
            PreparedStatement prepare = pdo.prepareStatement(requete);
            prepare.setString(1, login);
            prepare.setString(2, password);
            ResultSet authResultat = prepare.executeQuery(requete);
            if (authResultat.next()) {
                infos[0] = authResultat.getInt(1);
                infos[1] = authResultat.getInt(2);
                infos[2] = authResultat.getInt(3);
            }

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erreur Dans la connexion");
        }
        return infos;
    }

    /* méthode qui permet d'afficher le mot de passe 
    PARAMETRE : login
    
    RETURN : info = mot de passe de l'utilisateur saisi*/
    public String getHashMdp(String login) {
        String info = "";
        if (pdo == null) {
            Connection();
        }
        try {
            //Statement state = pdo.createStatement();
            String requete = "select passe from authentification where login =?";
            PreparedStatement prepare = pdo.prepareStatement(requete);
            prepare.setString(1, login);
            ResultSet authResultat = prepare.executeQuery(requete);
            if (authResultat.next()) {
                info = authResultat.getString(1);
            }

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erreur dans la récupération du mdp");
        }
        return info;
    }

}
