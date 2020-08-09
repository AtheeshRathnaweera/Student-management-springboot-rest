package com.atheesh.studentmenagementcache.utils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeAdapter implements JsonDeserializer<Date> {

    @Override
    public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date formattedDate = new Date();

        try {
            formattedDate = simpleDateFormat.parse(jsonElement.getAsString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formattedDate;
    }
}
