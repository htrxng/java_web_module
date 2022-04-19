package repository;

import model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IUserRepository {
    List<User> getUserList();


    void save(User user);

    User findById(Integer id) throws SQLException;

    void updateUser(User user);

    void remove(Integer id);

    List<User> search(String country);

    List<User> getListUseSP();
}
