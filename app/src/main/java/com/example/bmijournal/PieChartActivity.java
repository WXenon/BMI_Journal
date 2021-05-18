package com.example.bmijournal;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class PieChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);

        PieChart pieChart = findViewById(R.id.pieChart);

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
    }
}