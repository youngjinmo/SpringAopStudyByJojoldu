package com.devandy.springaopstudy;

import com.devandy.springaopstudy.board.BoardService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class SpringAopStudyApplicationTests {

    @Autowired
    private BoardService boardService;

    @Test
    @DisplayName("게시글 불러오기 테스트")
    public void getBoards() throws Exception {
        assertThat(boardService.getBoards().size()).isEqualTo(10);
    }

}
