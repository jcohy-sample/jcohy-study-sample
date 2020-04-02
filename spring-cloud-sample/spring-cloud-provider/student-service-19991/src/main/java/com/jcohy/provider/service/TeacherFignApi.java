package com.jcohy.provider.service;

import com.jcohy.sample.cloud.dto.TeacherDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Copyright: Copyright (c) 2019 http://www.jcohy.com
 *
 * @author jiac
 * @version v1.0.0
 * @Description: TODO 请添加该类的功能描述
 * @date 2019/7/9 16:58
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ----------------------------------------------------------------------------------*
 * 2019/7/9      jiac           v1.0.0               修改原因
 */

@FeignClient(value = "PROVIDER-TEACHER")
public interface TeacherFignApi {

    @RequestMapping(value = "/teacher/add", method = RequestMethod.POST)
    public TeacherDto add(@RequestBody TeacherDto teacherDto);

    @RequestMapping(value = "/teacher/get/{id}", method = RequestMethod.GET)
    public TeacherDto get(@PathVariable("id") Long id);

    @RequestMapping(value = "/teacher/list", method = RequestMethod.GET)
    public List<TeacherDto> list();

    @RequestMapping(value = "/teacher/{name}", method = RequestMethod.GET)
    public TeacherDto getTeacherByName(@PathVariable("name") String name);
}
