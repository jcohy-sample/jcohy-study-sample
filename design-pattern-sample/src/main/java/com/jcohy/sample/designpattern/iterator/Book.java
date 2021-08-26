package com.jcohy.sample.designpattern.iterator;

/**
 * Copyright : 2017- www.jcohy.com Created by jcohy on 23:48 2018/8/7 Email:
 * jia_chao23@126.com Description:
 **/
// tag::code[]
public class Book {

	private String name = "";

	public Book(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + "]";
	}

}
// end::code[]