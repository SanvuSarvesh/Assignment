package com.example.AlbaneroAssignment.DTOs;


/*
*   Reason to use DTO(Data transfer object) class is to make some restrictions for the
*   the user, user will be able to change the mobile number only or only that particular
*   things that he/she wanted to and she/he can't play with customerId.
*
*   if we wanted to set the customer Id from customer end,
*   then we'll create a column and mark it as unique using column annotation.
*
* */
public class CustomerUpdateDTOs {
    private int customerId;
    private String mobileNo;

    public CustomerUpdateDTOs() {

    }

    public CustomerUpdateDTOs(int customerId, String mobileNo) {
        this.customerId = customerId;
        this.mobileNo = mobileNo;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
}
