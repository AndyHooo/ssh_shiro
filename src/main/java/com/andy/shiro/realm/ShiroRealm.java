package com.andy.shiro.realm;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import com.andy.model.Permission;
import com.andy.model.User;
import com.andy.service.IUserService;

/**
 * @ClassName ShiroRealm
 * @Description 配置shiro realm
 * @author hdq
 * @Date 2016年7月28日 上午10:03:46
 * @version 1.0.0
 */
@Component("shiroRealm")
public class ShiroRealm extends AuthorizingRealm {

	@Resource(name = "userService")
	private IUserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection p) {
		String name = p.asList().get(0).toString();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		try {
			User user = userService.queryUserByName(name);
			for (Permission permission : user.getPermissions()) {
				info.addStringPermission(permission.getPermCode());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {

		SimpleAuthenticationInfo info = null;

		String name = (String) token.getPrincipal();
		String password = new String((char[])token.getCredentials());
		User user = null;
		User user2 = null;
		try {
			user = userService.queryUserByName(name);
			user2 = userService.queryByNameAndPass(name, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (user == null) {
			throw new UnknownAccountException();
		}
		if (user2 == null) {
			throw new IncorrectCredentialsException();
		}
		if (user != null && user2 != null) {
			info = new SimpleAuthenticationInfo(name, password, getName());
		}
		;

		return info;
	}

}
