package com.bwin.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

@Data
public class Dictionary {

    private String id;
    private String name;
    private String value;
    private String text;
    private String comments;
    @TableLogic
    private Integer deleted = 0;
    @Version
    private Integer version = 0;
    /**
     * 删除状态字典
     */
    private Dictionary deleteStatusDictionary;

}
