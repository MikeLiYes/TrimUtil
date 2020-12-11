package com.mike.TrimUtil.common;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

/**
 * 切面
 */
@Aspect
@Component
public class TrimAspect {

    @Autowired
    private ApplicationContext context;

    @Pointcut("execution(* com.mike.TrimUtil.controller..*.*(..))")
    public void trimPointCut() {
    }

    @Before("trimPointCut()")
    public void trim(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        //方法参数名
        String[] names = methodSignature.getParameterNames();
        //方法参数值
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < names.length; i++) {
            if(args[i] instanceof HttpServletRequest  || args[i] instanceof MultipartFile){

            }else{
            	Object arg = args[i];
            	if (arg != null) {
            		TrimUtil.trim(arg);
            	}
            }
        }
    }


}
