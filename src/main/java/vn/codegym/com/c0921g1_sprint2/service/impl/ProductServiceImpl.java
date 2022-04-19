package vn.codegym.com.c0921g1_sprint2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.com.c0921g1_sprint2.model.Product;
import vn.codegym.com.c0921g1_sprint2.repository.ProductRepository;
import vn.codegym.com.c0921g1_sprint2.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    //    Đăng ký sản phẩm-TaiLM
    @Override
    public void saveProduct(Product product) {
        product.setApprovedStatus(0);
        product.setPaymentStatus(0);
        product.setTimeRemaining("0");
        productRepository.saveProduct(product.getApprovedStatus(),product.getBidRange(),product.getDescription(),
                product.getEndDate(),product.getFinalBid(),product.getImageUrl(),product.getName(),product.getPaymentStatus(),
                product.getProductAddress(),product.getStartBid(),product.getStartDate(),product.getTimeRemaining(),product.getCategory().getId());
    }
}
