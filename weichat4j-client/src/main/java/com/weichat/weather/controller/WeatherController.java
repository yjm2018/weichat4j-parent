package com.weichat.weather.controller;

import java.io.IOException;

import org.junit.Test;

import com.weichat.weather.bean.WeatherInfo;
import com.weichat.weather.service.WeatherServiceImpl;
import com.weichat.weather.utils.enums.ConfAreaEnum;
import com.weichat.weather.utils.enums.ConfWeaScopeEnum;



/**
 * 	天气查询接口
 * @author Administrator
 *
 */
public class WeatherController {
	
	private static final WeatherServiceImpl weatherService = new WeatherServiceImpl();
	
	@Test
	public void test() throws IOException {
		WeatherInfo weatherInfo = (WeatherInfo)weatherService.queryOneDay(ConfWeaScopeEnum.ONE_DAY, ConfAreaEnum.AREA_FENGRUN);
		StringBuilder sBuilder = new StringBuilder(100);
		sBuilder.append("城市：").append(weatherInfo.getArea()).append("\r\n")
		.append("日期：").append(weatherInfo.getDate()).append("\r\n")
		.append("星期：").append(weatherInfo.getWeek()).append("\r\n")
		.append("温度：").append(weatherInfo.getTemperature()).append("\r\n")
		.append("天气：").append(weatherInfo.getWeather()).append("\r\n")
		.append("穿衣：").append(weatherInfo.getCy());
		System.out.println(sBuilder.toString());
	}
	
	public String queryOneDay() throws IOException {
		WeatherInfo weatherInfo = (WeatherInfo)weatherService.queryOneDay(ConfWeaScopeEnum.ONE_DAY, ConfAreaEnum.AREA_FENGRUN);
		StringBuilder sBuilder = new StringBuilder(100);
		sBuilder.append("城市：").append(weatherInfo.getArea()).append("\r\n")
		.append("日期：").append(weatherInfo.getDate()).append("\r\n")
		.append("星期：").append(weatherInfo.getWeek()).append("\r\n")
		.append("温度：").append(weatherInfo.getTemperature()).append("\r\n")
		.append("天气：").append(weatherInfo.getWeather()).append("\r\n")
		.append("穿衣：").append(weatherInfo.getCy());
		return sBuilder.toString();
	}
}
