package vn.codegym.com.c0921g1_sprint2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.com.c0921g1_sprint2.model.Auction;
import vn.codegym.com.c0921g1_sprint2.model.Product;
import vn.codegym.com.c0921g1_sprint2.repository.AuctionRepository;
import vn.codegym.com.c0921g1_sprint2.repository.ProductRepository;
import vn.codegym.com.c0921g1_sprint2.service.AuctionService;


@Service
public class AuctionServiceImpl implements AuctionService {
    @Autowired
    AuctionRepository auctionRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public Auction findAllEndAuction() {
        return auctionRepository.findMemBerFinal();
    }

    @Override
    public Page<Auction> findAll(Pageable pageable) {
        return auctionRepository.findAllAuction( pageable);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findProductById(id);
    }

    @Override
    public void saveInfoAuction(Long productId, Long memberId, Integer price, Integer quantity, String time) {
        auctionRepository.saveInfoAuction(productId, memberId, price, quantity, time);
    }

    @Override
    public void updateInfoAuction(Long productId, Long memberId, Integer price, Integer quantity, String time) {
        auctionRepository.updateInfoAuction(productId, memberId, price, quantity, time);
    }

}
