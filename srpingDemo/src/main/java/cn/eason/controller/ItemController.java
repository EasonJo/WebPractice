package cn.eason.controller;

import cn.eason.domain.Items;
import cn.eason.domain.QueryVo;
import cn.eason.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Eason
 * @date Create in 10:50 20/04/2018
 */
@Controller()
public class ItemController {

    @Resource(name = "productService")
    private ProductService productService;

    @RequestMapping(value = "/item/itemlist.action")
    public ModelAndView itemList() {
        ModelAndView modelAndView = new ModelAndView();

        List<Items> items = productService.getAllProducts();

        modelAndView.addObject("itemList", items);
        modelAndView.setViewName("/itemList");
        return modelAndView;
    }

    @RequestMapping(value = "/itemEdit.action")
    public ModelAndView findItemsById(Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        Items items = productService.findItemsById(id);
        modelAndView.addObject("item", items);
        modelAndView.setViewName("/editItem");
        return modelAndView;
    }

    @RequestMapping("/updateitem.action")
    public String updateItems(Items items, Model model) {
        productService.updateItems(items);
        return "success";
    }

    @RequestMapping("/deletes.action")
    public String deleteMore(QueryVo vo) {
        return "success";
    }

    @RequestMapping("/updates.action")
    public String updates(QueryVo vo) {

        for (Items items1 : vo.getItemsList()) {
            System.out.println(items1);

        }
        return "success";
    }

}
