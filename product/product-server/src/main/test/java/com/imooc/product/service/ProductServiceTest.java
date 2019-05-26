package com.gaoty.product.service;

import com.gaoty.product.DTO.CartDTO;
import com.gaoty.product.ProductApplicationTests;
import com.gaoty.product.dataobject.ProductInfo;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author gaoty
 * @version V1.0
 * @since 2019-01-20 16:44
 */
@Component
public class ProductServiceTest extends ProductApplicationTests {

    @Autowired
    private ProductService productService;

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfoList = productService.findUpAll();
        Assert.assertTrue(productInfoList.size()>0);
    }

    @Test
    public void findList() {
        List<ProductInfo> productInfoList = productService.findList(Arrays
            .asList("157875196366160022", "157875227953464068"));
        Assert.assertTrue(productInfoList.size()>0);
    }

    @Test
    public void decreaseStock() throws Exception {
        CartDTO cartDTO = new CartDTO("157875196366160022", 2);
        productService.decreaseStock(Arrays.asList(cartDTO));
    }
}