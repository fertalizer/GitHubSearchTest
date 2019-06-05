package com.mark.githubsearchtest;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mark.githubsearchtest.data.RemoteDataSource;
import com.mark.githubsearchtest.search.SearchFragment;
import com.mark.githubsearchtest.search.SearchPresenter;

public class MainActivity extends AppCompatActivity {

    private SearchPresenter mSearchPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchDemo();
    }

    private void searchDemo() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        SearchFragment fragment = SearchFragment.newInstance();
        mSearchPresenter = new SearchPresenter(RemoteDataSource.getInstance(), fragment);
        fragmentTransaction.replace(R.id.container, fragment, Constant.FRAGMENT_SEARCH);
        fragmentTransaction.commit();
    }
}
