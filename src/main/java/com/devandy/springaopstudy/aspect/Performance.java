package com.devandy.springaopstudy.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Performance {

    @Around("execution(* com.devandy.springaopstudy.board.BoardService.getBoards(..))")
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
