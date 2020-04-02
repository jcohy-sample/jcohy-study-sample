package com.jcohy.provider.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jcohy.sample.cloud.dto.TeacherDto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "teacher")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Teacher implements Serializable{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tid;

	@Column(name = "tname")
	private String 	tname;

	public Teacher(String tname) {
		this.tname = tname;
	}

	public Teacher() {
	}

	public Long getTid() {
		return tid;
	}

	public void setTid(Long tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public static TeacherDto ofDto(Teacher teacher){
        TeacherDto teacherDto = new TeacherDto(teacher.getTid(),teacher.getTname());
        return teacherDto;
	}

}
