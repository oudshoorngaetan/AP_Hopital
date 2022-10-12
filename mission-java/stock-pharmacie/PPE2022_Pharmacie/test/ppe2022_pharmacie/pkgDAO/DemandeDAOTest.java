/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ppe2022_pharmacie.pkgDAO;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ppe2022_pharmacie.metiers.Demande;

/**
 *
 * @author sio2022
 */
public class DemandeDAOTest {
    
    public DemandeDAOTest() {
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
     * Test of create method, of class DemandeDAO.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Demande unObjet = new Demande(90000,5,2,20);
        DemandeDAO instance = new DemandeDAO();
        Boolean expResult = true;
        Boolean result = instance.create(unObjet);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class DemandeDAO.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        int id = 1;
        DemandeDAO instance = new DemandeDAO();
        Demande expResult = new Demande(1,3,6,11);
        Demande result = instance.find(id);
        assertEquals(expResult.toString(), result.toString());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class DemandeDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Demande unObjet = new Demande(90000,3,2,200);
        DemandeDAO instance = new DemandeDAO();
        Boolean expResult = true;
        Boolean result = instance.update(unObjet);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class DemandeDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Demande unObjet = new Demande(90000,3,2,200);
        DemandeDAO instance = new DemandeDAO();
        Boolean expResult = true;
        Boolean result = instance.delete(unObjet);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class DemandeDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        DemandeDAO instance = new DemandeDAO();
        ArrayList<Demande> expResult = new ArrayList<>();
        expResult.add(new Demande(2,2,5,50));
        expResult.add(new Demande(1,3,6,11));
        ArrayList<Demande> result = instance.findAll();
        assertEquals(expResult.toString(), result.toString());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of AfficherDemandeParService method, of class DemandeDAO.
     */
    @Test
    public void testAfficherDemandeParService() {
        System.out.println("AfficherDemandeParService");
        int idService = 5;
        DemandeDAO instance = new DemandeDAO();
        ArrayList<Demande> expResult = new ArrayList<>();
        expResult.add(new Demande(2,5,5,50));
        expResult.add(new Demande(1,3,6,11));
        ArrayList<Demande> result = instance.AfficherDemandeParService(idService);
        assertEquals(expResult.get(0).toString(), result.get(0).toString());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
