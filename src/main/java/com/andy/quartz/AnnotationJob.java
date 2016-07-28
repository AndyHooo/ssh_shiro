package com.andy.quartz;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AnnotationJob {
	@Scheduled(cron = "0 */1 * * * ?")
	public void newWork(){
		System.out.println("hello,你好！");
	}
}
