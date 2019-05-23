package com.weichat.robot.qingyunke;

import java.io.IOException;

import com.weichat.utils.OKHttp3Util;

/**
 * 青云客机器人接口
 * 
 * @author mm
 *
 */
public class QingYunKeRobot {
	// 机器人api接口
	private static String url = "http://api.qingyunke.com/api.php?key=free&appid=0&msg=";

	private QingYunKeRobot() {

	}

	// 讲笑话接口
	public static String toRobot() {
		try {
			String synReturnStr = OKHttp3Util.getInstance().getSynReturnStr(url + "笑话");
			return synReturnStr;
		} catch (IOException e) {
			return "";
		}
	}

	public static void main(String[] args) {
		System.out.println(toRobot());
	}
}
