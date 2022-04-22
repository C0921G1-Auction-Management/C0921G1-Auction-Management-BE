package vn.codegym.com.c0921g1_sprint2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.com.c0921g1_sprint2.repository.CategoryRepository;
import vn.codegym.com.c0921g1_sprint2.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
}
