package com.bwin.mybatisplus.controller;

import com.bwin.mybatisplus.entity.Response;
import com.bwin.mybatisplus.service.MenuService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RequestMapping("/menu")
@RestController
public class MenuController {

    private final MenuService menuService;

    @GetMapping("/getChildrenByParentId/{parentId}")
    public Response getChildrenByParentId(@PathVariable("parentId") String parentId) {
        return new Response<>(menuService.findChildrenByParentId(parentId));
    }

    @GetMapping("/getParentsById/{id}")
    public Response getParentsById(@PathVariable("id") String id) {
        return new Response<>(menuService.findParentsById(id));
    }

    @GetMapping("/getChildrenByParentIdAndUserId")
    public Response getChildrenByParentIdAndUserId(String parentId, String userId) {
        return new Response<>(menuService.findChildrenByParentIdAndUserId(parentId, userId));
    }

}
