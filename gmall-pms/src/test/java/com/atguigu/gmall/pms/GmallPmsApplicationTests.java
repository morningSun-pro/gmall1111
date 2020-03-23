package com.atguigu.gmall.pms;

import com.atguigu.gmall.pms.entity.Product;
import com.atguigu.gmall.pms.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GmallPmsApplicationTests {
    @Autowired
    ProductService productService;
    @Test
    void contextLoads() {
        Product byId = productService.getById(1);
        System.out.println(byId.getName());
    }
    @Test
    void shardingJdbcTest(){
        Product product = new Product();
        product.setName("hahahha").setPic("http://www.baidu.com").setProductSn("6787879");
        boolean save = productService.save(product);
        System.out.println(save);
    }

    @Test
    void shardingJdbcFindByName() {
        System.out.println(productService.getById(44).getName());
    }
}
