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

    /*
    *  Whenever user try to send data with any of empty field then he/she will
    * get up message, that particular field is missing.
    *
    * for example
    * if customer forget to enter city name, in that case there will be pop-up message
    * that city name can't be empty
    * same thing will happen with others attributes too.
    *
    * In code cases if user will send wrong input in that case too, there will be pop-up
    * which will show Invalid or wrong input
    *
    * for example
    * As we know Pincode will be of length 6 and mobile number will be of length 10,
    * considering indian data.
    * in this case use will receive invalid input.
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
