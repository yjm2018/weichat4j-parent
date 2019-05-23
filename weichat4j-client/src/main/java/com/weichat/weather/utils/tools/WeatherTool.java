package com.weichat.weather.utils.tools;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import com.weichat.weather.bean.WeatherInfo;
import com.weichat.weather.utils.enums.ConfAreaEnum;
import com.weichat.weather.utils.enums.ConfUrlEnum;
import com.weichat.weather.utils.enums.ConfWeaScopeEnum;



public class WeatherTool {
	/**
	 * 获得天气信息
	 * @param cityid 城市ID
	 * @return 天气信息
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	@Test
	public void test() throws IOException  {
		
		String url = ConfUrlEnum.BASE_URL.getUrl()+ConfWeaScopeEnum.ONE_DAY.getUrl()
						+ConfAreaEnum.AREA_FENGRUN.getUrl()
						+ConfUrlEnum.SUFFIX_URL.getUrl();
		//	获取天气文本
		Document document = Jsoup.connect(url).get();
		//	缩小有用信息范围（根据class属性值筛选元素）
		Elements elementById = document.getElementsByAttributeValue("class", "clearfix");
		//	筛选出天气和穿衣指数两个数据元素
		Elements elements = new Elements(elementById.get(0),elementById.get(2));
//		for(int i = 0; i < elements.size(); i++) {
//			System.err.println("第"+i+"个");
//			System.out.println(elements.get(i).toString());
//		}
		WeatherInfo weatherInfo = new WeatherInfo();
		//	获取天气元素数据
		Element weaElement = elements.get(0);
		List<String> list = new ArrayList<String>();
		Elements select = weaElement.select("p");//根据标签类型筛选元素
		for (Element element2 : select) {
//			System.out.println(element2.text());
			list.add(element2.text());
		}
		//	获取穿衣指数元素数据
		Element cyElement = elements.get(1);
		Element cyElement2 = cyElement.getElementById("chuanyi");//根据id筛选元素
		Elements select2 = cyElement2.select("p");
		list.add(select2.get(0).text());
		System.out.println(list);
		//	封装天气信息
		String [] arr = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM月dd日-hh:mm:ss");
		String format = simpleDateFormat.format(calendar.getTime());
		int week = calendar.get(Calendar.DAY_OF_WEEK)-1;
		
		weatherInfo.setDate(format);
		weatherInfo.setWeek(arr[week]);
		weatherInfo.setWeather(list.get(0)+"~"+list.get(4));
		weatherInfo.setTemperature(list.get(5)+"~"+list.get(1));
		weatherInfo.setCy(list.get(8));
		
		System.out.println(weatherInfo);
//		return weatherInfo;
	}
	
	//	通用拼接url获取页面文本信息
	public static Document appendUrl(ConfWeaScopeEnum scope, ConfAreaEnum area) throws IOException {
		String url = ConfUrlEnum.BASE_URL.getUrl()
				+scope.getUrl()
				+area.getUrl()
				+ConfUrlEnum.SUFFIX_URL.getUrl();
		//	获取天气文本
		Document document = Jsoup.connect(url).get();
		return document;
	}
	
	public static Object queryOneDay(ConfWeaScopeEnum scope, ConfAreaEnum area) throws IOException {
		Document document = appendUrl(scope, area);
		//	缩小有用信息范围（根据class属性值筛选元素）
		Elements elementById = document.getElementsByAttributeValue("class", "clearfix");
		//	筛选出天气和穿衣指数两个数据元素
		Elements elements = new Elements(elementById.get(0),elementById.get(2));		
		//	获取天气元素数据
		Element weaElement = elements.get(0);
		List<String> list = new ArrayList<String>();
		Elements select = weaElement.select("p");//根据标签类型筛选元素
		for (Element element2 : select) {
			list.add(element2.text());
		}
		//	获取穿衣指数元素数据
		Element cyElement = elements.get(1);
		Element cyElement2 = cyElement.getElementById("chuanyi");//根据id筛选元素
		Elements select2 = cyElement2.select("p");
		list.add(select2.get(0).text());
		//	System.out.println(list);
		//	封装天气信息
		String [] arr = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM月dd日-hh:mm:ss");
		String date = simpleDateFormat.format(calendar.getTime());
		int week = calendar.get(Calendar.DAY_OF_WEEK)-1;
		
		WeatherInfo weatherInfo = new WeatherInfo();
		weatherInfo.setArea(area.getMsg());;
		weatherInfo.setDate(date);
		weatherInfo.setWeek(arr[week]);
		weatherInfo.setWeather(list.get(0)+"~"+list.get(4));
		weatherInfo.setTemperature(list.get(5)+"~"+list.get(1));
		weatherInfo.setCy(list.get(8));
		
		//	System.out.println(weatherInfo);
		return weatherInfo;
	}
	
	public static Object querySevenDay(ConfWeaScopeEnum scope, ConfAreaEnum area) throws IOException {
		Document document = appendUrl(scope, area);
		return null;
	}
	
	public static Object queryFifteenDay(ConfWeaScopeEnum scope, ConfAreaEnum area) throws IOException {
		Document document = appendUrl(scope, area);
		return null;
	}
	
	public static Object queryFortyDay(ConfWeaScopeEnum scope, ConfAreaEnum area) throws IOException {
		Document document = appendUrl(scope, area);
		return null;
	}
}
