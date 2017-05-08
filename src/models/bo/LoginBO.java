package models.bo;

import java.util.HashMap;

import models.dao.UserDAO;

public class LoginBO {
  public boolean isExist(String username, String password) {
    HashMap<String, String> condition = new HashMap<>();
    condition.put(UserDAO.USERNAME_KEY, username);
    condition.put(UserDAO.PASSWORD_KEY, password);
    return new UserDAO().getHelper().findBy(condition) != null;
  }
}
