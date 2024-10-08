package com.example.SpringBootAcademy.Controller;

//@author Sandushi Weraduwa


import com.example.SpringBootAcademy.Dto.CustomerDto;
import com.example.SpringBootAcademy.Dto.request.CustomerUpdateDto;
import com.example.SpringBootAcademy.Service.CustomerService;
import com.example.SpringBootAcademy.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("api/v1/customer")
@CrossOrigin
public class CustomerController {

  @Autowired
  private CustomerService customerService;

  @PostMapping("/save")
  public ResponseEntity<StandardResponse> saveCustomer(@RequestBody CustomerDto customerDto) {
      String message = customerService.saveCustomer(customerDto);
      return new ResponseEntity<StandardResponse>(
              new StandardResponse(201,"success",message),
              HttpStatus.CREATED
      );
  }

  @PutMapping("/update")
    public String updateCustomer(@RequestBody CustomerUpdateDto customerUpdateDto  ) throws ClassNotFoundException {
       String message = customerService.updateCustomer(customerUpdateDto);
       return message;


  }

//  @GetMapping(
//          path= "/get-by-id",
//          params = "id"
//  )
//    public CustomerDto getCustomerById(@RequestParam(value ="id") int customerId)
//  {
//        CustomerDto customerDto = customerService.getCustomerById(customerId);
//        return customerDto;
//
//  }

  @GetMapping(
          path = "/get-by-id",
          params = "id"
  )

  public ResponseEntity<StandardResponse> getCustomerById(@RequestParam(value = "id") int customerId)
  {
      CustomerDto customerDto = customerService.getCustomerById(customerId);
      return new ResponseEntity<StandardResponse>(
              new StandardResponse(200,"success",customerDto),
                      HttpStatus.OK);

  }


  @GetMapping(
          path ="/get-all-customer"

  )

    public List<CustomerDto> getAllCustomers() {
     List<CustomerDto>  allCustomer = customerService.getAllCustomers();
     return allCustomer;

  }


  @DeleteMapping(
          path = "/delete-customer/{id}"
  )

    public String deleteCustomer(@PathVariable(value = "id") int customerId ){
      String deleted = customerService.deleteCustomer(customerId);
      return deleted;
  }

  @GetMapping(
          path = "/get-all-customers-by-active-state/{status}"
  )

  public List<CustomerDto> getAllCustomerByActiveState(@PathVariable(value = "status") boolean activeState) {
       List<CustomerDto> allCustomers = customerService.getAllCustomersByActiveState(activeState);
       return allCustomers;
  }

  }




