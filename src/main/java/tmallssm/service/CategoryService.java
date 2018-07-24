package tmallssm.service;
import tmallssm.pojo.Category;
import tmallssm.util.Page;

import java.util.List;
public interface CategoryService{
    int total();
    List<Category> list(Page page);
}