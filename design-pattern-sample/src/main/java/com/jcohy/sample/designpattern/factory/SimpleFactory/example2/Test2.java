package com.jcohy.sample.designpattern.factory.SimpleFactory.example2;

/**
 * @author jcohy <a href="https://www.jcohy.com"></a>
 * @since 1.0.0
 * Description  2020/4/7 13:39
 */
// tag::code[]
public class Test2 {
    public static void main(String[] args) {
        Provider provider = new SendMailFactory();
        Sender sender = provider.produce();
        sender.Send();
    }
}
// end::code[]