package cn.cunchang.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author cunchang
 * @date 2021/2/15 4:29 下午
 */
public class FileUploadUtil {

    protected static Logger logger = LogManager.getLogger(FileUploadUtil.class);

    public static String realPath;

    static {
        realPath = System.getProperty("user.home")+"/upload/";
        FileIsExists.createDirectory(realPath);
    }

    /**
     * @param multipartFile 文件
     * @return
     */
    public static String upload(MultipartFile multipartFile) {
        String originalFileName = multipartFile.getOriginalFilename();
        String extension = originalFileName.substring(originalFileName.lastIndexOf('.'));
        String fileName = UUIDGenerator.generateUUID() + extension;
        // 文件全路径
        String fullFilePath = realPath + fileName;

        logger.info("文件上传路径：{}", fullFilePath);
        JSONObject jsonObject = new JSONObject();
        try {
            logger.info("文件上传中...");
            multipartFile.transferTo(new File(fullFilePath));
            logger.info("文件上传成功！");
            jsonObject.put("success", true);
            jsonObject.put("fileUrl", realPath + fileName);
        } catch (IOException e) {
            logger.warn("文件上传失败！");
            e.printStackTrace();
            jsonObject.put("success", false);
        }
        return jsonObject.toJSONString();
    }

}
