package com.home.record.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName tour_city
 */
@Data
public class TourCityVo  {
    private String city;
    private String friendName;
    private String place;

    private Integer id;
    private String season;
    private String tourStaTime;
    private String tourEndTime;
}