package com.jcohy.provider.service;

import com.jcohy.provider.model.Teacher;
import com.jcohy.sample.cloud.dto.TeacherDto;


import java.util.List;


public interface TeacherService {
	public TeacherDto add(Teacher teacher);

	public TeacherDto get(Long id);

	public List<TeacherDto> list();

	public TeacherDto getByName(String name);
}
