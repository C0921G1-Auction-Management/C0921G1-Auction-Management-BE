package vn.codegym.com.c0921g1_sprint2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.com.c0921g1_sprint2.repository.TransactionRepository;
import vn.codegym.com.c0921g1_sprint2.service.TransactionService;
@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
}
