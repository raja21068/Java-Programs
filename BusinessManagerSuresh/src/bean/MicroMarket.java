package bean;
// Generated Oct 30, 2013 3:01:14 AM by Hibernate Tools 3.2.1.GA



/**
 * MicroMarket generated by hbm2java
 */
public class MicroMarket  implements java.io.Serializable {


     private String zipCode;
     private Double radius;
     private Double areaLength;
     private Double areaWidth;

    public MicroMarket() {
    }

	
    public MicroMarket(String zipCode) {
        this.zipCode = zipCode;
    }
    public MicroMarket(String zipCode, Double radius, Double areaLength, Double areaWidth) {
       this.zipCode = zipCode;
       this.radius = radius;
       this.areaLength = areaLength;
       this.areaWidth = areaWidth;
    }
   
    public String getZipCode() {
        return this.zipCode;
    }
    
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public Double getRadius() {
        return this.radius;
    }
    
    public void setRadius(Double radius) {
        this.radius = radius;
    }
    public Double getAreaLength() {
        return this.areaLength;
    }
    
    public void setAreaLength(Double areaLength) {
        this.areaLength = areaLength;
    }
    public Double getAreaWidth() {
        return this.areaWidth;
    }
    
    public void setAreaWidth(Double areaWidth) {
        this.areaWidth = areaWidth;
    }




}


