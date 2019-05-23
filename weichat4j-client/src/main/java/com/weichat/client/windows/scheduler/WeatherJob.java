package com.weichat.client.windows.scheduler;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import com.weichat.weather.controller.WeatherController;


public class WeatherJob {
	
	private static final WeatherController weatherController = new WeatherController();
	public void run() {
		initJob();
	}
	public void initJob() {
		TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
            	try {
					String queryOneDay = weatherController.queryOneDay();
					System.out.println(queryOneDay);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        };
        
	    Timer timer = new Timer();
	    timer.schedule(timerTask,10,10000);
	}
}
