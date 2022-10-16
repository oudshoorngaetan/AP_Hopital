/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ppe2022_pharmacie.pkgDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

/**
 *
 * @author sio2021
 * @param <T>
 */

abstract class DAO<T> {

    protected static Connection pdo;

    // Connexion à la BDD postgres
    // Paramètre : Aucun
    // Retour : Aucun
    public static void Connection() {
        String url = "jdbc:postgresql://192.168.1.42:5432/bdd_stock";
        //String url = "jdbc:postgresql://192.168.0.43:5432/bdd_stock";
        String user = "gagou";
        String passwd = "Zoz09!";
        //Etablir connexion
        try {
            pdo = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connexion effective !");

        } catch (Exception e) {
            System.out.println("Connexion refusé !");
            System.out.println(e.getMessage());
        }
    }

    
    /* méthode qui 
    PARAMETRES : OBJ Dao
    
    RETURN : Vrai si l'insertion à bien effectué 
    false si ça a échoué*/
    public abstract Boolean create(T unObjet);
    
/* méthode qui cherche l'objet de la classe T
    PARAMETRES : id
    
    RETURN : renvoie la classe T selon l'id */
    public abstract T find(int id);
/* méthode qui update un objet ( qui depend de la classe dans laquelle il est)
    PARAMETRES : objet de de classe T(=une classe)
    
    RETURN : Vrai si l'update à bien été effectué 
    false si ça a échoué*/
   
   public abstract Boolean update(T unObjet);
/* méthode qui supprime un objet ( qui depend de la classe dans laquelle il est)
    PARAMETRES : objet de de classe T(=une classe)
    
    RETURN : Vrai si le delete à bien  été effectué 
    false si ça a échoué*/
  
    public abstract Boolean delete(T unObjet);
/* méthode qui renvoie l'arrayList d'objet ( qui depend de la classe dans laquelle il est)
    PARAMETRES : aucun
    
    RETURN : une arraylist d'objet*/
    public abstract ArrayList<T> findAll();

    // Get du pdo pour les classes qui héritent
    public static Connection getPdo() {
        return pdo;
    }
    
}
