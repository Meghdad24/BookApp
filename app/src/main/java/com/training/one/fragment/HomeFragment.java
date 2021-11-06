package com.training.one.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import com.training.one.R;
import com.training.one.adapter.HomeAdapter;
import com.training.one.fragment.home.ForeignFragment;
import com.training.one.fragment.home.IranFragment;

public class HomeFragment extends Fragment {

    private View view;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private HomeAdapter homeAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_fragment, container, false);

        setupViews();

        return view;
    }

    private void setupViews() {
        tabLayout = view.findViewById(R.id.home_tab_layout_id);
        viewPager = view.findViewById(R.id.home_vp_id);
        homeAdapter = new HomeAdapter(getChildFragmentManager(), 0);
        homeAdapter.addFragment(new IranFragment(), "ایرانی");
        homeAdapter.addFragment(new ForeignFragment(), "خارجی");
        viewPager.setAdapter(homeAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
