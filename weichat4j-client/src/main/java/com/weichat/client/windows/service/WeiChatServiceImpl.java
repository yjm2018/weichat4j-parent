package com.weichat.client.windows.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.weichat4j.api.MessageTools;
import com.weichat4j.api.WechatTools;
import com.weichat4j.beans.BaseMsg;



public class WeiChatServiceImpl implements WeiChatService {
	/*
	 * 1.获取好友昵称列表
	 * 此方法会返回好友昵称列表
	 */
	public List<String> getContactNickNameList() {
		List<String> contactNickNameList = WechatTools.getContactNickNameList();
		return contactNickNameList;
	}
	/*
	 * 2.获取好友完整信息列表
	 * 此方法会返回好友的完整信息，如昵称、备注、地区、头像链接等
	 */
	public List<JSONObject> getContactList() {
		List<JSONObject> contactList = WechatTools.getContactList();
		return contactList;
	}
	/*
	 * 3.获取群列表
	 * 群列表与好友列表不同，在登陆后群列表其实是空的，只有主动发送消息或者收到一条群消息时，
	 * 才能获取到这个群的信息，群列表会记录这个群的id，
	 * 其格式为@@d052d34b9c9228830363013ee53deb461404f80ea353dbdd8fc9391cbf5f1c46。
	 * 调用此方法会返回已知的群列表。
	 * (non-Javadoc)
	 * @see weichatclient.service.WeiChatService#getGroupIdList()
	 */
	public List<String> getGroupIdList() {
		List<String> groupIdList = WechatTools.getGroupIdList();
		return groupIdList;
	}
	/*
	 * 4.根据群ID获取群成员
	 * 此方法根据群ID（格式为@@d052d34b9c9228830363013ee53deb461404f80ea353dbdd8fc9391cbf5f1c46）获取群成员列表
	 * (non-Javadoc)
	 * @see weichatclient.service.WeiChatService#getMemberListByGroupId(java.lang.String)
	 */
	public JSONArray getMemberListByGroupId(String groupId) {
		JSONArray memberListByGroupId = WechatTools.getMemberListByGroupId(groupId);
		return memberListByGroupId;
	}
	/*
	 * 5.退出微信
	 * 退出weichat，不再处理消息
	 * (non-Javadoc)
	 * @see weichatclient.service.WeiChatService#logout()
	 */
	public void logout() {
		WechatTools.logout();
	}
	/*
	 * 6.获取微信在线状态
	 * 查询微信在线状态，在线返回true，离线返回false	
	 * (non-Javadoc)
	 * @see weichatclient.service.WeiChatService#getWechatStatus()
	 */
	public boolean getWechatStatus() {
		boolean wechatStatus = WechatTools.getWechatStatus();
		return wechatStatus;
	}
	/*
	 * 7.获取群昵称列表
	 * (non-Javadoc)
	 * @see weichatclient.service.WeiChatService#getGroupNickNameList()
	 */
	public List<String> getGroupNickNameList() {
		List<String> groupNickNameList = WechatTools.getGroupNickNameList();
		return groupNickNameList;
	}
	/*
	 * 8.根据用户昵称修改用户备注(方法有问题)
	 * 根据用户昵称修改用户备注名称
	 * (non-Javadoc)
	 * @see weichatclient.service.WeiChatService#remarkNameByNickName(java.lang.String, java.lang.String)
	 */
	public void remarkNameByNickName(String nickName, String remName) {
//		MessageTools.remarkNameByNickName(nickName, remName);

	}
	/*
	 * 9.根据好友昵称发送文本消息
	 * 此方法根据用户昵称发送文本消息，注意，用户需在你的好友列表里，否则发送失败，
	 * 如果你的好友列表里有存在昵称一样的多个用户，则只会给第一个匹配的好友发送消息。
	 * 方法接受两个参数，text为要发送的文本消息，nickName为要发送消息的好友昵称，
	 * 成功发送时返回true，失败返回false
	 * (non-Javadoc)
	 * @see weichatclient.service.WeiChatService#sendMsgByNickName(java.lang.String, java.lang.String)
	 */
	public boolean sendMsgByNickName(String text, String nickName) {
		boolean sendMsgByNickName = MessageTools.sendMsgByNickName(text, nickName);
		return sendMsgByNickName;
	}
	/*
	 * 10.根据ID发送文本消息
	 * 根据ID发送文本消息，发送者ID可以从msg里通过msg.getString("FromUserName")获取，
	 * 格式为@@d052d34b9c9228830363013ee53deb461404f80ea353dbdd8fc9391cbf5f1c46（群消息）
	 * 或@a257b99314d8313862cd44ab02fe0f81（非群消息），调用此方法可向指定id发送消息
	 * (non-Javadoc)
	 * @see weichatclient.service.WeiChatService#sendMsgById(java.lang.String, java.lang.String)
	 */
	public void sendMsgById(String text, String id) {
		MessageTools.sendMsgById(text, id);
	}
	/*
	 * 11.根据好友昵称发送图片消息
	 * 此方法根据好友昵称发送图片消息，filePath为图片文件路径，如D:/itchat4j/pic/test.jpg，
	 * 成功返回true，失败返回false
	 * (non-Javadoc)
	 * @see weichatclient.service.WeiChatService#sendPicMsgByNickName(java.lang.String, java.lang.String)
	 */
	public boolean sendPicMsgByNickName(String nickName, String filePath) {
		boolean sendPicMsgByNickName = MessageTools.sendPicMsgByNickName(nickName, filePath);
		return sendPicMsgByNickName;
	}
	/*
	 * 12.根据ID发送图片消息
	 * 此方法根据好友ID发送图片消息，filePath为图片文件路径，如D:/itchat4j/pic/test.jpg`，
	 * 成功返回true，失败返回false
	 * (non-Javadoc)
	 * @see weichatclient.service.WeiChatService#sendPicMsgByUserId(java.lang.String, java.lang.String)
	 */
	public boolean sendPicMsgByUserId(String userId, String filePath) {
		boolean sendPicMsgByUserId = MessageTools.sendPicMsgByUserId(userId, filePath);
		return sendPicMsgByUserId;
	}
	/*
	 * 13.根据好友昵称发送文件消息
	 * 此方法根据好友昵称发送文件消息，文件可以为多种类型，如txt、PDF、小视频、语音、excel、docx等，
	 * 发送时请保证文件后缀名正确。成功返回true，失败返回false
	 * (non-Javadoc)
	 * @see weichatclient.service.WeiChatService#sendPicFileByNickName(java.lang.String, java.lang.String)
	 */
	public boolean sendPicFileByNickName(String nickName, String filePath) {
		boolean sendFileMsgByNickName = MessageTools.sendFileMsgByNickName(nickName, filePath);
		return sendFileMsgByNickName;
	}
	/*
	 * 14.根据ID发送文件消息
	 * 此方法根据好友昵称发送文件消息，成功返回true，失败返回false
	 * (non-Javadoc)
	 * @see weichatclient.service.WeiChatService#sendFileMsgByUserId(java.lang.String, java.lang.String)
	 */
	public boolean sendFileMsgByUserId(String userId, String filePath) {
		boolean sendFileMsgByUserId = MessageTools.sendFileMsgByUserId(userId, filePath);
		return sendFileMsgByUserId;
	}
	/*
	 * 15.处理好友添加请求
	 * 当收到好友添加请求时，可调用此函数进行处理，msg为收到的好友添加请求消息，
	 * accept传true为接受好友请求，false为拒绝
	 * (non-Javadoc)
	 * @see weichatclient.service.WeiChatService#addFriend(cn.zhouyafeng.itchat4j.beans.BaseMsg, boolean)
	 */
	public void addFriend(BaseMsg msg, boolean accept) {
		MessageTools.addFriend(msg, accept);

	}

}
