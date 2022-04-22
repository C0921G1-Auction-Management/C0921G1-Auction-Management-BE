package vn.codegym.com.c0921g1_sprint2.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.codegym.com.c0921g1_sprint2.dto.ProductDto;
import vn.codegym.com.c0921g1_sprint2.model.Product;
import vn.codegym.com.c0921g1_sprint2.service.CategoryService;
import vn.codegym.com.c0921g1_sprint2.service.MemberService;
import vn.codegym.com.c0921g1_sprint2.service.ProductService;
import vn.codegym.com.c0921g1_sprint2.service.TransactionService;

import java.util.Optional;

@CrossOrigin("*")
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private TransactionService transactionService;

    //CaHM lấy list product
    @GetMapping("/getAllProduct")
    public ResponseEntity<Page<Product>> getAllProduct(@RequestParam(defaultValue = "") String nameProduct,
                                                       @RequestParam(defaultValue = "") String nameMember,
                                                       @RequestParam(defaultValue = "") String category_id,
                                                       @RequestParam(defaultValue = "") String start_bid,
                                                       @RequestParam(defaultValue = "") String approved_status,
                                                       @RequestParam(defaultValue = "0") Integer page
    ) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Product> pageProduct = productService.getFieldProduct(nameProduct, nameMember, category_id, start_bid, approved_status, pageable);
        if (pageProduct.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(pageProduct, HttpStatus.OK);
        }
    }

    //CaHM lấy một sản phẩm
    @GetMapping("/{id}/findByIdProduct")
    public ResponseEntity<?> findByIdProduct(@PathVariable Long id) {
        Optional<Product> optionalProduct = productService.findByIdProduct(id);
        if (!optionalProduct.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(optionalProduct.get(), HttpStatus.OK);
        }
    }

    //CaHM update product
    @PatchMapping("/{id}/updateProduct")
    public ResponseEntity<?> updateProduct(@PathVariable Long id,
                                           @RequestBody @Validated ProductDto productDto,
                                           BindingResult bindingResult) {
        Optional<Product> optionalProduct = productService.findByIdProduct(id);
        new ProductDto().validate(productDto,bindingResult);
        if (!optionalProduct.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.hasFieldErrors(), HttpStatus.BAD_REQUEST);
        }
        productDto.setId(optionalProduct.get().getId());
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        productService.updateProduct(product);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    // CaHM approved product
    @PatchMapping("/{id}/approvedProduct")
    public ResponseEntity<?> approved(@PathVariable Long id, Product product) {
        Optional<Product> optionalProduct = productService.findByIdProduct(id);
        if (!optionalProduct.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {

            productService.approved(optionalProduct.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
