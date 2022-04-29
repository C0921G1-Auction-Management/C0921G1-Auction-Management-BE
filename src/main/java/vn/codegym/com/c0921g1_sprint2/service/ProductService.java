package vn.codegym.com.c0921g1_sprint2.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.com.c0921g1_sprint2.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    //LongTK
    Page<Product> getProductListByMemberId(Long id, Pageable pageable);

    //LongTK
    Optional<Product> findById(long id);

    //LongTK
    List<Product> findAllByMemberId(Long id);

    //LongTK
    List<Long> changePaymentStatusId(String condition);

    //LongTK
    void changePaymentStatus(long id);
}
