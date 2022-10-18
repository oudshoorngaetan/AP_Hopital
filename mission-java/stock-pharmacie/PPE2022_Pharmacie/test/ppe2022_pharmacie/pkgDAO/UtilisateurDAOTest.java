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
        Utilisateur unObjet = new Utilisateur("testLogin", new Service(2, "Pharmacien"), 6, "testMdp");
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
    /*
    @Test
    public void testFind() {
        System.out.println("find");
        int id = 1;
        UtilisateurDAO instance = new UtilisateurDAO();
        Utilisateur expResult = new Utilisateur("admin", new Service(2, "admin"), 1, "827CCB0EEA8A706C4C34A16891F84E7B");
        Utilisateur result = instance.find(id);
        assertEquals(expResult.toString(), result.toString());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of update method, of class UtilisateurDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Utilisateur unUser = new Utilisateur("testLogin", new Service(2, "Pharmacien"), 6, "mdp");;
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
        Utilisateur unObjet = new Utilisateur("testLogin", new Service(2, "Pharmacien"), 6, "mdp");
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
        expResult.add(new Utilisateur("pharmacien", new Service(2, "Pharmacien"), 2, "14ED6179101D4BBBAC0EBEB19300FC7B"));
        expResult.add(new Utilisateur("radiologie", new Service(4, "radiologie"), 9, "CF7ED49AA105897253D9AF5AAD089563"));
        expResult.add(new Utilisateur("admin", new Service(1, "Administration"), 1, "21232F297A57A5A743894A0E4A801FC3"));
        expResult.add(new Utilisateur("chirurgie", new Service(5, "chirurgie"), 3, "E0F62D334C6FA96C60FEA5C10B0E6879"));
        expResult.add(new Utilisateur("medecine", new Service(3, "médecine générale"), 5, "174FF6B452EA8BB0256BA57C2F4D69D6"));
        

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
        String login = "radiologie";
        String password = "CF7ED49AA105897253D9AF5AAD089563";
        UtilisateurDAO instance = new UtilisateurDAO();
        int[] expResult = new int[3];
        // [0] = 1 si tu te connecter
        expResult[0] = 1;
        //[1] = service
        expResult[1] = 4;
        // [2] = id
        expResult[2] = 9;
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
        String login = "radiologie";
        UtilisateurDAO instance = new UtilisateurDAO();
        String expResult = "CF7ED49AA105897253D9AF5AAD089563";
        String result = instance.getHashMdp(login);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
