package com.training.one.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.training.one.R;
import com.training.one.adapter.PersonAdapter;
import com.training.one.data_base.DataBase;
import com.training.one.model.Person;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {

    private View view;
    private LinearLayout linearLayout;
    private RecyclerView recyclerView;
    private EditText editText;
    private PersonAdapter personAdapter;
    private List<Person> personList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.search_fragment, container, false);

        setupViews();

        setDate();

        showBackGround();

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().trim().isEmpty()) {
                    showBackGround();
                } else {
                    removeBackGround();
                    filter(editable.toString().trim());
                }
            }
        });

        return view;
    }

    private void filter(String text) {
        List<Person> filterList = new ArrayList<>();
        for (Person person : personList) {
            if (person.getName().equalsIgnoreCase(text)) {
                filterList.add(person);
            }
        }

        personAdapter.filterList(filterList);
    }

    private void setDate() {
        DataBase dataBase = new DataBase(getActivity());
        personList = dataBase.getAllPerson();
        personAdapter = new PersonAdapter(getActivity(), personList);
        recyclerView.setAdapter(personAdapter);
    }

    private void setupViews() {
        linearLayout = view.findViewById(R.id.search_linLay_id);
        recyclerView = view.findViewById(R.id.search_recycler_view);
        editText = view.findViewById(R.id.search_ed_txt_id);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void showBackGround() {
        linearLayout.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.INVISIBLE);
    }

    private void removeBackGround() {
        linearLayout.setVisibility(View.INVISIBLE);
        recyclerView.setVisibility(View.VISIBLE);
    }
}
