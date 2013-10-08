/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adparser;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * HashMap of keywords and their parameters.
 * @author Karol
 */
public class KeyWords extends HashMap<String, KeyWordParams>{
    
	/**
	 * Creates keywords hashmap
	 */
    public KeyWords() {
        super();
    }
    
    /**
     * Returns keywords hashmap as a string of key - value pairs
     */
    @Override
    public String toString() {
        String s = "";
        Iterator i = entrySet().iterator();
        while(i.hasNext()) {
            Map.Entry pair = (Map.Entry)i.next();
            s += pair.getKey() + " " + ((KeyWordParams)(pair.getValue())).getTf() + Constants.NEWLINE;
        }
        return s;
    }
}
