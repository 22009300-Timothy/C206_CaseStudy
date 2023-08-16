// 22024777 Ryan
public class Fees extends Institution {

  private String FeeType;
  private String status;

  public Fees(String id, String name, String FeeType, String status) {
    super(id, name);
    this.status = status;
    this.FeeType = FeeType;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
  
  public String getFeeType() {
    return FeeType;
  }

} // end of class