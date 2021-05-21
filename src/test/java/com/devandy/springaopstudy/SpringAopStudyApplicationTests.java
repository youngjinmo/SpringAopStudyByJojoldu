package com.devandy.springaopstudy;

import com.devandy.springaopstudy.board.BoardService;
import com.devandy.springaopstudy.history.History;
import com.devandy.springaopstudy.history.HistoryRepository;
import com.devandy.springaopstudy.user.User;
import com.devandy.springaopstudy.user.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class SpringAopStudyApplicationTests {

    @Autowired
    private BoardService boardService;

    @Autowired
    private UserService userService;

    @Autowired
    private HistoryRepository historyRepository;

    @Test
    @DisplayName("게시글 불러오기 테스트")
    public void getBoards() {
        assertThat(boardService.getBoards().size()).isEqualTo(10);
    }

    @Test
    @DisplayName("사용자 불러오기 테스트")
    void getUsers() {
        assertThat(userService.getUsers().size()).isEqualTo(10);
    }

    @Test
    @DisplayName("사용자 업데이트 테스트")
    void updateUser() {
        List<User> users = userService.getUsers();
        for (int i = 0; i<5; i++) {
            User user = users.get(i);
            user.setEmail("devandy@gmail.com");
            userService.update(user);
        }

        List<History> histories = historyRepository.findAll();
        assertEquals(5, histories.size());
        assertEquals(users.get(0).getId(), histories.get(0).getUserIdx());
        assertEquals(users.get(1).getId(), histories.get(1).getUserIdx());
    }
}
