package vn.codegym.com.c0921g1_sprint2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;
import vn.codegym.com.c0921g1_sprint2.model.Transaction;

import java.util.List;

public interface StaticsticRepository extends JpaRepository<Transaction, Long> {
//    @Query(value = "select count(transaction.id) " +
//            "from transaction " +
//            "where year(transaction.transaction_date) like year(:dateStart) " +
//            "and (" +
//            "(month(transaction.transaction_date) like month(:dateStart) and (day(transaction.transaction_date) between day(:dateStart) and '31') " +
//            "or (month(transaction.transaction_date) like (month(:transaction.transaction_date) and day(:end_date) between '1' and day(:end_date) " +
////            "or (month(transaction.transaction_date) between month(:dateStart) and month(:end_date))" +
//            "))" +
//            "group by transaction.transaction_date " +
//            "order by transaction.transaction_date asc "
//            , nativeQuery = true)
    @Query(value = "select count (transaction.id) " +
            "from transaction " +
            "where transaction.transaction_date between :dateStart and :dateEnd " +
            "group by transaction.transaction_date " +
            "order by transaction.transaction_date asc "
            , nativeQuery = true)
    List<Integer> getNumberOfTransactionByDate(@RequestParam("dateStart") String dateStart,
                                      @RequestParam("dateEnd") String dateEnd);
}
