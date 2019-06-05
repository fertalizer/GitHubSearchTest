package com.mark.githubsearchtest.search;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import com.mark.githubsearchtest.R;
import com.mark.githubsearchtest.data.User;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter {

    private SearchContract.Presenter mPresenter;

    private ArrayList<User> mUsers = new ArrayList<>();

    public SearchAdapter(SearchContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new SearchViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_search, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.d("Mark", "1. Bind" + mUsers.get(0).getName());
        Log.d("Mark", "2. Bind" + mUsers.get(1).getName());

        if (holder instanceof SearchViewHolder) {
            bindSearchViewHolder((SearchViewHolder) holder, mUsers.get(position));
        }
    }

    private void bindSearchViewHolder(SearchViewHolder holder, User user) {
        holder.getTextName().setText(user.getName());
        Picasso.get()
                .load(user.getAvatarUrl())
                .fit()
                .centerCrop()
                .into(holder.getImageAvatar());
    }

    @Override
    public int getItemCount() {
        Log.d("Mark", "Size = " + mUsers.size());
        return mUsers.size();
    }

    private class SearchViewHolder extends RecyclerView.ViewHolder{
        private TextView mTextName;
        private ImageView mImageAvatar;

        public SearchViewHolder(View itemView) {
            super(itemView);

            mTextName = itemView.findViewById(R.id.search_text_name);
            mImageAvatar = itemView.findViewById(R.id.search_image);
        }

        public TextView getTextName() {
            return mTextName;
        }

        public ImageView getImageAvatar() {
            return mImageAvatar;
        }
    }

    public void updateData(ArrayList<User> users) {
        mUsers = users;
        notifyDataSetChanged();
    }
}
