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
    if (username != null && !username.equals("")) {
      String query = "SELECT * FROM users WHERE username LIKE '%" + username + "%'";
      return dao.query(query);
    }
    return dao.all(new HashMap<>());
  }
}
