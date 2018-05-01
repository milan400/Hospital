package com.example.milan.hospital;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WelcomeFragment extends Fragment {

    private TextView txt_name_info;
    private Button bn_logout;

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
        txt_name_info = view.findViewById(R.id.txt_name_info);
        txt_name_info.setText("Welcome " + MainActivity.prefConfig.readName());
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




































































