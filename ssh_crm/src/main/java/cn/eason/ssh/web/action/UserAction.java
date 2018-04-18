package cn.eason.ssh.web.action;

import cn.eason.domain.User;
import cn.eason.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @author Eason
 * @date Create in 17:44 17/04/2018
 */

@Controller("userAction")
@Scope(scopeName = "prototype")
public class UserAction extends ActionSupport implements ModelDriven<User> {

    @Resource(name = "userService")
    private UserService userService;

    public String login(){
        System.out.println(userService);
        User u = userService.getUserByCode(user);
        ActionContext.getContext().getSession().put("user", u);
        return "toHome";
    }

    private User user = new User();

    @Override
    public User getModel() {
        return user;
    }
}
