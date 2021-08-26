package com.jcohy.provider.service;

import com.jcohy.sample.cloud.dto.CourseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Copyright: Copyright (c) 2019 https://www.jcohy.com
 *
 * @author jcohy
 * @version v1.0.0
 * @Description: TODO 请添加该类的功能描述
 * @date 2019/7/9 16:58
 * <p>
 * Modification History: Date Author Version Description
 * ----------------------------------------------------------------------------------*
 * 2019/7/9 jcohy v1.0.0 修改原因
 */

@FeignClient(value = "PROVIDER-COURSE")
public interface CoureFignApi {

	@RequestMapping(value = "/course/get/{id}", method = RequestMethod.GET)
	public CourseDto get(@PathVariable("id") long id);

	@RequestMapping(value = "/course/list", method = RequestMethod.GET)
	public List<CourseDto> list();

	@RequestMapping(value = "/course/add", method = RequestMethod.POST)
	public CourseDto add(@RequestBody CourseDto courseDto);

	@RequestMapping(value = "/course/{name}", method = RequestMethod.GET)
	public CourseDto getCourse(@PathVariable("name") String name);

}
