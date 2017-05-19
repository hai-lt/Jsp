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
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    if (username == null || password == null) {
      request.getRequestDispatcher("views/Login.jsp").forward(request, response);
      return;
    }
    User user = loginBO.authenticate(username, password);
    if (user != null) {
      HttpSession session = request.getSession();
      session.setAttribute("token", user.getToken());
      request.removeAttribute("login_failed");
      response.sendRedirect("index");
      return;
    }
    request.getRequestDispatcher("views/Login.jsp").forward(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("login_failed", true);
    doGet(request, response);
  }

}
