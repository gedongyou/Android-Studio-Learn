package com.example.model_d;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import androidx.fragment.app.Fragment;

import Adapter.yhgl_Adapter;

public class yhglFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_yhgl, container, false);
        Adapter yhgl_Adapter = new yhgl_Adapter(getContext(),);

        return inflater.inflate(R.layout.fragment_yhgl, container, false);
    }
}