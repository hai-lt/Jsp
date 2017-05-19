package models.bean;

public class PatientsReport {
  private String cutomerId, cutomerName, price;

  public PatientsReport(String... strings) {
    setAttributes(strings);
  }

  public PatientsReport() {
  }

  public void setAttributes(String... strings) {
    cutomerId = strings[0];
    cutomerName = strings[1];
    price = strings[2];
  }

  public String getCutomerId() {
    return cutomerId;
  }

  public String getCutomerName() {
    return cutomerName;
  }

  public String getPrice() {
    return price;
  }
}
