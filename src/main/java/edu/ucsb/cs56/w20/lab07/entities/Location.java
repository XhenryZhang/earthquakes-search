package edu.ucsb.cs56.w20.lab07.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; // used by website

    private long placeId; // name must match getter and setters
    private String name;
    private double latitude;
    private double longitude;

    public Location() {
    }

    public Location(long place, String name, double lat, double lon) {
        this.placeId = place;
        this.name = name;
        this.latitude = lat;
        this.longitude = lon;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPlaceId(long id) {
        this.placeId = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLatitude(double lat) {
        this.latitude = lat;
    }

    public void setLongitude(double lon) {
        this.longitude = lon;
    }

    public long getId() {
        return id;
    }

    public long getPlaceId() {
        return placeId;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}