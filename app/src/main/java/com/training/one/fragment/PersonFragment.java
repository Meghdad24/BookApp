package com.training.one.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.training.one.R;

public class PersonFragment extends Fragment {

    private final static String LOGIN = "login";
    private View view;
    private TextView name;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.person_fragment, container, false);

        setupView();

        return view;
    }

    private void setupView() {
        name = view.findViewById(R.id.person_name_id);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(LOGIN, Context.MODE_PRIVATE);
        name.setText(sharedPreferences.getString("NAME", null));
    }
}
