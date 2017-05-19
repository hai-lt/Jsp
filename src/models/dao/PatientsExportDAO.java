package models.dao;

import java.util.ArrayList;

import config.Database;
import models.bean.PatientsExport;

public class PatientsExportDAO {
  public static final String PATIENT_ID = "patient_id";
  public static final String PATIENT_NAME = "patient_name";
  public static final String ILL_NAME = "ill_name";
  public static final String VACXIN_ID = "vacxin_id";
  public static final String VACXIN_NAME = "vacxin_name";
  public static final String INJECTION_COUNT = "injecting_counts";
  private HelperDAO helper;
  public static String indexQuery = "SELECT customers.id AS " + PATIENT_ID + ", customers.name AS " + PATIENT_NAME
      + ", ills.name AS " + ILL_NAME + ", vacxins.id as " + VACXIN_ID + ", vaxins.name AS " + VACXIN_NAME
      + ", vaxins.injecting_counts AS " + INJECTION_COUNT + " FROM cusomters "
      + "INNER JOIN histories on histories.customer_id = customers.id"
      + "INNER JOIN vacxins on vacxins.id = histories.vacxin_id"
      + "INNER JOIN recover_vacxins on recover_vacxins.vacxin_id = vacxins.id"
      + "INNER JOIN ills on ills.id = recover_vacxins.ill_id";

  public ArrayList<PatientsExport> index() {
    ArrayList<PatientsExport> patientsExports = new ArrayList<>();
    for (String[] strings : getHelper().query(indexQuery)) {
      patientsExports.add(new PatientsExport(strings));
    }
    return patientsExports;
  }

  public HelperDAO getHelper() {
    if (helper == null) {
      helper = new HelperDAO() {

        @Override
        public String getTableName() {
          // TODO Auto-generated method stub
          return null;
        }
      };
    }
    return helper;
  }
}
