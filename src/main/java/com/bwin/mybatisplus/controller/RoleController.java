package com.bwin.mybatisplus.controller;

import com.bwin.mybatisplus.entity.Response;
import com.bwin.mybatisplus.entity.Role;
import com.bwin.mybatisplus.service.RoleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@AllArgsConstructor
@RequestMapping("/role")
@RestController
public class RoleController {

    private final RoleService roleService;

    @PostMapping
    public Response post(@RequestBody Role role) {
        return new Response<>(roleService.save(role));
    }

    @GetMapping("/getByPage")
    public Response getByPage(Integer page, Integer size) {
        return new Response<>(roleService.findByPage(page, size));
    }

}
