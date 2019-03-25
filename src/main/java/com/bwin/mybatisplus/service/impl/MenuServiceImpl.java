package com.bwin.mybatisplus.service.impl;

import com.bwin.mybatisplus.entity.Menu;
import com.bwin.mybatisplus.mapper.MenuMapper;
import com.bwin.mybatisplus.service.MenuService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class MenuServiceImpl implements MenuService {

    private final MenuMapper menuMapper;

    @Override
    public Menu save(Menu menu) {
        if (StringUtils.isBlank(menu.getId())) {
            if (menuMapper.insert(menu) > 0) {
                return menu;
            }
        }else {
            if (menuMapper.updateById(menu) > 0) {
                return menu;
            }
        }
        return null;
    }

    @Override
    public List<Menu> findChildrenByParentId(String parentId) {
        return menuMapper.selectChildrenByParentId(parentId);
    }

    @Override
    public Menu findParentsById(String id) {
        return menuMapper.selectParentsById(id);
    }

    @Override
    public List<Menu> findChildrenByParentIdAndUserId(String parentId, String userId) {
        return menuMapper.selectChildrenByParentIdAndUserId(parentId, userId);
    }

    @Override
    public int deleteById(String id) {
        return menuMapper.deleteById(id);
    }

}
