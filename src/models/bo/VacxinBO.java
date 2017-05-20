package models.bo;

import java.sql.SQLException;
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
    conditions.put(VacxinDAO.ID, (String) request.getAttribute("id"));
    return dao.delete(conditions);
  }

  public Vacxin find(HttpServletRequest request) {
    HashMap<String, String> conditions = new HashMap<>();
    conditions.put(VacxinDAO.ID, request.getParameter("id") + "");
    return dao.find(conditions);
  }

  public boolean update(HttpServletRequest request) {
    HashMap<String, String> attributes = getVacxin(request);

    HashMap<String, String> conditions = new HashMap<>();
    conditions.put(VacxinDAO.ID, request.getParameter("id"));
    return dao.update(attributes, conditions);
  }

  public boolean create(HttpServletRequest request) {
    try {
      dao.getHelper().create(getVacxin(request));
      return true;
    } catch (SQLException e) {
      return false;
    }
  }

  private HashMap<String, String> getVacxin(HttpServletRequest request) {
    HashMap<String, String> attributes = new HashMap<>();
    attributes.put(VacxinDAO.NAME, request.getParameter("name"));
    attributes.put(VacxinDAO.INJECTING_COUNTS, request.getParameter("injecting_counts"));
    attributes.put(VacxinDAO.PRICE, request.getParameter("price"));
    attributes.put(VacxinDAO.DESCRIPTION, request.getParameter("description"));
    attributes.put(VacxinDAO.SUPPLIER, request.getParameter("supplier"));
    return attributes;
  }
}
