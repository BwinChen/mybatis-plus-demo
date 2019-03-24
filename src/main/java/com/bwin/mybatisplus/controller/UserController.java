package com.bwin.mybatisplus.controller;

import com.bwin.mybatisplus.entity.User;
import com.bwin.mybatisplus.entity.Response;
import com.bwin.mybatisplus.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@AllArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping
    public Response post(@RequestBody User user) {
        return new Response<>(userService.save(user));
    }

    @GetMapping("/getByPage")
    public Response getByPage(Integer page, Integer size) {
        return new Response<>(userService.findByPage(page, size));
    }

}
