package com.weichat.weather.utils.enums;

public enum ConfUrlEnum {
	
	BASE_URL("http://www.weather.com.cn/","基本的URL"),
	SUFFIX_URL(".shtml", "后缀");
	
	private String url;
    private String msg;

    ConfUrlEnum(String url, String msg) {
        this.url = url;
        this.msg = msg;
    }
    
    public String getUrl() {
		return url;
	}

	public String getMsg() {
		return msg;
	}
}
