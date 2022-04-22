package vn.codegym.com.c0921g1_sprint2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.com.c0921g1_sprint2.model.Product;
import vn.codegym.com.c0921g1_sprint2.repository.ProductRepository;
import vn.codegym.com.c0921g1_sprint2.service.ProductService;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
   @Autowired
   private ProductRepository productRepository;

   // CaHM lấy list product
   @Override
   public Page<Product> getFieldProduct(String nameProduct, String nameMember, String category_id, String start_bid, String approved_status, Pageable pageable) {
      return productRepository.getFieldProduct(nameProduct,nameMember,category_id,start_bid,approved_status,pageable);
   }
   // CaHM
   @Override
   public Optional<Product> findByIdProduct(Long id) {
      return productRepository.findByIdProduct(id);
   }
   // CaHM update product
   @Override
   public void updateProduct(Product product) {
      productRepository.updateProduct(product.getName(),product.getStartBid(),product.getBidRange(),
      product.getFinalBid(),product.getImageUrl(),product.getStartDate(),product.getEndDate(),
              product.getApprovedStatus(),product.getDescription(),product.getPaymentStatus(),
              product.getTimeRemaining(),product.getProductAddress(),
              product.getCategory(),product.getId());
   }
   //CaHM approved product
   @Override
   public void approved(Product product) {
      product.setApprovedStatus(1);
      productRepository.save(product);
   }

}
