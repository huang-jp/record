package com.home.record.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.home.record.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【user_info】的数据库操作Mapper
* @createDate 2023-03-30 22:07:16
* @Entity com.home.record.entity.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {


}
