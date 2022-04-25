package vn.codegym.com.c0921g1_sprint2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.com.c0921g1_sprint2.model.Product;
import vn.codegym.com.c0921g1_sprint2.repository.ProductRepository;
import vn.codegym.com.c0921g1_sprint2.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    /*DatTC - Lấy list sản phẩm theo options*/
    @Override
    public Page<Product> getAllByOptions(String name, String category, Long minPrice, Long maxPrice, Pageable pageable) {
        return productRepository.findProductByOptions(name, category, minPrice, maxPrice, pageable);
//        return productRepository.findProductByOptions( pageable);
    }
}
