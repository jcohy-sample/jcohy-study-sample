package com.jcohy.sample.designpattern.templatemethod;


public class CharDisplay extends AbstractDisplay {
	private char ch;
	public CharDisplay(char ch) {
		this.ch = ch;
	}
	@Override
	public void open() {
		System.out.print("<<");
	}

	@Override
	public void close() {
		System.out.println(">>");
	}

	@Override
	public void print() {
		System.out.print(ch);
	}

}
