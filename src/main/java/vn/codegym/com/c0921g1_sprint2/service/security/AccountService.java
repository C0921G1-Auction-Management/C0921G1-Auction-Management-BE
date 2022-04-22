package vn.codegym.com.c0921g1_sprint2.service.security;

import vn.codegym.com.c0921g1_sprint2.model.security.Account;

import java.util.List;

public interface AccountService {

    //get all accounts - KhanhLDQ
    List<Account> getAll();

    //get account by username - KhanhLDQ
    Account findAccountByUsername(String username);

}
