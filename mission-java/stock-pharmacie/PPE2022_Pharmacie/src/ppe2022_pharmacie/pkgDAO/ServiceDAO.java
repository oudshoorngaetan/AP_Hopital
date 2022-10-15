/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ppe2022_pharmacie.pkgDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import ppe2022_pharmacie.metiers.Service;
import static ppe2022_pharmacie.pkgDAO.DAO.pdo;

/**
 *
 * @author sio2021
 */
public class ServiceDAO extends DAO<Service> {
 /* méthode qui crée un service 
    PARAMETRES : OBJET SERVICE
    
    RETURN : true si l'insertion a été correctement effectuée;
             false si l'opération à échoué + msg erreur.
    PS : A faire?
    */
    
    
    @Override
    public Boolean create(Service unObjet) {
        throw new UnsupportedOperationException("Not supported"); //To change body of generated methods, choose Tools | Templates.
    }
 /* méthode qui cherche un service par son id
    PARAMETRES : id
    
    RETURN : renvoie le service associé à l'id*/
    @Override
    public Service find(int id) {
         if (pdo == null) {
            Connection();
        }
        String requete = "select libelle from service where idservice =?";
        Service service = null;
        String libelleService;
        try {
            PreparedStatement prepare = pdo.prepareStatement(requete);
            prepare.setInt(1, id);
            //Statement state = pdo.createStatement();
            ResultSet serviceResultat = prepare.executeQuery(requete);
            if (serviceResultat.next()) {
                libelleService = serviceResultat.getString(1);
                service = new Service(id, libelleService);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erreur dans la récupération du service");
        }
        return service;
    }
 /* méthode qui update un service
    PARAMETRES : OBJ service
    
    RETURN : true si l'update a été correctement effectuée;
             false si l'update dans la bdd n'a pas pu être réalisée.*/
    @Override
    public Boolean update(Service unObjet) {
        throw new UnsupportedOperationException("Not supported"); //To change body of generated methods, choose Tools | Templates.
    }
 /* méthode qui delete un service
    PARAMETRES : OBJ service
    
    RETURN : true si le delete a été correctement effectuée;
             false si le delete dans la bdd n'a pas pu être réalisée.*/
    @Override
    public Boolean delete(Service unObjet) {
        throw new UnsupportedOperationException("Not supported"); //To change body of generated methods, choose Tools | Templates.
    }

     /* méthode qui liste tous les services
    PARAMETRES : aucun
    
    RETURN : la collection de tous les services*/
    @Override
    public ArrayList<Service> findAll() {
         if (pdo == null) {
            Connection();
        }
        ArrayList<Service> lesService = new ArrayList<>();
        String requete = "select idservice, libelle from service";
        try {
            Statement state = pdo.createStatement();
            ResultSet serviceResultat = state.executeQuery(requete);
            while (serviceResultat.next()) {
                int idService = serviceResultat.getInt(1);
                String libelle = serviceResultat.getString(2);
                lesService.add(new Service(idService, libelle));
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erreur dans la récupération des services");
        }
        return lesService;
    }
    
     /* méthode qui récupere l'id d'un service
    PARAMETRES : OBJ service
    
    RETURN : renvoie l'id d'un service*/
    public int getIdService(String libelle) {
         if (pdo == null) {
            Connection();
        }
        int idService = 0;
        try {
            //Statement state = pdo.createStatement();
            String requete = "select idservice from service where libelle=?";
            PreparedStatement prepare = pdo.prepareStatement(requete);
            prepare.setString(1, libelle);
            ResultSet resultat = prepare.executeQuery(requete);
            if (resultat.next()) {
                idService = resultat.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erreur dans la récupération de l'id service");
        }
        return idService;
    }
    
}
