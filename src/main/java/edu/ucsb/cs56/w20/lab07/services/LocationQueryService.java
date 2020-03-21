package edu.ucsb.cs56.w20.lab07.services;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import com.nimbusds.jose.util.StandardCharset;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

public class LocationQueryService {

    private Logger logger = LoggerFactory.getLogger(LocationQueryService.class);

    public String getJSON(String location) {
        /*
         * String fakeJson = "{ \"key\": \"value\" }"; String json = fakeJson;
         * logger.info("json=" + json);
         * 
         * return json;
         */
        RestTemplate template = new RestTemplate(); // rest template

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>("body", headers);
        String uri = "https://nominatim.openstreetmap.org/search?q="; // + doesn't work with /search/ format, so we switched to a format it was compatible with
        String locParam = encodeValue(location);
        String url = uri + locParam + "&format=json"; // forms the url for the web api call, based on api documentation
        logger.info("url=" + url);

        String retVal = "";
        
        try {
            ResponseEntity<String> re = template.exchange(url, HttpMethod.GET, entity, String.class); // makes response
            MediaType contentType = re.getHeaders().getContentType();
            HttpStatus statusCode = re.getStatusCode();
            retVal = re.getBody();
        } catch (HttpClientErrorException e) {
            retVal = "{\"error\": \"401: Unauthorized\"}";
        }

        logger.info("from LocationQueryService.getJSON: " + retVal);
        return retVal;
    }

    private String encodeValue(String value) {
        try {
            logger.info(URLEncoder.encode(value, StandardCharsets.UTF_8.toString()));
        } catch (UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "error";
    }
}