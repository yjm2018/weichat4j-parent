package com.weichat.utils;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Request.Builder;
import okio.BufferedSink;
import okhttp3.Response;

/**
 * OKHttp3工具类 比OKHttp工具类先进
 * 
 * @author mm
 *
 */
public class OKHttp3Util {

	private static final OKHttp3Util okhttp3Util = new OKHttp3Util();

	private static OkHttpClient client;

	private OKHttp3Util() {
		// 初始化配置
		client = new OkHttpClient.Builder().connectTimeout(5, TimeUnit.SECONDS).writeTimeout(10, TimeUnit.SECONDS)
				.readTimeout(10, TimeUnit.SECONDS).build();

	}

	/**
	 * 获取OKHttp3Util单例实例
	 * 
	 * @return
	 */
	public static final OKHttp3Util getInstance() {
		return okhttp3Util;
	}

	public static void main(String[] args) throws IOException {
		OKHttp3Util okHttp3Util = OKHttp3Util.getInstance();
		Builder builder = new Request.Builder().url(
				"https://search.damai.cn/search.htm?spm=a2oeg.home.category.ditem_6.83f723e13guQwR&ctl=%E6%9B%B2%E8%8B%91%E6%9D%82%E5%9D%9B&order=1&cty=");
		Request request = builder.get().build();
		Response execute = okHttp3Util.client.newCall(request).execute();
		if (execute.isSuccessful()) {
//			Headers headers = execute.headers();
//			Set<String> names = headers.names();
//			for (String string : names) {
//				System.out.println(string + "::" + headers.get(string));
//			}
			System.out.println(execute.body().string());
		}
	}

	/********************************************************************************/

	// 同步get请求
	@Test
	public String getSynReturnStr(String url) throws IOException {
		// 创建 一个请求实例，默认就是get请求
		Request request = new Request.Builder().url(url).get().build();
		// 发送请求，等待返回结果
		Response response = client.newCall(request).execute();
		// 成功响应，处理返回结果
		if (response.isSuccessful()) {
//				System.out.println(response.body().string());
			return response.body().string();
//			Document parse = Jsoup.parse(response.body().string());
//			String title = parse.title();
//			System.out.println(title);
		}
		return null;
	}

	// 异步get请求
	@Test
	public void getAsyn(String url) throws InterruptedException {
		// 创建一个请求实例
		Request request = new Request.Builder().url(url).get().build();
		// 发送请求，等待返回结果
		Call call = client.newCall(request);
		// 成功响应，处理返回结果
		call.enqueue(new Callback() {
			// 成功响应调用
			public void onResponse(Call call, Response response) throws IOException {
				// TODO Auto-generated method stub
				System.out.println("成功响应");
				System.out.println(response.body().string());
			}

			// 失败响应调用
			public void onFailure(Call call, IOException e) {
				// TODO Auto-generated method stub
				System.out.println("失败响应");

			}
		});
		// 主线程睡眠10s，等待OKHTTP3队列获取响应
//		Thread.sleep(10000);
	}

	// 异步get请求，传入回调函数处理请求成败或成功的操作
	@Test
	public void getAsynCallBack(String url, Callback callback) throws InterruptedException {
		// 创建一个请求实例
		Request request = new Request.Builder().url(url).get().build();
		// 发送请求，等待返回结果
		Call call = client.newCall(request);
		// 成功响应，处理返回结果
		call.enqueue(callback);
		// 主线程睡眠10s，等待OKHTTP3队列获取响应
//			Thread.sleep(10000);
	}

	/**********************************************************************/

	// 同步post请求
	@Test
	public String postSynWithStr(String url, String str) throws IOException {
		// 设置请求的mime类型和编码方式
		MediaType mediaType = MediaType.parse("text/html; charset=utf-8");

		// 创建请求对象
		Request request = new Request.Builder().url(url)// 设置请求URL
				.post(RequestBody.create(mediaType, str))// 设置请求体
				.build();// 创建请求对象
		// 发送请求
		Response response = client.newCall(request).execute();
		if (response.isSuccessful()) {
			// 获取HTTP请求协议版本、响应代码、响应行消息
			System.out.println(response.protocol() + " " + response.code() + " " + response.message());
			// 获取响应头信息，循环遍历响应头信息
			Headers headers = response.headers();
			for (int i = 0; i < headers.size(); i++) {
				System.out.println(headers.name(i) + ":" + headers.value(i));
			}
			// 返回响应体
			return response.body().string();
		}
		return null;
	}

	// 同步post请求
	@Test
	public String postSynWithJson(String url, String josn) throws IOException {
		// 设置请求的mime类型和编码方式
		MediaType mediaType = MediaType.parse("application/json; charset=utf-8");

		// 创建请求对象
		Request request = new Request.Builder().url(url)// 设置请求URL
				.post(RequestBody.create(mediaType, josn))// 设置请求体
				.build();// 创建请求对象
		// 发送请求
		Response response = client.newCall(request).execute();
		if (response.isSuccessful()) {
			// 获取HTTP请求协议版本、响应代码、响应行消息
//			System.out.println(response.protocol() + " " + response.code() + " " + response.message());
			// 获取响应头信息，循环遍历响应头信息
			Headers headers = response.headers();
			for (int i = 0; i < headers.size(); i++) {
//				System.out.println(headers.name(i) + ":" + headers.value(i));
			}
			// 返回响应体
			return response.body().string();
		}
		return null;
	}

	// 异步post请求
	@Test
	public void postAsynWithJson(String url, String json, Callback callback) throws IOException, InterruptedException {
		// 设置请求的memo类型和编码方式
		MediaType mediaType = MediaType.parse("application/json; charset=utf-8");

		// 创建请求对象
		Request request = new Request.Builder().url(url)// 设置请求URL
				.post(RequestBody.create(mediaType, json))// 设置请求体
				.build();// 创建请求对象
		// 创建新的请求
		Call call = client.newCall(request);
		// 将请求添加到异步队列中，有相应时会回调 Callback
		call.enqueue(callback);
		
				/*new Callback() {
			// 请求成功时回调这个方法
			public void onResponse(Call call, Response response) throws IOException {
				// TODO Auto-generated method stub
				System.out.println("请求成功");
				// 获取HTTP请求协议版本、响应代码、响应行消息
				System.out.println(response.protocol() + " " + response.code() + " " + response.message());
				// 获取响应头信息，循环遍历响应头信息
				Headers headers = response.headers();
				for (int i = 0; i < headers.size(); i++) {
					System.out.println(headers.name(i) + ":" + headers.value(i));
				}
				System.out.println("**************************");
				// 获取响应体字符串
				System.out.println(response.body().string());
			}

			// 请求失败时回调这个方法
			public void onFailure(Call call, IOException e) {
				// TODO Auto-generated method stub
				System.out.println("请求失败");
				// 获取HTTP请求协议版本、响应代码、响应行消息

			}
		});*/
		// 主线程睡眠等待响应
//		Thread.sleep(5000);
	}

	/********************************************************************/
	// POST同步请求方式提交String参数
	@Test
	public String demoPostSynWithStr(String url, String str) throws IOException {
		// 1.设置请求的memo类型和编码方式
		MediaType mediaType = MediaType.parse("text/plain; charset=utf-8");
		// 2.创建请求体字符串
		// 3.创建请求对象
		Request request = new Request.Builder().url(url)// 设置请求URL
				.post(RequestBody.create(mediaType, str))// 创建并设置请求体
				.build();// 创建请求对象
		// 5.发送请求获取响应
		Response response = client.newCall(request).execute();
		// 6.处理响应
		if (response.isSuccessful()) {
			// 获取HTTP请求协议版本、响应代码、响应行消息
			System.out.println(response.protocol() + " " + response.code() + " " + response.message());
			// 获取响应头信息，循环遍历响应头信息
			Headers headers = response.headers();
			for (int i = 0; i < headers.size(); i++) {
				System.out.println(headers.name(i) + ":" + headers.value(i));
			}
			// 获取响应体字符串
			return response.body().string();
		} else {
			System.out.println("请求失败");
			return null;
		}
	}

	// POST同步请求方式提交json串
	/*@Test
	public void demoPostSynJson() throws IOException {
		// 1.设置请求的memo类型和编码方式
		MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
		// 2.创建请求体的json串
		String json = "{\"name\":\"json\",\"age\":\"18\"}";

		// 3.创建请求对象
		Request request = new Request.Builder().url("https://www.baidu.com")// 设置URL
				.post(RequestBody.create(mediaType, json))// 创建并设置请求体
				.build();// 创建请求对象
		// 4.创建客户端对象
		OkHttpClient okHttpClient = new OkHttpClient();
		// 5.发送请求获取响应
		Response response = okHttpClient.newCall(request).execute();
		// 6.处理响应
		if (response.isSuccessful()) {
			System.out.println("请求成功");
			// 获取HTTP请求协议版本、响应代码、响应行消息
			System.out.println(response.protocol() + " " + response.code() + " " + response.message());
			// 获取响应头参数
			Headers headers = response.headers();
			for (int i = 0; i < headers.size(); i++) {
				System.out.println(headers.name(i) + ":" + headers.value(i));
			}
			// 获取响应体
			System.out.println(response.body().string());
		} else {
			System.out.println("请求失败");
			System.out.println("code:" + response.code());
		}
	}*/

	// POST同步请求方式提交流
	@Test
	public void demoPostSynStream() throws IOException {
		RequestBody requestBody = new RequestBody() {
			@Override
			public MediaType contentType() {
				return MediaType.parse("text/x-markdown; charset=utf-8");
			}

			@Override
			public void writeTo(BufferedSink sink) throws IOException {
				sink.writeUtf8("I am Jdqm.");
			}
		};

		Request request = new Request.Builder().url("https://api.github.com/markdown/raw").post(requestBody).build();
		OkHttpClient okHttpClient = new OkHttpClient();
		Response response = okHttpClient.newCall(request).execute();
		if (response.isSuccessful()) {
			System.out.println(response.protocol() + " " + response.code() + " " + response.message());
			Headers headers = response.headers();
			for (int i = 0; i < headers.size(); i++) {
				System.out.println(headers.name(i) + ":" + headers.value(i));
			}
			System.out.println("**************************************");
			System.out.println(response.body().string());
		}

	}

	// POST同步请求方式提交文件
	@Test
	public void demoPostSynFile() throws IOException {
		// 1.创建MIME类型
		MediaType mediaType = MediaType.parse("application/octet-stream; charset=utf-8");
		// 2.创建请求体数据
		File file = new File("test.md");
		if (!file.exists()) {
			file.createNewFile();
		}
		RequestBody requestBody = RequestBody.create(mediaType, file);
		// 3.创建请求对象
		Request request = new Request.Builder().url("https://api.github.com/markdown/raw").post(requestBody).build();
		// 4.创建客户端
		OkHttpClient okHttpClient = new OkHttpClient();
		// 5.发送请求获取响应
		Response response = okHttpClient.newCall(request).execute();
		// 6.处理响应
		if (response.isSuccessful()) {
			System.out.println("请求成功");
			// 获取HTTP请求协议版本、响应代码、响应行消息
			System.out.println(response.protocol() + " " + response.code() + " " + response.message());
			// 获取响应头参数
			Headers headers = response.headers();
			for (int i = 0; i < headers.size(); i++) {
				System.out.println(headers.name(i) + ":" + headers.value(i));
			}
			// 获取响应体
			System.out.println(response.body().string());
		}
	}

	// POST同步请求方式提交表单
	@Test
	public void demoPostSynForm() throws IOException {
		OkHttpClient okHttpClient = new OkHttpClient();
		RequestBody requestBody = new FormBody.Builder().add("search", "Jurassic Park").build();
		Request request = new Request.Builder().url("https://en.wikipedia.org/w/index.php").post(requestBody).build();

		Response response = okHttpClient.newCall(request).execute();
		if (response.isSuccessful()) {
			System.out.println("请求成功");
			System.out.println(response.protocol() + " " + response.code() + " " + response.message());
			Headers headers = response.headers();
			for (int i = 0; i < headers.size(); i++) {
				System.out.println(headers.name(i) + ":" + headers.value(i));
			}
			System.out.println("**************************************");
			System.out.println(response.body().string());
		}
	}

	// POST同步请求方式提交多种类型数据
	public void demoPostSynMultipartBody() throws IOException {
		// 1.创建MIME类型、创建请求体数据
		File file = new File("test.md");
		if (!file.exists()) {
			file.createNewFile();
		}
		MultipartBody multipartBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
				.addFormDataPart("name", "zhangsan").addFormDataPart("age", "20").addFormDataPart("file",
						file.getName(), RequestBody.create(MediaType.parse("application/octet-stream"), file))
				.build();
		// 2.创建请求对象
		Request request = new Request.Builder().url("").post(multipartBody).build();
		// 4.创建客户端
		OkHttpClient okHttpClient = new OkHttpClient();
		// 5.发送请求获取响应
		Response response = okHttpClient.newCall(request).execute();
		// 6.处理响应
		if (response.isSuccessful()) {
			System.out.println("请求成功");
			// 获取HTTP请求协议版本、响应代码、响应行消息
			System.out.println(response.protocol() + " " + response.code() + " " + response.message());
			// 获取响应头参数
			Headers headers = response.headers();
			for (int i = 0; i < headers.size(); i++) {
				System.out.println(headers.name(i) + ":" + headers.value(i));
			}
			// 获取响应体
			System.out.println(response.body().string());
		} else {
			System.out.println("请求失败");
			System.out.println("code:" + response.code());
		}
	}
}
