package com.mark.githubsearchtest.search;

import com.mark.githubsearchtest.base.BasePresenter;
import com.mark.githubsearchtest.base.BaseView;
import com.mark.githubsearchtest.data.bean.GetUserList;

public interface SearchContract {
    interface View extends BaseView<Presenter> {

        void initView();

        void showSearchUi(GetUserList bean);

    }

    interface Presenter extends BasePresenter {

        void loadSearchData(String result);

        void setSearchData(GetUserList bean);

    }

}
