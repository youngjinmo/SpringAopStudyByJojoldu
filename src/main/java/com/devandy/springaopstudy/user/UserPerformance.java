package com.devandy.springaopstudy.user;

import java.util.List;

public abstract class UserPerformance {
    private Long before() {
        return System.currentTimeMillis();
    }

    private void after(long start) {
        long end = System.currentTimeMillis();
        System.out.println("수행 시간 : "+(end-start));
    }

    private List<User> getUsers() {
        long start = before();
        List<User> users = findAll();
        after(start);
        return users;
    }

    public abstract List<User> findAll();
}
