package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.bean.PatientsReport;
import models.bo.PatientsReportBO;

@WebServlet("/patients_reports")
public class PatientsReportsServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private PatientsReportBO bo;

  public PatientsReportsServlet() {
    super();
    bo = new PatientsReportBO();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("patients_reports", bo.index());
    request.getRequestDispatcher("/views/patients_reports/main.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

}
