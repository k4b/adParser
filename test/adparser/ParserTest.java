/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adparser;

import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Karol
 */
public class ParserTest {
    
    public ParserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

//    @Test
    public void testGetPage() {
        System.out.println("getPage");
        Parser instance = new Parser();
        String url = "http://www.oferty.net/mieszkania/szukaj?ps%5Blocation%5D%5Btype%5D=1&ps%5Btype%5D=1&ps%5Btransaction%5D=1&ps%5Blocation%5D%5Btext%5D=Warszawa&ps%5Bliving_"
                + "area_from%5D=30&ps%5Bliving_area_to%5D=60&ps%5Bprice_from%5D=100&ps%5Bprice_to%5D=300000";
        Document d = instance.getPage(url);
        assertNotNull(d);
    }
    
    /**
     * Test of parse method, of class Parser.
     */
//    @Test
    public void testParse() {
        System.out.println("parse");
        String url = "http://www.oferty.net/mieszkania/szukaj?ps%5Blocation%5D%5Btype%5D=1&ps%5Btype%5D=1&ps%5Btransaction%5D=1&ps%5Blocation%5D%5Btext%5D=Warszawa&ps%5Bliving_"
                + "area_from%5D=30&ps%5Bliving_area_to%5D=60&ps%5Bprice_from%5D=100&ps%5Bprice_to%5D=300000";
        String tag = "tbody";
        Parser instance = new Parser();
        instance.parse(url, tag);
    }
    
    @Test
    public void testParseCreatingObjects() {
        System.out.println("testParseCreatingObjects");
        String url = "http://www.oferty.net/mieszkania/szukaj?ps%5Blocation%5D%5Btype%5D=1&ps%5Btype%5D=1&ps%5Btransaction%5D=1&ps%5Blocation%5D%5Btext%5D=Warszawa&ps%5Bliving_"
                + "area_from%5D=30&ps%5Bliving_area_to%5D=60&ps%5Bprice_from%5D=100&ps%5Bprice_to%5D=300000";
        String tag = "tbody";
        
        Parser p = new Parser();
        Document doc = p.getPage(url);
        if(doc == null) {
            System.out.println("doc == null");
            return;
        }
        Element e = p.getElement(doc, tag);
        ArrayList ads = p.createObjects(e);
        if(ads.size()>0)
            assertTrue(true);
        else
            fail();
        ads.get(0).toString();
    }
}