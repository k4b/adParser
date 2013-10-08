/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adparser;

/**
 * Object containing parameters of word in wordbank.
 * @author Karol
 */
public class WordParams {
    
	/**
	 * Word ID
	 */
    private int ID;
    
    /**
     * word document frequency
     */
    private int numDocs;
    
    public WordParams(int ID, int numDocs) {
        this.ID = ID;
        this.numDocs = numDocs;
    }
    
    public int getID() {
        return ID;
    }

    public int getNumDocs() {
        return numDocs;
    }
    
    public void increaseNumDocs() {
        numDocs++;
    }
    
    @Override
    public String toString() {
        String s = "";
        s += "ID=" + ID + " numDocs=" + numDocs;
        return s;
    }
    
}
