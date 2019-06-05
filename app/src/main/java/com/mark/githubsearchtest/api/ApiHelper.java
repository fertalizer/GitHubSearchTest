package com.mark.githubsearchtest.api;

import com.mark.githubsearchtest.data.bean.GetUserList;

import java.io.IOException;

public class ApiHelper {
    private static final String HOST = "https://api.github.com";
    private static final String SEARCH_PATH = "/search";
    private static final String USER_PATH = "/users";
    private static final String REQUIRED_PATH = "?q=";
    private static final String GET_USERS_URL = HOST + SEARCH_PATH + USER_PATH + REQUIRED_PATH;

    public static GetUserList getUserList(String result) throws IOException {

        return Parser.parseGetUserList(new Client().get(GET_USERS_URL + result));

    }

}
