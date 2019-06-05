package com.mark.githubsearchtest.data;

import android.support.annotation.NonNull;

import com.mark.githubsearchtest.data.bean.GetUserList;

public interface DataSource {

    interface GetUserListCallback {

        void onComplete(GetUserList bean);

        void onError(String errorMessage);

    }

    void getUserList(String result, @NonNull GetUserListCallback callback);

}
