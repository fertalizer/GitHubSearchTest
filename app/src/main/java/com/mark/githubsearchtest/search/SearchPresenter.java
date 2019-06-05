package com.mark.githubsearchtest.search;

import android.support.annotation.NonNull;
import android.util.Log;

import com.mark.githubsearchtest.data.DataSource;
import com.mark.githubsearchtest.data.RemoteDataSource;
import com.mark.githubsearchtest.data.bean.GetUserList;

import static com.google.common.base.Preconditions.checkNotNull;

public class SearchPresenter implements SearchContract.Presenter {

    private SearchContract.View mView;

    private RemoteDataSource mRemoteDataSource;

    public SearchPresenter(@NonNull RemoteDataSource remoteDataSource,
                           SearchContract.View view) {
        mRemoteDataSource = checkNotNull(remoteDataSource, "remoteDataSource cannot be null!");
        mView = checkNotNull(view, "view cannot be null!");
        mView.setPresenter(this);
    }

    @Override
    public void start() {
        mView.initView();
    }

    @Override
    public void loadSearchData(String result) {
        mRemoteDataSource.getUserList(result, new DataSource.GetUserListCallback() {
            @Override
            public void onComplete(GetUserList bean) {
                Log.d("Mark", "Complete");
                setSearchData(bean);
            }

            @Override
            public void onError(String errorMessage) {

            }
        });
    }

    @Override
    public void setSearchData(GetUserList bean) {
        Log.d("Mark", "Set Bean");
        mView.showSearchUi(bean);
    }
}
