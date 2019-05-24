package com.weichat4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.weichat4j.controller.LoginController;
import com.weichat4j.core.MsgCenter;
import com.weichat4j.face.IMsgHandlerFace;
/**
 * 	微信登录的入口类
 * 		通过IMsgHandlerFace（消息处理类）和String（登录二维码保存路径）构建Wechat
 * @author Administrator
 *
 */
public class Wechat {
	private static final Logger LOG = LoggerFactory.getLogger(Wechat.class);
	private IMsgHandlerFace msgHandler;

	public Wechat(IMsgHandlerFace msgHandler, String qrPath) {
		System.setProperty("jsse.enableSNIExtension", "false"); // 防止SSL错误
		this.msgHandler = msgHandler;

		// 	通过登陆控制器登录微信
		LoginController login = new LoginController();
		login.login(qrPath);
	}

	//	微信登录成功后，开启消息处理线程
	public void start() {
		LOG.info("+++++++++++++++++++开始消息处理+++++++++++++++++++++");
		new Thread(new Runnable() {
			@Override
			public void run() {
				MsgCenter.handleMsg(msgHandler);
			}
		}).start();
	}

}
