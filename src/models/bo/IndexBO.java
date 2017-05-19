package models.bo;

import java.util.ArrayList;
import java.util.HashMap;

import models.bean.Vacxin;
import models.dao.VacxinDAO;

public class IndexBO {
  VacxinDAO dao;

  public IndexBO() {
    super();
    this.dao = new VacxinDAO();
  }

  public ArrayList<Vacxin> search(Object name) {
    if (name != null && !name.equals("")) {
      String query = "SELECT * FROM users WHERE " + dao.ID_NAME + " LIKE '%" + name + "%'";
      return dao.query(query);
    }
    return dao.all(new HashMap<>());
  }
}
