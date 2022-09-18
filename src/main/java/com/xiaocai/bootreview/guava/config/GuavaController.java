package com.xiaocai.bootreview.guava.config;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName GuavaController
 * @Description TODO
 * @Author xiaocai
 * @Date 2022/9/18
 */
@RestController
@RequestMapping("/guava")
public class GuavaController {

    @RequestMapping("/limit")
    public String limit1(){
        System.out.println("接受到guava请求");
        return "success";
    }

}
