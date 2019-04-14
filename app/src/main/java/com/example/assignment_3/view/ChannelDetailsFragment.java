package com.example.assignment_3.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.assignment_3.R;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChannelDetailsFragment extends Fragment implements ViewContractChannelDetails {

    ImageView imageView;
    TextView tvTitle, tvDJ, tvDJEmail, tvListeners, tvGenre;

    String image, title, djText, djEmailText, numOfListeners, genreText;

    public ChannelDetailsFragment() {
        // Required empty public constructor
    }

    public static ChannelDetailsFragment createNewInstance(){
        return ViewContractChannelDetails.newInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_channel_details, container, false);

        imageView = rootView.findViewById(R.id.iv_image);
        tvTitle = rootView.findViewById(R.id.tv_title_dp);
        tvDJ = rootView.findViewById(R.id.tv_dj_dp);
        tvDJEmail = rootView.findViewById(R.id.tv_djmail);
        tvListeners = rootView.findViewById(R.id.tv_listeners);
        tvGenre = rootView.findViewById(R.id.tv_genre);

        image = getArguments().getString("image");
        title = getArguments().getString("title");
        djText = getArguments().getString("dj");
        djEmailText = getArguments().getString("djmail");
        numOfListeners = getArguments().getString("listeners");
        genreText = getArguments().getString("genre");

        Picasso.get().load(image).into(imageView);
        tvTitle.setText(title);
        tvDJ.setText(djText);
        tvDJEmail.setText(djEmailText);
        tvListeners.setText(numOfListeners);
        tvGenre.setText(genreText);

        return rootView;
    }

}
