package com.example.AlbaneroAssignment.Models;
import ch.qos.logback.core.boolex.EvaluationException;
import com.sun.istack.NotNull;
import org.aspectj.lang.annotation.RequiredTypes;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Required;

import javax.persistence.*;
import java.sql.Struct;
import java.util.Date;

@Entity
@Table(name = "customer")
public class Customer {

    /*
    * if we wanted to make it(customerId as) custom then
    * we can also do that by using column annotation
    *
    * @Column(unique = true)
    *
    * after doing this that particular column will be unique always.
    */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String city;
    @NotNull
    private String pincode;

    @NotNull
    private String mobileNo;

    @NotNull
    private String address;

    @CreationTimestamp
    private Date date;

    public Customer() {

    }

    public Customer(int customerId, String firstName, String lastName, String city, String pincode, String address, Date date, String mobileNo) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.pincode = pincode;
        this.address = address;
        this.date = date;
        this.mobileNo = mobileNo;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
}
