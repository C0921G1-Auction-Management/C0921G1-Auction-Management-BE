package vn.codegym.com.c0921g1_sprint2.repository.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.com.c0921g1_sprint2.model.security.AccountRole;

@Repository
public interface AccountRoleRepository extends JpaRepository<AccountRole, Integer> {
}
