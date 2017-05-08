package models;

import java.util.ArrayList;

public class User extends BaseModel {
  public static int columns;

  @Override
  public String getTableName() {
    return "users";
  }

  @Override
  public ArrayList<String> getAttributesName() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int getColumn() {
    if (columns < 1) {
      columns = getAttributesName().size(); 
    }
    return columns;
  }

}
