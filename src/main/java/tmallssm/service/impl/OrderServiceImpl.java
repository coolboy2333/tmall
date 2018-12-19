package tmallssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tmallssm.mapper.OrderMapper;
import tmallssm.pojo.Order;
import tmallssm.pojo.OrderExample;
import tmallssm.pojo.User;
import tmallssm.service.OrderService;
import tmallssm.service.UserService;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Autowired
    UserService userService;

    @Override
    public void add(Order o) {
        orderMapper.insert(o);
    }

    @Override
    public void delete(int id) {
        orderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Order o) {
        orderMapper.updateByPrimaryKeySelective(o);
    }

    @Override
    public Order get(int id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Order> list() {
        OrderExample example = new OrderExample();
        example.setOrderByClause("id desc");
        List<Order> os = orderMapper.selectByExample(example);
        setUser(os);
        return os;
    }

    public void setUser(Order o) {
        User user = userService.get(o.getUid());
        o.setUser(user);
    }

    public void setUser(List<Order> os) {
        for (Order o : os) {
            setUser(o);
        }
    }
}
