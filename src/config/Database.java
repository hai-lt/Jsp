package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
  private static Database instance;
  private Connection connection;

  private Database() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      String url = "jdbc:mysql://localhost:3306/jsp";
      connection = DriverManager.getConnection(url, "root", "111111");
    } catch (Exception e) {
      System.out.println("Could not connect: " + e.getMessage());
    }
  }

  private Database(String net, int port, String username, String password, String dbname) {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      String url = "jdbc:mysql://" + net + ":" + port + "/" + dbname;
      connection = DriverManager.getConnection(url, username, password);
    } catch (Exception e) {
      System.out.println("Could not connect: " + e.getMessage());
    }
  }

  public Statement getStatement() {
    try {
      return connection.createStatement();
    } catch (SQLException e) {
      return null;
    }
  }

  public Connection getConnection() {
    return connection;
  }

  public static Database getInstance() {
    if (instance != null) {
      return instance;
    }

    synchronized (Database.class) {
      if (instance != null) {
        return instance;
      }
      return instance = new Database();
    }
  }

}
