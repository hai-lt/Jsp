package models.bo;

import javax.servlet.http.HttpServletRequest;

import models.bean.Vacxin;
import models.dao.VacxinDAO;

public class VacxinBO {
  private VacxinDAO dao;
  
  public boolean delete(HttpServletRequest request) {
    return true;
  }
  
  public Vacxin find(HttpServletRequest request) {
    return new Vacxin();
  }
}
