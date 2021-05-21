package com.devandy.springaopstudy.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Performance {

    @Pointcut("execution(* com.devandy.springaopstudy.board.BoardService.getBoards(..))")
    public void getBoards() { }

    @Pointcut("execution(* com.devandy.springaopstudy.user.UserService.getUsers(..))")
    public void getUsers() { }

    @Around("getBoards() || getUsers()")
    public Object calculaterPerformanceTime(ProceedingJoinPoint jointPoint) {
        Object result = null;
        try {
            long start = System.currentTimeMillis();
            result = jointPoint.proceed();
            long end = System.currentTimeMillis();

            System.out.println("수행 시간 : "+(end-start));
        } catch (Throwable throwable) {
            System.out.println("exception !!");
        }
        return result;
    }
}
