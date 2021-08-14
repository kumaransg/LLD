package service.notification;

public abstract class AbstractNotification {
  String content;
  Boolean status;

  public AbstractNotification(String content){
    this.content =  content;
    this.status = false;
  }
  /**
   * @return the content
   */
  public String getContent() {
    return content;
  }

  /**
   * @param content the content to set
   */
  public void setContent(String content) {
    this.content = content;
  }

  /**
   * @return the status
   */
  public Boolean getStatus() {
    return status;
  }

  /**
   * @param status the status to set
   */
  public void setStatus(Boolean status) {
    this.status = status;
  }
  public abstract void send();
}
