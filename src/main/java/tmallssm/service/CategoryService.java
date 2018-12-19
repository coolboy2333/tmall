package tmallssm.service;

import tmallssm.pojo.Category;
import tmallssm.util.Page;

import java.util.List;

public interface CategoryService {
    //    int total();
//    List<Category> list(Page page);
    List<Category> list();

    void add(Category category);

    void delete(int id);

    Category get(int id);

    void update(Category category);
}