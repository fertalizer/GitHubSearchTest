package com.mark.githubsearchtest.data.bean;

import com.mark.githubsearchtest.data.User;

import java.util.ArrayList;

public class GetUserList {
    private ArrayList<User> mUsers;

    public GetUserList() {
        mUsers = new ArrayList<>();
    }

    public ArrayList<User> getUsers() {
        return mUsers;
    }

}
