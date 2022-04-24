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
    /*DatTC - Lấy list sản phẩm trang chủ*/
    @Override
    public Page<Product> getAll(String name, String category, String price1, String price2, Pageable pageable) {
        return productRepository.findProductByOption(name, category, price1, price2, pageable);
    }
}
