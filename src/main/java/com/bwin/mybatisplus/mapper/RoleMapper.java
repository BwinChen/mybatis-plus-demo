package com.bwin.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bwin.mybatisplus.entity.Role;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    @Select("select * from role")
    IPage<Role> selectByPage(Page<Role> page);

    @Select("select * from role where id in (select role_id from user_role where user_id = #{userId})")
    List<Role> selectByUserId(@Param("userId") String userId);

}
