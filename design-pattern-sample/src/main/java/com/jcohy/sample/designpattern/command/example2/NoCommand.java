package com.jcohy.sample.designpattern.command.example2;

/**
 * Created by jcohy on 2019/3/20. ClassName : com.jcohy.study.command.example2 Description
 * :
 */
public class NoCommand implements Command {

	@Override
	public void excute() {
		System.out.println("No command");
	}

	@Override
	public void undo() {

	}

}
