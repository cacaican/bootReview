package com.xiaocai.bootreview.ssm;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * @ClassName SsmAspect
 * @Description
 * 连接点（Joinpoint）: 表示需要在程序中插入横切关注点的扩展点，连接点可能是类初始化、方法执行、方法调用、字段调用或处理异常等等，Spring只支持方法执行连接点；在AOP中表示为“在哪里干”；
 *  切入点（Pointcut）: 选择一组相关连接点的模式，即可以认为连接点的集合，Spring支持perl5正则表达式和AspectJ切入点模式，Spring默认使用AspectJ语法；在AOP中表示为“在哪里干的集合”；
 *  通知（Advice）: 在连接点上执行的行为，通知提供了在AOP中需要在切入点所选择的连接点处进行扩展现有行为的手段；包括前置通知（before advice）、后置通知(after advice)、环绕通知（around advice），在Spring中通过代理模式实现AOP，并通过拦截器模式以环绕连接点的拦截器链织入通知；在AOP中表示为“干什么”；
 *  切面（Aspect）：横切关注点的模块化，比如日志组件。可以认为是通知、引入和切入点的组合；在Spring中可以使用Schema和@AspectJ方式进行组织实现；在AOP中表示为“在哪干和干什么集合”；
 *  引入（Introduction）: 也称为内部类型声明，为已有的类添加额外新的字段或方法，Spring允许引入新的接口（必须对应一个实现）到所有被代理对象（目标对象）；在AOP中表示为“干什么（引入什么）”；
 *  目标对象（Target Object）:需要被织入横切关注点的对象，即该对象是切入点选择的对象，需要被通知的对象，从而也可称为“被通知对象”；由于Spring AOP 通过代理模式实现，从而这个对象永远是被代理对象；在AOP中表示为“对谁干”；
 *  AOP代理（AOP Proxy）: AOP框架使用代理模式创建的对象，从而实现在连接点处插入通知（即应用切面），就是通过代理来对目标对象应用切面。在Spring中，AOP代理可以用JDK动态代理或CGLIB代理实现，而通过拦截器模型应用切面。
 *  织入（Weaving）: 织入是一个过程，是将切面应用到目标对象从而创建出AOP代理对象的过程，织入可以在编译期、类装载期、运行期进行。组装方面来创建一个被通知对象。这可以在编译时完成（例如使用AspectJ编译器），也可以在运行时完成。Spring和其他纯Java AOP框架一样，在运行时完成织入。
 * ————————————————
 * 原文链接：https://blog.csdn.net/qq_42162899/article/details/119037820
 *
 * @Author xiaocai
 * @Date 2022/9/19
 */
@Aspect
@Component
public class SsmAspect {

    // 定义切点Pointcut
    @Pointcut("execution(public * com.xiaocai.bootreview.ssm..*.*Controller.*(..))")
    public void excudeService() {
    }

    //环绕通知：灵活自由的在目标方法中切入代码
    @Around("excudeService()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long time1=System.currentTimeMillis();
        pjp.proceed();
        long time2=System.currentTimeMillis();
        //切面共耗时
        System.out.println("切面共耗时========="+(time2-time1));
        return null;
    }
}
