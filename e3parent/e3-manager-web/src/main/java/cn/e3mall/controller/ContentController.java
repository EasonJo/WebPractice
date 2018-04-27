package cn.e3mall.controller;

import cn.e3mall.common.utils.E3Result;
import cn.e3mall.content.service.ContentService;
import cn.e3mall.pojo.TbContent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author Eason
 * @date Create in 14:49 26/04/2018
 */
@Controller
public class ContentController {


    @Resource(name = "contentService")
    private ContentService contentService;

    @RequestMapping(value = "/content/save", method = RequestMethod.POST)
    @ResponseBody
    public E3Result addContent(TbContent tbContent) {
        return contentService.addContent(tbContent);
    }

}
