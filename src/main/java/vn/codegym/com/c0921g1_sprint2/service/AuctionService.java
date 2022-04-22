package vn.codegym.com.c0921g1_sprint2.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.com.c0921g1_sprint2.model.Auction;
import vn.codegym.com.c0921g1_sprint2.model.Product;


public interface AuctionService {
     Auction findAllEndAuction();

    Page<Auction> findAll(Pageable pageable);

    Product getProductById(Long id);

    void saveInfoAuction(Long productId,Long memberId ,Integer price, Integer quantity, String time);

    void updateInfoAuction(Long productId,Long memberId ,Integer price, Integer quantity, String time);
}
