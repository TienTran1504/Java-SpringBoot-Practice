package com.example.springboot.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class LuvAopExpressions {
    @Pointcut("execution(* com.example.springboot.aopdemo.dao.*.*(..))")  //pointcut declaration
    public void forDaoPackage(){}  //pointcut declaration

    //create a pointcut for getter methods
    @Pointcut("execution(* com.example.springboot.aopdemo.dao.*.get*(..))")  //pointcut declaration
    public void getter(){}  //pointcut declaration

    //create a pointcut for setter methods
    @Pointcut("execution(* com.example.springboot.aopdemo.dao.*.set*(..))")  //pointcut declaration
    public void setter(){}  //pointcut declaration

    //create a pointcut: include package...exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")  //pointcut declaration
    public void forDaoPackageNoGetterSetter(){}  //pointcut declaration
}
