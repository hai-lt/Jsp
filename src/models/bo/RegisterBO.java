package models.bo;

import java.util.HashMap;

import models.bean.User;
import models.dao.UserDAO;

public class RegisterBO {
  private UserDAO userDAO;
  private User user;
  
  public boolean register(String username, String password, String passwordConfirmation) {
    if (username == null || username.equals("") || !password.equals(passwordConfirmation)) {
      return false;
    }
    HashMap<String, String> attributes = new HashMap<>();
    attributes.put(UserDAO.PASSWORD_KEY, password);
    attributes.put(UserDAO.USERNAME_KEY, username);
    user = userDAO.create(attributes);
    if (user == null) {
      return false;
    }
    return true;
  }

  public RegisterBO() {
    this.userDAO = new UserDAO();
  }
}
