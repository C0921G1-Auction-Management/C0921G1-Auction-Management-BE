package vn.codegym.com.c0921g1_sprint2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long startBid;
    private Long bidRange;
    private Long finalBid;

    @Column(name = "imageUrl", columnDefinition = "LONGBLOB")
    private String imageUrl;
    private String startDate;
    private String endDate;
    private Integer approvedStatus;
    private String description;
    private Integer paymentStatus;
    private String timeRemaining;
    private String productAddress;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<Transaction> transactions;

    @JsonIgnore
    @ManyToOne(targetEntity = Category.class)
    private Category category;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getStartBid() {
        return startBid;
    }

    public void setStartBid(Long startBid) {
        this.startBid = startBid;
    }

    public Long getBidRange() {
        return bidRange;
    }

    public void setBidRange(Long bidRange) {
        this.bidRange = bidRange;
    }

    public Long getFinalBid() {
        return finalBid;
    }

    public void setFinalBid(Long finalBid) {
        this.finalBid = finalBid;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getApprovedStatus() {
        return approvedStatus;
    }

    public void setApprovedStatus(Integer approvedStatus) {
        this.approvedStatus = approvedStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getTimeRemaining() {
        return timeRemaining;
    }

    public void setTimeRemaining(String timeRemaining) {
        this.timeRemaining = timeRemaining;
    }

    public String getProductAddress() {
        return productAddress;
    }

    public void setProductAddress(String productAddress) {
        this.productAddress = productAddress;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


}
