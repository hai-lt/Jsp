package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.bean.User;
import models.bo.UserBO;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/users")
public class UserServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private UserBO bo;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public UserServlet() {
    super();
    bo = new UserBO();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    User user = bo.authentication(request);
    if (user == null) {
      response.sendRedirect("views/Login.jsp");
    }
    request.setAttribute("user", user);

    String action = request.getParameter("action");
    if (action != null && "delete".equals(action) && bo.delete(request)) {
      response.sendRedirect("index");
      return;
    }

    request.setAttribute("user_updated", bo.findBy(request));
    request.getRequestDispatcher("views/users/edit.jsp").forward(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    User user = bo.authentication(request);
    if (user == null) {
      response.sendRedirect("views/Login.jsp");
    }
    if (bo.update(request)) {
      response.sendRedirect("index");
      return;
    }
    request.getRequestDispatcher("views/users/edit.jsp").forward(request, response);
  }

}
