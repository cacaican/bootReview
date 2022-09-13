package com.xiaocai.bootreview;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName AbstractTest
 * @Description TODO
 * @Author xiaocai
 * @Date 2022/9/12
 */
//@RunWith是JUnit的一个注解, 用来告诉JUnit不要使用内置的方式进行单元测试, 而应该使用指定的类做单元测试 对于Spring单元测试总是要使用 SpringRunner.class
@RunWith(SpringRunner.class)
//告诉测试类启动类(这里的DockerspringbootApplication是自己再main/java包下的启动类) 因为启动类加载类配置文件 还有包扫描 才能使用Spring中的bean对象
@SpringBootTest(classes = BootReviewApplication.class)
//        原文链接：https://blog.csdn.net/weixin_44012722/article/details/105671118
public class AbstractTest {
}
