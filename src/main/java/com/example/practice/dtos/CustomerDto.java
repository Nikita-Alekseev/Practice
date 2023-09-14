package com.example.practice.dtos;

public class CustomerDto {
    private Long id;
    private String fullNameOfTheCustomer;
    private String mail;
    private String phone;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullNameOfTheCustomer() {
        return fullNameOfTheCustomer;
    }

    public void setFullNameOfTheCustomer(String fullNameOfTheCustomer) {
        this.fullNameOfTheCustomer = fullNameOfTheCustomer;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public CustomerDto(Long id, String fullNameOfTheCustomer, String mail, String phone) {
        this.id = id;
        this.fullNameOfTheCustomer = fullNameOfTheCustomer;
        this.mail = mail;
        this.phone = phone;
        this.address = address;
    }
    public CustomerDto() {};

    @Override
    public String toString() {
        return "CustomerDto{" +
                "id=" + id +
                ", fullNameOfTheCustomer='" + fullNameOfTheCustomer + '\'' +
                ", mail='" + mail + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
