package com.bwin.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bwin.mybatisplus.entity.Dictionary;
import java.util.List;

public interface DictionaryService {

    Dictionary save(Dictionary dictionary);

    IPage<Dictionary> findByPage(Integer pageNo, Integer size);

    List<Dictionary> findByName(String name);

    Dictionary findByNameAndValue(String name, String value);

    int deleteById(String id);

}
