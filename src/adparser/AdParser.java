/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adparser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Karol
 */
public class AdParser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if(args.length > 0)
            System.out.println("site: " + args[0]);
        
        String url = "http://www.oferty.net/mieszkania/szukaj?ps%5Btype%5D=1&ps%5Blocation%5D%5Btype%5D=1&ps%5Blocation%5D%5Btext_queue%5D%5B%5D=Warszawa&ps%5Btransaction%5D=1&ps%5Bprice_from%5D=10000&ps%5Bprice_to%5D=130000&ps%5Bdate_filter%5D=0&ps%5Bsort_order%5D=rank_asc";
        String tag = "tbody";
        
        Parser parser = new Parser();
        Preparator preparator = new Preparator();
        parser.startParsing(url, tag, 100);
        ArrayList<Ad> ads = parser.getAds();
        for(Ad ad : ads) {
            preparator.prepareKeywords(ad);
        }
        for(Ad ad : ads) {
            preparator.prepareSimilarityVector(ad);
        }
        System.out.println(parser.adsTitlesToString(ads));
        
        //save to DB
        DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy_HHmm");
        Calendar cal = Calendar.getInstance();
        String time = dateFormat.format(cal.getTime());
        String dbName = "ads_" + time;
        Utils.saveToDB(dbName, ads, preparator.getWordbank());
    }
}
