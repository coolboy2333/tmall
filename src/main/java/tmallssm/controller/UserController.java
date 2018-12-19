package tmallssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tmallssm.pojo.User;
import tmallssm.service.UserService;
import tmallssm.util.Page;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("admin_user_list")
    public String list(Model model, Page page) {
        PageHelper.offsetPage(page.getStart(), page.getCount());

        List<User> users = userService.list();

        int total = (int) new PageInfo<>(users).getTotal();
        page.setTotal(total);

        model.addAttribute("page", page);
        model.addAttribute("users", users);
        return "admin/listUser";
    }
}
