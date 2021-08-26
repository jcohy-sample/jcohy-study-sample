package com.jcohy.provider.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jcohy.sample.cloud.dto.StudentDto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "student")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Student implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sid;

	@Column(name = "sname")
	private String sname;

	@Column(name = "sage")
	private String sage;

	@Column(name = "ssex")
	private String ssex;

	public Student() {
	}

	public Student(String sname, String sage, String ssex) {
		this.sname = sname;
		this.sage = sage;
		this.ssex = ssex;
	}

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSage() {
		return sage;
	}

	public void setSage(String sage) {
		this.sage = sage;
	}

	public String getSsex() {
		return ssex;
	}

	public void setSsex(String ssex) {
		this.ssex = ssex;
	}

	public static StudentDto ofDto(Student student) {
		StudentDto studentDto = new StudentDto(student.getSid(), student.getSname(), student.getSage(),
				student.getSsex());
		return studentDto;
	}

}
