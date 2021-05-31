package com.example.bct.EcommerceByArpit.entity;

import javax.persistence.*;

@Entity
public class WishList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wishlist_id")
    Long id;

    @Column(name = "quantity")
    int quantity;

    @Column(name = "price_per_unit")
    Long pricePerUnit;

    @Column(name = "product_name")
    String productName;


    @ManyToOne
    Product product;

    @ManyToOne
    Customer customer;

    public WishList() {
    }

    public WishList(int quantity, Long pricePerUnit, String productName, Product product, Customer customer) {
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
        this.productName = productName;
        this.product = product;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(Long pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "WishList{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", pricePerUnit=" + pricePerUnit +
                ", productName='" + productName + '\'' +
                ", product=" + product +
                ", customer=" + customer +
                '}';
    }
}
