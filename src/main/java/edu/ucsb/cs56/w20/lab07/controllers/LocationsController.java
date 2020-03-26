package edu.ucsb.cs56.w20.lab07.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import edu.ucsb.cs56.w20.lab07.formbeans.LocSearch;
import edu.ucsb.cs56.w20.lab07.repositories.LocationRepository;
import edu.ucsb.cs56.w20.lab07.services.LocationQueryService;
import geojson.FeatureCollection;
import osm.Place;

@Controller
public class LocationsController {

    private LocationRepository locationRepository;

    @Autowired
    public LocationsController(LocationRepository repo) {
        this.locationRepository = repo;
    }
    
    @GetMapping("/locations/search")
    public String getLocationsSearch(Model model, OAuth2AuthenticationToken oAuth2AuthenticationToken,
            LocSearch locSearch) { // called whenever mapping is locations/search
        return "locations/search"; // called whenever a bean is added to it, creates a default bean
    }

    @GetMapping("/locations/results")
    public String getLocationsResults(Model model, OAuth2AuthenticationToken oAuth2AuthenticationToken,
            LocSearch blabla) {

        LocationQueryService e = new LocationQueryService(); // gets from formbeans class and gets json from the location, forming a url
        model.addAttribute("xdd", blabla);
        String json = e.getJSON(blabla.getLocation());

        // TODO: Actually do the search here and add results to the model
        List<Place> placeList = Place.listFromJson(json); // call the place json processor
        model.addAttribute("places", placeList);
        return "locations/results";
    }

    @GetMapping("/locations")
    public String users(Model model, OAuth2AuthenticationToken token) {
        
        model.addAttribute("locations", locationRepository.findAll());
        return "locations/index";
    }

}
