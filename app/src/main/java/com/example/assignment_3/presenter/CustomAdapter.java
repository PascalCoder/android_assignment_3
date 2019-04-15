package com.example.assignment_3.presenter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignment_3.R;
import com.example.assignment_3.model.ChannelPojo;
import com.example.assignment_3.model.Channels;
import com.example.assignment_3.view.ChannelDetailsFragment;
import com.example.assignment_3.view.MainActivity;
import com.squareup.picasso.Picasso;

import static com.example.assignment_3.view.MainActivity.frameLayout;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ChannelViewHolder>
                           implements PresenterContractCustomAdapter{

    Channels channelList;
    ChannelPojo channelPojo;
    static CardView cardView;

    private SearchView searchView;
    private RecyclerView recyclerView;


    public CustomAdapter(){}

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
                .resize(260, 260)
                .into(channelViewHolder.ivThumbnail);

        channelViewHolder.tvDJMail.setText(channelList.channels.get(i).getDJEmail());
        channelViewHolder.tvListeners.setText(channelList.channels.get(i).getNumberOfListeners());
        channelViewHolder.tvGenre.setText(channelList.channels.get(i).getGenre());
        channelViewHolder.tvLargeI.setText(channelList.channels.get(i).getLargeimage());
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
        ImageView ivThumbnail;
        TextView tvTitle, tvDescription, tvDJ;

        TextView tvLargeI, tvDJMail, tvListeners, tvGenre;


        public ChannelViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.card_view);
            ivThumbnail = itemView.findViewById(R.id.iv_thumbnail);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDescription = itemView.findViewById(R.id.tv_description);
            tvDJ = itemView.findViewById(R.id.tv_dj);

            tvLargeI = itemView.findViewById(R.id.tv_image_large);
            tvDJMail = itemView.findViewById(R.id.tv_djmail_i);
            tvListeners = itemView.findViewById(R.id.tv_listeners_i);
            tvGenre = itemView.findViewById(R.id.tv_genre_i);

            cardView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v){
                    //Log.d("Info", channel.toString()); //tvTitle.getText()
                    channelPojo = new ChannelPojo(tvLargeI.getText().toString(), tvTitle.getText().toString(), tvDJ.getText().toString(),
                                                   tvDJMail.getText().toString(), tvListeners.getText().toString(), tvGenre.getText().toString());
                    Toast.makeText(v.getContext(), "" + channelPojo, Toast.LENGTH_SHORT).show();

                    Bundle bundle = new Bundle();
                    bundle.putString("image", channelPojo.getLargeimage());
                    bundle.putString("title", channelPojo.getTitle());
                    bundle.putString("dj", channelPojo.getDJ());
                    bundle.putString("djmail", channelPojo.getDJEmail());
                    bundle.putString("listeners", channelPojo.getNumberOfListeners());
                    bundle.putString("genre", channelPojo.getGenre());

                    ChannelDetailsFragment fragment = ChannelDetailsFragment.createNewInstance();
                    fragment.setArguments(bundle);

                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    FragmentManager fragmentManager = activity.getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, fragment).addToBackStack(null).commit();


                    MainActivity.recyclerView.setVisibility(View.GONE);

                    //searchView = v.findViewById(R.id.sv_search_icon);
                    MainActivity.searchView.setVisibility(View.GONE);

                    MainActivity.isChannelDetailsDisplayed = true;

                    frameLayout.setVisibility(View.VISIBLE);
                }
            });
        }
    }
}
