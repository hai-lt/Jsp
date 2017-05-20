package models.bo;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import models.bean.Vacxin;
import models.dao.VacxinDAO;

public class VacxinBO {
  private VacxinDAO dao;

  public VacxinBO() {
    super();
    this.dao = new VacxinDAO();
  }

  public boolean delete(HttpServletRequest request) {
    HashMap<String, String> conditions = new HashMap<>();
    conditions.put(VacxinDAO.ID_KEY, (String) request.getAttribute("id"));
    return dao.delete(conditions);
  }

  public Vacxin find(HttpServletRequest request) {
    HashMap<String, String> conditions = new HashMap<>();
    conditions.put(VacxinDAO.ID_KEY, request.getParameter("id") + "");
    return dao.find(conditions);
  }
}
