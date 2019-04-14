package com.example.assignment_3.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.assignment_3.R;
import com.example.assignment_3.model.ChannelApi;
import com.example.assignment_3.model.Channels;
import com.example.assignment_3.presenter.CustomAdapter;
import com.example.assignment_3.presenter.Presenter;
import com.example.assignment_3.presenter.PresenterContract;

public class MainActivity extends AppCompatActivity implements ViewContractMainActivity, ViewContract {

    public static RecyclerView recyclerView;
    public static SearchView searchView;
    public static FrameLayout frameLayout;
    PresenterContract presenterContract;
    Presenter presenter;
    ChannelApi api;

    public static boolean isChannelDetailsDisplayed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.sv_search_icon);
        frameLayout = findViewById(R.id.fragment_container);

        recyclerView = findViewById(R.id.recycler_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);

        presenter = new Presenter();

        presenter.bindView(this);
        presenter.initializeRetrofit();
        presenter.getChannels();

        /*CustomAdapter customAdapter = new CustomAdapter();
        CardView cardView = CustomAdapter.cardView;
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplication(), ChannelDetailsFragment.class);

                startActivity(intent);
            }
        });*/
    }

    @Override
    public void onBackPressed(){
        if(isChannelDetailsDisplayed){
            searchView.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.VISIBLE);

            frameLayout.setVisibility(View.GONE);

            isChannelDetailsDisplayed = false;
        }else{
            finish();
        }
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
