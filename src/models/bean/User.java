package models.bean;

public class User {
  private String id, username, password, token;

  public User(String... strings) {
    setAttributes(strings);
  }

  public User() {

  }

  public void setAttributes(String... strings) {
    id = strings[0];
    username = strings[1];
    password = strings[2];
    token = strings[3];
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
