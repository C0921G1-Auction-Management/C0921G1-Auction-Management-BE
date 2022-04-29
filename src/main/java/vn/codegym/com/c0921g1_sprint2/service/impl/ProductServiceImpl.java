package vn.codegym.com.c0921g1_sprint2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.com.c0921g1_sprint2.model.Product;
import vn.codegym.com.c0921g1_sprint2.repository.ProductRepository;
import vn.codegym.com.c0921g1_sprint2.service.ProductService;

import java.util.ArrayList;
import java.util.Arrays;
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


    @Override
    public List<Long> changePaymentStatusId(String idList) {
        System.out.println(idList);
        List<Long> longId = new ArrayList<>();
        List<String> myList = new ArrayList<String>(Arrays.asList(idList.split(",")));
        for (String id : myList) {
            try {
                Long addId = Long.parseLong(id);
                longId.add(addId);
            } catch (Exception e) {
                System.out.println("co loi tai: " + id + " " + e);
            }
        }
        return longId;
    }

    @Override
    public void changePaymentStatus(long id) {
        productRepository.changePaymentStatus(id);
    }


//    changePaymentStatus

}
