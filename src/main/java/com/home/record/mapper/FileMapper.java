package com.home.record.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.home.record.entity.ImageFile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Administrator
* @description 针对表【file】的数据库操作Mapper
* @createDate 2023-04-08 15:15:16
* @Entity com.home.record.entity.File
*/
@Mapper
public interface FileMapper extends BaseMapper<ImageFile> {

    public List<ImageFile> welcomeImg();

}
