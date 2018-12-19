package tmallssm.service;

import tmallssm.pojo.Order;
import tmallssm.pojo.OrderItem;

import java.util.List;

public interface OrderItemService {
    void add(OrderItem oi);

    void delete(int id);

    void update(OrderItem oi);

    OrderItem get(int id);

    List<OrderItem> list();

    void fill(Order o);

    void fill(List<Order> os);

    int getSaleCount(int pid);

    List<OrderItem> listByUser(int uid);
}
