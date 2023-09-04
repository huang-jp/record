package com.home.record.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.home.record.entity.User;

import java.util.List;

/**
* @author Administrator
* @description 针对表【user_info】的数据库操作Service
* @createDate 2023-03-30 22:07:16
*/
public interface UserService extends IService<User> {

    public User selectOne(LambdaQueryWrapper<User> user);

    public int insert(User user);

    public int deleteById(Integer userId);

    public Page<User> selectPage(Integer pageNum,Integer pageSize,String search);

    public int selectCount(LambdaQueryWrapper<User> user);

    public int saveUser(User user);
}
