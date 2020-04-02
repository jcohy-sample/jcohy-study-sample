package com.jcohy.provider.service.impl;

import java.util.*;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.jcohy.provider.dto.StudentSocre;
import com.jcohy.provider.model.Sc;
import com.jcohy.provider.repository.ScRepository;
import com.jcohy.provider.repository.StudentRepository;
import com.jcohy.provider.model.Student;
import com.jcohy.provider.service.CoureFignApi;
import com.jcohy.provider.service.StudentService;
import com.jcohy.provider.service.TeacherFignApi;
import com.jcohy.sample.cloud.dto.CourseDto;
import com.jcohy.sample.cloud.dto.TeacherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class StudentServiceImpl implements StudentService {


	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private CoureFignApi coureFignApi;

	@Autowired
	private TeacherFignApi teacherFignApi;

	@Autowired
	private ScRepository scRepository;

	@Override
	public Student add(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student get(Long id) {
		return studentRepository.getOne(id);
	}

	@Override
	public List<Student> list() {
		return studentRepository.findAll();
	}

	@Override
	public StudentSocre getStudentSocre(Long id) {

		StudentSocre studentSocre = new StudentSocre();

		List<Sc> scs = scRepository.findScoreById(id);
		Student student = get(id);
		studentSocre.setSname(student.getSname());

		List<Map<String,Object>> mapList = new ArrayList<>();
		for (Sc sc:scs) {
			Map<String,Object> map = new HashMap<>();
			Long cid = sc.getCid();
			Integer score = sc.getScore();
			CourseDto courseDto = coureFignApi.get(cid);
			Long tid = courseDto.getTid();
			TeacherDto teacherDto = teacherFignApi.get(tid);
			map.put("cname",courseDto.getCname());
			map.put("tname",teacherDto.getTname());
			map.put("score",score);
			mapList.add(map);
		}
		studentSocre.setMapList(mapList);
		return studentSocre;
	}

	@Override
	@LcnTransaction
	@Transactional
	public String addStudentScore(StudentSocre studentSocre, String exFlag) {
		String sname = studentSocre.getSname();

		List<Map<String, Object>> mapList = studentSocre.getMapList();
		Student student = studentRepository.save(new Student(sname, "55", "男"));

//		Thread.sleep(1000);
		for(Map<String,Object> map:mapList){
			String cname = (String) map.get("cname");
			String tname = (String) map.get("tname");
			Integer score = (Integer) map.get("score");
//			int s = 4/0;
			TeacherDto teacherDto = new TeacherDto();
			teacherDto.setTname(tname);
			TeacherDto tDto = teacherFignApi.add(teacherDto);


			CourseDto courseDto = new CourseDto();
			courseDto.setCname(cname);


			courseDto.setTid(tDto.getTid());
			CourseDto cDto = coureFignApi.add(courseDto);

			Sc sc = new Sc(student.getSid(),cDto.getCid(),score);
			scRepository.save(sc);

			// 置异常标志，DTX 回滚
			if (Objects.nonNull(exFlag)) {
				throw new IllegalStateException("by exFlag");
			}
		}
		return "Successful";
	}
}
