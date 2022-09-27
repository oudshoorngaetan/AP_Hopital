/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ppe2022_pharmacie;

import ppe2022_pharmacie.DAO.UtilisateurDAO;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sio2022
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
        Utilisateur unObjet = null;
        UtilisateurDAO instance = new UtilisateurDAO();
        Boolean expResult = null;
        Boolean result = instance.create(unObjet);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class UtilisateurDAO.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        int id = 0;
        UtilisateurDAO instance = new UtilisateurDAO();
        Utilisateur expResult = null;
        Utilisateur result = instance.find(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class UtilisateurDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Utilisateur unUser = null;
        UtilisateurDAO instance = new UtilisateurDAO();
        Boolean expResult = null;
        Boolean result = instance.update(unUser);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class UtilisateurDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Utilisateur unObjet = null;
        UtilisateurDAO instance = new UtilisateurDAO();
        Boolean expResult = null;
        Boolean result = instance.delete(unObjet);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class UtilisateurDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        UtilisateurDAO instance = new UtilisateurDAO();
        ArrayList<Utilisateur> expResult = null;
        ArrayList<Utilisateur> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Authentification method, of class UtilisateurDAO.
     */
    @Test
    public void testAuthentification() {
        System.out.println("Authentification");
        String login = "";
        String password = "";
        UtilisateurDAO instance = new UtilisateurDAO();
        int[] expResult = null;
        int[] result = instance.Authentification(login, password);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHashMdp method, of class UtilisateurDAO.
     */
    @Test
    public void testGetHashMdp() {
        System.out.println("getHashMdp");
        String login = "";
        UtilisateurDAO instance = new UtilisateurDAO();
        String expResult = "";
        String result = instance.getHashMdp(login);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
