package edu.ucsb.cs56.w20.lab07.formbeans;

public class LocSearch {
    private String location;
    
    public LocSearch () {
    
    }
    
    // naming convention matters, after get must match name specified on
    // thymeleaf form in th:field
    public String getLocation() { return location; }
    
    public void setLocation(String loc) { this.location = loc; }
    
}