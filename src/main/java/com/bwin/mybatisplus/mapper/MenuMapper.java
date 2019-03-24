package com.bwin.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bwin.mybatisplus.entity.Menu;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import java.util.List;

@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * @see <a href="http://www.spring4all.com/article/627">MyBatis collection 集合嵌套查询树形节点</a>
     */
    @Select("select * from menu where parent_id = #{parentId}")
    @Results({
        @Result(id = true, column="id", property="id"),
        @Result(column="id", property="children", many = @Many(select = "com.bwin.mybatisplus.mapper.MenuMapper.selectChildrenByParentId", fetchType = FetchType.EAGER))
    })
    List<Menu> selectChildrenByParentId(@Param("parentId") String parentId);

    @Select("select * from menu where id = #{id}")
    @Results({
        @Result(id = true, column="id", property="id"),
        @Result(column="parent_id", property="parents", many = @Many(select = "com.bwin.mybatisplus.mapper.MenuMapper.selectParentsById", fetchType = FetchType.EAGER))
    })
    Menu selectParentsById(@Param("id") String id);

    @Select("select m.*, #{userId} as userId from menu m where parent_id = 0 and id in (select menu_id from role_menu where role_id in (select role_id from user_role where user_id = #{userId}))")
    @Results({
        @Result(id = true, column="id", property="id"),
        @Result(column="{parentId = id, userId = userId}", property="children", many = @Many(select = "com.bwin.mybatisplus.mapper.MenuMapper.selectChildrenByParentIdAndUserId", fetchType = FetchType.EAGER))
    })
    List<Menu> selectChildrenByUserId(@Param("userId") String userId);

    @Select("select m.*, #{userId} as userId from menu m where parent_id = #{parentId} and id in (select menu_id from role_menu where role_id in (select role_id from user_role where user_id = #{userId}))")
    @Results({
        @Result(id = true, column="id", property="id"),
        @Result(column="{parentId = id, userId = userId}", property="children", many = @Many(select = "com.bwin.mybatisplus.mapper.MenuMapper.selectChildrenByParentIdAndUserId", fetchType = FetchType.EAGER))
    })
    List<Menu> selectChildrenByParentIdAndUserId(@Param("parentId") String parentId, @Param("userId") String userId);

}
