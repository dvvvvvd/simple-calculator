package com.helper.utility;

import com.google.gson.Gson;
import org.springframework.test.web.servlet.MvcResult;

public class MvcJsonResultConverter {
    private static final Gson gson = new Gson();

    public static <T> T convert(MvcResult mvcResult, Class<T> clazz) throws Exception {
        String responseString = mvcResult.getResponse().getContentAsString();

        return gson.fromJson(responseString, clazz);
    }
}
