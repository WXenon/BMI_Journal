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
import com.example.bmijournal.databinding.FragmentPieChartBinding;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class PieChartFragment extends Fragment {

    private PieChartViewModel pieChartViewModel;
    private FragmentPieChartBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        pieChartViewModel =
                new ViewModelProvider(this).get(PieChartViewModel.class);

        binding = FragmentPieChartBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final PieChart pieChart = binding.pieChart;
        ArrayList<PieEntry> BMI = new ArrayList<>();
        BMI.add(new PieEntry(30, "2015"));
        BMI.add(new PieEntry(25, "2016"));
        BMI.add(new PieEntry(24, "2017"));
        BMI.add(new PieEntry(23, "2018"));
        BMI.add(new PieEntry(22, "2019"));
        BMI.add(new PieEntry(21, "2020"));
        BMI.add(new PieEntry(20, "2021"));

        PieDataSet pieDataSet = new PieDataSet(BMI, "BMI");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueTextSize(18f);

        PieData pieData = new PieData(pieDataSet);

        pieChart.setData(pieData);
        pieChart.getDescription().setEnabled(false);
        pieChart.setCenterText("BMI");
        pieChart.animate();
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