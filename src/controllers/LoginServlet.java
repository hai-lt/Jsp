package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.bean.User;
import models.bo.LoginBO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private LoginBO loginBO;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public LoginServlet() {
    super();
    loginBO = new LoginBO();
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    User user = loginBO.authenticate(request.getParameter("username"), request.getParameter("password"));
    if (user != null) {
      HttpSession session = request.getSession();
      session.setAttribute("token", user.getToken());
      response.sendRedirect("index");
      return;
    }
    request.getRequestDispatcher("views/auth/LoginFailed.jsp").forward(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

}
