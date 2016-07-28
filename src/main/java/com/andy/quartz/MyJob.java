package com.andy.quartz;

import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * @ClassName MyJob
 * @Description 自定义打印时间的bean
 * @author hdq
 * @Date 2016年7月28日 下午2:22:43
 * @version 1.0.0
 */
@Component("myJob")
public class MyJob {

	public void work() {
		System.out.println("date:" + new Date().toString());
	}
}
