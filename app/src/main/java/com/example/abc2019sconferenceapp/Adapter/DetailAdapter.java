package com.example.abc2019sconferenceapp.Adapter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.abc2019sconferenceapp.Fragment.DetailFragment;
import com.example.abc2019sconferenceapp.Fragment.SearchResultFragment;
import com.example.abc2019sconferenceapp.R;
import com.example.abc2019sconferenceapp.TimelineDataBean;


public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.DetailRecyclerViewHolder> {
    private TimelineDataBean.TimelineData dataBeans;
    private FragmentManager fragmentManager;
    private Fragment fragment;

    public DetailAdapter(TimelineDataBean.TimelineData dataBeans, FragmentManager fragmentManager, Fragment fragment) {
        this.dataBeans = dataBeans;
        this.fragmentManager = fragmentManager;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public DetailAdapter.DetailRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflateView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.detail_item, viewGroup, false);
        return new DetailAdapter.DetailRecyclerViewHolder(inflateView);
    }

    @Override
    public void onBindViewHolder(@NonNull final DetailAdapter.DetailRecyclerViewHolder viewHolder, int i) {
        Glide.with(fragment).load(dataBeans.getPresenterIcons().get(i).getIconUrl()).into(viewHolder.presenterIcon);
        viewHolder.presenterName.setText(dataBeans.getPresenterNames().get(i).getPresenter());
        viewHolder.companyName.setText(dataBeans.getBelongs().get(i).getBelong());
    }

    @Override
    public int getItemCount() {
        if (dataBeans != null) {
            return dataBeans.getPresenterNames().size();
        } else {
            return 0;
        }
    }

    class DetailRecyclerViewHolder extends RecyclerView.ViewHolder {
        ImageView presenterIcon;
        TextView presenterName;
        TextView companyName;

        private DetailRecyclerViewHolder(View itemView) {
            super(itemView);
            presenterIcon = itemView.findViewById(R.id.presenterIcon);
            presenterName = itemView.findViewById(R.id.presenterName);
            companyName = itemView.findViewById(R.id.companyName);
        }
    }
}