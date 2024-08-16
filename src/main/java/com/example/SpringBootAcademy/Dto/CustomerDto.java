package com.example.SpringBootAcademy.Dto;

//@author Sandushi Weraduwa


import java.util.ArrayList;
import java.util.List;

public class CustomerDto {

    private int customerid;
    private String customerName;
    private String customerAddress;
    private ArrayList contactNumber;
    private double customerSalary;
    private String nic;
    private boolean active;

    public CustomerDto() {
    }

    public CustomerDto(int customerid, String customerName, String customerAddress, ArrayList contactNumber, double customerSalary, String nic, boolean active) {
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
        return "CustomerDto{" +
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


