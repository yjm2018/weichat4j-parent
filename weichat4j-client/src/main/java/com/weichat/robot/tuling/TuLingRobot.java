package com.weichat.robot.tuling;
/**
 * 	图灵机器人接口
 * @author mm
 *
 */

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import com.weichat.utils.OKHttp3Util;

public class TuLingRobot {
	// 用于记录机器人接口调用次数的
	private static Map<String, AtomicInteger> map = new HashMap<>();
	// 每天机器人接口的调用阈值
	private static int threshold = 1000;
	// 格式化当天日期，作为key
	private static SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	// 机器人api接口
	private static String url = "http://openapi.tuling123.com/openapi/api/v2";

	private static String json = "{\"reqType\":0,\"perception\":{\"inputText\":{\"text\":\"笑话\"}},\"userInfo\":{\"apiKey\":\"8b1cffd8f7b74f89adf724423f667b7a\",\"userId\":\"1438189\"}}";

	private TuLingRobot() {
		
	}

	// 当日调用次数加一接口
	public static int add() {
		Date date = new Date();
		String format2 = format.format(date);
		AtomicInteger atomicInteger = (AtomicInteger) map.get(format2);
		if (atomicInteger != null) {
			int incrementAndGet = atomicInteger.incrementAndGet();
			return incrementAndGet;
		} else {
			AtomicInteger atomicInteger2 = new AtomicInteger();
			int incrementAndGet = atomicInteger2.incrementAndGet();
			map.put(format2, atomicInteger2);
			return incrementAndGet;
		}
	}

	// 讲笑话接口
	public static String toRobot() {
		try {
			int add = add();
			System.out.println(add);
			if (add >= threshold)
				return "";
			String result = OKHttp3Util.getInstance().postSynWithJson(url, json);
			return result;
		} catch (IOException e) {
			return "10000";
		}

	}

	public static void main(String[] args) {
		System.out.println(toRobot());
	}
}
