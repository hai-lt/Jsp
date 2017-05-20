package models.bo;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import models.bean.Vacxin;
import models.dao.VacxinDAO;

public class VacxinBO {
  private VacxinDAO dao;
  
  public boolean delete(HttpServletRequest request) {
    HashMap<String, String> conditions = new HashMap<>();
    conditions.put(dao.ID_KEY, request.getAttribute("id") + "");
    return dao.delete(conditions);
  }
  
  public Vacxin find(HttpServletRequest request) {
    return new Vacxin();
  }
}
