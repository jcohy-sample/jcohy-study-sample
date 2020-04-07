package com.jcohy.sample.designpattern.factory.SimpleFactory.example2;

/**
 * @author jcohy <a href="http://www.jcohy.com"></a>
 * @since 1.0.0
 * Description  2020/4/7 13:33
 */
// tag::code[]
public class FactoryTest {
    public static void main(String[] args) {
        SendFactory factory = new SendFactory();
        Sender sender = factory.produce("sms");
        sender.Send();
    }
}
// end::code[]