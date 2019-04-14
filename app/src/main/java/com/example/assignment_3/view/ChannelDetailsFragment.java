package com.example.assignment_3.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.assignment_3.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChannelDetailsFragment extends Fragment implements ViewContractChannelDetails {


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

        return rootView;
    }

}
