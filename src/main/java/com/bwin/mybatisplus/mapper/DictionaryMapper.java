package com.bwin.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bwin.mybatisplus.entity.Dictionary;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

@Mapper
public interface DictionaryMapper extends BaseMapper<Dictionary> {

    @Select("select d.*, 'delete_status' as delete_status_dictionary from dictionary d")
    @Results({
        @Result(id = true, column = "id", property = "id"),
        @Result(column = "{name = delete_status_dictionary, value = deleted}", property = "deleteStatusDictionary", one = @One(select = "com.bwin.mybatisplus.mapper.DictionaryMapper.selectByNameAndValue", fetchType = FetchType.EAGER))
    })
    IPage<Dictionary> selectByPage(Page<Dictionary> page);

    @Select("select * from dictionary where name = #{name} and value = #{value} and deleted = 0")
    Dictionary selectByNameAndValue(@Param("name") String name, @Param("value") String value);

}
