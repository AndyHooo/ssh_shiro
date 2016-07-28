package com.andy.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

/**
 * @ClassName UserAction
 * @Description 用户相关操作
 * @author hdq
 * @Date 2016年7月28日 上午9:49:29
 * @version 1.0.0
 */
@Namespace("/")
public class UserAction {
	private static final Log LOG = LogFactory.getLog(UserAction.class);
	
	private String name; //用户名
	private String password; //密码
	/**
	 * @MethodName reg  
	 * @Description 用户登录
	 * @return
	 */
	@Action(value = "login", results = {
			@Result(name = "success", location = "/main.jsp"),
			@Result(name = "fail", location = "/login.jsp") })
	public String login() {
		Subject subject = SecurityUtils.getSubject();
		subject.login(new UsernamePasswordToken(name, password));
		if(subject.isAuthenticated()){
			LOG.debug("身份验证通过");
			return "success";
		}
		LOG.debug("身份验证不通过");
		return "fail";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
