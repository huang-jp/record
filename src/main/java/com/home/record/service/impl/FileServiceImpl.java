package com.home.record.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.home.record.entity.ImageFile;
import com.home.record.service.FileService;
import com.home.record.mapper.FileMapper;
import com.home.record.util.FileUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
* @author Administrator
* @description 针对表【file】的数据库操作Service实现
* @createDate 2023-04-08 15:15:16
*/
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, ImageFile>
implements FileService{

    @Resource
    private FileMapper fileMapper;

    @Override
    public List<ImageFile> welcomeImg() {
        List<ImageFile> wel = fileMapper.welcomeImg();
        try {
            for (ImageFile imageFile : wel) {
                String[] split = imageFile.getFileName().split("\\.");
                imageFile.setFilePath("data:image/"+split[split.length-1]+";base64,"+FileUtil.convertBase64(imageFile.getFilePath()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wel;
    }
}
