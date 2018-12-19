package comparator;

import tmallssm.pojo.Product;

import java.util.Comparator;

public class ProductDateComparator implements Comparator<Product> {
    //新品比较器
    @Override
    public int compare(Product p1, Product p2) {
        return p2.getCreateDate().compareTo(p1.getCreateDate());
    }
}
