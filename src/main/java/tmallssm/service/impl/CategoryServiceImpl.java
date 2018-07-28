package tmallssm.service.impl;
import tmallssm.mapper.CategoryMapper;
import tmallssm.pojo.Category;
import tmallssm.service.CategoryService;
import tmallssm.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl  implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
//    @Override
//    public List<Category> list(Page page){
//        return categoryMapper.list(page);
//    }
//    @Override
//    public int total(){
//        return categoryMapper.total();
//    }
    @Override
    public List<Category> list(){
        return categoryMapper.list();
    }
    @Override
    public void add(Category category){
        categoryMapper.add(category);
    }
    @Override
    public void delete(int id){
        categoryMapper.delete(id);
    }

    @Override
    public Category get(int id){
        return categoryMapper.get(id);
    }

    @Override
    public void update(Category category){
        categoryMapper.update(category);
    }
}