package com.jcohy.sample.designpattern.flyweight;


/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jcohy on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
// tag::code[]
public class Client {
	public static void main(String[] args) {
		if(args.length==0) {
			System.out.println("Usage:java Main digits");
			System.out.println("Example:java Main 1212123");
			System.exit(0);
		}
		BigString bs = new BigString(args[0]);
		bs.print();
	}
}
// end::code[]