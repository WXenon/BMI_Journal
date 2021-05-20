package com.example.bmijournal.ui.history;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bmijournal.BarChartActivity;
import com.example.bmijournal.PieChartActivity;
import com.example.bmijournal.R;
import com.example.bmijournal.RadarChartActivity;

public class bmihistory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmihistory);

        findViewById(R.id.buttonBarChart).setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), BarChartActivity.class)));

        findViewById(R.id.buttonPieChart).setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), PieChartActivity.class)));

        findViewById(R.id.buttonRadarChart).setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), RadarChartActivity.class)));
    }
}
