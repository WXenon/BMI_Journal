package com.example.bmijournal.ui.history;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.bmijournal.databinding.FragmentBarChartBinding;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class BarChartFragment extends Fragment {

    private BarChartViewModel barChartViewModel;
    private FragmentBarChartBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        barChartViewModel =
                new ViewModelProvider(this).get(BarChartViewModel.class);

        binding = FragmentBarChartBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final BarChart barChart = binding.barChart;
        ArrayList<BarEntry> BMI = new ArrayList<>();
        BMI.add(new BarEntry(2015, 30));
        BMI.add(new BarEntry(2016, 25));
        BMI.add(new BarEntry(2017, 24));
        BMI.add(new BarEntry(2018, 23));
        BMI.add(new BarEntry(2019, 22));
        BMI.add(new BarEntry(2020, 21));
        BMI.add(new BarEntry(2021, 20));

        BarDataSet barDataSet = new BarDataSet(BMI, "BMI");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(18f);

        BarData barData = new BarData(barDataSet);

        barChart.setFitBars(true);
        barChart.setData(barData);
        barChart.getDescription().setText("BMI Bar Chart");
        barChart.animateY(2000);
//        barChartViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}