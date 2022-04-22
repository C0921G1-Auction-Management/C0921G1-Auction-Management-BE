package vn.codegym.com.c0921g1_sprint2.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.codegym.com.c0921g1_sprint2.model.security.Account;
import vn.codegym.com.c0921g1_sprint2.repository.security.AccountRepository;

@Service
@Transactional
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findAccountByUsername(username);

        if(account == null){
            throw new UsernameNotFoundException("User Not Found with username:"+ username);
        }

        return UserDetailsImpl.build(account);
    }

}
