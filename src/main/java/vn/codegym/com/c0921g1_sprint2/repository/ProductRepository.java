package vn.codegym.com.c0921g1_sprint2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.codegym.com.c0921g1_sprint2.model.Product;


import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    //LongTK
    @Query(value = "SELECT * FROM product \n" +
            " join transaction on transaction.product_id = product.id\n" +
            " join member on transaction.member_id = member.id\n" +
            " where member.id = :memberId and payment_status = 1 ",
            countQuery = "SELECT count(*) FROM product \n" +
                    " join transaction on transaction.product_id = product.id\n" +
                    " join member on transaction.member_id = member.id\n" +
                    " where member.id = :memberId and payment_status = 1 ",
            nativeQuery = true)
    Page<Product> getProductListByMemberId(@Param("memberId") Long memberId, Pageable page);
}
