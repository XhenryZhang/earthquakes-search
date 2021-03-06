package geojson;

// convert JSON representation of a Feature Collection into FeatureCollection obj.
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

// logging
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FeatureCollection {
    public String type;
    public Metadata metadata;
    public List<Feature> features; // after meta data, list of features
    private static Logger logger = LoggerFactory.getLogger(FeatureCollection.class);
    
     /**
     * Create a FeatureCollection object from json representation
     * 
     * @param json String of json returned by API endpoint {@code /classes/search}
     * @return a new FeatureCollection object
     * @see <a href=
     *      "https://tools.ietf.org/html/rfc7946">https://tools.ietf.org/html/rfc7946</a>
     */
    public static FeatureCollection fromJSON(String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            // if there's a property in JSON that doesn't match any field in Java object it will ignore it
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            FeatureCollection featureCollection = objectMapper.readValue(json, FeatureCollection.class);
            return featureCollection;
        } catch (JsonProcessingException jpe) {
            logger.error("JsonProcessingException:" + jpe);
            return null;
        } catch (Exception e) {
            logger.error("Exception:" + e);
            return null;
        }
    }

}