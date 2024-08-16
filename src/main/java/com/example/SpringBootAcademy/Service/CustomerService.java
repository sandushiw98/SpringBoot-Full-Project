package com.example.SpringBootAcademy.Service;

//@author Sandushi Weraduwa


import com.example.SpringBootAcademy.Dto.CustomerDto;
import com.example.SpringBootAcademy.Dto.CustomerUpdateDto;

public interface CustomerService {

   public String saveCustomer(CustomerDto customerDto);
   public String updateCustomer(CustomerUpdateDto customerUpdateDto) throws ClassNotFoundException;


   CustomerDto getCustomerById(int customerId);
}
