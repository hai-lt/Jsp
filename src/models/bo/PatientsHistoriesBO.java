package models.bo;

import java.util.ArrayList;

import models.bean.PatientsExport;
import models.dao.PatientsExportDAO;

public class PatientsHistoriesBO {

  public ArrayList<PatientsExport> index() {
    return new PatientsExportDAO().index();
  }
}
