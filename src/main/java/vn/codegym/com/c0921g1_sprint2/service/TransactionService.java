package vn.codegym.com.c0921g1_sprint2.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.com.c0921g1_sprint2.model.Transaction;

import java.util.Optional;

public interface TransactionService {
    //    Phương thức list + filter Transaction của AnhVN
    Page<Transaction> findAllTransaction(String member_sell, String member_buy, String name_product, String total_money, String status, Pageable pageable1);

    //    Phương thức tìm kiếm giao dịch theo id của AnhVN
    Optional<Transaction> findByIdTransaction(Long id);

    //    Phương thức xóa giao dịch theo id của AnhVN
    void deleteTransaction(Long id);
}
