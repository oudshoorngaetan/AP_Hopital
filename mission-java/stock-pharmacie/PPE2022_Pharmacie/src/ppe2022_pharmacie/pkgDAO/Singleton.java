/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ppe2022_pharmacie.pkgDAO;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author sio2022
 */
public class Singleton {
    private static Singleton singleton;
    private Connection co;
    private String url;
    private String user;
    private String passwd;
    
    private Singleton() {
        url = "jdbc:postgresql://192.168.1.43:5432/bdd_stock";
        user = "gagou";
        passwd = "Zoz09!";
        
        //Etablir connexion
        try {
            co = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connexion effective !");

        } catch (Exception e) {
            System.out.println("Connexion refusé !");
            System.out.println(e.getMessage());
        }
    }
    
    public static Singleton getInstance() {
        if(singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
    
    public Connection getCo() {
        return co;
    }
}
