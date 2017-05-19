package models.bean;

public class PatientHistory {
  private String vacxinID, patientId, injectionNth, injectionDate, nextDate;

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

}
