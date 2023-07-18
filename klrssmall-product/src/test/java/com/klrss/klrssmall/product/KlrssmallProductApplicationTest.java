package com.klrss.klrssmall.product;

import com.klrss.klrssmall.product.entity.BrandEntity;
import com.klrss.klrssmall.product.service.impl.BrandServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class KlrssmallProductApplicationTest {

    @Autowired
    BrandServiceImpl brandService;
    //
    //@Autowired
    //StringRedisTemplate stringRedisTemplate;
    //
    //@Autowired
    //RedissonClient redissonClient;
    //
    //@Test
    //@DisplayName("测试StringRedisTemplate")
    //public void TestStringRedisTemplate(){
    //    ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
    //    stringStringValueOperations.set("Hello","KK"+ UUID.randomUUID());
    //    System.out.println(stringStringValueOperations.get("Hello"));
    //}
    //
    //@Test
    //@DisplayName("测试RedissonClient")
    //public void TestRedissonClient(){
    //    System.out.println(redissonClient);
    //}

    @Test
    void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setName("华为");
        brandService.save(brandEntity);
        System.out.println("保存成功！！！");
    }

}
