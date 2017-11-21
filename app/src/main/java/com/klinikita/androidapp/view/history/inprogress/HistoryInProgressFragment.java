package com.klinikita.androidapp.view.history.inprogress;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.klinikita.androidapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryInProgressFragment extends Fragment {


    public HistoryInProgressFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history_in_progress, container, false);
    }

}
