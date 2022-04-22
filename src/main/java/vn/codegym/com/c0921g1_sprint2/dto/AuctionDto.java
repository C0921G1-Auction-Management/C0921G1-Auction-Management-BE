package vn.codegym.com.c0921g1_sprint2.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vn.codegym.com.c0921g1_sprint2.model.Auction;
import vn.codegym.com.c0921g1_sprint2.model.Member;
import vn.codegym.com.c0921g1_sprint2.model.Product;
import vn.codegym.com.c0921g1_sprint2.repository.AuctionRepository;


import javax.validation.constraints.NotNull;

@Component
public class AuctionDto implements Validator {
    @Autowired
    AuctionRepository auctionRepository;

    @NotNull
    private Long id;
    private Integer currentBid;
    private Integer quantity;
    private String auctionTime;
    private Member members;
    private Product product;

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

    public Integer getCurrentBid() {
        return currentBid;
    }

    public void setCurrentBid(Integer currentBid) {
        this.currentBid = currentBid;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getAuctionTime() {
        return auctionTime;
    }

    public void setAuctionTime(String auctionTime) {
        this.auctionTime = auctionTime;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        AuctionDto auctionDto = (AuctionDto) target;
        Integer auctionPrice = auctionDto.getCurrentBid();
        Auction auctionTop1 = auctionRepository.findMemBerFinal();
        System.out.println(auctionTop1);

        if (auctionPrice <= auctionTop1.getCurrentBid()){
            errors.rejectValue("currentBid", "currentBid.lessPrice", "Giá bạn nhập vào phải lớn giá hiện tại đang đấu");
        }

    }
}
