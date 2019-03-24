package com.bwin.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

@Data
public class Dictionary {

    private String id;
    private String name;
    private String value;
    private String text;
    private String comments;
    @Version
    private Integer version = 0;

}
