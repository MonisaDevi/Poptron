package com.example.poptronproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.poptronproject.Model.EntireSharedPreferences;


public class ProfileFragment extends Fragment {

    TextView namee;
    TextView emaill;
    SharedPreferences sharedPreferences;
    TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profilefragment, container, false);
        namee = view.findViewById(R.id.profilename);
        emaill = view.findViewById(R.id.emailtxt);
        textView = view.findViewById(R.id.logout);
        namee.setText(EntireSharedPreferences.getUserName());
        emaill.setText(EntireSharedPreferences.getEmail());
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EntireSharedPreferences.doesNotLogin(true);
                Intent i = new Intent(getActivity(), LoginActivity.class);
                startActivity(i);
                getActivity().finish();
            }
        });

        return view;
    }
}