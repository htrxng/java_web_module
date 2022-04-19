package service;

import model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IUserSerivce {
    List<User> getUserList();

     Map<String, String> save(User user);

    User findByID(Integer id) throws SQLException;


    String updateUser(User user);

    void remove(Integer id);

    List<User> search(String country);
}
