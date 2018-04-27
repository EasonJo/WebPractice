package cn.e3mall.controller;

import cn.e3mall.common.pojo.EasyUITreeNote;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.content.service.ContentCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Eason
 * @date Create in 17:51 25/04/2018
 */
@Controller
public class ContentCatController {

    @Resource(name = "contentCategoryService")
    private ContentCategoryService contentCategoryService;


    @RequestMapping("/content/category/list")
    @ResponseBody
    public List<EasyUITreeNote> getContentCatList(@RequestParam(name = "id", defaultValue = "0") long parentId) {
        return contentCategoryService.getContentCatList(parentId);
    }

    @RequestMapping(value = "/content/category/create",method = RequestMethod.POST)
    @ResponseBody
    public E3Result createContentCategory(Long parenId,String name){
        return contentCategoryService.addContentCategory(parenId,name);
    }
}
