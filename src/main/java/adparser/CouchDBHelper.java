/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adparser;

import org.lightcouch.*;

/**
 * Uses LightCouch
 * @author Karol
 */
public class CouchDBHelper {
    
    CouchDbClient dbClient;
    
    public CouchDBHelper(String name) {
        dbClient = new CouchDbClient(name, true, "http", "127.0.0.1", 5984, "", "");
    }
    
    public void test() {
        Ad a = new Ad();
        a.setTitle("First ad");
        a.setPrice(200000);
        Response response = dbClient.save(a);
        String id = response.getId();
        Ad b = dbClient.find(Ad.class, id);
        System.out.println(b.toString());
    }
    
    public Response save(Object o) {
        return dbClient.save(o);
    }
    
}
