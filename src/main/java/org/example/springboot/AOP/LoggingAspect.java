package org.example.springboot.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {


    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);


    @Pointcut("execution(   * org.example.springboot.*.*.*(..))")
    public void PointCutMethod(){}

    @Before("PointCutMethod()")
    public void logBefore(JoinPoint joinPoint) {

        System.out.println("logging before: name" + joinPoint.getSignature().getName());
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println("arg" + arg.toString());
        }

//        logger.info(joinPoint.getSignature().getName());
//        Object[] args = joinPoint.getArgs();
//        for (Object arg : args) {
//            logger.info(arg.toString());
//        }


    }




    @AfterReturning("execution(   * org.example.springboot.service.UserService.save(..))")
    public void After(){
        System.out.println("After Method");
    }






}

