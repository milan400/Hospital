package com.example.milan.hospital;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class OptionFragment extends Fragment {

    private Button test_gnd,doc_inform,bn_chatapp,bn_logout;
    OnLogoutListener onLogoutListener;

    public interface OnLogoutListener
    {
        public void LogoutPerformed();
    }



    public OptionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_option, container, false);

        test_gnd = view.findViewById(R.id.test_gnd);
        doc_inform = view.findViewById(R.id.doc_inform);
        bn_chatapp = view.findViewById(R.id.bn_chatapp);
        bn_logout = view.findViewById(R.id.bn_logout);


        test_gnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(getContext(),Welcome.class);
               startActivity(intent);
            }
        });

        bn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLogoutListener.LogoutPerformed();
            }
        });

        bn_chatapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchFacebookApplication = getActivity().getPackageManager().getLaunchIntentForPackage("com.example.kiran.chatapp");
                startActivity(launchFacebookApplication);
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
