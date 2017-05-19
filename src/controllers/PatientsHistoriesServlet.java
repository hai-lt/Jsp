package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.bo.PatientsHistoriesBO;

@WebServlet("/patients_histories")
public class PatientsHistoriesServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private PatientsHistoriesBO bo;

  public PatientsHistoriesServlet() {
    super();
    bo = new PatientsHistoriesBO();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("patients_histories", bo.index());
    request.getRequestDispatcher("/views/patients_history/main_view.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

}
