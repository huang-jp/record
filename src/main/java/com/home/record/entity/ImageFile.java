package com.home.record.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName file
 */
@TableName("image_file")//与数据库表明对应
@Data
public class ImageFile implements Serializable {
    @TableId(type = IdType.AUTO)//主键id自动生成
    private Integer id;
    private String fileName;
    private String filePath;
    private String season;
    private Date createTime;
    private Date updateTime;
}