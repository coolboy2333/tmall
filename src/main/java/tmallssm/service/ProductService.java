package tmallssm.service;

import tmallssm.pojo.Category;
import tmallssm.pojo.Product;

import java.util.List;

public interface ProductService {
    void add(Product product);
    void delete(int id);
    void update(Product product);
    Product get(int id);
    List<Product> list(int cid);
    void setFirstProductImage(Product p);
    void setFirstProductImage(List<Product> p);

    void fill(Category c);
    void fill(List<Category> cs);
    void fillByRow(List<Category> cs);
}
