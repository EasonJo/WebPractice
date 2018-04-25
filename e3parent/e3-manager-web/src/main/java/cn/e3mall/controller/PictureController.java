package cn.e3mall.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * 文件上传的 controller
 *
 * @author Eason
 * @date Create in 14:39 25/04/2018
 */
@Controller
public class PictureController {


    @Value("${PIC_URL}")
    private String pic_url;

    /**
     * file upload
     *
     * @param multipartFile {@link MultipartFile}
     * @return map
     */
    @RequestMapping(value = "" ,produces = MediaType.TEXT_PLAIN_VALUE + ";charset=utf-8 ")
    @ResponseBody
    public Map uploadFile(MultipartFile multipartFile) {

        //把图片上传到文件服务器

        //得到一个图片的地址和文件名

        //补充为完整 url

        //封装到 map 中返回

        return null;
    }
}
