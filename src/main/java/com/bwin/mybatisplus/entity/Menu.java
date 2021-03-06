package com.bwin.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;
import java.util.List;

@Data
public class Menu {

    private String id;
    private String name;
    private String parentId;
    @TableLogic
    private Integer deleted = 0;
    @Version
    private Integer version = 0;
    /**
     * 子菜单
     */
    private List<Menu> children;
    /**
     * 父菜单
     */
    private List<Menu> parents;
    /**
     * 删除状态字典
     */
    private Dictionary deleteStatusDictionary;

}
