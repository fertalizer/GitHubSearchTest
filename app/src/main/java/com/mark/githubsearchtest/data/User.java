package com.mark.githubsearchtest.data;

public class User {
    private String mName;
    private String mAvatarUrl;

    public User() {
        mName = "";
        mAvatarUrl = "";
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getAvatarUrl() {
        return mAvatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        mAvatarUrl = avatarUrl;
    }
}
