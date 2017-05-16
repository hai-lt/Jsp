package models.bo;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;

import models.bean.User;
import models.dao.UserDAO;

public class LoginBO extends BaseBO {
  private UserDAO userDAO;

  public LoginBO() {
    userDAO = new UserDAO();
  }

  public User authenticate(String username, String password) {
    HashMap<String, String> condition = new HashMap<>();
    condition.put(UserDAO.USERNAME_KEY, username);
    condition.put(UserDAO.PASSWORD_KEY, password);
    User user = userDAO.findBy(condition);
    if (user == null) {
      return null;
    }
    user.setToken(generateToken(new Date().toString() + user.getUsername()));
    HashMap<String, String> attributes = new HashMap<>();
    attributes.put(UserDAO.TOKEN_KEY, user.getToken());
    try {
      UserDAO.getHelper().update(attributes, condition);
    } catch (SQLException e) {
      user.setToken(e.getMessage());
      e.printStackTrace();
    }
    return user;
  }
}
