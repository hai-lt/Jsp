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

  public boolean update(HttpServletRequest request) {
    HashMap<String, String> attributes = new HashMap<>();
    attributes.put(VacxinDAO.ID_NAME, request.getParameter("name"));
    attributes.put(VacxinDAO.ID_INJECTING_COUNTS, request.getParameter("injecting_counts"));
    attributes.put(VacxinDAO.ID_PRICE, request.getParameter("price"));
    attributes.put(VacxinDAO.ID_DESCRIPTION, request.getParameter("description"));
    attributes.put(VacxinDAO.ID_SUPPLIER, request.getParameter("supplier"));

    HashMap<String, String> conditions = new HashMap<>();
    conditions.put(VacxinDAO.ID_KEY, request.getParameter("id"));
    return dao.update(attributes, conditions);
  }
}
