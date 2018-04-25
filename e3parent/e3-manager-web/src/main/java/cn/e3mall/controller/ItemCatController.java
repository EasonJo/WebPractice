package cn.e3mall.controller;

import cn.e3mall.common.pojo.EasyUITreeNote;
import cn.e3mall.service.ItemCatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Eason
 * @date Create in 16:55 24/04/2018
 */
@Controller
public class ItemCatController {

    @Resource(name = "itemCatService")
    private ItemCatService itemCatService;

    @RequestMapping("/item/cat/list")
    @ResponseBody
    public List<EasyUITreeNote> getItemCatList(@RequestParam(name = "id", defaultValue = "0") long id) {
        List<EasyUITreeNote> easyUITreeNotes = itemCatService.getItemCatList(id);
        return easyUITreeNotes;
    }
}
