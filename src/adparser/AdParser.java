/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adparser;

/**
 *
 * @author Karol
 */
public class AdParser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String url = "http://www.oferty.net/mieszkania/szukaj?ps%5Blocation%5D%5Btype%5D=1&ps%5Btype%5D=1&ps%5Btransaction%5D=1&ps%5Blocation%5D%5Btext%5D=Warszawa&ps%5Bliving_"
                + "area_from%5D=30&ps%5Bliving_area_to%5D=60&ps%5Bprice_from%5D=100&ps%5Bprice_to%5D=300000";
        String tag = "tbody";
        
        Parser parser = new Parser();
        parser.parse(url, tag);
    }
}
