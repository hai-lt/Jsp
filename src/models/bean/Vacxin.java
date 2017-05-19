package models.bean;

public class Vacxin {

  private String id, name, description, price, injecting_counts, supplier;

  public void setAttributes(String... strings) {
    id = strings[0];
    name = strings[1];
    description = strings[2];
    price = strings[3];
    injecting_counts = strings[4];
    supplier = strings[5];
  }

  public Vacxin(String... strings) {
    setAttributes(strings);
  }

  public Vacxin() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public String getInjecting_counts() {
    return injecting_counts;
  }

  public void setInjecting_counts(String injecting_counts) {
    this.injecting_counts = injecting_counts;
  }

  public String getSupplier() {
    return supplier;
  }

  public void setSupplier(String supplier) {
    this.supplier = supplier;
  }

}
