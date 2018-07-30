package tmallssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tmallssm.mapper.PropertyValueMapper;
import tmallssm.pojo.Category;
import tmallssm.pojo.Product;
import tmallssm.pojo.PropertyValue;
import tmallssm.service.CategoryService;
import tmallssm.service.ProductService;
import tmallssm.service.PropertyService;
import tmallssm.service.PropertyValueService;

import java.util.List;

@Controller
@RequestMapping("")
public class PropertyValueController {
    @Autowired
    PropertyValueService propertyValueService;
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping("admin_propertyValue_edit")
    public String edit(Model model,int pid){
        Product p=productService.get(pid);
        Category c=categoryService.get(p.getCid());
        p.setCategory(c);
        propertyValueService.init(p);
        List<PropertyValue> pvs=propertyValueService.list(pid);

        model.addAttribute("p",p);
        model.addAttribute("pvs",pvs);

        return "admin/editPropertyValue";
    }

    @RequestMapping("admin_propertyValue_update")
    @ResponseBody
    //@ResponseBody 注解表示该方法的返回的结果直接写入 HTTP 响应正文（ResponseBody）中，
    // 一般在异步获取数据时使用，通常是在使用 @RequestMapping 后，返回值通常解析为跳转路径，
    // 加上 @ResponseBody 后返回结果不会被解析为跳转路径，而是直接写入HTTP 响应正文中。
    public String update(PropertyValue pv){
        //因为post传了{"value":value,"id":pvid},
        //这儿接收value和id
        System.out.println(pv.getId()+","+pv.getValue());
        propertyValueService.update(pv);
        return "success";

    }
}
