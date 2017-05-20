package models.bean;

import java.util.HashMap;

import models.dao.PatientDAO;
import models.dao.VacxinDAO;

public class PatientHistory {
  private String vacxinID, patientId, injectionNth, injectionDate, nextDate;
  private Vacxin vacxin;
  private Patient patient;

  public PatientHistory(String... strings) {
    setAttributes(strings);
  }

  public PatientHistory() {
  }

  public void setAttributes(String... strings) {
    vacxinID = strings[0];
    patientId = strings[1];
    injectionNth = strings[2];
    injectionDate = strings[3];
    nextDate = strings[4];
  }

  public String getVacxinID() {
    return vacxinID;
  }

  public void setVacxinID(String vacxinID) {
    this.vacxinID = vacxinID;
  }

  public String getPatientId() {
    return patientId;
  }

  public void setPatientId(String patientId) {
    this.patientId = patientId;
  }

  public String getInjectionNth() {
    return injectionNth;
  }

  public void setInjectionNth(String injectionNth) {
    this.injectionNth = injectionNth;
  }

  public String getInjectionDate() {
    return injectionDate;
  }

  public void setInjectionDate(String injectionDate) {
    this.injectionDate = injectionDate;
  }

  public String getNextDate() {
    return nextDate;
  }

  public void setNextDate(String nextDate) {
    this.nextDate = nextDate;
  }

  public Vacxin getVacxin() {
    if (vacxin == null) {
      return loadVacxin();
    }
    return vacxin;
  }

  public Vacxin loadVacxin() {
    HashMap<String, String> conditions = new HashMap<>();
    conditions.put(VacxinDAO.ID, getVacxinID());
    return vacxin = new VacxinDAO().find(conditions);
  }

  public Patient getPatient() {
    if (patient == null) {
      return loadPatient();
    }
    return patient;
  }

  public Patient loadPatient() {
    HashMap<String, String> conditions = new HashMap<>();
    conditions.put(PatientDAO.ID, getPatientId());
    return patient = new PatientDAO().find(conditions);
  }

}
