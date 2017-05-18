package models.bo;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import models.bean.User;
import models.dao.UserDAO;

public class BaseBO {
  public static String generateToken(String value) {
    try {
      MessageDigest m = MessageDigest.getInstance("MD5");
      m.reset();
      m.update(value.getBytes());
      byte[] digest = m.digest();
      BigInteger bigInt = new BigInteger(1, digest);
      String hashtext = bigInt.toString(16);
      while (hashtext.length() < 32) {
        hashtext = "0" + hashtext;
      }
      return hashtext;
    } catch (Exception e) {
      return "";
    }
  }

  public User authentication(HttpServletRequest request) {
    String token = (String) request.getSession().getAttribute("token");
    if (token == null) {
      return null;
    }
    HashMap<String, String> condition = new HashMap<>();
    condition.put(UserDAO.TOKEN_KEY, token);
    return new UserDAO().findBy(condition);
  }
}
