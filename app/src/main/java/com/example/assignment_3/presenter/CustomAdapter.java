package com.example.assignment_3.presenter;

import android.content.Context;
import android.content.Intent;
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
    static ChannelPojo channel;
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
                .resize(200, 200)
                .into(channelViewHolder.imageView);

        ChannelPojo channelPojo = channelList.channels.get(i);
        channel = new ChannelPojo(channelPojo.getLargeimage(), channelPojo.getTitle(),
                channelPojo.getDJ(), channelPojo.getDJEmail(),
                channelPojo.getNumberOfListeners(),
                channelPojo.getGenre());

        cardView.setOnClickListener(v -> {

            frameLayout.setVisibility(View.VISIBLE);
            showChannelDetails();
            Log.d("Info", channel.toString());
            Toast.makeText(v.getContext(), "" + channel.toString(), Toast.LENGTH_SHORT).show();

            Log.d("Card View", "Inside the onBindViewHolder of CustomAdapter");

            Intent intent = new Intent(v.getContext(), ChannelDetailsFragment.class);
            //intent.setClass(v.getContext(), ChannelDetailsFragment.class);

            //v.getContext().startActivity(intent);

            ChannelDetailsFragment fragment = ChannelDetailsFragment.createNewInstance();

            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            FragmentManager fragmentManager = activity.getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragment_container, fragment).addToBackStack(null).commit();

            //recyclerView = v.findViewById(R.id.recycler_view);
            MainActivity.recyclerView.setVisibility(View.GONE);

            //searchView = v.findViewById(R.id.sv_search_icon);
            MainActivity.searchView.setVisibility(View.GONE);

            MainActivity.isChannelDetailsDisplayed = true;

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
        //CardView cardView;
        ImageView imageView;
        TextView tvTitle;
        TextView tvDescription;
        TextView tvDJ;
        Context context;


        public ChannelViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.card_view);
            imageView = itemView.findViewById(R.id.iv_thumbnail);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDescription = itemView.findViewById(R.id.tv_description);
            tvDJ = itemView.findViewById(R.id.tv_dj);

            /*cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(v.getContext(), "" + channel.toString(), Toast.LENGTH_SHORT).show();
                    //Log.d("Card View", "Inside the ChannelViewHolder");
                }
            });*/
        }
    }
}
