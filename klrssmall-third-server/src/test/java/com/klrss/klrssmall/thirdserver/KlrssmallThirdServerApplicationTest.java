//package com.klrss.klrssmall.thirdserver;
//
//import com.aliyun.oss.OSSClient;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.io.FileInputStream;
//
///**
// * @author: zhongnan
// */
//@SpringBootTest
//public class KlrssmallThirdServerApplicationTest {
//
//    @Autowired
//    private OSSClient ossClient;
//
//    @Test
//    public void test01() throws Exception {
//        // 上傳文件流
//        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\zhongnan\\Desktop\\20230621104825.png");
//        ossClient.putObject("klrssmall", "haha.png", fileInputStream);
//        // 关闭OSSClient。
//        ossClient.shutdown();
//    }
//
//}
