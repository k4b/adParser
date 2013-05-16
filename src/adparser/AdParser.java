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
        String url = "http://www.oferty.net/mieszkania/szukaj?ps%5Blocation%5D%5Btype%5D=1&ps%5Btype%5D=1&ps%5Btransaction%5D=1&ps%5Blocation%5D%5Btext%5D=Warszawa&ps%5Bliving_area_from%5D=30&ps%5Bliving_area_to%5D=60&ps%5Bprice_from%5D=100&ps%5Bprice_to%5D=300000";
        
        String url2 = "http://www.oferty.net/mieszkania/szukaj?ps%5Btype%5D=1&ps%5Blocation%5D%5Btype%5D=1&ps%5Blocation%5D%5Btext_queue%5D%5B%5D=Warszawa&ps%5Btransaction%5D=1&ps%5Bprice_from%5D=10000&ps%5Bprice_to%5D=155000&ps%5Bdate_filter%5D=0&ps%5Bsort_order%5D=rank_asc";
        String tag = "tbody";
        String detailsURL = "http://www.oferty.net/mieszkanie-na-sprzedaz-broniewskiego-warszawa-bielany,922442274";
        
        Parser parser = new Parser();
        parser.startParsing(url2, tag, 1);
    }
}
