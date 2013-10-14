/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adparser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import morfologik.stemming.PolishStemmer;
import morfologik.stemming.WordData;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author Karol
 */
public class UtilsTest extends TestBase {
    
    public UtilsTest() {
    }
    
    @Before
    public void beforeTestBase() {
      System.out.println(UtilsTest.class + " beforeTestBase() Done");
    }
    
    @After
    public void afterTestBase() {
      System.out.println(UtilsTest.class + " afterTestBase() Done");
    }
    
    @BeforeClass
    public static void setUpClass() {
      System.out.println(UtilsTest.class + " setUpClass() Done");
    }
    
    @AfterClass
    public static void tearDownClass() {
      System.out.println(UtilsTest.class + " tearDownClass() Done");
    }

    /**
     * Test of listToString method, of class Utils.
     */
//    @Test
    public void testArrayToString_List() {
        System.out.println("arrayToString");
        List<WordData> list = null;
        String expResult = "";
        String result = Utils.listToString(list);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listToString method, of class Utils.
     */
//    @Test
    public void testArrayToString_Collection() {
        System.out.println("arrayToString");
        Collection<Object> col = null;
        String expResult = "";
        String result = Utils.arrayToString(col);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStems method, of class Utils.
     */
    @Test
    public void testGetStems() {
        System.out.println(Constants.NEWLINE + "========= getStems =========" + Constants.NEWLINE);
        PolishStemmer stemmer = new PolishStemmer();
        List<WordData> list = stemmer.lookup("poniedziałek");
        System.out.println(Utils.listToString(list));
        int num1 = list.size();
        ArrayList stems = Utils.getStems(list);
        System.out.println(Utils.arrayToString(stems));
        int num2 = stems.size();
        assertEquals(num1, num2);
    }

    /**
     * Test of removeDuplicates method, of class Utils.
     */
    @Test
    public void testRemoveDuplicates() {
        System.out.println(Constants.NEWLINE + "========= removeDuplicates =========" + Constants.NEWLINE);
        PolishStemmer stemmer = new PolishStemmer();
        List<WordData> list = stemmer.lookup("poniedziałek");
        System.out.println("list:");
        System.out.println(Utils.listToString(list));
        ArrayList stems = Utils.getStems(list);
        System.out.println("stems:");
        System.out.println(Utils.arrayToString(stems));
        ArrayList noDups = Utils.removeDuplicates(stems);
        System.out.println("noDups:");
        System.out.println(Utils.arrayToString(noDups));;
        assertEquals(1, noDups.size());
    }
}