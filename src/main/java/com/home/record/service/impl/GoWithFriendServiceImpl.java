package com.home.record.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.home.record.entity.GoWithFriend;
import com.home.record.entity.User;
import com.home.record.service.GoWithFriendService;
import com.home.record.mapper.GoWithFriendMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author Administrator
* @description 针对表【go_with_friend】的数据库操作Service实现
* @createDate 2023-04-10 19:52:18
*/
@Service
public class GoWithFriendServiceImpl extends ServiceImpl<GoWithFriendMapper, GoWithFriend>
implements GoWithFriendService{

    @Resource
    private GoWithFriendMapper goWithFriendMapper;

    @Override
    public Page<GoWithFriend> selectPage(Integer pageNum, Integer pageSize, String search, String placeList) {
        LambdaQueryWrapper<GoWithFriend> query = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(search)){
            query.like(GoWithFriend::getFriendName, search);
        }
        if(StringUtils.isNotBlank(placeList)){
            query.eq(GoWithFriend::getPlace,placeList);
        }
        Page<GoWithFriend> page = goWithFriendMapper.selectPage(new Page<>(pageNum, pageSize), query);
        return page;
    }

    @Override
    public List<Map<String,Object>> placeList() {
        List<GoWithFriend> goWithFriends = goWithFriendMapper.placeList();
        List<Map<String,Object>> mapList = new ArrayList<>();
        for (GoWithFriend goWithFriend : goWithFriends) {
            Map<String,Object> map = new HashMap<>();
            map.put("value",goWithFriend.getPlace());
            map.put("label",goWithFriend.getPlace());
            mapList.add(map);
        }
        return mapList;
    }
}
