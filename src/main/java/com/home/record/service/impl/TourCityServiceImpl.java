package com.home.record.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.home.record.entity.TourCity;
import com.home.record.service.TourCityService;
import com.home.record.mapper.TourCityMapper;
import com.home.record.vo.TourCityVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
* @author Administrator
* @description 针对表【tour_city】的数据库操作Service实现
* @createDate 2023-04-11 14:56:48
*/
@Service
public class TourCityServiceImpl extends ServiceImpl<TourCityMapper, TourCity>
implements TourCityService{

    @Resource
    private TourCityMapper tourCityMapper;

    @Override
    public Page<TourCityVo> tourCityPage(Integer pageNum, Integer pageSize, String search, String strTime, String endTime) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat ("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
        TourCityVo tourCityVo = new TourCityVo();
        tourCityVo.setFriendName(search);
//        try {
            if(StringUtils.isNotBlank(strTime)){
                tourCityVo.setTourStaTime(strTime);
            }
            if(StringUtils.isNotBlank(endTime)) {
                tourCityVo.setTourEndTime(endTime);
            }
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        LambdaQueryWrapper<TourCityVo> query = new LambdaQueryWrapper<>();
//        if(StringUtils.isNotBlank(search)){
//            query.like(TourCity::getCity, search);
//        }
//        if(StringUtils.isNotBlank(strTime)){
//            query.eq(TourCity::getTourStaTime, strTime);
//        }
//        if(StringUtils.isNotBlank(endTime)){
//            query.eq(TourCity::getTourEndTime,endTime);
//        }
        Page<TourCityVo> page1 = new Page<>(pageNum,pageSize);

        Page<TourCityVo> page = tourCityMapper.tourCityPage(page1,tourCityVo);
        return page;
    }
}
