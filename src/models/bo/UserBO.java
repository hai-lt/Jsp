package models.bo;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import models.bean.User;
import models.dao.UserDAO;

public class UserBO extends BaseBO {
  private UserDAO dao;

  public UserBO() {
    super();
    this.dao = new UserDAO();
  }

  public boolean delete(HttpServletRequest request) {
    HashMap<String, String> condition = new HashMap<>();
    condition.put("id", request.getParameter("id"));
    return dao.delete(condition);
  }

  public User findBy(HttpServletRequest request) {
    HashMap<String, String> condition = new HashMap<>();
    condition.put(UserDAO.ID_KEY, request.getParameter("id"));
    return dao.findBy(condition);
  }

  public boolean update(HttpServletRequest request) {
    HashMap<String, String> attributes = new HashMap<>();
    attributes.put(UserDAO.USERNAME_KEY, request.getParameter("username"));
    attributes.put(UserDAO.PASSWORD_KEY, request.getParameter("password"));
    HashMap<String, String> condition = new HashMap<>();
    condition.put(UserDAO.ID_KEY, request.getParameter("id"));
    return dao.update(attributes, condition);
  }
}
