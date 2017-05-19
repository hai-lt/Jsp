package models.dao;

import java.util.ArrayList;
import java.util.HashMap;

import models.bean.PatientHistory;

public class PatientHistoryDAO {
  public final static String PATIENT_ID = "customer_id";
  public final static String VACXIN_ID = "vacxin_id";
  public final static String INJECTION_NTH = "injection_nth";
  public final static String INJECTION_DATE = "injection_date";
  public final static String NEXT_DATE = "next_date";
  public final static String TABLE_NAME = "histories";
  private static HelperDAO helper;

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

  public ArrayList<PatientHistory> all(HashMap<String, String> conditions) {
    ArrayList<PatientHistory> patientHistories = new ArrayList<>();
    for (String[] strings : getHelper().all(conditions)) {
      patientHistories.add(new PatientHistory(strings));
    }
    return patientHistories;
  }

}
