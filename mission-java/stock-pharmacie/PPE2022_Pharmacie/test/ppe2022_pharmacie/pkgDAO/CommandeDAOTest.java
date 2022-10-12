/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ppe2022_pharmacie.pkgDAO;

import java.util.ArrayList;
import java.util.Collections;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ppe2022_pharmacie.metiers.*;

/**
 *
 * @author sio2022
 */
public class CommandeDAOTest {
    
    public CommandeDAOTest() {
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
     * Test of create method, of class CommandeDAO.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Commandes uneCommande = new Commandes(9000,"Hauser","Compresse",200);
        CommandeDAO instance = new CommandeDAO();
        Boolean expResult = true;
        Boolean result = instance.create(uneCommande);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class CommandeDAO.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        int pId = 1;
        CommandeDAO instance = new CommandeDAO();
        Commandes expResult = new Commandes(1,"Hauser","Spasfon",50);
        Commandes result = instance.find(pId);
        assertEquals(expResult.toString(), result.toString());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class CommandeDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Commandes uneCommande = new Commandes(9,"Hauser","Compresse",100);
        CommandeDAO instance = new CommandeDAO();
        Boolean expResult = true;
        Boolean result = instance.update(uneCommande);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class CommandeDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Commandes uneCommande = new Commandes(9000,"Hauser","Compresse",100);
        CommandeDAO instance = new CommandeDAO();
        Boolean expResult = true;
        Boolean result = instance.delete(uneCommande);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class CommandeDAO.
     */
    
    /*
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        CommandeDAO instance = new CommandeDAO();
        ArrayList<Commandes> expResult = new ArrayList<>();
        expResult.add(new Commandes(1,"Hauser","Spasfon",50));
        expResult.add(new Commandes(2,"Seppic","Ventoline",100));
        expResult.add(new Commandes(3,"ACS Phyto","Spasfon",40));
        expResult.add(new Commandes(4,"Endress","Compresse",8));
        expResult.add(new Commandes(5,"Zwiebel","Codéïne",24));
        expResult.add(new Commandes(6,"Seppic","Tramadol",4));
        expResult.add(new Commandes(7,"Horizane Sante","Codéïne",600));
        expResult.add(new Commandes(8,"Hauser","Ventoline",12));
        ArrayList<Commandes> result = instance.findAll();
        assertEquals(expResult.toString(), result.toString());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    */

    /**
     * Test of donnerToutesLesCommandes method, of class CommandeDAO.
     */
    @Test
    public void testDonnerToutesLesCommandes() {
        System.out.println("donnerToutesLesCommandes");
        CommandeDAO instance = new CommandeDAO();
        ArrayList<Commandes> expResult = new ArrayList<>();
        expResult.add(new Commandes(1,"Hauser","Spasfon",50));
        expResult.add(new Commandes(2,"Seppic","Ventoline",100));
        expResult.add(new Commandes(3,"ACS Phyto","Spasfon",40));
        expResult.add(new Commandes(4,"Endress","Compresse",8));
        expResult.add(new Commandes(5,"Zwiebel","Codéïne",24));
        expResult.add(new Commandes(6,"Seppic","Tramadol",4));
        expResult.add(new Commandes(7,"Horizane Sante","Codéïne",600));
        expResult.add(new Commandes(8,"Hauser","Ventoline",12));
        ArrayList<Commandes> result = instance.donnerToutesLesCommandes();
        assertEquals(expResult.toString(), result.toString());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of ajouterCommande method, of class CommandeDAO.
     */
    @Test
    public void testAjouterCommande() {
        System.out.println("ajouterCommande");
        String fournisseur = "Hauser";
        String medicament = "Compresse";
        int qtte = 10;
        boolean expResult = true;
        boolean result = CommandeDAO.ajouterCommande(fournisseur, medicament, qtte);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of donnerFournisseur method, of class CommandeDAO.
     */
    @Test
    public void testDonnerFournisseur() {
        System.out.println("donnerFournisseur");
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("Horizane Sante");
        expResult.add("Endress");
        expResult.add("Hauser");
        expResult.add("ACS Phyto");
        expResult.add("Zwiebel");
        expResult.add("Seppic");
        expResult.add("Lavollee");
        expResult.add("Caquant");
        ArrayList<String> result = CommandeDAO.donnerFournisseur();
        Collections.sort(result);
        Collections.sort(expResult);
        assertEquals(expResult.toString(), result.toString());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
