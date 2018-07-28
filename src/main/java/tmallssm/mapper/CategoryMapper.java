package tmallssm.mapper;

import tmallssm.pojo.Category;
import tmallssm.util.Page;

import java.util.List;

public interface CategoryMapper {
    List<Category> list(Page page);
    int total();
    void add(Category category);
    void delete(int id);
    Category get(int id);
    void update(Category category);
}
