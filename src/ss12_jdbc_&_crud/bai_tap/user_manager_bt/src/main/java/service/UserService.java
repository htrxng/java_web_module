package service;

import model.User;
import repository.IUserRepository;
import repository.impl.UserRepository;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService implements IUserSerivce {
    private  IUserRepository iUserRepository = new UserRepository();

    @Override
    public List<User> getUserList() {
        List<User> userList = iUserRepository.getListUseSP();
        return userList;
    }

    @Override
    public Map<String, String> save(User user) {
        Map<String, String> map = new HashMap<>();
        if (user.getName().equals("")) {
            map.put("name", "invalid name");
        }
        if (map.isEmpty()) {
            iUserRepository.save(user);
        }
        return map;
    }

    @Override
    public User findByID(Integer id) throws SQLException {
            return iUserRepository.findById(id);
    }

    @Override
    public String updateUser(User user) {
        String notice = "";
        if (user.getName().equals("")) {
            notice = "Username can not be empty!";
        } else if (!user.getName().matches("^[a-zA-Z ]+$")) {
            notice = "User Name is invalid!";
        }
        if (notice.equals("")) {
            iUserRepository.updateUser( user);
            notice = "Update successful!";
        }
        return notice;
    }

    @Override
    public void remove(Integer id) {
        iUserRepository.deleteUseSP(id);
    }

    @Override
    public List<User> search(String country) {
        return iUserRepository.search(country);
    }
}
