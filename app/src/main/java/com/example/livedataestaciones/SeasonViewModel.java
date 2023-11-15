package com.example.livedataestaciones;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class SeasonViewModel extends ViewModel {
    private LiveData<Integer> seasonImageLiveData;
    private SeasonModel model;
    public SeasonViewModel() {
        SeasonModel model = new SeasonModel();
        seasonImageLiveData = Transformations.map(model.getSeasonsData(), season -> {
            switch (season) {
                case "primavera":
                    return R.drawable.primavera;
                case "verano":
                    return R.drawable.verano;
                case "otoño":
                    return R.drawable.otono;
                case "invierno":
                    return R.drawable.invierno;
                default:
                    return R.drawable.ic_launcher_background; // un drawable por defecto
            }
        });
    }
    public void nextSeason() {
        model.nextSeason();
    }

    public LiveData<Integer> getSeasonImageLiveData() {
        return seasonImageLiveData;
    }
}
