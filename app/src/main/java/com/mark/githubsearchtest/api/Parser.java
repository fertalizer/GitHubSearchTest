package com.mark.githubsearchtest.api;

import com.mark.githubsearchtest.data.User;
import com.mark.githubsearchtest.data.bean.GetUserList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Parser {
    public static JSONObject parseError(String jsonString) {

        JSONObject obj = null;

        try {
            obj = new JSONObject(jsonString);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return obj;
    }


    public static GetUserList parseGetUserList(String jsonString) {

        GetUserList bean = new GetUserList();

        try {
            JSONObject obj = parseError(jsonString);

            JSONArray items = obj.getJSONArray("items");

            for (int i = 0; i < items.length(); i++) {
                bean.getUsers().add(parseProduct(items.getJSONObject(i)));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return bean;
    }

    public static User parseProduct(JSONObject jsonObject) {

        User objUser = new User();

        try {
            objUser.setName(jsonObject.getString("login"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            objUser.setAvatarUrl(jsonObject.getString("avatar_url"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return objUser;
    }
}
