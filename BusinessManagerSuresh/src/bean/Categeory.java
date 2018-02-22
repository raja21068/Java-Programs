package bean;
// Generated Oct 29, 2013 9:01:18 AM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Categeory generated by hbm2java
 */
public class Categeory  implements java.io.Serializable {


     private Integer categoryId;
     private String categoryName;
     private String remarks;
     private Set products = new HashSet(0);

    public Categeory() {
    }

	
    public Categeory(String categoryName, String remarks) {
        this.categoryName = categoryName;
        this.remarks = remarks;
    }
    public Categeory(String categoryName, String remarks, Set products) {
       this.categoryName = categoryName;
       this.remarks = remarks;
       this.products = products;
    }
   
    public Integer getCategoryId() {
        return this.categoryId;
    }
    
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    public String getCategoryName() {
        return this.categoryName;
    }
    
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public String getRemarks() {
        return this.remarks;
    }
    
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public Set getProducts() {
        return this.products;
    }
    
    public void setProducts(Set products) {
        this.products = products;
    }


    @Override
    public String toString() {
        return categoryName; //To change body of generated methods, choose Tools | Templates.
    }


}


