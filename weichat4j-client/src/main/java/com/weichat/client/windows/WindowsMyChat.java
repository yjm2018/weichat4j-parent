package com.weichat.client.windows;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.weichat4j.Wechat;
import com.weichat4j.api.MessageTools;
import com.weichat4j.beans.BaseMsg;
import com.weichat4j.face.IMsgHandlerFace;
import com.weichat4j.utils.enums.MsgTypeEnum;
import com.weichat4j.utils.tools.DownloadTools;





public class WindowsMyChat implements IMsgHandlerFace {
	
	public String textMsgHandle(BaseMsg msg) {
		String text = msg.getText();
		String result = "收到文本信息： " + text;
		return result;
	}

	public String picMsgHandle(BaseMsg msg) {
		String fileName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()) + ".jpg"; // 这里使用收到图片的时间作为文件名
		String picPath = "D://itchat4j/pic" + File.separator + fileName; // 保存图片的路径
		DownloadTools.getDownloadFn(msg, MsgTypeEnum.PIC.getType(), picPath); // 调用此方法来保存图片
		return "图片保存成功";
	}

	public String voiceMsgHandle(BaseMsg msg) {
		String fileName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()) + ".mp3"; // 这里使用收到语音的时间作为文件名
		String voicePath = "D://itchat4j/voice" + File.separator + fileName; // 保存语音的路径
		DownloadTools.getDownloadFn(msg, MsgTypeEnum.VOICE.getType(), voicePath); // 调用此方法来保存语音
		return "声音保存成功";
	}

	public String viedoMsgHandle(BaseMsg msg) {
		String fileName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()) + ".mp4"; // 这里使用收到小视频的时间作为文件名
		String viedoPath = "D://itchat4j/viedo" + File.separator + fileName;// 保存小视频的路径
		DownloadTools.getDownloadFn(msg, MsgTypeEnum.VIEDO.getType(), viedoPath);// 调用此方法来保存小视频
		return "视频保存成功";
	}

	public static void main(String[] args) throws InterruptedException {
		IMsgHandlerFace msgHandler = new WindowsMyChat();
		String qrPath = "D://itchat4j/login";
		// Wechat wechat = new Wechat(msgHandler,
		// "/home/itchat4j/demo/itchat4j/login");
		Wechat wechat = new Wechat(msgHandler, qrPath);
		wechat.start();
		Thread.sleep(10000);
//		System.out.println("-------------获取好友列表----------");
//		List<String> contactNickNameList = WechatTools.getContactNickNameList();
//		for (String string : contactNickNameList) {
//			System.out.println(string);
//		}
		for(int i = 0; i < 10; i++) {
			
			MessageTools.sendMsgByNickName("你猜我是谁","草莓");
			Thread.sleep(1000);
			System.out.println("-------");
		}
	}

	public String nameCardMsgHandle(BaseMsg arg0) {
		return "收到名片消息";
	}

	public void sysMsgHandle(BaseMsg msg) {
		// TODO Auto-generated method stub
		
	}

	public String verifyAddFriendMsgHandle(BaseMsg msg) {
		// TODO Auto-generated method stub
		return "收到验证消息";
	}

	public String mediaMsgHandle(BaseMsg msg) {
		// TODO Auto-generated method stub
		return "收到多媒体消息";
	}
}
