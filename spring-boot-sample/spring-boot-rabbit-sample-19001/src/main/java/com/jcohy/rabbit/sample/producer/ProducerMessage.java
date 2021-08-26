package com.jcohy.rabbit.sample.producer;

import com.jcohy.rabbit.sample.callback.RabbitCallback;
import com.jcohy.rabbit.sample.config.RabbitConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author jiac <a href="https://www.jcohy.com"></a>
 * @since 1.0.0 2020/04/13 2020/4/13:10:18 Description
 */
@Component
public class ProducerMessage implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback {

	private static final Logger log = LoggerFactory.getLogger(ProducerMessage.class);

	private final RabbitTemplate rabbitTemplate;

	private RabbitCallback rabbitCallback;

	@Autowired
	public ProducerMessage(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
		// rabbitTemplate如果为单例的话，那回调就是最后设置的内容
		rabbitTemplate.setConfirmCallback(this::confirm);
		rabbitTemplate.setReturnCallback(this::returnedMessage);
		rabbitTemplate.setMandatory(true);
	}

	public void sendMsgToA(String content, RabbitCallback rabbitCallback) {
		this.rabbitCallback = rabbitCallback;
		CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
		rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_A, RabbitConfig.ROUTINGKEY_A, content, correlationId);
	}

	public void sendMsgToB(String content) {
		CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
		rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_B, RabbitConfig.ROUTINGKEY_B, content, correlationId);
	}

	/**
	 * 如果发送到交换器都没有成功，比如删除了交换器，ack 返回值为 false 如果发送到交换器成功，但是没有匹配的队列（比如取消了绑定），ack 返回值还是
	 * true。这是一个坑
	 *
	 * 开启publisher-confirms，当消息发生到 exchange 成功时，ack 为 true。当发送 exchange 失败时，ack 为 false。
	 *
	 * 为了防止消息发送异常,我们需要在发送消息前，进行消息本地缓存。在 ReturnCallback 中可以直接进行消息的重新发送。
	 *
	 * 如果 ConfirmCallback 中 ack 返回 true，这里需要注意的是，当 exchange 没有找到匹配队列，ack 也会返回 true，说明消息发到
	 * exchange 中成功，这个时候需要查看 ReturnCallback 中有没有发生异常，如果消息正常投递， 可以通过 correlationData 删除
	 * redis 或者数据库中的本地消息，否则也需要做异常处理。
	 *
	 * ack 返回 false。则需要做异常处理
	 */
	@Override
	public void confirm(CorrelationData correlationData, boolean ack, String cause) {
		log.info("ConsumerA 消息确认的id： " + correlationData);
		if (ack) {
			rabbitCallback.returnCallBack("消息发送成功");
			log.info("消息发送成功");
			// 发送成功 删除本地数据库存的消息
		}
		else {
			rabbitCallback.returnCallBack("消息发送失败");
			log.info("消息发送失败：id {} | 消息发送失败的原因 {}", correlationData, cause);
			// 根据本地消息的状态为失败，可以用定时任务去处理数据
		}
	}

	/**
	 * 如果发送到交换机成功，但是没有匹配的队列，则会触发这个回调 开启 publisher-returns，发送到交换器成功，但是没有匹配的队列会触发，这样消息也会丢失。
	 */
	@Override
	public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
		rabbitCallback.returnCallBack("returnedMessage [消息从交换机到队列失败]");
		log.info("returnedMessage [消息从交换机到队列失败]  message：" + message);
	}

}
