package models.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import config.Database;

public abstract class HelperDAO {

  public abstract String getTableName();

  public ArrayList<String[]> all() {
    String query = "select * from " + getTableName();
    return query(query);
  }

  public ArrayList<String[]> all(String condition) {
    String query = "select * from " + getTableName() + " where " + condition;
    return query(query);
  }

  public String[] findBy(HashMap<String, String> object) {
    String condition = "";
    for (String key : object.keySet()) {
      condition += key + " = '" + object.get(key) + "' AND ";
    }
    if (!condition.equals("")) {
      condition = condition.substring(0, condition.length() - 4);
    }
    ArrayList<String[]> objects = all(condition);
    if (objects.size() == 0) {
      return null;
    }
    return all(condition).get(0);
  }

  public ArrayList<String[]> query(String query) {
    ArrayList<String[]> data = new ArrayList<>();
    try {
      ResultSet result = Database.getInstance().getStatement().executeQuery(query);
      while (result.next()) {
        String attributes[] = new String[result.getMetaData().getColumnCount()];
        for (int i = 1; i <= result.getMetaData().getColumnCount(); i++) {
          attributes[i - 1] = result.getString(i);
        }
        data.add(attributes);
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return data;
  }

  public String[] find(long id) {
    String condition = "id = " + id;
    ArrayList<String[]> objects = all(condition);
    if (objects.size() == 0) {
      return null;
    }
    return all(condition).get(0);
  }

  public boolean destroy(String condition) {
    String query = "DELETE * FROM " + getTableName();
    if (!condition.equals("") || condition != null) {
      query += " where " + condition;
    }
    try {
      return Database.getInstance().getConnection().prepareStatement(query).execute();
    } catch (SQLException e) {
      System.out.println(getClass().getSimpleName() + ": " + e.getMessage());
      return false;
    }
  }

  public boolean create(HashMap<String, String> record) throws SQLException {
    String keys;
    String values;
    if (record.isEmpty()) {
      keys = "()";
      values = "()";
    } else {
      keys = "(";
      values = "('";
      for (String key : record.keySet()) {
        keys += key + ", ";
        values += record.get(key) + "', '";
      }
      keys = keys.substring(0, keys.length() - 2) + ")";
      values = values.substring(0, values.length() - 3) + ");";
    }
    String query = "insert into " + getTableName() + " " + keys + " VALUES " + values;
    Database.getInstance().getStatement().executeUpdate(query);
    return true;
  }

  public void update(HashMap<String, String> attributes, HashMap<String, String> condition) throws SQLException {
    if (attributes.keySet().size() == 0) {
      return;
    }
    String query = "UPDATE " + getTableName() + " SET ";
    String setOfAttributes = "";
    for (String key : attributes.keySet()) {
      setOfAttributes += key + " = '" + attributes.get(key) + "', ";
    }
    query += setOfAttributes.substring(0, setOfAttributes.length() - 2);

    String con = "";
    if (condition != null && !condition.isEmpty()) {
      for (String key : condition.keySet()) {
        con += key + " = '" + condition.get(key) + "', ";
      }
      query += " WHERE " + con.substring(0, con.length() - 2);
    }
    Database.getInstance().getStatement().executeLargeUpdate(query);
  }

  public boolean destroy(HashMap<String, String> record) throws SQLException {
    String query = "DELETE FROM " + getTableName() + " ";
    if (record != null) {
      query += " WHERE ";
      for (String key : record.keySet()) {
        query += "`" + getTableName() + "`.`" + key + "` = '" + record.get(key) + "'AND ";
      }
      query = query.substring(0, query.length() - 4);
    }
    Database.getInstance().getStatement().execute(query);
    return true;
  }

}
