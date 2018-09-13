package com.lianyun.scan.timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Timer {

	protected static Logger logger = LoggerFactory.getLogger(Timer.class);

	public void start(String name) {
		logger.info("任务[" + name + "]开始");
		try {
			run();
		} catch (Exception e) {
			logger.warn("任务[" + name + "]异常", e);
		}
		logger.info("任务[" + name + "]结束");
	}

	public abstract void run();

}
