package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import config.Database;

public abstract class BaseModel {
  public abstract String getTableName();

  public abstract ArrayList<String> getAttributesName();

  public abstract int getColumn();

  public ArrayList<HashMap<String, String>> all() {
    ArrayList<HashMap<String, String>> data = new ArrayList<>();
    String query = "select * from " + getTableName();
    try {
      ResultSet result = Database.getInstance().getStatement().executeQuery(query);
      while(result.next()) {
        HashMap<String, String> row = new HashMap<>();
        for (int i = 1; i <= getColumn(); i++) {
            row.put(getAttributesName().get(i - 1), result.getString(i));
        }
        data.add(row);
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return data;
  }

  public ArrayList<HashMap<String, String>> all(String condition) {
    ArrayList<HashMap<String, String>> data = new ArrayList<>();
    String query = "select * from " + getTableName() + " where " + condition;
    try {
      ResultSet result = Database.getInstance().getStatement().executeQuery(query);
      while(result.next()) {
        HashMap<String, String> row = new HashMap<>();
        for (int i = 1; i <= getColumn(); i++) {
            row.put(getAttributesName().get(i - 1), result.getString(i));
        }
        data.add(row);
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return data;
  }

  public HashMap<String, String> findBy(HashMap<String, String> object) {
    String condition = "";
    for (String key : object.keySet()) {
      condition += key + " = " + object.get(key); 
    }
    ArrayList<HashMap<String, String>> objects = all(condition);
    if (objects.size() == 0) {
      return new HashMap<>();
    }
    return all(condition).get(0);
  }
  

  public HashMap<String, String> findBy(long id) {
    String condition = "id = " + id;
    ArrayList<HashMap<String, String>> objects = all(condition);
    if (objects.size() == 0) {
      return new HashMap<>();
    }
    return all(condition).get(0);
  }
}
