/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adparser;

import java.io.IOException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Karol
 */
public class Parser {
    
    private ArrayList<Ad> ads;
    
    public Parser() {
        ads = new ArrayList<>();
    }
    
    public void parse(String url, String tag) {
        Document doc = getPage(url);
        if(doc == null) {
            System.out.println("doc == null");
            return;
        }
        Element e = getElement(doc, tag);
        ArrayList<Ad> ads = createObjects(e);
        System.out.println(ads.size());
        System.out.println(arrayListToString(ads));
        System.out.println("koniec");
    }
    
    public Document getPage(String url) {
        Document d = null;
        try {
            d = Jsoup.connect(url).get();
        } catch (IOException ex) {
            Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }
    
    public Element getElement(Document doc, String tag) {
        Element element = doc.getElementsByTag(tag).get(0);
        return element;
    }
    
    public ArrayList createObjects( Element element) {
        ArrayList ads = new ArrayList();
        StringTokenizer st;
        
        if(element == null)
            return ads;
        
        Elements children = element.children();
        if(children == null)
            return ads;
        
        for(Element child : children) {
            if(child.className().equals("property oddRow highlight") || child.className().equals("property  highlight")) {
                Ad a = new Ad();
                //get location
                String location = child.getElementsByClass("cell_location").first().getElementsByTag("a").first().text();
                st = new StringTokenizer(location, ",");
                a.setCity(st.nextToken().trim());
                a.setDistrict(st.nextToken().trim());
                
                //get last update
                String dateString = child.getElementsByClass("cell_location").first().getElementsByTag("p").first().text();
                dateString.trim();
                st = new StringTokenizer(dateString, " ");
                int length = st.countTokens();
                if(length > 1) {
                    st.nextToken();
                    dateString = st.nextToken();
                }
                DateFormat formatter = new SimpleDateFormat("DD-MM-YYYY");
                Date date = null;
                try {
                    date = formatter.parse(dateString);
                } catch (ParseException ex) {
                    Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
                }
                a.setLastUpdate(date);
                
                //get street
                String street = child.getElementsByClass("cell_street").first().getElementsByTag("div").first().text();
                street.trim();
                a.setStreet(street);
                
                //get rooms
                String rooms = child.getElementsByClass("cell_rooms").first().text();
                rooms.trim();
                int b = -1;
                b = Integer.parseInt(rooms);
                a.setBedroomsNo(b);
                
                //get area
                String area = child.getElementsByClass("cell_area").first().text();
                area.trim();
                double ar = -1.0;
                NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
                Number number = 0;
                try {
                    number = format.parse(area);
                } catch (ParseException ex) {
                    Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
                }
                ar = number.doubleValue();
                a.setArea(ar);
                
                //get floor
                String floor = child.getElementsByClass("cell_floor").first().text();
                floor.trim();
                if(floor.equals("parter")) {
                    floor = "0";
                }
                int f = -1;
                f = Integer.parseInt(floor);
                a.setFloor(f);
                
                //get price
                String priceString = child.getElementsByClass("cell_price").first().getElementsByTag("div").first().text();
                priceString.trim();
                // remove "&nbsp;"
                priceString = priceString.replace("\u00a0","");
                priceString = priceString.replaceAll("PLN", "");
                priceString =  priceString.replaceAll("\\s", "");
                int p = -1;
                p = Integer.parseInt(priceString);
                a.setPrice(p);
                
                //get price per meter
                if(a.getPrice() > -1 && a.getArea() > -1) {
                    int ppm = (int)(a.getPrice()/a.getArea());
                    a.setPricePerMeter(ppm);
                }
                
                //get link
                String link = child.getElementsByClass("cell_location").first().getElementsByTag("a").first().attr("href");
                link.trim();
                a.setLink(link);
                
                ads.add(a);
            }
        }
        return ads;
    }
    
    public String arrayListToString(ArrayList ar) {
        String s = "";
        for(Object o : ar) {
            s += o.toString();
            s +=Constants.LINE + Constants.NEWLINE;
        }
        return s;
    }
}
