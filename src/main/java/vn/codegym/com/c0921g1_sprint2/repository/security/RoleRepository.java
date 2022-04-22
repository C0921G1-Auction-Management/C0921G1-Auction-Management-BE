package vn.codegym.com.c0921g1_sprint2.repository.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.codegym.com.c0921g1_sprint2.model.security.Role;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    //get all roles - KhanhLDQ
    @Query(value = "select * from role",nativeQuery = true)
    List<Role> getAll();

}
