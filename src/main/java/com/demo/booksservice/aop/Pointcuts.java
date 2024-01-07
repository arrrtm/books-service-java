package com.demo.booksservice.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

    @Pointcut("execution(* com.demo.booksservice.db.service.impl.BookServiceImpl.get*(..)) ")
    public void getMethodsHandler() {
    }

    @Pointcut("execution(* com.demo.booksservice.db.service.impl.BookServiceImpl.add*(..)) ")
    public void addMethodsHandler() {
    }

}