package com.home.record.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.home.record.entity.TourCity;
import com.home.record.vo.TourCityVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author Administrator
* @description 针对表【tour_city】的数据库操作Mapper
* @createDate 2023-04-11 14:56:48
* @Entity com.home.record.entity.TourCity
*/
@Mapper
public interface TourCityMapper extends BaseMapper<TourCity> {

//    @Select("select c.city,g.place from tour_city c left join go_with_friend g on c.friend_id = g.id ${ew.customSqlSegment}")
    Page<TourCityVo> tourCityPage(Page<TourCityVo> page, @Param("tourCityVo") TourCityVo tourCityVo);
}
