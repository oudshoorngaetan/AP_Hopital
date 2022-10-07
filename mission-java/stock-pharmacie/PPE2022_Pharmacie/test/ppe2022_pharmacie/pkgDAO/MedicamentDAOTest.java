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
import ppe2022_pharmacie.metiers.Medicament;

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
        //test 1
        Medicament unMedicament = new Medicament(1, "Bandage", 600, 400, "Matériel Médical");
        MedicamentDAO test = new MedicamentDAO();
        Boolean expResult = false; // car la clé existe déjà
        //Boolean result = test.create(unMedicament);
        //assertEquals(expResult, result);
        // test 2
        Medicament unMedoc = new Medicament(13, "Bandage", 600, 400, "Matériel Médical");
        MedicamentDAO test2 = new MedicamentDAO();
        Boolean exp2 = true; // nouveau id
        //Boolean res = test2.create(unMedoc);
        //assertEquals(exp2, res);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class MedicamentDAO.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        int pId = 2;
        MedicamentDAO instance = new MedicamentDAO();
        Medicament expResult = new Medicament(2,"Xanax",670,200,"Psychiatrie");
        Medicament result = instance.find(pId);
        assertEquals(expResult.toString(), result.toString());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class MedicamentDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Medicament unMedicament = new Medicament(4, "Ventoline", 500, 200, "Pneumologie");
        MedicamentDAO instance = new MedicamentDAO();
        Boolean expResult = true;
        Boolean result = instance.update(unMedicament);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class MedicamentDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Medicament unMedicament = new Medicament(11, "2", 300, 200, "oui");;
        MedicamentDAO instance = new MedicamentDAO();
        Boolean expResult = true;
        Boolean result = instance.delete(unMedicament);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class MedicamentDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        MedicamentDAO instance = new MedicamentDAO();
        ArrayList<Medicament> expResult = new ArrayList<>();
        expResult.add(new Medicament(6,	"Lisopaïne",653,200,"Antalgique"));
        expResult.add(new Medicament(7,"Morphine",326,200,"Antalgique"));
        expResult.add(new Medicament(8,"Codéïne",284,200,"Antalgique"));
        expResult.add(new Medicament(10,"Compresse",252,200,"Matériel Médical"));
        expResult.add(new Medicament(9,"Tramadol",311,400,"Antalgique"));
        expResult.add(new Medicament(5,	"Spasfon",360,200,"Antalgique"));
        expResult.add(new Medicament(3,"Smecta",1300,200,"Antalgique"));
        expResult.add(new Medicament(2,"Xanax",670,200,"Psychiatrie"));
        expResult.add(new Medicament(12,"Doxycycline",80,50,"Antibiotique"));
        expResult.add(new Medicament(1,"Bandage",300,200,"Matériel Médical"));
        expResult.add(new Medicament(4,"Ventoline",500,200,"Pneumologie"));
        
        ArrayList<Medicament> result = instance.findAll();
        assertEquals(expResult.get(0).toString(), result.get(0).toString());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of donnerUnStock method, of class MedicamentDAO.
     */
    @Test
    public void testDonnerUnStock() {
        System.out.println("donnerUnStock");
        int idM = 1;
        Medicament expResult = new Medicament(1,"Bandage",300,200,"Matériel Médical");
        Medicament result = MedicamentDAO.donnerUnStock(idM);
        assertEquals(expResult.toString(), result.toString());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of donnerStockSeuil method, of class MedicamentDAO.
     */
    @Test
    public void testDonnerStockSeuil() {
        System.out.println("donnerStockSeuil");
        ArrayList<Medicament> expResult = new ArrayList<>();
        expResult.add(new Medicament(9,"Tramadol",311,400,"Antalgique"));
        
        ArrayList<Medicament> result = MedicamentDAO.donnerStockSeuil();
        assertEquals(expResult.get(0).toString(), result.get(0).toString());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of donnerCategorie method, of class MedicamentDAO.
     */
    @Test
    public void testDonnerCategorie() {
        System.out.println("donnerCategorie");
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("Tous");
        expResult.add("Antalgique");
        expResult.add("Matériel Médical");
        expResult.add("Psychiatrie");
        expResult.add("Antibiotique");
        expResult.add("Pneumologie");
        
        ArrayList<String> result = MedicamentDAO.donnerCategorie();
        assertEquals(expResult.get(0).toString(), result.get(0).toString());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of AfficheEnFonctionCategorie method, of class MedicamentDAO.
     */
    @Test
    public void testAfficheEnFonctionCategorie() {
        System.out.println("AfficheEnFonctionCategorie");
        String pCategorie = "Psychiatrie";
        ArrayList<Medicament> lesMedoc = new ArrayList<>();
        lesMedoc.add(new Medicament(2,"Xanax",670,200,"Psychiatrie"));
        ArrayList<Medicament> result = MedicamentDAO.AfficheEnFonctionCategorie(pCategorie);
        assertEquals(lesMedoc.get(0).toString(), result.get(0).toString());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of listerMedicament method, of class MedicamentDAO.
     */
    @Test
    public void testListerMedicament() {
        System.out.println("listerMedicament");
        ArrayList<Medicament> expResult = new ArrayList<>();
        expResult.add(new Medicament(6,	"Lisopaïne",653,200,"Antalgique"));
        expResult.add(new Medicament(7,"Morphine",326,200,"Antalgique"));
        expResult.add(new Medicament(8,"Codéïne",284,200,"Antalgique"));
        expResult.add(new Medicament(10,"Compresse",252,200,"Matériel Médical"));
        expResult.add(new Medicament(9,"Tramadol",311,400,"Antalgique"));
        expResult.add(new Medicament(5,	"Spasfon",360,200,"Antalgique"));
        expResult.add(new Medicament(3,"Smecta",1300,200,"Antalgique"));
        expResult.add(new Medicament(2,"Xanax",670,200,"Psychiatrie"));
        expResult.add(new Medicament(12,"Doxycycline",80,50,"Antibiotique"));
        expResult.add(new Medicament(1,"Bandage",300,200,"Matériel Médical"));
        expResult.add(new Medicament(4,"Ventoline",500,200,"Pneumologie"));
        
        ArrayList<Medicament> result = MedicamentDAO.listerMedicament();
        assertEquals(expResult.get(0).toString(), result.get(0).toString());
        // TODO review the generated test code and remove the default call to fail.
       //fail("The test case is a prototype.");
    }

    /**
     * Test of avoirQtte method, of class MedicamentDAO.
     */
    @Test
    public void testAvoirQtte() {
        System.out.println("avoirQtte");
        int idM = 2;
        int expResult = 670;
        int result = MedicamentDAO.avoirQtte(idM);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of validerQtte method, of class MedicamentDAO.
     */
    @Test
    public void testValiderQtte() {
        System.out.println("validerQtte");
        //Lorsque la qtteD est supérieure à qqteM
        int qtteD = 800;
        int qtteM = 600;
        int idM = 1;
        MedicamentDAO.validerQtte(qtteD, qtteM, idM);
        //Lorsque la qtteM est supérieure à qtteD
        int qD = 300;
        int qM = 600;
        MedicamentDAO.validerQtte(qD, qtteM, idM);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of derniereid method, of class MedicamentDAO.
     */
    @Test
    public void testDerniereid() {
        System.out.println("derniereid");
        int expResult = 12;
        int result = MedicamentDAO.derniereid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
