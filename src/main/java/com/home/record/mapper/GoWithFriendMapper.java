package com.home.record.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.home.record.entity.GoWithFriend;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Administrator
* @description 针对表【go_with_friend】的数据库操作Mapper
* @createDate 2023-04-10 19:52:18
* @Entity com.home.record.entity.GoWithFriend
*/
@Mapper
public interface GoWithFriendMapper extends BaseMapper<GoWithFriend> {

    public List<GoWithFriend> selectFriends(@Param("search") String search,@Param("placeList") String placeList);
    public List<GoWithFriend> placeList();
}
