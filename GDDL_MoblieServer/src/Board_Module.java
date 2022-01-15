

import java.sql.Time;

public class Board_Module {
	private int o_number = 0;
    private String orders = "";
    private String errand = "";
    private String title = "";
    private String text = "";
    private double latitude = 0.0;
    private double longitude = 0.0;
    private String detail_address = "";
    private int price = 0;
    private String o_time = "";
    private String progress = "";
  
    public int getO_number() {
      return o_number;
    }
    public void setO_number(int o_number) {
      this.o_number = o_number;
    }
    public String getOrders() {
      return orders;
    }
    public void setOrders(String orders) {
      this.orders = orders;
   }
   public String getErrand() {
      return errand;
   }
   public void setErrand(String errand) {
      this.errand = errand;
   }
   public String getTitle() {
      return title;
   }
   public void setTitle(String title) {
      this.title = title;
   }
   public String getText() {
      return text;
   }
   public void setText(String text) {
      this.text = text;
   }
   public double getLatitude() {
      return latitude;
   }
   public void setLatitude(double latitude) {
      this.latitude = latitude;
   }
   public double getLongitude() {
      return longitude;
   }
   public void setLongitude(double longitude) {
      this.longitude = longitude;
   }
   public String getDetail_address() {
      return detail_address;
   }
   public void setDetail_address(String detail_address) {
      this.detail_address = detail_address;
   }
   public int getPrice() {
      return price;
   }
   public void setPrice(int price) {
      this.price = price;
   }
   public String getO_time() {
      return o_time;
   }
   public void setO_time(String o_time) {
      this.o_time = o_time;
   }
   public String getProgress() {
	   return progress;
   }
   public void setProgress(String progress) {
	   this.progress = progress;
   }

}