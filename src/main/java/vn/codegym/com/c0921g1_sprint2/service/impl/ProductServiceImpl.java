package vn.codegym.com.c0921g1_sprint2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.com.c0921g1_sprint2.model.Product;
import vn.codegym.com.c0921g1_sprint2.repository.ProductRepository;
import vn.codegym.com.c0921g1_sprint2.service.ProductService;

import java.util.List;
import java.util.Optional;

@Service

public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    //LongTk
    @Override
    public Page<Product> getProductListByMemberId(Long id, Pageable pageable) {
        return productRepository.getProductListByMemberId(id, pageable);
    }

    @Override
    public Optional<Product> findById(long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAllByMemberId(Long id) {
        return productRepository.findAllProdByMemberId(id);
    }
}
