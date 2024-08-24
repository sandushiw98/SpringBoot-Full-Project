package com.example.SpringBootAcademy.Entity;

//@author Sandushi Weraduwa




import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;

import java.util.ArrayList;


@Entity
@Table(name = "Customer")
@TypeDefs({
      @TypeDef(name="json",typeClass= JsonType.class)
})
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO )
  @Column(name = "customer_id", length = 45)
  private int customerid;

  @Column(name = "customer_name", length = 100, nullable = false)
  private String customerName;

  @Column(name = "customer_address", length = 225)
  private String customerAddress;

  @Type(type = "json")
  @Column(name = "contact_number", columnDefinition = "json")
  private ArrayList contactNumber;

  @Column(name = "customer_salary", length = 225)
  private double customerSalary;

  @Column(name = "customer_nic", length = 20)
  private String nic;

  @Column(name = "active", columnDefinition = "TINYINT default 1")
  private boolean active;

  public Customer() {
  }

  public Customer(int customerid, String customerName, String customerAddress, ArrayList contactNumber, double customerSalary, String nic, boolean active) {
    this.customerid = customerid;
    this.customerName = customerName;
    this.customerAddress = customerAddress;
    this.contactNumber = contactNumber;
    this.customerSalary = customerSalary;
    this.nic = nic;
    this.active = active;
  }

  public int getCustomerid() {
    return customerid;
  }

  public void setCustomerid(int customerid) {
    this.customerid = customerid;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public String getCustomerAddress() {
    return customerAddress;
  }

  public void setCustomerAddress(String customerAddress) {
    this.customerAddress = customerAddress;
  }

  public ArrayList getContactNumber() {
    return contactNumber;
  }

  public void setContactNumber(ArrayList contactNumber) {
    this.contactNumber = contactNumber;
  }

  public double getCustomerSalary() {
    return customerSalary;
  }

  public void setCustomerSalary(double customerSalary) {
    this.customerSalary = customerSalary;
  }

  public String getNic() {
    return nic;
  }

  public void setNic(String nic) {
    this.nic = nic;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  @Override
  public String toString() {
    return "Customer{" +
            "customerid=" + customerid +
            ", customerName='" + customerName + '\'' +
            ", customerAddress='" + customerAddress + '\'' +
            ", contactNumber=" + contactNumber +
            ", customerSalary=" + customerSalary +
            ", nic='" + nic + '\'' +
            ", active=" + active +
            '}';
  }
}