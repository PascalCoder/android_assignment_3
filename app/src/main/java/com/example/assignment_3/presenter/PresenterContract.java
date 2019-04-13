package com.example.assignment_3.presenter;

import com.example.assignment_3.view.ViewContract;

public interface PresenterContract {

    void bindView(ViewContract viewContract);
    void initializeRetrofit();
    void getChannels();
    void onDestroy();
}
