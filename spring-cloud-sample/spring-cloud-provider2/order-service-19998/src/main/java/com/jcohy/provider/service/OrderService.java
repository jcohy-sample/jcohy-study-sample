package com.jcohy.provider.service;


import com.jcohy.provider.entity.Order;
import com.jcohy.provider.feign.AccountFeignClient;
import com.jcohy.provider.repository.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * Description：
 *
 * @author fangliangsheng
 * @date 2019-04-04
 */
@Service
public class OrderService {

    @Autowired
    private AccountFeignClient accountFeignClient;

    @Autowired
    private OrderDAO orderDAO;

    @Transactional
    public void create(String userId, String commodityCode, Integer count) {

        BigDecimal orderMoney = new BigDecimal(count).multiply(new BigDecimal(5));

        Order order = new Order();
        order.setUserId(userId);
        order.setCommodityCode(commodityCode);
        order.setCount(count);
        order.setMoney(orderMoney);

        orderDAO.save(order);

        accountFeignClient.debit(userId, orderMoney);

    }

}
