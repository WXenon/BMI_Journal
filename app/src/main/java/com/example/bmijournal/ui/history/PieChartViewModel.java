package com.example.bmijournal.ui.history;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PieChartViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PieChartViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is bar chart fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}