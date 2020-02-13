package edu.ucsb.cs56.w20.lab07.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.ucsb.cs56.w20.lab07.formbeans.EqSearch;
import edu.ucsb.cs56.w20.lab07.services.EarthquakeQueryService;

@Controller
public class EarthquakesController {
    
    @GetMapping("/earthquakes/search")
    public String getEarthquakesSearch(Model model, OAuth2AuthenticationToken oAuth2AuthenticationToken,
            EqSearch eqSearch) {
        return "earthquakes/search";        
    }
    
    @GetMapping("/earthquakes/results")
    public String getEarthquakesResults(Model model, OAuth2AuthenticationToken oAuth2AuthenticationToken,
            EqSearch eqSearch) {
            
        EarthquakeQueryService e = new EarthquakeQueryService();
        model.addAttribute("eqSearch", eqSearch);
        String json = e.getJSON(eqSearch.getDistance(), eqSearch.getMinmag());
        model.addAttribute("json", json);
        return "earthquakes/results";
    }
   
}
