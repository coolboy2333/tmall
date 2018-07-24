package tmallssm.controller;

import tmallssm.pojo.Category;
import tmallssm.service.CategoryService;
import tmallssm.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @RequestMapping("admin_category_list")
    public String list(Model model, Page page){
        List<Category> cs=categoryService.list(page);
        int total=categoryService.total();
        page.setTotal(total);
        model.addAttribute("cs",cs);
        model.addAttribute("page",page);//
        return "admin/listCategory";
    }
}
