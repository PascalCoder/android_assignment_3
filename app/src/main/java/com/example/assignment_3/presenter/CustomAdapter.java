package com.example.assignment_3.presenter;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.assignment_3.R;
import com.example.assignment_3.model.Channels;
import com.squareup.picasso.Picasso;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ChannelViewHolder>
                           implements PresenterContractCustomAdapter{

    Channels channelList;

    public CustomAdapter(Channels channelList){
        this.channelList = channelList;
    }

    @NonNull
    @Override
    public ChannelViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ChannelViewHolder(LayoutInflater.from(viewGroup.getContext())
                                .inflate(R.layout.item_layout, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ChannelViewHolder channelViewHolder, int i) {

        Log.d("Size", "" + channelList.channels.size());

        channelViewHolder.tvTitle.setText(channelList.channels.get(i).getTitle());
        channelViewHolder.tvDescription.setText(channelList.channels.get(i).getDescription());
        channelViewHolder.tvDJ.setText(channelList.channels.get(i).getDJ());
        Picasso.get().load(channelList.channels.get(i).getImage())
                .resize(200, 200)
                .into(channelViewHolder.imageView);

        channelViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChannelDetails();
            }
        });
    }

    @Override
    public int getItemCount() {
        return channelList.channels.size();
    }

    @Override
    public void showChannelDetails() {

    }

    public class ChannelViewHolder extends RecyclerView.ViewHolder {

        //Items of the item_layout.xml file
        CardView cardView;
        ImageView imageView;
        TextView tvTitle;
        TextView tvDescription;
        TextView tvDJ;

        public ChannelViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.card_view);
            imageView = itemView.findViewById(R.id.iv_thumbnail);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDescription = itemView.findViewById(R.id.tv_description);
            tvDJ = itemView.findViewById(R.id.tv_dj);
        }
    }
}
