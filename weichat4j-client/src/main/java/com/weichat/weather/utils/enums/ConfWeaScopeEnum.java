package com.weichat.weather.utils.enums;

public enum ConfWeaScopeEnum {
	
	ONE_DAY("weather1d/", "1天的天气"),
	SEVEN_DAY("weather/", "7天的天气"),
	EIGHTH_FIFTEENTH_DAY("weather15d/", "第8天到第15天的天气"),
	FORTY_DAY("weather40d/", "40天的天气");
	
	private String url;
    private String msg;

    ConfWeaScopeEnum(String url, String msg) {
        this.url = url;
        this.msg = msg;
    }

	public String getUrl() {
		return url;
	}

	public String getMsg() {
		return msg;
	}
	
	public static void main(String[] args) {
		System.out.println(ConfWeaScopeEnum.ONE_DAY);
	}
}
