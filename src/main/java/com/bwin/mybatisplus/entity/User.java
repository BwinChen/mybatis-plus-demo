package com.bwin.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;
import java.util.List;

@Data
public class User {

    private String id;
    private String name;
    private String password;
    private String email;
    private Long cellphoneNumber;
    private String sex;
    @Version
    private Integer version = 0;
    /**
     * 性别字典
     */
    private Dictionary sexDictionary;
    /**
     * 角色
     */
    private List<Role> roles;
    /**
     * 角色
     */
    private List<Menu> menus;

}
