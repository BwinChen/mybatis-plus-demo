package com.bwin.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bwin.mybatisplus.entity.User;

public interface UserService {

    User save(User user);

    IPage<User> findByPage(Integer pageNo, Integer size);

}
