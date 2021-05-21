package com.example.bmijournal.ui.history;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.bmijournal.R;
import com.example.bmijournal.databinding.FragmentHistoryBinding;

public class HistoryFragment extends Fragment {

    private HistoryViewModel historyViewModel;
    private FragmentHistoryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        historyViewModel =
                new ViewModelProvider(this).get(HistoryViewModel.class);

        binding = FragmentHistoryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHistory;
        historyViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        final Button barChartBtn = binding.buttonBarChart;
        barChartBtn.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                BarChartFragment barChartFragment = new BarChartFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment_content_main, barChartFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        final Button radarChartBtn = binding.buttonRadarChart;
        radarChartBtn.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                RadarChartFragment radarChartFragment = new RadarChartFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment_content_main, radarChartFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        final Button pieChartBtn = binding.buttonPieChart;
        pieChartBtn.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                PieChartFragment pieChartFragment = new PieChartFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment_content_main, pieChartFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}