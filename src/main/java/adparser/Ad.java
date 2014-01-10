/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adparser;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Instance of ad. All fields are optional.
 * @author Karol Abramczyk
 */
public class Ad {
    /**
     * Holds the number of all created ads. Used for ad ID assignment.
     */
    public static int adsCount = 0;
    
    /**
     * Ad unique ID
     */
    private int ID;
    
    /**
     * Ad title
     */
    private String title;
    
    /**
     * Ad description
     */
    private String description;
    
    /**
     * City, where advertised property is located.
     */
    private String city;
    
    /**
     * District of city, where advertised property is located.
     */
    private String district;
    
    /**
     * Street, where advertised property is located.
     */
    private String street;
    
    /**
     * Price of the advertised property
     */
    private int price;
    
    /**
     * Price per meter of advertised property
     */
    private int pricePerMeter;
    
    /**
     * Number of bedrooms
     */
    private int numBedrooms;
    
    /**
     * Number of bathrooms
     */
    private int numBathrooms;
    
    /**
     * Floor number
     */
    private int floor;
    
    /**
     * Area of the advertised property in square meters
     */
    private double area;
    
    /**
     * Time of ad last update
     */
    private Date lastUpdate;
    
    /**
     * Year of building construction
     */
    private int constructionYear;
    
    /**
     * Number of floors in the building
     */
    private int numFloors;
    
    /**
     * Direct link to this advertisement
     */
    private String link;
    
    /**
     * Map of keywords and their parameters extracted from the ad
     */
    private KeyWords keywords;
    
    /**
     * Similarity vector of this ad.
     */
    private SimilarityVector similarityVector;
    
    /**
     * Number of the cluster this ad was assigned to by classification
     */
    private int clusterNo;
    
    /**
     * Number of the cluster this ad should obtain by classification (assigned manually)
     */
    private int predictedClusterNo;

    /**
     * Returns unique ID of this ad
     * @return ad ID
     */
    public int getID() {
        return ID;
    }
    
    /**
     * Sets ad ID
     * @param ID new ID of the ad
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Returns ad title
     * @return ad title
     */
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

    public int getNumBedrooms() {
        return numBedrooms;
    }

    public void setNumBedrooms(int numBedrooms) {
        this.numBedrooms = numBedrooms;
    }

    public int getNumBathrooms() {
        return numBathrooms;
    }

    public void setNumBathrooms(int numBathrooms) {
        this.numBathrooms = numBathrooms;
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

    public int getNumFloors() {
        return numFloors;
    }

    public void setNumFloors(int numFloors) {
        this.numFloors = numFloors;
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
    
    /**
     * Creates Ad, increments number of all ads, and assigns ID to this Ad
     */
    public Ad() {
        Ad.adsCount++;
        this.ID = Ad.adsCount;
        keywords = new KeyWords();
        similarityVector = new SimilarityVector();
    }
    
    /**
     * Returns parameters of this Ad as a string
     */
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
                + "rooms : " + numBedrooms + Constants.NEWLINE
                + "bathrooms : " + numBathrooms + Constants.NEWLINE
                + "floor : " + floor + Constants.NEWLINE
                + "floors in building : " + numFloors + Constants.NEWLINE
                + "construction year : " + constructionYear + Constants.NEWLINE
                + "description : " + description + Constants.NEWLINE
                + "link : " + link + Constants.NEWLINE;
        
        return out;
    }
    
    /**
     * Returns keywords of this Ad as string
     * @return Ad keywords as string
     */
    public String keywordsToString() {
        return keywords.toString();
    }
    
    /**
     * Returns similarity vector of this ad as string
     * @return Ad similarity vector as string
     */
    public String similarityVectorToString() {
        return similarityVector.toString();
    }
}
