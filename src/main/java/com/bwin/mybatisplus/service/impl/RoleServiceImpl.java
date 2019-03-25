package com.bwin.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bwin.mybatisplus.entity.Role;
import com.bwin.mybatisplus.mapper.RoleMapper;
import com.bwin.mybatisplus.service.RoleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleMapper roleMapper;

    @Override
    public Role save(Role role) {
        if (StringUtils.isBlank(role.getId())) {
            if (roleMapper.insert(role) > 0) {
                return role;
            }
        }else {
            if (roleMapper.updateById(role) > 0) {
                return role;
            }
        }
        return null;
    }

    @Override
    public IPage<Role> findByPage(Integer pageNo, Integer size) {
        Page<Role> page = new Page<>();
        page.setCurrent(pageNo);
        page.setSize(size);
        return roleMapper.selectByPage(page);
    }

    @Override
    public int deleteById(String id) {
        return roleMapper.deleteById(id);
    }

}
