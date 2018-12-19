package tmallssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tmallssm.mapper.OrderItemMapper;
import tmallssm.pojo.Order;
import tmallssm.pojo.OrderItem;
import tmallssm.pojo.OrderItemExample;
import tmallssm.pojo.Product;
import tmallssm.service.OrderItemService;
import tmallssm.service.ProductService;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    OrderItemMapper orderItemMapper;
    @Autowired
    ProductService productService;

    @Override
    public void add(OrderItem oi) {
        orderItemMapper.insert(oi);
    }

    @Override
    public void delete(int id) {
        orderItemMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(OrderItem oi) {
        orderItemMapper.updateByPrimaryKeySelective(oi);
    }

    @Override
    public OrderItem get(int id) {
        OrderItem result = orderItemMapper.selectByPrimaryKey(id);
        setProduct(result);
        return result;
    }

    @Override
    public List<OrderItem> list() {
        OrderItemExample example = new OrderItemExample();
        example.setOrderByClause("id desc");
        return orderItemMapper.selectByExample(example);
    }

    @Override
    public void fill(Order o) {
        //根据订单id查询出其对应的所有订单项
        OrderItemExample example = new OrderItemExample();
        example.createCriteria().andOidEqualTo(o.getId());
        example.setOrderByClause("id desc");
        List<OrderItem> ois = orderItemMapper.selectByExample(example);

        //通过setProduct为所有的订单项设置Product属性
        setProduct(ois);
        //遍历所有的订单项，然后计算出该订单的总金额和总数量
        float total = 0;
        int totalNumber = 0;
        for (OrderItem oi : ois) {
            total += oi.getNumber() * oi.getProduct().getPromotePrice();
            totalNumber += oi.getNumber();
        }
        o.setTotal(total);
        o.setTotalNumber(totalNumber);
        //最后再把订单项设置在订单的orderItems属性上。
        o.setOrderItems(ois);
    }

    @Override
    public void fill(List<Order> os) {
        for (Order o : os) {
            fill(o);
        }
    }

    public void setProduct(OrderItem oi) {
        Product p = productService.get(oi.getPid());
        productService.setFirstProductImage(p);
        oi.setProduct(p);
    }

    public void setProduct(List<OrderItem> ois) {
        for (OrderItem oi : ois) {
            setProduct(oi);
        }
    }

    @Override
    public int getSaleCount(int pid) {
        OrderItemExample example = new OrderItemExample();
        example.createCriteria().andPidEqualTo(pid);
        List<OrderItem> ois = orderItemMapper.selectByExample(example);
        int result = 0;
        for (OrderItem oi : ois) {
            result += oi.getNumber();
        }
        return result;
    }

    @Override
    public List<OrderItem> listByUser(int uid) {
        //用户的订单项
        OrderItemExample example =new OrderItemExample();
        example.createCriteria().andUidEqualTo(uid).andOidIsNull();
        List<OrderItem> result =orderItemMapper.selectByExample(example);
        setProduct(result);
        return result;
    }
}
