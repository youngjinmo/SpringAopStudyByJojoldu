package com.devandy.springaopstudy.board;

import java.util.List;

public abstract class BoardPerformance {
    private Long before() {
        return System.currentTimeMillis();
    }

    private void after(long start) {
        long end = System.currentTimeMillis();
        System.out.println("수행 시간 : "+(end-start));
    }

    private List<Board> getBoards() {
        long start = before();
        List<Board> boards = findAll();
        after(start);
        return boards;
    }

    public abstract List<Board> findAll();
}
