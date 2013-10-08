/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.adparser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import morfologik.stemming.WordData;

/**
 *
 * @author Karol
 */
public class Utils {
    
//    public static String listToString( List<Object> col) {
//        String s = "";
//        for(Object o : col) {
//            s += o.toString() + "\n";
//        }
//        return s;
//    }
    
    public static String listToString( List<WordData> list) {
        String s = "";
        for(WordData w : list) {
            s += w.toString() + "\n";
        }
        return s;
    }
    
    public static String arrayToString( Collection<Object> col) {
        String s = "";
        for(Object o : col) {
            s += o.toString() + "\n";
        }
        return s;
    }
    
    public static ArrayList<String> getStems(List<WordData> list) {
        ArrayList a = new ArrayList();
        for(WordData w : list) {
            a.add(w.getStem().toString());
        }
        return a;
    }
    
    public static ArrayList removeDuplicates(ArrayList list) {
        HashSet noDuplicates = new HashSet();
        noDuplicates.addAll(list);
        
        list.clear();
        list.addAll(noDuplicates);
        return list;
    }
    
    public static void saveToDB(String dbName, ArrayList<Ad> ads, WordBank wordbank) {
        System.out.println("Writing to DB: " + dbName);
        CouchDBHelper dbHelper = new CouchDBHelper(dbName);
        for(Ad a : ads) {
            dbHelper.save(a);
        }
        String wordbankDBName = dbName + "_wordbank";
        CouchDBHelper dbhelperWB = new CouchDBHelper(wordbankDBName);
        dbhelperWB.save(wordbank);
    }
}
