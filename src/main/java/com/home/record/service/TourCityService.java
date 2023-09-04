package com.home.record.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.home.record.entity.TourCity;
import com.home.record.vo.TourCityVo;

/**
* @author Administrator
* @description 针对表【tour_city】的数据库操作Service
* @createDate 2023-04-11 14:56:48
*/
public interface TourCityService extends IService<TourCity> {

    public Page<TourCityVo> tourCityPage(Integer pageNum, Integer pageSize, String search, String strTime, String endTime);
}
