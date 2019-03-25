package com.bwin.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bwin.mybatisplus.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * @see <a href="https://blog.csdn.net/sinat_32034679/article/details/78727612">mybatis collection column 传常量</a>
     */
    @Select("select u.*, 'sex' as sex_dictionary, 'delete_status' as delete_status_dictionary from user u")
    @Results({
        @Result(id = true, column = "id", property = "id"),
        @Result(column = "{name = sex_dictionary, value = sex}", property = "sexDictionary", one = @One(select = "com.bwin.mybatisplus.mapper.DictionaryMapper.selectByNameAndValue", fetchType = FetchType.EAGER)),
        @Result(column = "{name = delete_status_dictionary, value = deleted}", property = "deleteStatusDictionary", one = @One(select = "com.bwin.mybatisplus.mapper.DictionaryMapper.selectByNameAndValue", fetchType = FetchType.EAGER))
    })
    IPage<User> selectByPage(Page<User> page);

    @Select("select * from user where name = #{name} and deleted = 0")
    @Results({
        @Result(id = true, column = "id", property = "id"),
        @Result(column = "id", property = "roles", many = @Many(select = "com.bwin.mybatisplus.mapper.RoleMapper.selectByUserId", fetchType = FetchType.EAGER)),
        @Result(column = "id", property = "menus", many = @Many(select = "com.bwin.mybatisplus.mapper.MenuMapper.selectChildrenByUserId", fetchType = FetchType.EAGER))
    })
    User selectByName(String name);

}
