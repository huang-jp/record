package com.home.record.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName go_with_friend
 */
@TableName("go_with_friend")//与数据库表明对应
@Data
public class GoWithFriend implements Serializable {
    @TableId(type = IdType.AUTO)//主键id自动生成
    private Integer id;
    private String friendName;
    private String sex;
    private String place;
    private String relation;
    private Date tourTime;
    private Date createTime;
    private Date endTime;
    private Date updateTime;
}