package vn.codegym.com.c0921g1_sprint2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.com.c0921g1_sprint2.model.Transaction;
import vn.codegym.com.c0921g1_sprint2.repository.ProductRepository;
import vn.codegym.com.c0921g1_sprint2.repository.TransactionRepository;
import vn.codegym.com.c0921g1_sprint2.service.TransactionService;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;


    @Override
    public Long findPriceByProductId(Long id) {
        return transactionRepository.getPriceByProductId(id);
    }
}
