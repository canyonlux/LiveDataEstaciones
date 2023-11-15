package com.example.livedataestaciones;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.Timer;
import java.util.TimerTask;

public class SeasonModel {
    private MutableLiveData<String> seasonsData;
    private String[] seasons = {"primavera", "verano", "otoño", "invierno"};
    private int currentSeason = 0;

    public SeasonModel() {
        seasonsData = new MutableLiveData<>();
        emitSeasons();
    }

    private void emitSeasons() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                seasonsData.postValue(seasons[currentSeason]);
                currentSeason = (currentSeason + 1) % seasons.length;
            }
        };
        timer.schedule(task, 1000, 1000);
    }
    public void nextSeason() {
        currentSeason = (currentSeason + 1) % seasons.length;
        seasonsData.setValue(seasons[currentSeason]);
    }

    public LiveData<String> getSeasonsData() {
        return seasonsData;
    }
}
