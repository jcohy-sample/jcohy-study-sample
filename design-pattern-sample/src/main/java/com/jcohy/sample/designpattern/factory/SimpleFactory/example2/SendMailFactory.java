package com.jcohy.sample.designpattern.factory.SimpleFactory.example2;

/**
 * @author jcohy <a href="http://www.jcohy.com"></a>
 * @since 1.0.0
 * Description  2020/4/7 13:37
 */
// tag::code[]
public class SendMailFactory implements Provider {
    @Override
    public Sender produce() {
        return new MailSender();
    }
}
// end::code[]