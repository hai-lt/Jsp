package models.bo;

import java.util.ArrayList;
import java.util.HashMap;

import models.bean.User;
import models.dao.UserDAO;

public class IndexBO {
  UserDAO dao;

  public IndexBO() {
    super();
    this.dao = new UserDAO();
  }
  
  public ArrayList<User> search(Object username) {
    HashMap<String, String> keys = new HashMap<>();
    if (username != null && !username.equals("")) {
      keys.put("username", username +"");
    }
    return dao.all(keys);
  }
}
