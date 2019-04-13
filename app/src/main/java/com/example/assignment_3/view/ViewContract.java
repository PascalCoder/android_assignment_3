package com.example.assignment_3.view;

import com.example.assignment_3.model.Channels;

public interface ViewContract {

    void populateChannels(Channels dataSet);
    void onError(String message);

}
