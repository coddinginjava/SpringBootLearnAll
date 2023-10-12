package com.sai.SpringBootLearnAll.advice;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggerAdvice  {

    @Autowired
    private  ObjectMapper objectMapper;

//    @Pointcut(value = "execution(* com.sai.SpringBootLearnAll.*.*.*(..))")  for all methods
    @Pointcut(value = "execution(* com.sai.SpringBootLearnAll.controller.*.*(..))")
    public void myPointCut(){
        System.out.println("Summa");
    }


    @Around("myPointCut()")
    public Object customLoggerForIO(ProceedingJoinPoint pjp) throws Throwable {
        String className = pjp.getTarget().getClass().getName();
        String methodName = pjp.getSignature().getName();
        Object[] args = pjp.getArgs();

        log.info("Method invoked in {}:{} with args= {}",className,methodName,objectMapper.writeValueAsString(args));

        Object proceeded = pjp.proceed();

        log.info("Response for {}:{} is {}",className,methodName,objectMapper.writeValueAsString(proceeded));


        return  proceeded;


    }

    @Around("@annotation(com.sai.SpringBootLearnAll.advice.TimeTracker)")
    public Object trackTimeForTheSpecificMethodWithCustomInterface(ProceedingJoinPoint pjp) throws Throwable {
        long current = System.currentTimeMillis();
        Object proceeded = pjp.proceed();
        log.info(pjp.getSignature().toString() + " has took  = " + (System.currentTimeMillis() - current) );
        return  proceeded;

    }

}

