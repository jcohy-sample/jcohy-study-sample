package com.jcohy.sample.designpattern.factory.SimpleFactory.example2;

/**
 * @author jcohy <a href="http://www.jcohy.com"></a>
 * @since 1.0.0
 * Description  2020/4/7 13:31
 */
// tag::code[]
public class SmsSender implements Sender {
    @Override
    public void Send() {
        System.out.println("this is sms sender!");
    }
}
// end::code[]
