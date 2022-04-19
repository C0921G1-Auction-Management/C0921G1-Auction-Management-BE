package vn.codegym.com.c0921g1_sprint2.controller;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.codegym.com.c0921g1_sprint2.dto.ProjectDTO;
import vn.codegym.com.c0921g1_sprint2.model.Product;
import vn.codegym.com.c0921g1_sprint2.service.ProductService;

import javax.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/product/")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("create")
    public ResponseEntity<?> registerProduct(@RequestBody @Valid ProjectDTO projectDTO,
                                             BindingResult bindingResult){
        new ProjectDTO().validate(projectDTO,bindingResult);
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getAllErrors(),HttpStatus.BAD_REQUEST);
        }else {
            Product product =new Product();
            BeanUtils.copyProperties(projectDTO,product);
            productService.saveProduct(product);
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }

}
