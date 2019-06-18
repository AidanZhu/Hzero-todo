package org.hzero.todo.infra.repository.impl;

import org.hzero.todo.domain.entity.User;
import org.hzero.todo.domain.repository.UserRepository;
import org.hzero.todo.infra.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserRepositoryImpl implements UserRepository {

    private UserMapper userMapper;

    @Autowired
    public UserRepositoryImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public User create(User user) {
        userMapper.insert(user);
        return user;
    }

}
