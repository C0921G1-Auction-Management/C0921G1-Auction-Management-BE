package vn.codegym.com.c0921g1_sprint2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.com.c0921g1_sprint2.model.Transaction;
import vn.codegym.com.c0921g1_sprint2.repository.TransactionRepository;
import vn.codegym.com.c0921g1_sprint2.service.TransactionService;

import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    
    //    Phương thức list + filter Transaction của AnhVN
    @Override
    public Page<Transaction> findAllTransaction(String member_sell, String member_buy, String name_product, String total_money, String status, Pageable pageable1) {
        return transactionRepository.findAllTransactionTicket(member_sell, member_buy, name_product, total_money, status, pageable1);
    }

    //    Phương thức tìm kiếm giao dịch theo id của AnhVN
    @Override
    public Optional<Transaction> findByIdTransaction(Long id) {
        return transactionRepository.findByIdTransaction(id);
    }

    //    Phương thức xóa giao dịch theo id của AnhVN
    @Override
    public void deleteTransaction(Long id) {
        transactionRepository.deleteTransaction(id);
    }
}
