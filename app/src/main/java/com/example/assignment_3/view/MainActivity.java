package com.example.assignment_3.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.assignment_3.R;
import com.example.assignment_3.model.ChannelApi;
import com.example.assignment_3.model.Channels;
import com.example.assignment_3.presenter.CustomAdapter;
import com.example.assignment_3.presenter.Presenter;
import com.example.assignment_3.presenter.PresenterContract;

public class MainActivity extends AppCompatActivity implements ViewContractMainActivity, ViewContract {

    RecyclerView recyclerView;
    PresenterContract presenterContract;
    Presenter presenter;
    ChannelApi api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);

        presenter = new Presenter();

        presenter.bindView(this);
        presenter.initializeRetrofit();
        presenter.getChannels();
    }

    @Override
    public void populateChannels(Channels dataSet) {
        recyclerView.setAdapter(new CustomAdapter(dataSet));
    }

    @Override
    public void onError(String message) {
        Toast.makeText(this, "Something went wrong!", Toast.LENGTH_SHORT).show();
    }
}
