package comparator;

import tmallssm.pojo.Product;

import java.util.Comparator;

public class ProductSaleCountComparator implements Comparator<Product> {
    //销量比较器
    @Override
    public int compare(Product p1, Product p2) {
        return p2.getSaleCount()-p1.getSaleCount();
    }
}
