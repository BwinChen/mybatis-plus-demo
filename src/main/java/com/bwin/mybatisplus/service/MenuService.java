package com.bwin.mybatisplus.service;

import com.bwin.mybatisplus.entity.Menu;
import java.util.List;

public interface MenuService {

    Menu save(Menu menu);

    List<Menu> findChildrenByParentId(String parentId);

    Menu findParentsById(String id);

    List<Menu> findChildrenByParentIdAndUserId(String parentId, String userId);

    int deleteById(String id);

}
