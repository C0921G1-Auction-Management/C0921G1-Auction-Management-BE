package vn.codegym.com.c0921g1_sprint2.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.com.c0921g1_sprint2.model.Product;

import java.util.Optional;

public interface ProductService {
    //CaHM lấy list product
    Page<Product> getFieldProduct(String nameProduct, String nameMember, String category_id, String start_bid, String approved_status, Pageable pageable);
    // CaHM FindById product
    Optional<Product> findByIdProduct(Long id);
    // CaHM update product
    void updateProduct(Product product);
    //CaHM approved product
    void approved(Product product);
}
