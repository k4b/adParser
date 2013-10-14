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

    @Test
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
    @Test
    public void testParse() {
        System.out.println("parse");
        String url = "http://www.oferty.net/mieszkania/szukaj?ps%5Blocation%5D%5Btype%5D=1&ps%5Btype%5D=1&ps%5Btransaction%5D=1&ps%5Blocation%5D%5Btext%5D=Warszawa&ps%5Bliving_"
                + "area_from%5D=30&ps%5Bliving_area_to%5D=60&ps%5Bprice_from%5D=100&ps%5Bprice_to%5D=300000";
        String tag = "tbody";
        Parser instance = new Parser();
        instance.startParsing(url, tag, 5);
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
        Element e = p.getElementByTag(doc, tag);
        ArrayList ads  = new ArrayList<>();
        p.createObjects(e, ads);
        if(ads.size()>0)
            assertTrue(true);
        else
            fail();
        ads.get(0).toString();
    }
    
    @Test
    public void testParseDetails() {
        System.out.println(Constants.NEWLINE + "========= testParseDetails =========" + Constants.NEWLINE);
        String url = "http://www.oferty.net/mieszkanie-na-sprzedaz-broniewskiego-warszawa-bielany,922442274";
        String classname = "param";
        
        Parser p = new Parser();
        Ad a = new Ad();
        
        p.parseDetails(url, a);
        
        
        assertFalse(a.getDescription().equals(""));
//        assertTrue(a.getBathroomsNo()!=0);
//        assertTrue(a.getConstructionYear()!=0);
//        assertTrue(a.getFloorsInBuilding()!=0);
        
    }
}