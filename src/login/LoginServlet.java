package login;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import config.Database;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public LoginServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if (isMember(request.getParameter("username"), request.getParameter("password"))) {
      response.sendRedirect("profile");
      return;
    }
    ;
    request.setAttribute("warning", "Wrong username or password");
    request.getRequestDispatcher("views/Login.jsp").forward(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

  private boolean isMember(String username, String password) {
    String condition = "username = '" + username + "' and password = '" + password + "'";
    try {
      ResultSet result = Database.getInstance().getStatement().executeQuery("select * from users where " + condition);
      return result.next();
    } catch (SQLException e) {
      return false;
    }
  }

}
