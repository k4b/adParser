/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.adparser;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Karol
 */
public class KeyWords extends HashMap<String, KeyWordParams>{
    
    public KeyWords() {
        super();
    }
    
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
