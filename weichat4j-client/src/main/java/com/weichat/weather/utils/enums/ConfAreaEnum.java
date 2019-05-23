package com.weichat.weather.utils.enums;
/**
 * 	地区标识码
 * @author Administrator
 *
 */
public enum ConfAreaEnum {
	
	AREA_FENGRUN("101090503", "河北丰润");
	
	private String url;
    private String msg;

    ConfAreaEnum(String url, String msg) {
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
