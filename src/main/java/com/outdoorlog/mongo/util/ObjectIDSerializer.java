package com.outdoorlog.mongo.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.bson.types.ObjectId;

import java.io.IOException;

/**
 * Created for Outdoorlog
 * User: jonasbirgersson
 * Date: 2015-02-03
 * Time: 5:50 PM
 */
public class ObjectIDSerializer extends JsonSerializer<ObjectId> {

    @Override
    public void serialize(ObjectId objectId, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
        if(objectId == null){
            jgen.writeNull();
        } else {
            jgen.writeString(objectId.toString());
        }
    }
}
