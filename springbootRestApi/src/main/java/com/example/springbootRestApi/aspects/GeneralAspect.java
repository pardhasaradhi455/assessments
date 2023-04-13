package com.example.springbootRestApi.aspects;

import com.example.springbootRestApi.entity.Employee;
import com.example.springbootRestApi.service.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;


@Aspect
@Slf4j
@Component
public class GeneralAspect {

//    @Pointcut("execution(* com.example.springbootRestApi.controller.*.*(..))")
    @Pointcut("within(com.example.springbootRestApi..*)")
    public void loggingPointCut(){}

//    @Before("loggingPointCut()")
//    public void before(JoinPoint p){
//        System.out.println("Before method :: "+p.getSignature());
//    }
//
//    @After("loggingPointCut()")
//    public void after(JoinPoint p){
//        log.info("After method :: "+p.getSignature());
//    }
//
//    @AfterReturning(value = "execution(* com.example.springbootRestApi.controller.*.*(..))", returning = "employee")
//    public void afterReturning(JoinPoint p, Employee employee){
//        log.info("After Returning method returns :: " + employee + " with " + p.getSignature());
//    }
//
//    @AfterThrowing(value = "execution(* com.example.springbootRestApi.controller.*.*(..))", throwing = "e")
//    public void afterThrowing(JoinPoint p, Exception e){
//        log.info("After Throwing method throws :: " + e + " with " + p.getSignature());
//    }

    @Around("loggingPointCut()")
    public Object logBeforeAndAfterMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Before method invoked::"+joinPoint.getArgs()[0]);
        Object object = joinPoint.proceed();

        if(object instanceof Employee){
            log.info("After method invoked..."+joinPoint.getArgs()[0]);
        }

        return object;

    }
}
