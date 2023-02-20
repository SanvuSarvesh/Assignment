package com.example.AlbaneroAssignment.Services;

import com.example.AlbaneroAssignment.DTOs.CustomerUpdateDTOs;
import com.example.AlbaneroAssignment.Models.Customer;
import com.example.AlbaneroAssignment.Repositories.CustomerRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    public CustomerRepository customerRepository;
    public String addCustomer(Customer customer) throws Exception{
        String pinCode = customer.getPincode();
        if(pinCode.length()!=6){
            return "Opps!! You have entered wrong Pincode.";
        }
        else if(pinCode.length()==6){
            for(int i=0;i<6;i++){
                if(pinCode.charAt(i)>'9' || pinCode.charAt(i)<'0'){
                    return "You have entered wrong pincode, Kindly check and Re-enter.";
                }
            }
        }
        String mobileNo = customer.getMobileNo();
        if(mobileNo.length() != 10){
            return "Opps!! wrong mobile number, Kindly re-enter correct mobile number.";
        }
        else if(mobileNo.length() == 10){
            for(int i=0;i<10;i++){
                if(mobileNo.charAt(0)<'6' || mobileNo.charAt(0)>'9'){
                    // In India Mobile number Generally Starts with 9,8,7 or 6.
                    return "Invalid Mobile Number";
                }
            }
        }
        String city = customer.getCity();
        String firstName = customer.getFirstName();
        String lastName = customer.getLastName();
        String address = customer.getAddress();
        String pincode = customer.getPincode();
        String contactNo = customer.getMobileNo();

        // Validation check for every property given in the question.

        if(firstName==null){
            return "First Name can't be empty.";
        }
        if(lastName==null){
            return "Last Name can't be empty.";
        }
        if(city==null){
            return "City name can't be empty.";
        }
        if(pincode==null){
            return "Kindly enter your pincode.";
        }
        if(address==null){
            return "Kindly enter your addess.";
        }
        if(contactNo==null){
            return "Kindly enter contact number.";
        }
        customerRepository.save(customer);
        return "New Customer has been added.";
    }

    public Customer getCustomer(int customerId) {
        Customer customer = customerRepository.findById(customerId).get();
        return customer;
    }

    // If we have to update Mobile number of the customer
    // First we shall try to find out the customer with the help of
    // customer id then we'll update his/her credentials further
    // We can update any property that we wanted to update

    public String updateCustomer(CustomerUpdateDTOs customerUpdateDTOs){
        Customer originalCustomer = customerRepository.findById(customerUpdateDTOs.getCustomerId()).get();
        originalCustomer.setMobileNo(customerUpdateDTOs.getMobileNo());
        customerRepository.save(originalCustomer);
        return "Your data has been updated.";
    }

    public String deleteCustomer(int customerId){
        customerRepository.deleteById(customerId);
        return "Your credentials has been removed.";
    }

}
