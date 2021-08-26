package com.jcohy.provider.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.codingapi.txlcn.tc.annotation.TxcTransaction;
import com.jcohy.provider.repository.TeacherRepository;
import com.jcohy.provider.model.Teacher;
import com.jcohy.provider.service.TeacherService;
import com.codingapi.txlcn.tc.annotation.TccTransaction;
import com.jcohy.sample.cloud.dto.TeacherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;

	@Override
	@LcnTransaction(propagation = DTXPropagation.SUPPORTS)
	@Transactional
	public TeacherDto add(Teacher teacher) {
		return Teacher.ofDto(teacherRepository.save(teacher));
	}

	@Override
	public TeacherDto get(Long id) {
		Teacher one = teacherRepository.getOne(id);
		return Teacher.ofDto(one);
	}

	@Override
	public List<TeacherDto> list() {
		List<Teacher> teachers = teacherRepository.findAll();
		return teachers.stream().map(Teacher::ofDto).collect(Collectors.toList());
	}

	@Override
	public TeacherDto getByName(String name) {
		return Teacher.ofDto(teacherRepository.getByTname(name));
	}

}
