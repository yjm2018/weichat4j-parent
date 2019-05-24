package com.weichat.bootstart.utils;

public enum WeiChatEnum {
	WEICHAT_LOGIN_PATH("D:/itchat4j/login", "微信登录时登录二维码存储路径"),
	WEICHAT_MESSAGE_PIC("D:/itchat4j/pic", "微信图片消息临时保存路径"),
	WEICHAT_MESSAGE_VIDEO("D:/itchat4j/video", "微信视频消息临时保存路径"),
	WEICHAT_MESSAGE_VOICE("D:/itchat4j/voice", "微信声音消息临时保存路径");
	
	private String key;
	private String description;
	
	private WeiChatEnum(String key, String description) {
		this.key = key;
		this.description = description;
	}
	public String getKey() {
		return key;
	}
	public String getDescription() {
		return description;
	}
	
}
