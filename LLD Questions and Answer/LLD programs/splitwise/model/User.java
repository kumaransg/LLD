package io.abhishek.machinecoding.splitwise.model;

public class User {
  private String id;
  private String name;
  private String emailId;
  private Long mobileNo;

  public User(String id, String name, String emailId, Long mobileNo) {
    this.id = id;
    this.name = name;
    this.emailId = emailId;
    this.mobileNo = mobileNo;
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

  public String getEmailId() {
    return emailId;
  }

  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }

  public Long getMobileNo() {
    return mobileNo;
  }

  public void setMobileNo(Long mobileNo) {
    this.mobileNo = mobileNo;
  }
}
