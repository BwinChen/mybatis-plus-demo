package com.bwin.mybatisplus.controller;

import com.bwin.mybatisplus.entity.Dictionary;
import com.bwin.mybatisplus.entity.Response;
import com.bwin.mybatisplus.service.DictionaryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@AllArgsConstructor
@RequestMapping("/dictionary")
@RestController
public class DictionaryController {

    private final DictionaryService dictionaryService;

    @PostMapping
    public Response post(@RequestBody Dictionary dictionary) {
        return new Response<>(dictionaryService.save(dictionary));
    }

    @GetMapping("/getByPage")
    public Response getByPage(Integer page, Integer size) {
        return new Response<>(dictionaryService.findByPage(page, size));
    }

    @GetMapping("/getByName/{name}")
    public Response getByName(@PathVariable String name) {
        return new Response<>(dictionaryService.findByName(name));
    }

    @GetMapping("/getByNameAndValue")
    public Response getByNameAndValue(String name, String value) {
        return new Response<> (dictionaryService.findByNameAndValue(name, value));
    }

    @DeleteMapping("/deleteById/{id}")
    public Response deleteById(@PathVariable("id") String id) {
        return new Response<>(dictionaryService.deleteById(id));
    }

}
