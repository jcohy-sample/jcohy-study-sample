package com.jcohy.sample.designpattern.command;

import java.util.Iterator;
import java.util.Stack;

/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jcohy on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
// tag::code[]
/**
 * 结合多个命令的命令的类
 *
 * @author jcohy
 */
public class MacroCommand implements Command {

	private Stack<Command> commands = new Stack<Command>();

	@Override
	public void execute() {
		Iterator<Command> it = commands.iterator();
		while (it.hasNext()) {
			((Command) it.next()).execute();
		}
	}

	public void append(Command cmd) {
		if (cmd != this) {
			commands.push(cmd);
		}
	}

	// 删除最后一个命令
	public void undo() {
		if (!commands.empty()) {
			commands.pop();
		}
	}

	public void clear() {
		commands.clear();
	}

}
// end::code[]