package cn.e3mall.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Eason
 * @date Create in 16:15 25/04/2018
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String showIndex() {
        return "index";
    }
}
