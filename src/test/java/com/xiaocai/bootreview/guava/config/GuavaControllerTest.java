package com.xiaocai.bootreview.guava.config;

import com.xiaocai.bootreview.AbstractTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

public class GuavaControllerTest extends AbstractTest {

    @Autowired
    private GuavaController controller;

    @Test
    public void test(){
        for (int i = 0; i < 10; i++) {
            controller.limit1();
        }
    }

}