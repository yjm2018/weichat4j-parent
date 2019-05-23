package com.weichat.weather.bean;


/**
 * 	天气信息封装
 * @author Administrator
 *
 */
public class WeatherInfo {
	//	城市
	private String area; 
	//	日期
	private String date;
	//	星期
	private String week;
	//	温度
	private String temperature;
	//	天气现象
	private String weather;
	//	穿衣指数
	private String cy;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getCy() {
		return cy;
	}
	public void setCy(String cy) {
		this.cy = cy;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	@Override
	public String toString() {
		return "weatherInfo [area=" + area + ", date=" + date + ", week=" + week + ", temperature=" + temperature
				+ ", weather=" + weather + ", cy=" + cy + "]";
	}
	
}
