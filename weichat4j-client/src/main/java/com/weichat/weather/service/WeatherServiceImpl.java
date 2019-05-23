package com.weichat.weather.service;

import java.io.IOException;

import com.weichat.weather.utils.enums.ConfAreaEnum;
import com.weichat.weather.utils.enums.ConfWeaScopeEnum;
import com.weichat.weather.utils.tools.WeatherTool;


/**
 * 	天气查询业务处理
 * @author Administrator
 *
 */
public class WeatherServiceImpl implements WeatherService {

	public Object queryOneDay(ConfWeaScopeEnum scope, ConfAreaEnum area) throws IOException {
		final Object object;
		switch (scope) {
			case ONE_DAY:
				object = WeatherTool.queryOneDay(scope, area);
				break;
			
			case SEVEN_DAY:
				object = WeatherTool.querySevenDay(scope, area);
				break;
				
			case EIGHTH_FIFTEENTH_DAY:
				object = WeatherTool.queryFifteenDay(scope, area);
				break;
				
			case FORTY_DAY:
				object = WeatherTool.queryFortyDay(scope, area);
				break;
	
			default:
				//	默认查询丰润1天的天气
				object = WeatherTool.queryFortyDay(scope, area);
				break;
		}
		return object;
	}
}
