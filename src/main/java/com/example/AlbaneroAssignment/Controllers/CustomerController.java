package com.example.AlbaneroAssignment.Controllers;

import com.example.AlbaneroAssignment.DTOs.CustomerUpdateDTOs;
import com.example.AlbaneroAssignment.Models.Customer;
import com.example.AlbaneroAssignment.Services.CustomerService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    /*
    *   this is also one of a way to communicat with service layer.
    *
    *   @Autowired
    *   public CustomerService customerService;
    *
    * */

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/add_customer")
    public String addCustomer(@RequestBody Customer customer){
        try{
            return customerService.addCustomer(customer);
        }
        catch (Exception exception){
            return "Invalid/Missing Input " + exception.getMessage();
        }
    }

    @GetMapping("get_customer")
    public Customer getCustomer(@RequestParam("id") int customerId){
        return customerService.getCustomer(customerId);
    }

    @PutMapping("/update_customer")
    public String updateCustomer(@RequestBody CustomerUpdateDTOs customerUpdateDTOs){
        return customerService.updateCustomer(customerUpdateDTOs);
    }

    @DeleteMapping("/delete_customer")
    public String deleteCustomer(@RequestParam("id") int customerId ){
        return  customerService.deleteCustomer(customerId);
    }
}
