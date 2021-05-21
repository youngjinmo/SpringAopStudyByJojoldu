package com.devandy.springaopstudy;

import com.devandy.springaopstudy.board.Board;
import com.devandy.springaopstudy.board.BoardRepository;
import com.devandy.springaopstudy.board.BoardService;
import com.devandy.springaopstudy.user.User;
import com.devandy.springaopstudy.user.UserRepository;
import com.devandy.springaopstudy.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class SpringAopStudyApplication implements CommandLineRunner {

    @Autowired
    private BoardService boardService;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/boards")
    public List<Board> getBoards() {
        return boardService.getBoards();
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 1; i <= 10; i++) {
            boardRepository.save(new Board(i+"번째 게시글의 제목", i+"번째 게시글의 내용"));
            userRepository.save(new User(i+"@gmail.com",i+"번째 사용자"));
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringAopStudyApplication.class, args);
    }

}
