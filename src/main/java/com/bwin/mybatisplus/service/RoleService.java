package com.bwin.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bwin.mybatisplus.entity.Role;

public interface RoleService {

    Role save(Role role);

    IPage<Role> findByPage(Integer pageNo, Integer size);

}
