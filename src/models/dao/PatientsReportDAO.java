package models.dao;

import java.util.ArrayList;

import models.bean.PatientsReport;

public class PatientsReportDAO {
  private HelperDAO helper;
  private static String query = "SELECT customers.id, customers.full_name, sum(vacxins.price) AS price"
      + " FROM customers" + " INNER JOIN histories ON histories.customer_id = customers.id"
      + " INNER JOIN vacxins ON vacxins.id= histories.vacxin_id" + " GROUP BY customers.id" + " ORDER BY price";

  public HelperDAO getHepler() {
    if (helper == null) {
      helper = new HelperDAO() {

        @Override
        public String getTableName() {
          return null;
        }
      };
    }
    return helper;
  }

  public ArrayList<PatientsReport> index() {
    ArrayList<PatientsReport> patientsReports = new ArrayList<>();
    for (String[] strings : getHepler().query(query)) {
      patientsReports.add(new PatientsReport(strings));
    }
    return patientsReports;
  }
}
