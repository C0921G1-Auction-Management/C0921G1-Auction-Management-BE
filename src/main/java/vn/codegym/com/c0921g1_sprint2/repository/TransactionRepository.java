package vn.codegym.com.c0921g1_sprint2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.codegym.com.c0921g1_sprint2.model.Product;
import vn.codegym.com.c0921g1_sprint2.model.Transaction;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    //LongTK
    @Query(value = " SELECT currrent_bid FROM product \n" +
            "join transaction on transaction.product_id = product.id\n" +
            "join member on transaction.member_id = member.id\n" +
            "where product.id = :productId",
            countQuery = " SELECT count(currrent_bid) FROM product \n" +
                    " join transaction on transaction.product_id = product.id\n" +
                    " join member on transaction.member_id = member.id\n" +
                    " where product.id = :productId",
            nativeQuery = true)
    Long getPriceByProductId(@Param("productId") Long productId);
}
