package cn.cunchang.controller;

import cn.cunchang.util.FileUploadUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author cunchang
 * @date 2020/12/26 9:57 下午
 */
@Api(value = "用户页面接口", description = "")
@Slf4j
@RestController
public class FileController {

    @ApiOperation(value = "文件上传", notes = "文件上传")
    @PostMapping("/upload")
    public String fileUpload(@RequestParam("file") MultipartFile file) {
        return FileUploadUtil.upload(file);
    }

}
