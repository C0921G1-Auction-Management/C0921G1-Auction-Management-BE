package vn.codegym.com.c0921g1_sprint2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.com.c0921g1_sprint2.model.Product;
import vn.codegym.com.c0921g1_sprint2.service.ProductService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/c09")
public class ProductController {
    @Autowired
    ProductService productService;

    /*DatTC - Lấy list sản phẩm trang chủ*/
    @GetMapping (value = "/product/list")
    public ResponseEntity<Page<Product>> getAll(@RequestParam(defaultValue = "") String name,
                                                @RequestParam(defaultValue = "") String category,
                                                @RequestParam(defaultValue = "") String price,
                                                @RequestParam(defaultValue = "0") Integer page){
        try {
            Pageable pageable = PageRequest.of(page, page);
            String price1 = price.substring(0, price.indexOf("-") - 1);
            String price2 = price.substring(price.indexOf("-") + 1, price.length()-1);
            Page<Product> products = productService.getAll(name, category, price1, price2, pageable);
            if (products.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(products, HttpStatus.OK);
            }
        } catch (NullPointerException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
