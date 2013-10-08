/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.adparser;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author Karol
 */
public class Ad {
    /**
     * Holds the number of all created ads. Used for ad ID assignment.
     */
    public static int adsCount = 0;
    
    private int ID;
    private String title;
    private String description;
    private String city;
    private String district;
    private String street;
    //Numbers
    private int price;
    private int pricePerMeter;
    private int bedroomsNo;
    private int bathroomsNo;
    private int floor;
    private double area;
    //Details
    private Date lastUpdate;
    private int constructionYear;
    private int floorsInBuilding;
    private String link;
    //Prepared data
    private KeyWords keywords;
    private SimilarityVector similarityVector;
    //Postclassification data
    private int clusterNo;
    private int predictedClusterNo;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPricePerMeter() {
        return pricePerMeter;
    }

    public void setPricePerMeter(int pricePerMeter) {
        this.pricePerMeter = pricePerMeter;
    }

    public int getBedroomsNo() {
        return bedroomsNo;
    }

    public void setBedroomsNo(int bedroomsNo) {
        this.bedroomsNo = bedroomsNo;
    }

    public int getBathroomsNo() {
        return bathroomsNo;
    }

    public void setBathroomsNo(int bathroomsNo) {
        this.bathroomsNo = bathroomsNo;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public int getConstructionYear() {
        return constructionYear;
    }

    public void setConstructionYear(int constructionYear) {
        this.constructionYear = constructionYear;
    }

    public int getFloorsInBuilding() {
        return floorsInBuilding;
    }

    public void setFloorsInBuilding(int floorsInBuilding) {
        this.floorsInBuilding = floorsInBuilding;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public KeyWords getKeywords() {
        return keywords;
    }

    public void setKeywords(KeyWords keywords) {
        this.keywords = keywords;
    }

    public SimilarityVector getSimilarityVector() {
        return similarityVector;
    }

    public void setSimilarityVector(SimilarityVector similarityVector) {
        this.similarityVector = similarityVector;
    }

    public int getClusterNo() {
        return clusterNo;
    }

    public void setClusterNo(int clusterNo) {
        this.clusterNo = clusterNo;
    }
    
    public int getPredictedClusterNo() {
        return predictedClusterNo;
    }

    public void setPredictedClusterNo(int predictedClusterNo) {
        this.predictedClusterNo = predictedClusterNo;
    }
    
    
    public Ad() {
        Ad.adsCount++;
        this.ID = Ad.adsCount;
        keywords = new KeyWords();
        similarityVector = new SimilarityVector();
    }
    
    @Override
    public String toString() {
        String out = "";
        out += "ID :" + ID + Constants.NEWLINE 
                + "title : " + title + Constants.NEWLINE 
                + "price : " + price + Constants.NEWLINE
                + "price/m2 : " + pricePerMeter + Constants.NEWLINE
                + "area : " + area + Constants.NEWLINE
                + "city : " + city + Constants.NEWLINE
                + "district : " + district + Constants.NEWLINE
                + "street : " + street + Constants.NEWLINE
                + "rooms : " + bedroomsNo + Constants.NEWLINE
                + "bathrooms : " + bathroomsNo + Constants.NEWLINE
                + "floor : " + floor + Constants.NEWLINE
                + "floors in building : " + floorsInBuilding + Constants.NEWLINE
                + "construction year : " + constructionYear + Constants.NEWLINE
                + "description : " + description + Constants.NEWLINE
                + "link : " + link + Constants.NEWLINE;
        
        return out;
    }
    
    public String keywordsToString() {
        return keywords.toString();
    }
    
    public String similarityVectorToString() {
        return similarityVector.toString();
    }
}
