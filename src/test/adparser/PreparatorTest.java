/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.adparser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import morfologik.stemming.PolishStemmer;
import morfologik.stemming.WordData;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import main.java.adparser.*;


/**
 *
 * @author Karol
 */
public class PreparatorTest {
    
    public PreparatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of loadStopWords method, of class Preparator.
     */
//    @Test
    public void testLoadStopWords() throws Exception {
        System.out.println("loadStopWords");
        String path = "";
        Preparator instance = new Preparator();
        instance.loadStopWords(path);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of prepareKeywords method, of class Preparator.
     */
//    @Test
    public void testPrepareForClassifier() {
        System.out.println("prepareForClassifier");
        Ad ad = null;
        Preparator instance = new Preparator();
        instance.prepareKeywords(ad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKeywords method, of class Preparator.
     */
//    @Test
    public void testGetKeywords() {
        System.out.println("getKeywords");
        Preparator instance = new Preparator();
        KeyWords k = instance.getKeywords("poniedziałek poniedziałek poniedziałek");
        System.out.println(k.toString());
        assertEquals(1, k.size());
        assertEquals(3, k.get("poniedziałek").getTf());
    }

    /**
     * Test of removeStopWords method, of class Preparator.
     */
    @Test
    public void testRemoveStopWords() {
        System.out.println("removeStopWords");
        Preparator instance = new Preparator();
        String text = instance.stopWordsToString();
        System.out.println("text:");
        System.out.println(text);
        String result = instance.removeStopWords(text);
        result.trim();
        System.out.println("result:");
        System.out.println(result);
        Pattern p = Pattern.compile("\\s*");
        Matcher m = p.matcher(result);
        assertTrue(m.matches());
    }

    /**
     * Test of doStemming method, of class Preparator.
     */
    @Test
    public void testDoStemming() {
        System.out.println("doStemming");
        String text = "poniedziałek wtorek środa poniedziałek";
        String result;
        Preparator instance = new Preparator();
        KeyWords k = instance.doStemming(text);
        System.out.println(k.toString());
        assertEquals(3, k.size());
        assertEquals(1, k.get("wtorek").getTf());
        assertEquals(2, k.get("poniedziałek").getTf());
    }

    /**
     * Test of addKeywordsToWordBank method, of class Preparator.
     */
    @Test
    public void testAddKeywordsToWordBank() {
        System.out.println("addKeywordsToWordBank");
        ArrayList<String> keywords = new ArrayList<>();
        keywords.add("jeden");
        keywords.add("dwa");
        keywords.add("trzy");
        Preparator instance = new Preparator();
        int expResult = 3;
        int result = instance.addKeywordsToWordBank(keywords);
        System.out.println("added " + result);
        assertEquals(expResult, result);
        assertEquals(expResult, instance.getWordbank().size());
        keywords.clear();
        keywords.add("jeden");
        int result2 = instance.addKeywordsToWordBank(keywords);
        System.out.println("added " + result2);
        assertEquals(0, result2);
        System.out.println(instance.getWordbank().toString());
    }

    /**
     * Test of makeSimilarityVector method, of class Preparator.
     */
    @Test
    public void testMakeSimilarityVector() {
        System.out.println("makeSimilarityVector");
        Ad ad = new Ad();
        Preparator instance = new Preparator();
        ad.setDescription("poniedziałek wtorek środa poniedziałek");
        KeyWords stems = instance.getKeywords(ad.getDescription());
        ad.setKeywords(stems);
        instance.addKeywordsToWordBank(new ArrayList<>(stems.keySet()));
        SimilarityVector v = instance.makeSimilarityVector(ad);
        System.out.println(v.toString());
        ArrayList<String> words = new ArrayList(instance.getWordbank().keySet());
        ArrayList<Integer> ids = new ArrayList<>();
        for(String word : words) {
            if(word.equals("poniedziałek") || word.equals("wtorek") || word.equals("środa")) {
                assertTrue(true);
            } else {
                assertFalse(true);
            }
            ids.add(instance.getWordbank().getID(word));
        }
        int ponIindex = words.indexOf("poniedziałek");
        int wtIndex = words.indexOf("wtorek");
        assertTrue(ids.get(ponIindex) > ids.get(wtIndex));
        
    }
    
    @Test
    public void testWordParamsIncreaseNumDocs() {
        System.out.println("wordParamsIncreaseNumDocs");
        WordBank b = new WordBank();
        b.addWord("test");
        assertEquals(1, b.getNumDocs("test"));
        
        b.getParams("test").increaseNumDocs();
        assertEquals(2, b.getNumDocs("test"));
    }
}