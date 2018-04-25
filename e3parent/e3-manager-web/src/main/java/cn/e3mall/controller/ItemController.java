package cn.e3mall.controller;

import cn.e3mall.common.pojo.EasyUIDataResult;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author Eason
 * @date Create in 19:34 23/04/2018
 */
@Controller
public class ItemController {

    @Resource(name = "itemService")
    private ItemService itemService;

    @RequestMapping("/item/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable Long itemId) {
        TbItem tbItem = itemService.getItemById(itemId);
        System.out.println(tbItem);
        return tbItem;
    }

    @RequestMapping("/item/list")
    @ResponseBody
    public EasyUIDataResult<TbItem> getItemList(Integer page, Integer rows) {
        return itemService.getItemList(page, rows);
    }


    @RequestMapping(value = "/item/save", method = RequestMethod.POST)
    @ResponseBody
    public E3Result addItem(TbItem item, String desc) {
        return itemService.addItem(item, desc);
    }
}
