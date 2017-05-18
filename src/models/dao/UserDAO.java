package models.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import models.bean.User;

public class UserDAO {
  public static final String TABLE_NAME = "users";
  public static final String ID_KEY = "id";
  public static final String USERNAME_KEY = "username";
  public static final String PASSWORD_KEY = "password";
  public static final String TOKEN_KEY = "token";
  public static int columns;
  private static HelperDAO helper;

  public static HelperDAO getHelper() {
    if (helper == null) {
      helper = new HelperDAO() {

        @Override
        public String getTableName() {
          return TABLE_NAME;
        }
      };
    }
    return helper;
  }

  public ArrayList<User> getAll() {
    ArrayList<User> users = new ArrayList<>();
    for (String[] strings : getHelper().all()) {
      users.add(new User(strings));
    }
    return users;
  }

  public User findBy(HashMap<String, String> conditions) {
    String userAttributes[] = getHelper().findBy(conditions);
    if (userAttributes == null)
      return null;
    return new User(userAttributes);
  }

  public User create(HashMap<String, String> attributes) {
    try {
      getHelper().create(attributes);
      return findBy(attributes);
    } catch (SQLException e) {
      return null;
    }
  }

  public ArrayList<User> all(HashMap<String, String> conditions) {
    ArrayList<User> users = new ArrayList<>();
    for (String[] strings : getHelper().all(conditions)) {
      users.add(new User(strings));
    }
    return users;
  }

  public boolean delete(HashMap<String, String> condition) {
    try {
      getHelper().destroy(condition);
      return true;
    } catch (SQLException e) {
      return false;
    }
  }

  public boolean update(HashMap<String, String> attrs, HashMap<String, String> conditions) {
    try {
      getHelper().update(attrs, conditions);
      return true;
    } catch (SQLException e) {
      return false;
    }
  }

}
