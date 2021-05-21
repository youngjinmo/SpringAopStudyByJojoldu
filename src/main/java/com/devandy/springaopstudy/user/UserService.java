package com.devandy.springaopstudy.user;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    void update(User user);
}
