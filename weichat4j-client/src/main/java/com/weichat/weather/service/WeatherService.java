package com.weichat.weather.service;

import java.io.IOException;

import com.weichat.weather.utils.enums.ConfAreaEnum;
import com.weichat.weather.utils.enums.ConfWeaScopeEnum;



public interface WeatherService {
	public Object queryOneDay(ConfWeaScopeEnum scope, ConfAreaEnum area) throws IOException;
}
