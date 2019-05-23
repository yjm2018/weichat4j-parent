package com.weichat.client.windows.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.weichat4j.beans.BaseMsg;


public interface WeiChatService {
	//	1.获取好友昵称列表
	public List<String> getContactNickNameList();
	//	2.获取好友完整信息列表
	public List<JSONObject> getContactList();
	//	3.获取群列表
	public List<String> getGroupIdList();
	//	4.根据群ID获取群成员
	public JSONArray getMemberListByGroupId(String groupId);
	//	5.退出微信
	public void logout();
	//	6.获取微信在线状态
	public boolean getWechatStatus();
	//	7.获取群昵称列表
	public List<String> getGroupNickNameList();
	//	8.根据用户昵称修改用户备注
	public void remarkNameByNickName(String nickName, String remName);
	//	9.根据好友昵称发送文本消息
	public boolean sendMsgByNickName(String text, String nickName);
	/*
	 * 10.根据ID发送文本消息
	 */
	public void sendMsgById(String text, String id);
	/*
	 * 11.根据好友昵称发送图片消息
	 */
	public boolean sendPicMsgByNickName(String nickName, String filePath);
	/*
	 * 12.根据ID发送图片消息
	 */
	public boolean sendPicMsgByUserId(String userId, String filePath);
	/*
	 * 13.根据好友昵称发送文件消息
	 */
	public boolean sendPicFileByNickName(String nickName, String filePath);
	/*
	 * 14.根据ID发送文件消息
	 */
	public boolean sendFileMsgByUserId(String userId, String filePath);
	/*
	 * 15.处理好友添加请求
	 */
	public void addFriend(BaseMsg msg, boolean accept);
}
