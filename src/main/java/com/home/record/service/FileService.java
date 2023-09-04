package com.home.record.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.home.record.entity.ImageFile;

import java.util.List;


/**
 * @author Administrator
 * @description 针对表【file】的数据库操作Service
 * @createDate 2023-04-08 15:15:16
 */
public interface FileService extends IService<ImageFile> {

    public List<ImageFile> welcomeImg();
}
