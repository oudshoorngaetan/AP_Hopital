/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppe2022_pharmacie.pkgDAO;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ppe2022_pharmacie.metiers.Service;
import ppe2022_pharmacie.metiers.Utilisateur;

/**
 *
 * @author olivi
 */
public class UtilisateurDAOTest {
    
    public UtilisateurDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class UtilisateurDAO.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Utilisateur unObjet = new Utilisateur ("testLogin", new Service(2, "Pharmacien"), 6, "testMdp");
        UtilisateurDAO instance = new UtilisateurDAO();
        Boolean expResult = true;
        //Boolean result = instance.create(unObjet);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class UtilisateurDAO.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        int id = 1;
        UtilisateurDAO instance = new UtilisateurDAO();
        Utilisateur expResult = new Utilisateur ("Valentin", new Service(2, "Pharmacien"),1,"827CCB0EEA8A706C4C34A16891F84E7B" );
        Utilisateur result = instance.find(id);
        assertEquals(expResult.toString(), result.toString());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class UtilisateurDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Utilisateur unUser = new Utilisateur ("testLogin", new Service(2, "Pharmacien"), 6, "mdp");;
        UtilisateurDAO instance = new UtilisateurDAO();
        Boolean expResult = true;
        Boolean result = instance.update(unUser);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class UtilisateurDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Utilisateur unObjet = new Utilisateur ("testLogin", new Service(2, "Pharmacien"), 6, "mdp");
        UtilisateurDAO instance = new UtilisateurDAO();
        Boolean expResult = true;
        Boolean result = instance.delete(unObjet);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class UtilisateurDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        UtilisateurDAO instance = new UtilisateurDAO();
        ArrayList<Utilisateur> expResult = new ArrayList<>();
        expResult.add(new Utilisateur("Valentin",new Service(2, "Pharmacien"), 1,"827CCB0EEA8A706C4C34A16891F84E7B"));
        expResult.add(new Utilisateur("Charly",new Service(5,"chirurgie"),3,"F0D41400626D1B9457628E9F874D0804"));
        expResult.add(new Utilisateur("Antoine", new Service(1, "Administration"),2,"B9A6D02F68947DDF2EDC86A59C3AF4CA"));
        
        ArrayList<Utilisateur> result = instance.findAll();
        assertEquals(expResult.get(0).toString(), result.get(0).toString());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of Authentification method, of class UtilisateurDAO.
     */
    @Test
    public void testAuthentification() {
        System.out.println("Authentification");
        String login = "Radiologie";
        String password = "FDD03ECD5844F694BC5B201535B2D1EA";
        UtilisateurDAO instance = new UtilisateurDAO();
        int[] expResult = new int[3];
        expResult[0] = 1;
        expResult[1] = 4;
        expResult[2] = 3;
        int[] result = instance.Authentification(login, password);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getHashMdp method, of class UtilisateurDAO.
     */
    @Test
    public void testGetHashMdp() {
        System.out.println("getHashMdp");
        String login = "Radiologie";
        UtilisateurDAO instance = new UtilisateurDAO();
        String expResult = "FDD03ECD5844F694BC5B201535B2D1EA";
        String result = instance.getHashMdp(login);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
