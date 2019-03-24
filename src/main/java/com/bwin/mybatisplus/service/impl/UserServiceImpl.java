package com.bwin.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bwin.mybatisplus.entity.User;
import com.bwin.mybatisplus.mapper.UserMapper;
import com.bwin.mybatisplus.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public User save(User user) {
        if (StringUtils.isBlank(user.getId())) {
            if (userMapper.insert(user) > 0) {
                return user;
            }
        }else {
            if (userMapper.updateById(user) > 0) {
                return user;
            }
        }
        return null;
    }

    public IPage<User> findByPage(Integer pageNo, Integer size) {
        Page<User> page = new Page<>();
        page.setCurrent(pageNo);
        page.setSize(size);
        return userMapper.selectByPage(page);
    }

}
