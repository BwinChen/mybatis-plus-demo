package com.bwin.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bwin.mybatisplus.entity.Dictionary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DictionaryMapper extends BaseMapper<Dictionary> {

    @Select("select * from dictionary")
    IPage<Dictionary> selectByPage(Page<Dictionary> page);

    @Select("select * from dictionary where name = #{name} and value = #{value}")
    Dictionary selectByNameAndValue(@Param("name") String name, @Param("value") String value);

}
