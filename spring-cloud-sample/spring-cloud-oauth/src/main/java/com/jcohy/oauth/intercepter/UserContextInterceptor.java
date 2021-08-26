package com.jcohy.oauth.intercepter;

import com.jcohy.oauth.model.User;
import com.jcohy.oauth.util.UserPermissionUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Copyright: Copyright (c) 2019 https://www.jcohy.com
 *
 * @author jcohy
 * @version v1.0.0
 * @Description: TODO 请添加该类的功能描述
 * @date 2019/7/12 9:55
 * <p>
 * Modification History: Date Author Version Description
 * ----------------------------------------------------------------------------------*
 * 2019/7/12 jcohy v1.0.0 修改原因
 */

public class UserContextInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		User user = getUser(request);
		UserPermissionUtil.permission(user);

		if (!UserPermissionUtil.verify(user, request)) {
			response.setHeader("Content-Type", "application/json");
			String jsonstr = JSON.toJSONString("no permisson access service, please check");
			response.getWriter().write(jsonstr);
			response.getWriter().flush();
			response.getWriter().close();
			throw new PermissionException("no permisson access service, please check");
		}
		UserContextHolder.set(user);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse respone, Object arg2, ModelAndView arg3)
			throws Exception {
		// DOING NOTHING
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse respone, Object arg2, Exception arg3)
			throws Exception {
		UserContextHolder.shutdown();
	}

	private User getUser(HttpServletRequest request) {
		String userid = request.getHeader("x-user-id");
		String username = request.getHeader("x-user-name");
		User user = new User();
		user.setUserId(userid);
		user.setUserName(username);
		return user;
	}

	static class PermissionException extends RuntimeException {

		private static final long serialVersionUID = 1L;

		public PermissionException(String msg) {
			super(msg);
		}

	}

}
