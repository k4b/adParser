/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adparser;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Vector containing pairs of term ID and its tf-idf statistic
 * @author Karol
 */
public class SimilarityVector extends TreeMap<Integer, Double>{
    
    public SimilarityVector() {
        super();
    }
    
    @Override
    public String toString() {
        String s = "";
        Iterator i = entrySet().iterator();
        while(i.hasNext()) {
            Map.Entry pair = (Map.Entry)i.next();
            s += pair.getKey() + " " + ((Double)(pair.getValue())).toString() + Constants.NEWLINE;
        }
        return s;
    }
}
