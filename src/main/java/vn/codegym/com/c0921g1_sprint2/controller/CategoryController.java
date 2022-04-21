package vn.codegym.com.c0921g1_sprint2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.codegym.com.c0921g1_sprint2.model.Category;
import vn.codegym.com.c0921g1_sprint2.service.CategoryService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/category/")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping()
    public ResponseEntity<List<Category>> findAll(){
        if (categoryService.findAll().isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(categoryService.findAll(),HttpStatus.OK);
        }
    }
}
