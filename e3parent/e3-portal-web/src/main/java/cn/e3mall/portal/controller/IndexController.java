package cn.e3mall.portal.controller;

import cn.e3mall.content.service.ContentService;
import cn.e3mall.pojo.TbContent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Eason
 * @date Create in 16:15 25/04/2018
 */
@Controller
public class IndexController {

    @Resource(name = "contentService")
    private ContentService contentService;

    @Value("${CONTENT_LUNBO}")
    private long cid;

    @RequestMapping("/index")
    public String showIndex(Model model) {
       List<TbContent> tbContents =  contentService.getContentListByCid(cid);
        model.addAttribute("ad1List",tbContents);
        return "index";
    }
}
