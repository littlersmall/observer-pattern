package com.littlersmall.observer.example;

import com.littlersmall.observer.annotation.Observer;
import org.springframework.stereotype.Service;

/**
 * Created by sigh on 2016/3/1.
 */
@Service
public class ForecastDisplay {
    @Observer("weatherChanged")
    public void futureConditions(WeatherDataModel weatherDataModel) {
        for (int i = 0; i < weatherDataModel.getForecastTemperatures().size(); i++) {
            System.out.println("day: " + i + " " + weatherDataModel.getForecastTemperatures().get(i) + "℃");
        }
    }
}
