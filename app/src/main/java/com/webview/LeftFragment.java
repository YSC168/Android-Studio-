package com.webview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LeftFragment extends Fragment {

    public View OnCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view =inflater.inflate(R.layout.left_fragment,container,false);
        return  view;
    }
}

