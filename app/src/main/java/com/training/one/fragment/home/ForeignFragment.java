package com.training.one.fragment.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.training.one.R;
import com.training.one.adapter.PersonAdapter;
import com.training.one.data_base.DataBase;
import com.training.one.model.Person;

public class ForeignFragment extends Fragment {

    View view;
    private RecyclerView recyclerView;
    PersonAdapter personAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.recycler_home, container, false);

        setupViews();

        return view;
    }

    private void setupViews() {
        recyclerView = view.findViewById(R.id.home_recycler_id);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        DataBase dataBase = new DataBase(getActivity());
        List<Person> personList = dataBase.getForeignPerson();
        personAdapter = new PersonAdapter(getActivity(), personList);
        recyclerView.setAdapter(personAdapter);
    }
}
