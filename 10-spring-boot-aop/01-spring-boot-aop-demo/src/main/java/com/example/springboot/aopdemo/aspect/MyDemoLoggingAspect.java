package com.example.springboot.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

//    @Before("execution(public void updateAccount())")
//    @Before("execution(public void com.example.springboot.aopdemo.dao.AccountDAO.addAccount())")
//    public void beforeAddAccountAdvice(){
//        System.out.println("\n=====>>> Executing @Before advice on method");
//    }

//    @Before("execution(public void add*())")
//    public void beforeAddAccountAdvice(){
//        System.out.println("\n=====>>> Executing @Before advice on method");
//    }

    //    @Before("execution(void add*())")
//    @Before("execution(* add*())")
//    public void beforeAddAccountAdvice(){
//        System.out.println("\n=====>>> Executing @Before advice on method");
//    }

//    @Before("execution(* add*(com.example.springboot.aopdemo.Account))")
//    public void beforeAddAccountAdvice(){
//        System.out.println("\n=====>>> Executing @Before advice on method");
//    }

//    @Before("execution(* add*(com.example.springboot.aopdemo.Account,..))")
//    public void beforeAddAccountAdvice(){
//        System.out.println("\n=====>>> Executing @Before advice on method");
//    }

//    @Before("execution(* add*(..))")
//    public void beforeAddAccountAdvice(){
//        System.out.println("\n=====>>> Executing @Before advice on method");
//    }

    @Before("execution(* com.example.springboot.aopdemo.dao.*.*(..))")  //match all methods in all return types, method in class in dao
    public void beforeAddAccountAdvice(){
        System.out.println("\n=====>>> Executing @Before advice on method");
    }


}
