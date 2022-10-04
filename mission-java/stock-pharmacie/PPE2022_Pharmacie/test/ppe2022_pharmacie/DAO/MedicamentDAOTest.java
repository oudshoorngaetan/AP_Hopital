/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ppe2022_pharmacie.DAO;

import ppe2022_pharmacie.pkgDAO.MedicamentDAO;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ppe2022_pharmacie.Medicament;

/**
 *
 * @author sio2022
 */
public class MedicamentDAOTest {
    
    public MedicamentDAOTest() {
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
     * Test of create method, of class MedicamentDAO.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Medicament unMedicament = new Medicament(1, "Bandage", 600, 300, "Matér");
        MedicamentDAO instance = new MedicamentDAO();
        Boolean expResult = null;
        Boolean result = instance.create(unMedicament);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class MedicamentDAO.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        int pId = 0;
        MedicamentDAO instance = new MedicamentDAO();
        Medicament expResult = null;
        Medicament result = instance.find(pId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class MedicamentDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Medicament unMedicament = null;
        MedicamentDAO instance = new MedicamentDAO();
        Boolean expResult = null;
        Boolean result = instance.update(unMedicament);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class MedicamentDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Medicament unMedicament = null;
        MedicamentDAO instance = new MedicamentDAO();
        Boolean expResult = null;
        Boolean result = instance.delete(unMedicament);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class MedicamentDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        MedicamentDAO instance = new MedicamentDAO();
        ArrayList<Medicament> expResult = null;
        ArrayList<Medicament> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of donnerUnStock method, of class MedicamentDAO.
     */
    @Test
    public void testDonnerUnStock() {
        System.out.println("donnerUnStock");
        int idM = 0;
        Medicament expResult = null;
        Medicament result = MedicamentDAO.donnerUnStock(idM);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of donnerStockSeuil method, of class MedicamentDAO.
     */
    @Test
    public void testDonnerStockSeuil() {
        System.out.println("donnerStockSeuil");
        ArrayList<Medicament> expResult = null;
        ArrayList<Medicament> result = MedicamentDAO.donnerStockSeuil();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of donnerCategorie method, of class MedicamentDAO.
     */
    @Test
    public void testDonnerCategorie() {
        System.out.println("donnerCategorie");
        ArrayList<String> expResult = null;
        ArrayList<String> result = MedicamentDAO.donnerCategorie();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AfficheEnFonctionCategorie method, of class MedicamentDAO.
     */
    @Test
    public void testAfficheEnFonctionCategorie() {
        System.out.println("AfficheEnFonctionCategorie");
        String pCategorie = "";
        ArrayList<Medicament> expResult = null;
        ArrayList<Medicament> result = MedicamentDAO.AfficheEnFonctionCategorie(pCategorie);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listerMedicament method, of class MedicamentDAO.
     */
    @Test
    public void testListerMedicament() {
        System.out.println("listerMedicament");
        ArrayList<Medicament> expResult = null;
        ArrayList<Medicament> result = MedicamentDAO.listerMedicament();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of avoirQtte method, of class MedicamentDAO.
     */
    @Test
    public void testAvoirQtte() {
        System.out.println("avoirQtte");
        int idM = 0;
        int expResult = 0;
        int result = MedicamentDAO.avoirQtte(idM);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validerQtte method, of class MedicamentDAO.
     */
    @Test
    public void testValiderQtte() {
        System.out.println("validerQtte");
        int qtteD = 0;
        int qtteM = 0;
        int idM = 0;
        MedicamentDAO.validerQtte(qtteD, qtteM, idM);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of derniereid method, of class MedicamentDAO.
     */
    @Test
    public void testDerniereid() {
        System.out.println("derniereid");
        int expResult = 0;
        int result = MedicamentDAO.derniereid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
