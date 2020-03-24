package edu.ucsb.cs56.w20.lab07.formbeans;

public class EqSearch {
    private int distance;
    private int minmag;
    private double lat;
    private double lon;
    private String location;
    
    public EqSearch () {
    
    }
    
    public int getDistance() { return distance; }
    public int getMinmag() { return minmag; }
    public double getLat() { return lat; }
    public double getLon() { return lon; }
    public String getLocation() { return location; }
    
    public void setDistance(int dist) { this.distance = dist; }
    public void setMinmag(int newMinMag) { this.minmag = newMinMag; }
    public void setLat(double newLat) { this.lat = newLat; }
    public void setLon(double newLon) { this.lon = newLon; }
    public void setLocation(String newloc) { this.location = newloc; }
}