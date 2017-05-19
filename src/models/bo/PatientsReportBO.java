package models.bo;

import java.util.ArrayList;

import models.bean.PatientsReport;
import models.dao.PatientsReportDAO;

public class PatientsReportBO {
  private PatientsReportDAO dao;

  public PatientsReportBO() {
    dao = new PatientsReportDAO();
  }
  
  public ArrayList<PatientsReport> index() {
    return dao.index();
  }
  
  

}
