package com.bwin.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import com.bwin.mybatisplus.entity.enums.SexEnum;
import lombok.Data;
import java.util.List;

@Data
public class User {

    private String id;
    private String name;
    private String password;
    private String email;
    private Long cellphoneNumber;
    private SexEnum sex;
    @TableLogic
    private Integer deleted = 0;
    @Version
    private Integer version = 0;
    /**
     * 角色
     */
    private List<Role> roles;
    /**
     * 菜单
     */
    private List<Menu> menus;
    /**
     * 性别字典
     */
    private Dictionary sexDictionary;
    /**
     * 删除状态字典
     */
    private Dictionary deleteStatusDictionary;

}
