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
import ppe2022_pharmacie.metiers.Medicament;
import ppe2022_pharmacie.metiers.Service;

/**
 *
 * @author julie
 */
public class ServiceDAOTest {

    public ServiceDAOTest() {
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
     * Test of create method, of class ServiceDAO.
     */
    /**
    @Test
    public void testCreate() {
        System.out.println("create");
        Service unObjet = null;
        ServiceDAO instance = new ServiceDAO();
        Boolean expResult = null;
        Boolean result = instance.create(unObjet);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
 */
    /**
     * Test of find method, of class ServiceDAO.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        int id = 1;
        ServiceDAO instance = new ServiceDAO();
        Service expResult = new Service(1, "Administration");

        Service result = instance.find(id);
        assertEquals(expResult.toString(), result.toString());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class ServiceDAO.
     */
     /**
    @Test
    public void testUpdate() {
        System.out.println("update");
        Service unObjet = null;
        ServiceDAO instance = new ServiceDAO();
        Boolean expResult = null;
        Boolean result = instance.update(unObjet);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
 */
    /**
     * Test of delete method, of class ServiceDAO.
     *
     */
    /**
    @Test
    public void testDelete() {
        System.out.println("delete");
        Service unObjet = null;
        ServiceDAO instance = new ServiceDAO();
        Boolean expResult = null;
        Boolean result = instance.delete(unObjet);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    */
    /**
     * Test of findAll method, of class ServiceDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");

        ServiceDAO instance = new ServiceDAO();
        ArrayList<Service> expResult = new ArrayList<>();
        expResult.add(new Service(1, "Administration"));
        expResult.add(new Service(2, "Phamarcien"));
        expResult.add(new Service(4, "radiologie"));
        expResult.add(new Service(5, "médécine générale"));
        expResult.add(new Service(3, "chirurgie"));
        ArrayList<Service> result = instance.findAll();
        assertEquals(expResult.get(0).toString(), result.get(0).toString());
        // TODO review the generated test code and remove the default call to fail.
        //   fail("The test case is a prototype.");
    }

    /**
     * Test of getIdService method, of class ServiceDAO.
     */
    @Test
    public void testGetIdService() {
        System.out.println("getIdService");
        String libelle = "radiologie";
        ServiceDAO instance = new ServiceDAO();
        int expResult = 4;
        int result = instance.getIdService(libelle);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
