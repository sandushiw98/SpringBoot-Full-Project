package com.example.SpringBootAcademy.Service.impl;

//@author Sandushi Weraduwa


import com.example.SpringBootAcademy.Dto.CustomerDto;
import com.example.SpringBootAcademy.Dto.request.CustomerUpdateDto;
import com.example.SpringBootAcademy.Entity.Customer;
import com.example.SpringBootAcademy.Repository.CustomerRepo;
import com.example.SpringBootAcademy.Service.CustomerService;
import com.example.SpringBootAcademy.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerRepo customerRepo;
//    @Override
//    public String saveCustomer(CustomerDto customerDto) {
//        Customer customer = new Customer(
//                customerDto.getCustomerid(),
//                customerDto.getCustomerName(),
//                customerDto.getCustomerAddress(),
//                customerDto.getContactNumber(),
//                customerDto.getCustomerSalary(),
//                customerDto.getNic(),
//                customerDto.isActive()
//        );
//        System.out.println(customerDto.getCustomerAddress());
//        customerRepo.save(customer);
//        return customerDto.getCustomerName()+ " saved successfully" ;
//    }

    @Override
    public String saveCustomer(CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto,Customer.class);
        System.out.println(customerDto.getCustomerAddress());
        customerRepo.save(customer);
        return customerDto.getCustomerName()+ " saved successfully" ;
    }

    @Override
    public String updateCustomer(CustomerUpdateDto customerUpdateDto) throws ClassNotFoundException {
        if (customerRepo.existsById(customerUpdateDto.getCustomerid())){

               Customer customer = customerRepo.getReferenceById(customerUpdateDto.getCustomerid());
               customer.setCustomerName(customerUpdateDto.getCustomerName());
               customer.setCustomerAddress(customerUpdateDto.getCustomerAddress());
               customer.setCustomerSalary(customerUpdateDto.getCustomerSalary());

               customerRepo.save(customer);
               return customerUpdateDto.getCustomerName()+ " details updated successfull";
        }else{
            throw new ClassNotFoundException("No data found for that id");
        }

    }

    @Override
    public CustomerDto getCustomerById(int customerId) {
        if(customerRepo.existsById(customerId)){
            Customer customer = customerRepo.getReferenceById(customerId);
            CustomerDto customerDto = new CustomerDto(
                    customer.getCustomerid(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getContactNumber(),
                    customer.getCustomerSalary(),
                    customer.getNic(),
                    customer.isActive()

            );
          return customerDto;
        }else{
            throw new RuntimeException("No customer");
        }

    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> getAllCustomer = customerRepo.findAll();
        if(getAllCustomer.size()>0){
        List<CustomerDto> customerDtoList = new ArrayList<>();

        for(Customer customer : getAllCustomer){
            CustomerDto customerDto = new CustomerDto(
                    customer.getCustomerid(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getContactNumber(),
                    customer.getCustomerSalary(),
                    customer.getNic(),
                    customer.isActive()

            );
            customerDtoList.add(customerDto);

        }

        return customerDtoList ;
        }else{
           throw new NotFoundException("No customer Found");
        }
    }

    @Override
    public String deleteCustomer(int customerId) {
        if(customerRepo.existsById(customerId)){
            customerRepo.deleteById(customerId);
            return "deleted successfully" + customerId;
        }
        else{
            throw new RuntimeException("No customer found in " + customerId);
        }
    }

    @Override
    public List<CustomerDto> getAllCustomersByActiveState(boolean activeState) {

        List<Customer> getAllCustomer = customerRepo.findAllByActive(activeState);
        List<CustomerDto> customerDtoList = new ArrayList<>();

        for(Customer customer : getAllCustomer){
            CustomerDto customerDto = new CustomerDto(
                    customer.getCustomerid(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getContactNumber(),
                    customer.getCustomerSalary(),
                    customer.getNic(),
                    customer.isActive()

            );
            customerDtoList.add(customerDto);

        }

        return customerDtoList ;
    }
}
