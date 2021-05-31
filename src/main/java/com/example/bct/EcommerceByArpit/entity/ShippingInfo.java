package com.example.bct.EcommerceByArpit.entity;


import javax.persistence.*;

@Entity
public class ShippingInfo {

    @Id
    @Column(name = "shipping_info_id")
    Long id;

    @Column(name = "customer_address")
    String customer_address;

    @Column(name = "city")
    String city;

    @Column(name = "state")
    String state;

    @Column(name = "phone_number")
    String phone_number;


    public ShippingInfo(Long id, String customer_address, String city, String state, String phone_number) {
        this.id = id;
        this.customer_address = customer_address;
        this.city = city;
        this.state = state;
        this.phone_number = phone_number;
    }

    public ShippingInfo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }


    @Override
    public String toString() {
        return "ShippingInfo{" +
                "id=" + id +
                ", customer_address='" + customer_address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }
}
