package com.home.record.util;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.Objects;

public class FileUtil {

    /**
     * 把文件转为base64
     * @param path
     * @return
     * @throws Exception
     */
    public static String convertBase64(String path) throws Exception {
        if(StringUtils.isBlank(path)){
            throw new Exception("path is null");
        }else {
            return convertBase64(new File(path));
        }
    }

    /**
     * 文件转为Base64
     * @param file
     * @return
     * @throws Exception
     */
    public static String convertBase64(File file) throws Exception {
        if(Objects.isNull(file)){
            throw new Exception("file is null");
        }else if(!file.exists()){
            throw new Exception("file is not exists");
        }else{
            StringBuilder result = new StringBuilder();
            byte[] data = FileUtils.readFileToByteArray(file);
            return result.append(Base64.getEncoder().encodeToString(data)).toString();
        }
    }

    /**
     * base64转File
     * @param code
     * @param path
     * @return
     * @throws IOException
     */
    public static File base64ToFile(String code, String path) throws IOException {
        File file = new File(path);
        byte[] data = Base64.getDecoder().decode(code);
        FileUtils.writeByteArrayToFile(file, data);
        return file;
    }
}
