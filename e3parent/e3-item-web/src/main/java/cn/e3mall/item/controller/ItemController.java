package cn.e3mall.item.controller;

import cn.e3mall.item.pojo.Item;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemDesc;
import cn.e3mall.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * 商品详情页面展示
 *
 * @author Eason
 * @date Create in 14:44 28/04/2018
 */

@Controller
public class ItemController {

    @Resource(name = "itemService")
    private ItemService itemService;


    @RequestMapping("/item/{itemId}")
    public String showItemInfo(@PathVariable long itemId, Model model) {

        TbItem tbItem = itemService.getItemById(itemId);

        TbItemDesc tbItemDesc = itemService.getItemDescById(itemId);

        model.addAttribute("item", new Item(tbItem));
        model.addAttribute("itemDesc", tbItemDesc);

        return "item";
    }
}
