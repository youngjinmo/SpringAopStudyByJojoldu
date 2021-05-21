package com.devandy.springaopstudy.aspect;

import java.util.List;

public abstract class SuperPerformance<T> {
    private Long before() {
        return System.currentTimeMillis();
    }

    private void after(long start) {
        long end = System.currentTimeMillis();
        System.out.println("수행 시간 : "+(end-start));
    }

    public List<T> getDataAll() {
        long start = before();
        List<T> datas = findAll();
        after(start);
        return datas;
    }

    public abstract List<T> findAll();
}
