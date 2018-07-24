package tmallssm.mapper;

import tmallssm.pojo.Category;
import tmallssm.util.Page;

import java.util.List;

public interface CategoryMapper {
    public List<Category> list(Page page);
    public int total();

}
