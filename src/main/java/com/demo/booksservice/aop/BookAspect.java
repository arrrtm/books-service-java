package com.demo.booksservice.aop;

import com.demo.booksservice.util.CustomResponseBody;
import com.demo.booksservice.util.CustomResponseStatus;
import com.demo.booksservice.web.dto.BookDto;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Slf4j
@Aspect
@Component
public class BookAspect {

    @Around("Pointcuts.getMethodsHandler()")
    public Object aroundGettingAdvice(ProceedingJoinPoint joinPoint) {
        Object title = null;

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        if (methodSignature.getName().equals("getAll")) {
            log.info("try get all books");
        } else if (methodSignature.getName().equals("getBookByTitle")) {
            title = joinPoint.getArgs();
            log.info("try get book by title {}", title);
        }

        Object bookResult;
        try {
            bookResult = joinPoint.proceed();
        } catch (NoSuchElementException nsex) {
            log.error("ERROR: {}", nsex.getLocalizedMessage());
            return new CustomResponseBody<>(
                    CustomResponseStatus.NOT_FOUND, null);
        } catch (Throwable ex) {
            log.error("ERROR: {}", ex.getLocalizedMessage());
            bookResult = new CustomResponseBody<>(
                    CustomResponseStatus.EXCEPTION, ex.getLocalizedMessage());
        }

        if (methodSignature.getName().equals("getAll")) {
            log.info("list of books: {}", bookResult);
        } else if (methodSignature.getName().equals("getBookByTitle")) {
            log.info("book with title {} is found: {}", title, bookResult);
        }
        return bookResult;

    }

    @Around("Pointcuts.addMethodsHandler()")
    public Object aroundAddingAdvice(ProceedingJoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        if (methodSignature.getName().equals("addBook")) {
            Object[] arguments = joinPoint.getArgs();
            for (Object arg : arguments) {
                if (arg instanceof BookDto) {
                    log.info("save book object: {}", arg);
                }
            }
        }

        Object result;
        try {
            result = joinPoint.proceed();
        } catch (Throwable ex) {
            log.error("ERROR: {}", ex.getLocalizedMessage());
            result = new CustomResponseBody<>(
                    CustomResponseStatus.EXCEPTION, ex.getLocalizedMessage());
        }
        return result;

    }

}