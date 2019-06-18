package org.hzero.todo.domain.repository;

import org.hzero.todo.domain.entity.User;

public interface UserRepository {
    User create(User user);
}
