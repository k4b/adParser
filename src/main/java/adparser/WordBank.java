/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adparser;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Object containing map of terms and their parameters
 * @author Karol Abramczyk
 */
public class WordBank extends HashMap<String, WordParams>{
    
    String name = "WordBank";
    
    public WordBank() {
        super();
    }
    
    /**
     * Puts new word to wordbank
     * @param word Word inserted to wordbank
     */
    public void addWord(String word) {
        WordParams params = new WordParams(size()+1, 1);
        put(word, params);
    }
    
    /**
     * Returns ID of specified word from wordbank
     * @param word word from wordbank
     * @return ID of specified word
     */
    public int getID(String word) {
        WordParams params = get(word);
        return params.getID();
    }
    
    /**
     * Returns document frequency of specified word from wordbank
     * @param word word from wordbank
     * @return word document frequency
     */
    public int getNumDocs(String word) {
        WordParams params = get(word);
        return params.getNumDocs();
    }
    
    public boolean contains(String word) {
        return containsKey(word);
    }
    
    public WordParams getParams(String word) {
        return get(word);
    }
     
    public void increaseNumDocs(String word) {
        getParams(word).increaseNumDocs();
    }
    
    @Override
    public String toString() {
        String s = "";
        Iterator i = entrySet().iterator();
        while(i.hasNext()) {
            Map.Entry pair = (Map.Entry)i.next();
            s += pair.getKey() + " " + ((WordParams)(pair.getValue())).toString() + Constants.NEWLINE;
        }
        return s;
    }
}
