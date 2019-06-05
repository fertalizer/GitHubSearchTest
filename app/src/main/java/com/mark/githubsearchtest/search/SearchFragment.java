package com.mark.githubsearchtest.search;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.mark.githubsearchtest.R;
import com.mark.githubsearchtest.data.bean.GetUserList;

import static com.google.common.base.Preconditions.checkNotNull;


public class SearchFragment extends Fragment implements SearchContract.View, View.OnClickListener {
    private SearchContract.Presenter mPresenter;
    private SearchAdapter mSearchAdapter;
    private EditText mEditText;
    private RecyclerView mRecyclerView;
    private Button mButton;
    private String mResult;

    public SearchFragment() {

    }

    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    @Override
    public void setPresenter(SearchContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSearchAdapter = new SearchAdapter(mPresenter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_search, container, false);
        mRecyclerView = root.findViewById(R.id.search_recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mSearchAdapter);
        mEditText = root.findViewById(R.id.search_edit_name);
        mButton = root.findViewById(R.id.search_button);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.start();
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mResult = s.toString();
            }
        });

        mButton.setOnClickListener(this);

    }

    @Override
    public void initView() {

    }


    @Override
    public void showSearchUi(GetUserList bean) {
        Log.d("Mark", "Update");
        mSearchAdapter.updateData(bean.getUsers());
    }


    @Override
    public void onClick(View v) {
        if (!"".equals(mResult) && mResult != null) {
            mRecyclerView.setVisibility(View.VISIBLE);
            mPresenter.loadSearchData(mResult);
        } else {
            mRecyclerView.setVisibility(View.GONE);
        }
    }
}
