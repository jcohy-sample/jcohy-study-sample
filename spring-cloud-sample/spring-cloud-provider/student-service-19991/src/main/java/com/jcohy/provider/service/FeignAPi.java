package com.jcohy.provider.service;

import com.jcohy.provider.config.FeignServiceConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Copyright: Copyright (c) 2019 http://www.jcohy.com
 *
 * @author jiac
 * @version v1.0.0
 * @Description: TODO 请添加该类的功能描述
 * @date 2019/7/9 13:58
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ----------------------------------------------------------------------------------*
 * 2019/7/9      jiac           v1.0.0               修改原因
 */

@FeignClient(name = "github-client", url = "https://api.github.com", configuration = FeignServiceConfig.class)
public interface FeignAPi {

    @RequestMapping(value = "/search/repositories", method = RequestMethod.GET)
    String searchRepo(@RequestParam("q") String queryStr);
}
