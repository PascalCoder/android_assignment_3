package com.example.assignment_3.model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ChannelApi {

    @GET("jvanaria/jvanaria.github.io/master/channels.json")
    Call<Channels> getChannel();
}
