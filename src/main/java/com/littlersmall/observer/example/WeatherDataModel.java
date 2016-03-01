package com.littlersmall.observer.example;

import lombok.Data;

import java.util.List;

/**
 * Created by sigh on 2016/3/1.
 */
@Data
public class WeatherDataModel {
    float temperature;
    float humidity;
    float pressure;

    List<Float> forecastTemperatures;
}
