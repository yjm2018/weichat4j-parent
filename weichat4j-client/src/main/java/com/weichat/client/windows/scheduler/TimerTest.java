package com.weichat.client.windows.scheduler;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
	public static void main(String[] args) {
		//	1. 创建我们的任务类，实现run()方法，里面就是我们想要执行的操作
	    TimerTask timerTask = new TimerTask() {
	        @Override
	        public void run() {
	            System.out.println("task  run:"+ new Date());
	        }
	    };
	    
	    //	2. 创建调度任务对象
	    Timer timer = new Timer();
	    //	3. 添加任务设置执行策略并开始执行任务
	    timer.schedule(timerTask,10,3000);
	    
	}
}
