package com.home.record.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.home.record.entity.GoWithFriend;
import com.home.record.entity.User;

import java.util.List;
import java.util.Map;

/**
* @author Administrator
* @description 针对表【go_with_friend】的数据库操作Service
* @createDate 2023-04-10 19:52:18
*/
public interface GoWithFriendService extends IService<GoWithFriend> {

    public Page<GoWithFriend> selectPage(Integer pageNum, Integer pageSize, String search, String placeList);

    public List<Map<String,Object>> placeList();

}
