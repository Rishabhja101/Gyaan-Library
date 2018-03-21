package com.example.risha.gyaanlibraryalpha;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by risha on 2/27/2018.
 */

public class Page_BookView extends Fragment{
    View myView;
    //TextView


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.page_book_view, container, false);
        return myView;
    }
}
