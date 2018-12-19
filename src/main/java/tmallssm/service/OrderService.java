package tmallssm.service;

import tmallssm.pojo.Order;
import tmallssm.pojo.OrderItem;

import java.util.List;

public interface OrderService {

    void add(Order o);

    void delete(int id);

    void update(Order o);

    Order get(int id);

    List<Order> list();
    List list(int uid, String excludedStatus);

    float add(Order c,List<OrderItem> ois);

    String waitPay = "waitPay";
    String waitDelivery = "waitDelivery";
    String waitConfirm = "waitConfirm";
    String waitReview = "waitReview";
    String finish = "finish";
    String delete = "delete";
}
