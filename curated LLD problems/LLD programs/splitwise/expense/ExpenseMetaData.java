package io.abhishek.machinecoding.splitwise.expense;

public class ExpenseMetaData {
  private String name;
  private String description;
  private String imgUrl;

  public ExpenseMetaData(String name, String description, String imgUrl) {
    this.name = name;
    this.description = description;
    this.imgUrl = imgUrl;
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

  public String getImgUrl() {
    return imgUrl;
  }

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }
}
