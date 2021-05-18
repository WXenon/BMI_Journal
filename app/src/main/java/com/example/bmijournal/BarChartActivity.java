package com.example.bmijournal;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class BarChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);

        BarChart barChart = findViewById(R.id.barChart);

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
    }
}