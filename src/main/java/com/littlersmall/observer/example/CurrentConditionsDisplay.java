package com.littlersmall.observer.example;

import com.littlersmall.observer.annotation.Observer;
import org.springframework.stereotype.Service;

/**
 * Created by sigh on 2016/3/1.
 */
@Service
public class CurrentConditionsDisplay {
    @Observer("weatherChanged")
    public void currentConditions(WeatherDataModel weatherDataModel) {
        System.out.println("温度: " + weatherDataModel.getTemperature());
        System.out.println("湿度: " + weatherDataModel.getHumidity());
        System.out.println("气压: " + weatherDataModel.getPressure());
    }
}
