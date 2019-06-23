/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.gaoty.product.service.impl;

import com.gaoty.product.common.DecreaseStockInput;
import com.gaoty.product.common.ProductInfoOutput;
import com.gaoty.product.dataobject.ProductInfo;
import com.gaoty.product.enums.ProductStatusEnum;
import com.gaoty.product.enums.ResultEnum;
import com.gaoty.product.exception.ProductException;
import com.gaoty.product.repository.ProductInfoRepository;
import com.gaoty.product.service.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

/**
 * TODO
 *
 * @author gaoty
 * @version V1.0
 * @since 2019-01-20 16:42
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Autowired
    private RestTemplate restTemplate;
    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfoOutput> findList(List<String> productIdList) {
        return productInfoRepository.findByProductIdIn(productIdList).stream()
            .map(e -> {
                ProductInfoOutput output = new ProductInfoOutput();
                BeanUtils.copyProperties(e, output);
                return output;
            })
            .collect(Collectors.toList());
    }

    @Override
    public void decreaseStock(List<DecreaseStockInput> cartDTOList) {
        for (DecreaseStockInput cartDTO:cartDTOList){
            Optional<ProductInfo> optionalProductInfo = productInfoRepository.findById(cartDTO.getProductId());
            //判断商品是否存在
            if(!optionalProductInfo.isPresent()){
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            ProductInfo productInfo = optionalProductInfo.get();
            //库存是否足够
            Integer result = productInfo.getProductStock()-cartDTO.getProductQuantity();
            if(result<0){
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        }
    }

}