package models.dao;

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
    return new User(getHelper().findBy(conditions));
  }

}
