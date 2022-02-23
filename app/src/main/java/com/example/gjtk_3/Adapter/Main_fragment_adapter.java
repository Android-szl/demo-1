package com.example.gjtk_3.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class Main_fragment_adapter extends FragmentStateAdapter {
    private ArrayList<Fragment>fragments;
    public Main_fragment_adapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle,ArrayList<Fragment>fragments) {
        super(fragmentManager, lifecycle);
        this.fragments=fragments;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }
}
