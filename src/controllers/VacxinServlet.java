package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.bo.VacxinBO;

@WebServlet("/vacxins")
public class VacxinServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private VacxinBO bo;

  public VacxinServlet() {
    super();
    bo = new VacxinBO();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String action = request.getParameter("action");
    if (action != null && "delete".equals(action) && bo.delete(request)) {
      response.sendRedirect("index");
      return;
    }

    request.setAttribute("user_updated", bo.find(request));
    request.getRequestDispatcher("views/users/edit.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

}