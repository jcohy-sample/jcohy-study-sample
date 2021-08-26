package com.jcohy.sample.java.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Copyright : 2017- www.jcohy.com Created by jcohy on 22:38 2019/4/17 Email:
 * jia_chao23@126.com ClassName: Demo1 Description:
 **/
public class Demo1 {

	public static void main(String[] args) {
		List<Integer> lists = new ArrayList<>();
		Set<Integer> sets = new HashSet<>();

		for (int i = 0; i < 6; i++) {
			lists.add(i);
			sets.add(i);
		}

		System.out.println("lists:" + lists);
		System.out.println("sets" + sets);

		for (int i = 0; i < 3; i++) {
			lists.remove(i);
			sets.remove(i);
		}
		System.out.println("lists:" + lists);
		System.out.println("sets" + sets);

	}

}
