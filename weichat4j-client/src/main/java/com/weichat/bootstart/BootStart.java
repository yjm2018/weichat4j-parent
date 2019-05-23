package com.weichat.bootstart;

import java.util.List;

import com.weichat.client.windows.WindowsMyChat;
import com.weichat.client.windows.service.WeiChatServiceImpl;
import com.weichat4j.Wechat;
import com.weichat4j.face.IMsgHandlerFace;





public class BootStart {
	public static void main(String[] args) {
		//	1.启动微信
		IMsgHandlerFace msgHandler = new WindowsMyChat();
		String qrPath = "D://itchat4j/login";
		// Wechat wechat = new Wechat(msgHandler,
		// "/home/itchat4j/demo/itchat4j/login");
		Wechat wechat = new Wechat(msgHandler, qrPath);
		wechat.start();
		//	2.启动定时任务
//		WeatherJob weatherJob = new WeatherJob();
//		weatherJob.run();
		
		WeiChatServiceImpl weiChatService = new WeiChatServiceImpl();
		List<String> contactNickNameList = weiChatService.getContactNickNameList();
		System.out.println("--------------------------获取好友昵称列表------------------------");
		for (String string : contactNickNameList) {
			System.out.println(string);
		}
		System.out.println("--------------------------获取群id列表------------------------");
		List<String> groupIdList = weiChatService.getGroupIdList();
		for (String string : groupIdList) {
			System.out.println(string);
		}
		System.out.println("--------------------------获取群昵称列表------------------------");
		List<String> groupNickNameList = weiChatService.getGroupNickNameList();
		for (String string : groupNickNameList) {
			System.out.println(string);
		}
		
		System.out.println("--------------------------向好友发送消息------------------------");
//		String msString = "放假了";
//		for(int i = 0; i < 100; i++) {
//			weiChatService.sendMsgByNickName(msString,"草莓");
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		System.out.println(msString);
	}
}
