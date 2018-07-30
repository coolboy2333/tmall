package tmallssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tmallssm.mapper.CategoryMapper;
import tmallssm.mapper.ProductImageMapper;
import tmallssm.mapper.ProductMapper;
import tmallssm.pojo.Category;
import tmallssm.pojo.Product;
import tmallssm.pojo.ProductExample;
import tmallssm.pojo.ProductImage;
import tmallssm.service.ProductImageService;
import tmallssm.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    ProductImageService productImageService;

    @Override
    public void add(Product product) {
        productMapper.insert(product);
    }

    @Override
    public void delete(int id) {
        productMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Product product) {
        productMapper.updateByPrimaryKeySelective(product);
    }

    @Override
    public Product get(int id) {
        return productMapper.selectByPrimaryKey(id);
    }
    public void setCategory(Product p){
        int cid=p.getCid();
        Category c=categoryMapper.selectByPrimaryKey(cid);
        p.setCategory(c);
    }
    public void  setCategory(List<Product> ps){
        for (Product p : ps)
            setCategory(p);
    }
    @Override
    public List<Product> list(int cid) {
        ProductExample example=new ProductExample();
        example.createCriteria().andCidEqualTo(cid);
        example.setOrderByClause("id desc");
        List result=productMapper.selectByExample(example);
        setCategory(result);
        return result;
    }

    @Override
    public void setFirstProductImage(Product p) {
        List<ProductImage> pis=productImageService.list(p.getId(),productImageService.type_single);
        if (!pis.isEmpty()){
            ProductImage pi=pis.get(0);
            p.setFirstProductImage(pi);
        }
    }
    @Override
    public void setFirstProductImage(List<Product> ps){
        for (Product p:ps){
            setFirstProductImage(p);
        }
    }
}
