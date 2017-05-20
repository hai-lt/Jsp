package models.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import models.bean.Vacxin;

public class VacxinDAO {
  public static String TABLE_NAME = "vacxins";
  public static String ID = "id";
  public static String NAME = "name";
  public static String DESCRIPTION = "description";
  public static String PRICE = "price";
  public static String INJECTING_COUNTS = "injecting_counts";
  public static String SUPPLIER = "supplier";
  private static HelperDAO helper;

  public HelperDAO getHelper() {
    if (helper == null) {
      return helper = new HelperDAO() {

        @Override
        public String getTableName() {
          return TABLE_NAME;
        }
      };
    }
    return helper;
  }

  public ArrayList<Vacxin> all(HashMap<String, String> conditions) {
    ArrayList<Vacxin> vacxins = new ArrayList<>();
    for (String[] strings : getHelper().all(conditions)) {
      vacxins.add(new Vacxin(strings));
    }
    return vacxins;
  }

  public ArrayList<Vacxin> query(String query) {
    ArrayList<Vacxin> vacxins = new ArrayList<>();
    for (String[] strings : getHelper().query(query)) {
      vacxins.add(new Vacxin(strings));
    }
    return vacxins;
  }

  public Vacxin find(HashMap<String, String> conditions) {
    return new Vacxin(getHelper().findBy(conditions));
  }

  public boolean delete(HashMap<String, String> conditions) {
    try {
      return getHelper().destroy(conditions);
    } catch (SQLException e) {
      return false;
    }
  }

  public boolean update(HashMap<String, String> attributes, HashMap<String, String> conditions) {
    try {
      getHelper().update(attributes, conditions);
      return true;
    } catch (SQLException e) {
      return false;
    }
  }

}
