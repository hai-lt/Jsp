package models.bean;

public class Patient {
  private String id, fullname, address, birthdate, gender;

  public void setAttributes(String... strings) {
    id = strings[0];
    fullname = strings[1];
    address = strings[2];
    birthdate = strings[3];
    gender = strings[4];
  }

  public Patient() {
  }

  public Patient(String... strings) {
    setAttributes(strings);
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFullname() {
    return fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(String birthdate) {
    this.birthdate = birthdate;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

}
