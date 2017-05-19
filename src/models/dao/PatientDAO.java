package models.dao;

import java.util.HashMap;

import models.bean.Patient;

public class PatientDAO {
  public static final String ID = "id";
  public static final String FULLNAME = "full_name";
  public static final String ADDRESS = "address";
  public static final String BIRTHDATE = "birthdate";
  public static final String GENDER = "gender";
  public static final String TABLE_NAME = "customers";
  public static HelperDAO helper;

  public static HelperDAO getHelper() {
    if (helper == null) {
      helper = new HelperDAO() {

        @Override
        public String getTableName() {
          // TODO Auto-generated method stub
          return TABLE_NAME;
        }
      };
    }
    return helper;
  }
  
  public Patient find(HashMap<String, String> conditions) {
    return new Patient(getHelper().findBy(conditions));
  }
}
