package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.bo.RegisterBO;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private RegisterBO bo;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public RegisterServlet() {
    super();
    bo = new RegisterBO();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getRequestDispatcher("/views/auth/register.jsp").forward(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String passwordConfirmation = request.getParameter("password_confirmation");
    if (bo.register(username, password, passwordConfirmation)) {
      request.getSession().setAttribute("success_message", true);
      response.sendRedirect("views/Login.jsp");
      return;
    };
    request.getRequestDispatcher("/views/auth/register.jsp").forward(request, response);
  }

}
