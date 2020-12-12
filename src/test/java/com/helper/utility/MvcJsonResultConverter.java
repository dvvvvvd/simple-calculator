package com.helper.utility;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

public class MvcJsonResultConverter {
    private static final Gson gson = new Gson();
    private static final JsonParser jsonParser = new JsonParser();

    public static <T> T convert(MvcResult mvcResult, Class<T> clazz) throws Exception {
        String responseString = mvcResult.getResponse().getContentAsString();

        return gson.fromJson(responseString, clazz);
    }

    public static <T> List<T> convertFromJsonArray(MvcResult mvcResult, Class<T> clazz) throws Exception {
        String responseString = mvcResult.getResponse().getContentAsString();

        JsonElement jsonElement = jsonParser.parse(responseString);
        JsonArray jsonArray = jsonElement.getAsJsonArray();

        List<T> resultList = new ArrayList<>();

        for (JsonElement element : jsonArray) {
            resultList.add(gson.fromJson(element, clazz));
        }

        return resultList;
    }
}
