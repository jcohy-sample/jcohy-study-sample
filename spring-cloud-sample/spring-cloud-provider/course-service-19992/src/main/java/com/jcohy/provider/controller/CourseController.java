package com.jcohy.provider.controller;

import java.util.List;

import com.jcohy.provider.model.Course;
import com.jcohy.provider.service.CourseService;
import com.jcohy.sample.cloud.dto.CourseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

	@Autowired
	private CourseService service;

	@Autowired
	private DiscoveryClient client;

	@RequestMapping(value = "/course/add", method = RequestMethod.POST)
	public CourseDto add(@RequestBody CourseDto courseDto) {
		return service.add(new Course(courseDto.getCname(), courseDto.getTid()));
	}

	@RequestMapping(value = "/course/get/{id}", method = RequestMethod.GET)
	public CourseDto get(@PathVariable("id") Long id) {
		return service.get(id);
	}

	@RequestMapping(value = "/course/list", method = RequestMethod.GET)
	public List<CourseDto> list() {
		return service.list();
	}

	@RequestMapping(value = "/course/{name}", method = RequestMethod.GET)
	public CourseDto getCourse(@PathVariable("name") String name) {
		return service.getByByName(name);
	}

	@RequestMapping(value = "/course/discovery", method = RequestMethod.GET)
	public Object discovery() {
		List<String> list = client.getServices();
		System.out.println("**********" + list);

		List<ServiceInstance> srvList = client.getInstances("provider-course");
		for (ServiceInstance element : srvList) {
			System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
					+ element.getUri());
		}
		return this.client;
	}

}
