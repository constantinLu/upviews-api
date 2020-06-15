package com.program.upviews.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Wrapper {

    /**
     * Wrap object to json
     *
     * @param obj to be wrapped in json
     * @return json format
     * @throws JsonProcessingException .
     */
    public static String jsonWrapper(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer();
        return ow.writeValueAsString(obj);
    }
}
