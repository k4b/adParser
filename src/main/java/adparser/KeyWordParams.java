/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adparser;

/**
 * Keyword parameters object
 * @author Karol Abramczyk
 */
public class KeyWordParams {
	
	/**
	 * Keyword term frequency
	 */
    private int tf;
    
    /**
     * Creates keyword parameters object
     * @param tf KeyWord term frequency
     */
    public KeyWordParams(int tf) {
        this.tf = tf;
    }

    /**
     * Returns keyword term frequency value
     * @return term frequency value of this keyword
     */
    public int getTf() {
        return tf;
    }

    /**
     * Sets this keyword term frequency value
     * @param tf new value of the term frequency
     */
    public void setTf(int tf) {
        this.tf = tf;
    }
    
    
}
