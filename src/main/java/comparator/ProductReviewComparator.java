package comparator;

import tmallssm.pojo.Product;

import java.util.Comparator;

public class ProductReviewComparator implements Comparator<Product> {
    //人气比较器
    @Override
    public int compare(Product p1, Product p2) {
        return p2.getReviewCount()-p1.getReviewCount();
    }
}
