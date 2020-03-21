package osm;

// convert JSON representation of a Place into Place obj.
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;

// logging
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Place {
    public String type; // name must match json titles
    public long place_id;
    public double lat;
    public double lon;
    public String display_name;

    private static Logger logger = LoggerFactory.getLogger(Place.class);
    
    /**
     * Create a List of Place objects from json representation
     * 
     * @param json String of json returned by API endpoint {@code /classes/search}
     * @return a new List of Place objects
     */
    public static List<Place> listFromJson(String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            List<Place> placeList = objectMapper.readValue(json, new TypeReference<List<Place>>(){});
            return placeList;
        } catch (JsonProcessingException jpe) {
            logger.error("JsonProcessingException:" + jpe);
            return null;
        } catch (Exception e) {
            logger.error("Exception:" + e);
            return null;
        }
    }

}

