package com.home.record.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 
 * @TableName tour_city
 */
@TableName("tour_city")//与数据库表明对应
@Data
public class TourCity implements Serializable {
    @TableId(type = IdType.AUTO)//主键id自动生成
    private Integer id;
    private String city;
    private String friendId;
    private String season;
    private Date tourStaTime;
    private Date tourEndTime;
}