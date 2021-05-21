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
import com.example.bmijournal.databinding.FragmentRadarChartBinding;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class RadarChartFragment extends Fragment {

    private RadarChartViewModel radarChartViewModel;
    private FragmentRadarChartBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        radarChartViewModel =
                new ViewModelProvider(this).get(RadarChartViewModel.class);

        binding = FragmentRadarChartBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final RadarChart radarChart = binding.radarChart;
        ArrayList<RadarEntry> BMI = new ArrayList<>();
        BMI.add(new RadarEntry(30));
        BMI.add(new RadarEntry(25));
        BMI.add(new RadarEntry(24));
        BMI.add(new RadarEntry(23));
        BMI.add(new RadarEntry(22));
        BMI.add(new RadarEntry(21));
        BMI.add(new RadarEntry(20));

        RadarDataSet radarDataSet = new RadarDataSet(BMI, "BMI");
        radarDataSet.setColor(Color.RED);
        radarDataSet.setLineWidth(2f);
        radarDataSet.setValueTextColor(Color.RED);
        radarDataSet.setValueTextSize(16f);

        RadarData radarData = new RadarData();
        radarData.addDataSet(radarDataSet);

        String[] labels = { "2015", "2016", "2017", "2018", "2019", "2020", "2021" };

        XAxis xAxis = radarChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));

        radarChart.setData(radarData);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}