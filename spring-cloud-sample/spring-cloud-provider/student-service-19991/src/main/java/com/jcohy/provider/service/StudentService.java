package com.jcohy.provider.service;

import com.jcohy.provider.dto.StudentSocre;
import com.jcohy.provider.model.Student;

import java.util.List;


public interface StudentService {
	public Student add(Student student);

	public Student get(Long id);

	public List<Student> list();

	public StudentSocre getStudentSocre(Long id);

	public String addStudentScore(StudentSocre studentSocre, String exFlag);
}
