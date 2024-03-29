package com.jcohy.sample.designpattern.command.example2;

/**
 * Created by jcohy on 2019/3/20. ClassName : com.jcohy.study.command.example2 Description
 * :
 */
public class LightOnCommand implements Command {

	Light light;

	public LightOnCommand(Light light) {
		this.light = light;
	}

	@Override
	public void excute() {
		light.on();
	}

	@Override
	public void undo() {
		light.off();
	}

}
