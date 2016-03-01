package com.littlersmall.observer.example;

import com.littlersmall.observer.annotation.Subject;
import org.springframework.stereotype.Service;

/**
 * Created by sigh on 2016/3/1.
 */
@Service
public class Weather {
    @Subject("weatherChanged")
    public WeatherDataModel measurementChanged(WeatherDataModel weatherDataModel) {
        System.out.println("weather changed: ");

        return weatherDataModel;
    }
}
