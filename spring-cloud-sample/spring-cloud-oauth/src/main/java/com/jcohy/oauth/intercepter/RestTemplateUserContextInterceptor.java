package com.jcohy.oauth.intercepter;

import com.jcohy.oauth.model.User;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * Copyright: Copyright (c) 2019 http://www.jcohy.com
 *
 * @author jcohy
 * @version v1.0.0
 * @Description: TODO 请添加该类的功能描述
 * @date 2019/7/12 10:06
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ----------------------------------------------------------------------------------*
 * 2019/7/12      jcohy           v1.0.0               修改原因
 */


public class RestTemplateUserContextInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        User user = UserContextHolder.currentUser();
        request.getHeaders().add("x-user-id",user.getUserId());
        request.getHeaders().add("x-user-name",user.getUserName());
        request.getHeaders().add("x-user-serviceName",request.getURI().getHost());
        return execution.execute(request, body);
    }
}
