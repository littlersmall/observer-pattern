package com.littlersmall.observer.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

/**
 * Created by sigh on 2016/3/1.
 */
public class ObserverTest {
    public static void main(String[] args) {
        WeatherDataModel weatherDataModel = new WeatherDataModel();

        weatherDataModel.setTemperature(22f);
        weatherDataModel.setHumidity(0.8f);
        weatherDataModel.setPressure(1.2f);

        weatherDataModel.setForecastTemperatures(new ArrayList<Float>());
        weatherDataModel.getForecastTemperatures().add(22f);
        weatherDataModel.getForecastTemperatures().add(23f);
        weatherDataModel.getForecastTemperatures().add(27f);

        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Weather weather = ac.getBean(Weather.class);

        weather.measurementChanged(weatherDataModel);
    }
}
