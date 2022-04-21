package vn.codegym.com.c0921g1_sprint2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.codegym.com.c0921g1_sprint2.model.Transaction;

import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

//    Query filter + list AnhVN
    @Query(value = "select * From c0921g1_sprint_2.transaction \n" +
            " join `member` on `transaction`.member_id = member_id\n" +
            " join `product` on `transaction`.product_id = product_id\n" +
            " where `member`.name like %?1% and `member`.name like %?2% and `product`.name like %?3% and `member`.total_money like %?4% and `transaction`.currrent_bid like %?5%\n" +
            " group by `member`.id",nativeQuery = true)
    Page<Transaction> findAllTransactionTicket(String member_sell, String member_buy, String name_product, String total_money, String status, Pageable pageable1);

//    Query tìm kiếm theo id AnhVN
    @Query(value = "select * from `transaction` \n" +
            " where `transaction`.id = :ids and `transaction`.delete_flag = 0;", nativeQuery = true)
    Optional<Transaction> findByIdTransaction(@Param("ids") Long id);

//   Query xóa giao dịch
    @Modifying
    @Query(value = "update `transaction` set `transaction`.delete_flag = 1\n" +
            " where `transaction`.id = ?1;", nativeQuery = true)
    void deleteTransaction(Long id);
}
