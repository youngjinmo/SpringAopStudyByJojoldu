package com.devandy.springaopstudy.aspect;

import com.devandy.springaopstudy.history.History;
import com.devandy.springaopstudy.history.HistoryRepository;
import com.devandy.springaopstudy.user.User;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class UserHistory {

    @Autowired
    private HistoryRepository historyRepository;

    @Pointcut("execution(* com.devandy.springaopstudy.user.UserService.update(*)) && args(user)")
    public void updateUser(User user) { }

    @AfterReturning("updateUser(user)")
    public void saveHistory(User user) {
        historyRepository.save(new History(user.getId(), LocalDateTime.now()));
    }
}
