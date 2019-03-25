package com.bwin.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bwin.mybatisplus.entity.Dictionary;
import com.bwin.mybatisplus.mapper.DictionaryMapper;
import com.bwin.mybatisplus.service.DictionaryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class DictionaryServiceImpl implements DictionaryService {

    private final DictionaryMapper dictionaryMapper;

    @Override
    public Dictionary save(Dictionary dictionary) {
        if (StringUtils.isBlank(dictionary.getId())) {
            if (dictionaryMapper.insert(dictionary) > 0) {
                return dictionary;
            }
        }else {
            if (dictionaryMapper.updateById(dictionary) > 0) {
                return dictionary;
            }
        }
        return null;
    }

    @Override
    public IPage<Dictionary> findByPage(Integer pageNo, Integer size) {
        Page<Dictionary> page = new Page<>();
        page.setCurrent(pageNo);
        page.setSize(size);
        return dictionaryMapper.selectByPage(page);
    }

    @Override
    public List<Dictionary> findByName(String name) {
        QueryWrapper<Dictionary> queryWrapper = new QueryWrapper<> ();
        queryWrapper.eq("name", name);
        return dictionaryMapper.selectList(queryWrapper);
    }

    @Override
    public Dictionary findByNameAndValue(String name, String value) {
        return dictionaryMapper.selectByNameAndValue(name, value);
    }

    @Override
    public int deleteById(String id) {
        return dictionaryMapper.deleteById(id);
    }

}
