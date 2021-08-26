package com.jcohy.oauth.util;

import com.jcohy.oauth.model.User;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright: Copyright (c) 2019 https://www.jcohy.com
 *
 * @author jcohy
 * @version v1.0.0
 * @Description: TODO 请添加该类的功能描述
 * @date 2019/7/12 9:59
 * <p>
 * Modification History: Date Author Version Description
 * ----------------------------------------------------------------------------------*
 * 2019/7/12 jcohy v1.0.0 修改原因
 */

public class UserPermissionUtil {

	/**
	 * 模拟权限校验, 可以根据自己项目需要定制不同的策略,如查询数据库获取具体的菜单url或者角色等等.
	 * @param user
	 */
	public static boolean verify(User user, HttpServletRequest request) {
		String url = request.getHeader("x-user-serviceName");
		if (StringUtils.isEmpty(user)) {
			return false;
		}
		else {
			List<String> str = user.getAllowPermissionService();
			for (String permissionService : str) {
				if (url.equalsIgnoreCase(permissionService)) {
					return true;
				}
			}
			return false;
		}
	}

	/**
	 * 模拟权限赋值, 可以根据自己项目需要定制不同的策略,如查询数据库获取具体的菜单url或者角色等等.
	 * @param user
	 */
	public static void permission(User user) {

		if ("admin".equals(user.getUserName())) {
			List<String> allowPermissionService = new ArrayList<>();
			allowPermissionService.add("provider-teacher");
			allowPermissionService.add("provider-student");
			allowPermissionService.add("provider-course");
			user.setAllowPermissionService(allowPermissionService);
		}
		else if ("spring".equals(user.getUserName())) {
			List<String> allowPermissionService = new ArrayList<String>();
			allowPermissionService.add("provider-student");
			allowPermissionService.add("provider-course");
			user.setAllowPermissionService(allowPermissionService);
		}
		else {
			List<String> allowPermissionService = new ArrayList<>();
			user.setAllowPermissionService(allowPermissionService);
		}
	}

}
