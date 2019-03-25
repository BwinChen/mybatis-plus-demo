package com.bwin.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bwin.mybatisplus.entity.Role;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    @Select("select r.*, 'delete_status' as delete_status_dictionary from role r")
    @Results({
        @Result(id = true, column = "id", property = "id"),
        @Result(column = "{name = delete_status_dictionary, value = deleted}", property = "deleteStatusDictionary", one = @One(select = "com.bwin.mybatisplus.mapper.DictionaryMapper.selectByNameAndValue", fetchType = FetchType.EAGER))
    })
    IPage<Role> selectByPage(Page<Role> page);

    @Select("select * from role where id in (select role_id from user_role where user_id = #{userId}) and deleted = 0")
    List<Role> selectByUserId(@Param("userId") String userId);

}
