package com.example.milan.hospital;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class WelcomeFragment extends Fragment {

    private TextView txt_name_info;
    private Button bn_logout;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter adapter;
    private List<Disease> diseaseList;
    private ApiInterface apiInterface;



    OnLogoutListener onLogoutListener;

    public interface OnLogoutListener
    {
        public void LogoutPerformed();
    }

    public WelcomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_welcome, container, false);


        //txt_name_info = view.findViewById(R.id.txt_name_info);
        //txt_name_info.setText("Welcome " + MainActivity.prefConfig.readName());

        recyclerView = view.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<Disease>> call = apiInterface.getSymptoms();
        call.enqueue(new Callback<List<Disease>>() {
            @Override
            public void onResponse(Call<List<Disease>> call, Response<List<Disease>> response) {
                diseaseList = response.body();
                adapter = new RecyclerAdapter(diseaseList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Disease>> call, Throwable t) {

            }
        });



        bn_logout = view.findViewById(R.id.bn_logout);

        bn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLogoutListener.LogoutPerformed();
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        onLogoutListener = (OnLogoutListener) activity;
    }
}




































































