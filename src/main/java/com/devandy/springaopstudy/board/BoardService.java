package com.devandy.springaopstudy.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService extends BoardPerformance{

    @Autowired
    private BoardRepository boardRepository;

    public List<Board> getBoards() {
        long start = System.currentTimeMillis();
        List<Board> boards = boardRepository.findAll();
        long end = System.currentTimeMillis();

        System.out.println("수행 시간 : "+(end-start));
        return boards;
    }

    @Override
    public List<Board> findAll() {
        return boardRepository.findAll();
    }
}
