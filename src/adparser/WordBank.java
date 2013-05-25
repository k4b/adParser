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
 *
 * @author Karol
 */
public class WordBank extends HashMap<String, WordParams>{
    
    String name = "WordBank";
    
    public WordBank() {
        super();
    }
    
    public void addWord(String word) {
        WordParams params = new WordParams(size()+1, 1);
        put(word, params);
    }
    
    public int getID(String word) {
        WordParams params = get(word);
        return params.getID();
    }
    
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
