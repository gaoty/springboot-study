package com.gaoty.order.repository;

import com.gaoty.order.dataobject.OrderDetail;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author gaoty
 * @version V1.0
 * @since 2019-02-23 13:25
 */
@Component
public class OrderDetailRepositoryTest extends com.gaoty.order.repository.OrderMasterRepositoryTest {

    @Autowired
    private OrderDetailRepository orderDetailRepository;



    @Test
    public void findByOrderId() {
    }

    @Test
    public void testSave() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("12367");
        orderDetail.setOrderId("123456");
        orderDetail.setProductIcon("http://xxx.com");
        orderDetail.setProductId("157875196366160022");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(new BigDecimal(0.01));
        orderDetail.setProductQuantity(2);

        OrderDetail result = orderDetailRepository.save(orderDetail);
        Assert.assertTrue(result != null);
    }

}