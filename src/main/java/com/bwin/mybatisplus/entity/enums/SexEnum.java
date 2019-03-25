package com.bwin.mybatisplus.entity.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum SexEnum {

    FEMALE("f", "女"),
    MALE("m", "男"),
    NEUTRAL("n", "中");

    SexEnum(String value, String text) {
        this.value = value;
        this.text = text;
    }

    /**
     * @see <a href="https://mp.baomidou.com/guide/enum.html">通用枚举</a>
     */
    @EnumValue
    private final String value;
    private final String text;

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

}
