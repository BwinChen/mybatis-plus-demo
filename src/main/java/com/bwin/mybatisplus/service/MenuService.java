package com.bwin.mybatisplus.service;

import com.bwin.mybatisplus.entity.Menu;
import java.util.List;

public interface MenuService {

    List<Menu> findChildrenByParentId(String parentId);

    Menu findParentsById(String id);

    List<Menu> findChildrenByParentIdAndUserId(String parentId, String userId);

}
