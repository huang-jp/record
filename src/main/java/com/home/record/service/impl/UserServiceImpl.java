package com.home.record.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.home.record.common.Result;
import com.home.record.entity.User;
import com.home.record.service.UserService;
import com.home.record.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
* @author Administrator
* @description 针对表【user_info】的数据库操作Service实现
* @createDate 2023-03-30 22:07:16
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User selectOne(LambdaQueryWrapper<User> user) {
        return userMapper.selectOne(user);
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int deleteById(Integer userId) {
        return userMapper.deleteById(userId);
    }

    @Override
    public Page<User> selectPage(Integer pageNum,Integer pageSize,String search) {
        // Wrappers.<User>lambdaQuery().like(User::getNickname,search) 模糊查询，根据前端传来的search
        Page<User> page = userMapper.selectPage(new Page<>(pageNum, pageSize), Wrappers.<User>lambdaQuery().like(User::getNickname, search).or().eq(User::getUsername, search));
        return page;
    }

    @Override
    public int selectCount(LambdaQueryWrapper<User> user) {
        return userMapper.selectCount(user);
    }

    @Override
    public int saveUser(User user) {
        int count = userMapper.selectCount(Wrappers.<User>lambdaQuery().eq(User::getUsername, user.getUsername()));
        if (user.getId() != null) {
            if(count<=1){
                userMapper.updateById(user);
            }else{
                return -1;
            }
        } else {
            if(count<=0){
                User user1 = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, user.getUsername()));
                if(user1==null){
                    userMapper.insert(user);
                }
            }else{
                return -1;
            }
        }
        return count;
    }
}
