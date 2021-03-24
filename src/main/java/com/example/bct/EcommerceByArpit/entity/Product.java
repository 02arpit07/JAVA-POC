package com.example.bct.EcommerceByArpit.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_Id")
    private Long productId;

    @Column(name = "product_Name")
    private String productName;

    @Column(name = "manufacturer_name")
    private String manufacturerName;

    @Column(name = "price_per_unit")
    private Long price;

//    default of @ManyToOne is EAGER
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_category_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Category category;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "long_description")
    private String longDescription;

    @Column(name = "is_active")
    @JsonProperty
    private boolean isActive;

    @Column(name = "is_deleted")
    @JsonProperty
    private  boolean isDeleted;

    @Column(name = "is_featured")
    @JsonProperty
    private  boolean isFeatured;

    @Column(name = "created_on")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd" , timezone = "Asia/Kolkata")
    private Date createdOn;

    @Column(name = "updatedon")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd" , timezone = "Asia/Kolkata")
    private Date updatedOn;

    public Product() {
    }

    public Product(String productName, String manufacturerName, Long price, Category category, String imageUrl, String shortDescription, String longDescription, boolean isActive, boolean isDeleted, boolean isFeatured, Date createdOn, Date updatedOn) {
        this.productName = productName;
        this.manufacturerName = manufacturerName;
        this.price = price;
        this.category = category;
        this.imageUrl = imageUrl;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.isActive = isActive;
        this.isDeleted = isDeleted;
        this.isFeatured = isFeatured;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public boolean isFeatured() {
        return isFeatured;
    }

    public void setFeatured(boolean featured) {
        isFeatured = featured;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", ManufacturerName='" + manufacturerName + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", imageUrl='" + imageUrl + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", longDescription='" + longDescription + '\'' +
                ", isActive=" + isActive +
                ", isDeleted=" + isDeleted +
                ", isFeatured=" + isFeatured +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                '}';
    }
}
