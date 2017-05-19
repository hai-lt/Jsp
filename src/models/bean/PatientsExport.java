package models.bean;

public class PatientsExport {
  private String patientId, patientName, illName, vacxinId, vacxinName, injectionCounts;

  public PatientsExport(String... strings) {
    setAttributes(strings);
  }

  public PatientsExport() {
  }

  public void setAttributes(String... strings) {
    patientId = strings[0];
    patientName = strings[1];
    illName = strings[2];
    vacxinId = strings[3];
    vacxinName = strings[4];
    injectionCounts = strings[5];
  }

  public String getPatientId() {
    return patientId;
  }

  public void setPatientId(String patientId) {
    this.patientId = patientId;
  }

  public String getPatientName() {
    return patientName;
  }

  public void setPatientName(String patientName) {
    this.patientName = patientName;
  }

  public String getIllName() {
    return illName;
  }

  public void setIllName(String illName) {
    this.illName = illName;
  }

  public String getVacxinId() {
    return vacxinId;
  }

  public void setVacxinId(String vacxinId) {
    this.vacxinId = vacxinId;
  }

  public String getVacxinName() {
    return vacxinName;
  }

  public void setVacxinName(String vacxinName) {
    this.vacxinName = vacxinName;
  }

  public String getInjectionCounts() {
    return injectionCounts;
  }

  public void setInjectionCounts(String injectionCounts) {
    this.injectionCounts = injectionCounts;
  }

}
