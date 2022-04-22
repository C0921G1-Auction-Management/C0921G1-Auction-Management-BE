package vn.codegym.com.c0921g1_sprint2.repository.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.codegym.com.c0921g1_sprint2.model.security.Account;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {

    //get all accounts - KhanhLDQ
    @Query(value = "select * from account", nativeQuery = true)
    List<Account> getAll();

    //get account by username - KhanhLDQ
    @Query(value = "select * from account where username = ?1", nativeQuery = true)
    Account findAccountByUsername(String username);

}
