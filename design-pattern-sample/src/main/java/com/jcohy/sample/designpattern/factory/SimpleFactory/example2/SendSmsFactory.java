package com.jcohy.sample.designpattern.factory.SimpleFactory.example2;

/**
 * @author jcohy <a href="https://www.jcohy.com"></a>
 * @since 1.0.0 Description 2020/4/7 13:38
 */
// tag::code[]
public class SendSmsFactory implements Provider {

	@Override
	public Sender produce() {
		return new SmsSender();
	}

}
// end::code[]