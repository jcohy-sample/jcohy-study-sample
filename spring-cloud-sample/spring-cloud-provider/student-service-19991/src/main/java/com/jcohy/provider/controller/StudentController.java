package com.jcohy.provider.controller;

import java.util.List;

import com.jcohy.provider.dto.StudentSocre;
import com.jcohy.provider.model.Student;
import com.jcohy.provider.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;


/**
 * @author pc
 */
@RestController
public class StudentController {

	@Autowired
	private StudentService service;

	@Autowired
	private DiscoveryClient client;

	@RequestMapping(value = "/student/add", method = RequestMethod.POST)
	public Student add(@RequestBody Student student)
	{
		return service.add(student);
	}

	@RequestMapping(value = "/student/get/{id}", method = RequestMethod.GET)
	public Student get(@PathVariable("id") Long id)
	{
		return service.get(id);
	}

	@RequestMapping(value = "/student/list", method = RequestMethod.GET)
	public List<Student> list()
	{
		return service.list();
	}

	/**
	 * 添加学生的姓名，课程，教师信息。
	 * @return
	 */
	@RequestMapping(value = "/student/score/add", method = RequestMethod.POST)
	public String addStudentScore(@RequestBody() StudentSocre studentSocre, @RequestParam(value = "ex", required = false) String exFlag) {
		return service.addStudentScore(studentSocre,exFlag);
	}

	/**
	 * 获取单个学生的姓名，课程，教师信息。
	 * @return
	 */
	@RequestMapping(value = "/student/score/{id}", method = RequestMethod.GET)
	public StudentSocre getAllScore(@PathVariable("id") Long id) {
		return service.getStudentSocre(id);
	}


	@RequestMapping(value = "/student/discovery", method = RequestMethod.GET)
	public Object discovery()
	{
		List<String> list = client.getServices();
		System.out.println("**********" + list);

		List<ServiceInstance> srvList = client.getInstances("provider-student");
		for (ServiceInstance element : srvList) {
			System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
					+ element.getUri());
		}
		return this.client;
	}

}
