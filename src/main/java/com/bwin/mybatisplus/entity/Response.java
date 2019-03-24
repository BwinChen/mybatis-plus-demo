package com.bwin.mybatisplus.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Response<T> {

    private String code = "200";
    private String message = "success";
    private T data;

    public Response(T data) {
        this.data = data;
    }

    public Response(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
