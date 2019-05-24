package com.weichat4j.face;

import com.weichat4j.beans.BaseMsg;

/**
 * 消息处理接口
 * 
 * @author https://github.com/yaphone
 * @date 创建时间：2017年4月20日 上午12:13:49
 * @version 1.0
 *
 */
public interface IMsgHandlerFace {
	/**
	 * 处理文本消息
	 * @param msg
	 * @return
	 */
	public String textMsgHandle(BaseMsg msg);

	/**
	 * 处理图片消息
	 * @param msg
	 * @return
	 */
	public String picMsgHandle(BaseMsg msg);

	/**
	 * 处理声音消息
	 * @param msg
	 * @return
	 */
	public String voiceMsgHandle(BaseMsg msg);

	/**
	 * 处理小视频消息
	 * @param msg
	 * @return
	 */
	public String viedoMsgHandle(BaseMsg msg);

	/**
	 * 处理名片消息
	 * @param msg
	 * @return
	 */
	public String nameCardMsgHandle(BaseMsg msg);

	/**
	 * 处理系统消息
	 * @param msg
	 */
	public void sysMsgHandle(BaseMsg msg);

	/**
	 * 处理确认添加好友消息
	 * @param msg
	 * @return
	 */
	public String verifyAddFriendMsgHandle(BaseMsg msg);

	/**
	 * 处理收到的文件消息
	 * @param msg
	 * @return
	 */
	public String mediaMsgHandle(BaseMsg msg);

}
