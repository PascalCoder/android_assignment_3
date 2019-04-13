package com.example.assignment_3.presenter;

import com.example.assignment_3.model.ChannelApi;
import com.example.assignment_3.model.Channels;
import com.example.assignment_3.view.ViewContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Presenter implements PresenterContract {

    ViewContract viewContract;
    ChannelApi api;

    @Override
    public void bindView(ViewContract viewContract) {
        this.viewContract = viewContract;
    }

    @Override
    public void initializeRetrofit() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://raw.githubusercontent.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        api = retrofit.create(ChannelApi.class);
    }

    @Override
    public void getChannels() {
        api.getChannel().enqueue(new Callback<Channels>() {
            @Override
            public void onResponse(Call<Channels> call, Response<Channels> response) {
                viewContract.populateChannels(response.body());
            }

            @Override
            public void onFailure(Call<Channels> call, Throwable t) {
                viewContract.onError(t.getMessage());
            }
        });
    }

    @Override
    public void onDestroy() {
        viewContract = null;
    }
}
