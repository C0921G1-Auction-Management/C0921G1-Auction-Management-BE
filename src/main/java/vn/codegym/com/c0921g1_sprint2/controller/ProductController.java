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

@RestController
@CrossOrigin("*")
@RequestMapping("/c09")
public class ProductController {
    @Autowired
    ProductService productService;

    /*DatTC - Lấy list sản phẩm theo options*/
    @GetMapping(value = "/product-list")
    public ResponseEntity<Page<Product>> getAllByOptions(@RequestParam(defaultValue = "") String name,
                                                         @RequestParam(defaultValue = "") String category,
                                                         @RequestParam(defaultValue = "") String price,
                                                         @RequestParam(defaultValue = "0") String page){
        if (page.equals("")){
            page = "0";
        }
        if (name == null || category == null || price == null || page == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Pageable pageable = PageRequest.of(Integer.parseInt(page), 5);
        Long minPrice = 0L;
        Long maxPrice = 0L;


        if (price.equals("")){
            minPrice = 0L;
            maxPrice = 9999999999999L;
        } else {
            String[] priceArr = price.split("-");
            minPrice = Long.parseLong(priceArr[0]);
            maxPrice = Long.parseLong(priceArr[1]);
        }

        Page<Product> products = productService.getAllByOptions(name, category, minPrice, maxPrice, pageable);
        if (products.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(products, HttpStatus.OK);
        }
    }
}
