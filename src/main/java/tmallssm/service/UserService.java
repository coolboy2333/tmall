package tmallssm.service;

import tmallssm.pojo.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void delete(int id);
    void update(User user);
    User get(int id);
    List<User> list();

}
