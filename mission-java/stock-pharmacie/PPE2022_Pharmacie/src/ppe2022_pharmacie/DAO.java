/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ppe2022_pharmacie;

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
        //String url = "jdbc:postgresql://192.168.1.42:5432/bdd_stock";
        String url = "jdbc:postgresql://192.168.0.42:5432/bdd_stock";
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

    public abstract Boolean create(T unObjet);

    public abstract T find(int id);

    public abstract Boolean update(T unObjet);

    public abstract Boolean delete(T unObjet);

    public abstract ArrayList<T> findAll();
}
