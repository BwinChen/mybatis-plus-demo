package com.bwin.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

@Data
public class Role {

    private String id;
    private String name;
    private String comment;
    @Version
    private Integer version = 0;

}
