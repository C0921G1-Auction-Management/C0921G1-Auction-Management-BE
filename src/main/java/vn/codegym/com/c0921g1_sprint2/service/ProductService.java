package vn.codegym.com.c0921g1_sprint2.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.com.c0921g1_sprint2.model.Product;

public interface ProductService {
    /*DatTC - Lấy list theo option*/
    Page<Product> getAll(String name, String category, String price1, String price2, Pageable pageable);
}
