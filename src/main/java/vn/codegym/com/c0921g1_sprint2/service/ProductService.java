package vn.codegym.com.c0921g1_sprint2.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.com.c0921g1_sprint2.model.Product;

public interface ProductService {
    Page<Product> getAllByOptions(String name, String category, Long minPrice, Long maxPrice, Pageable pageable);
}
