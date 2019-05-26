/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.gaoty.order.repository;

import com.gaoty.order.dataobject.OrderMaster;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TODO
 *
 * @author gaoty
 * @version V1.0
 * @since 2019-01-20 17:43
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {
}
