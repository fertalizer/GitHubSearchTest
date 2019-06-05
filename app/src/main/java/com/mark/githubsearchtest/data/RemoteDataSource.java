package com.mark.githubsearchtest.data;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import com.mark.githubsearchtest.api.ApiHelper;
import com.mark.githubsearchtest.data.bean.GetUserList;

import java.io.IOException;

public class RemoteDataSource implements DataSource{
    private static RemoteDataSource INSTANCE;

    public static RemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RemoteDataSource();
        }
        return INSTANCE;
    }

    private RemoteDataSource() {}

    @SuppressLint("StaticFieldLeak")
    @Override
    public void getUserList(final String result, @NonNull final GetUserListCallback callback) {

        new AsyncTask<Void, Void, GetUserList>() {

            private String mErrorMessage = "";

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected GetUserList doInBackground(Void... voids) {

                GetUserList bean = null;

                try {
                    bean = ApiHelper.getUserList(result);
                } catch (IOException e) {
                    mErrorMessage = e.getMessage();
                    e.printStackTrace();
                }
                return bean;
            }

            @Override
            protected void onPostExecute(GetUserList bean) {
                super.onPostExecute(bean);

                if (bean != null) {

                    callback.onComplete(bean);
                } else if (!"".equals(mErrorMessage)) {

                    callback.onError(mErrorMessage);
                } else {

                    Log.d("Mark", "GetUserList fail");
                }
            }
        }.execute();

    }

}
