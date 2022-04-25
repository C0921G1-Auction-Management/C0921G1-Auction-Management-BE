package vn.codegym.com.c0921g1_sprint2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.com.c0921g1_sprint2.model.Transaction;
import vn.codegym.com.c0921g1_sprint2.service.TransactionService;

import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    //    Chức năng hiển thị list và lọc của AnhVN
    @GetMapping(value = "/list")
    public ResponseEntity<Page<Transaction>> listTransaction(@RequestParam(defaultValue = "0") Integer pageable,
                                                             @RequestParam(defaultValue = "") String member_sell,
                                                             @RequestParam(defaultValue = "") String member_buy,
                                                             @RequestParam(defaultValue = "") String name_product,
                                                             @RequestParam(defaultValue = "") String total_money,
                                                             @RequestParam(defaultValue = "") String status
    ) {
        Pageable pageable1 = PageRequest.of(pageable, 10);

        Page<Transaction> transactionsListFilter = transactionService.findAllTransaction(member_sell, member_buy, name_product, total_money, status, pageable1);
        if (transactionsListFilter.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(transactionsListFilter, HttpStatus.OK);
    }

     //    Chức năng xóa giao dịch của AnhVN
     @GetMapping("delete/{id}")
     public ResponseEntity<?> deleteTransaction(@PathVariable Long id) {
         Optional<Transaction> transactionOptional = transactionService.findByIdTransaction(id);

         if (transactionOptional.isPresent()) {
             transactionService.deleteTransaction(transactionOptional.get().getId());
             return new ResponseEntity<>(HttpStatus.OK);
         } else {
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }

     }
}
