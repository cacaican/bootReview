package com.xiaocai.bootreview;

import org.junit.Test;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName TransactionalDemo
 * @Description TODO
 * @Author xiaocai
 * @Date 2022/9/19
 */
public class TransactionalDemo extends AbstractTest{

    @Test()
    @Transactional(propagation=Propagation.REQUIRES_NEW)
    public  void test01 (){

    }

    @Test()
    @Transactional(propagation=Propagation.REQUIRED)
    public  void test02 (){

    }

    @Test()
    @Transactional(propagation=Propagation.REQUIRED)
    public  void test03 (){

    }
}
