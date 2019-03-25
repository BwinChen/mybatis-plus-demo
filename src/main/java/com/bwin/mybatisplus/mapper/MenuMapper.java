package com.bwin.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bwin.mybatisplus.entity.Menu;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import java.util.List;

@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    @Select("select m.*, 'delete_status' as delete_status_dictionary from menu m")
    @Results({
        @Result(id = true, column = "id", property = "id"),
        @Result(column = "{name = delete_status_dictionary, value = deleted}", property = "deleteStatusDictionary", one = @One(select = "com.bwin.mybatisplus.mapper.DictionaryMapper.selectByNameAndValue", fetchType = FetchType.EAGER))
    })
    IPage<Menu> selectByPage(Page<Menu> page);

    /**
     * @see <a href="http://www.spring4all.com/article/627">MyBatis collection 集合嵌套查询树形节点</a>
     */
    @Select("select * from menu where parent_id = #{parentId} and deleted = 0")
    @Results({
        @Result(id = true, column="id", property="id"),
        @Result(column="id", property="children", many = @Many(select = "com.bwin.mybatisplus.mapper.MenuMapper.selectChildrenByParentId", fetchType = FetchType.EAGER))
    })
    List<Menu> selectChildrenByParentId(@Param("parentId") String parentId);

    @Select("select * from menu where id = #{id} and deleted = 0")
    @Results({
        @Result(id = true, column="id", property="id"),
        @Result(column="parent_id", property="parents", many = @Many(select = "com.bwin.mybatisplus.mapper.MenuMapper.selectParentsById", fetchType = FetchType.EAGER))
    })
    Menu selectParentsById(@Param("id") String id);

    @Select("select m.*, #{userId} as user_id from menu m where parent_id = 0 and id in (select menu_id from role_menu where role_id in (select role_id from user_role where user_id = #{userId})) and deleted = 0")
    @Results({
        @Result(id = true, column="id", property="id"),
        @Result(column="{parentId = id, userId = user_id}", property="children", many = @Many(select = "com.bwin.mybatisplus.mapper.MenuMapper.selectChildrenByParentIdAndUserId", fetchType = FetchType.EAGER))
    })
    List<Menu> selectChildrenByUserId(@Param("userId") String userId);

    @Select("select m.*, #{userId} as user_id from menu m where parent_id = #{parentId} and id in (select menu_id from role_menu where role_id in (select role_id from user_role where user_id = #{userId})) and deleted = 0")
    @Results({
        @Result(id = true, column="id", property="id"),
        @Result(column="{parentId = id, userId = user_id}", property="children", many = @Many(select = "com.bwin.mybatisplus.mapper.MenuMapper.selectChildrenByParentIdAndUserId", fetchType = FetchType.EAGER))
    })
    List<Menu> selectChildrenByParentIdAndUserId(@Param("parentId") String parentId, @Param("userId") String userId);

}
