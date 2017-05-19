package models.dao;

import java.util.ArrayList;
import java.util.HashMap;

import models.bean.Vacxin;

public class VacxinDAO {
  public static String TABLE_NAME = "vacxins";
  public static String ID_KEY = "id";
  public static String ID_NAME = "name";
  public static String ID_DESCRIPTION = "description";
  public static String ID_PRICE = "price";
  public static String ID_INJECTING_COUNTS = "injecting_counts";
  public static String ID_SUPPLIER = "supplier";
  private static HelperDAO helper;

  public HelperDAO getHelper() {
    if (helper != null)
      return helper;
    return helper = new HelperDAO() {

      @Override
      public String getTableName() {
        return TABLE_NAME;
      }
    };
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

}