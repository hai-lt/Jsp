package controllers;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.bean.User;
import models.bo.IndexBO;
import models.dao.UserDAO;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  private IndexBO bo;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public IndexServlet() {
    super();
    bo = new IndexBO();
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    String token = (String) request.getSession().getAttribute("token");
    if (token == null) {
      request.getRequestDispatcher("/views/Login.jsp").forward(request, response);
      return;
    }
    HashMap<String, String> condition = new HashMap<>();
    condition.put(UserDAO.TOKEN_KEY, token);
    User user = new UserDAO().findBy(condition);
    if (user == null) {
      request.getRequestDispatcher("/views/Login.jsp").forward(request, response);
      return;
    }
    request.setAttribute("user", user);

    request.setAttribute("users", bo.search(request.getParameter("username")));

    request.getRequestDispatcher("views/index.jsp").forward(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("searched", true);
    doGet(request, response);
  }

}
