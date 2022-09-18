package com.xiaocai.bootreview.rabbitMq.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName Routing
 * @Description TODO
 * @Author xiaocai
 * @Date 2022/9/18
 */
@Configuration
public class RouteConfig {

    public static  final String ROUTEEXCHANGENAME ="route_exchange1";
    public static  final String ROUTEQUEUE1 ="route_queue1";
    public static  final String ROUTEQUEUE2 ="route_queue2";
}
