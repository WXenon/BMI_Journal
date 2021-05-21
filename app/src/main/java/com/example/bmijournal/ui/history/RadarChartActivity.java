package com.example.bmijournal.ui.history;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.example.bmijournal.R;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;

public class RadarChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_radar_chart);

        RadarChart radarChart = findViewById(R.id.radarChart);

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
    }
}