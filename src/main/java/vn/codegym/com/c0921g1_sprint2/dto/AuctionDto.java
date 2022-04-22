package vn.codegym.com.c0921g1_sprint2.dto;

import vn.codegym.com.c0921g1_sprint2.model.Member;
import vn.codegym.com.c0921g1_sprint2.model.Product;

import javax.persistence.ManyToOne;

public class AuctionDto {
    private Long id;
    @ManyToOne(targetEntity = Member.class)
    private Member members;
    @ManyToOne (targetEntity = Product.class)
    private Product product;
    private Long currentBid;
    private String auctionTime;

    public AuctionDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMembers() {
        return members;
    }

    public void setMembers(Member members) {
        this.members = members;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getCurrentBid() {
        return currentBid;
    }

    public void setCurrentBid(Long currentBid) {
        this.currentBid = currentBid;
    }

    public String getAuctionTime() {
        return auctionTime;
    }

    public void setAuctionTime(String auctionTime) {
        this.auctionTime = auctionTime;
    }
}
