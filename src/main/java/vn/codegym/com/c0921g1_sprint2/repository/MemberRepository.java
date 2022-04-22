package vn.codegym.com.c0921g1_sprint2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.codegym.com.c0921g1_sprint2.model.Member;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    //find member by account - KhanhLDQ
    @Query(value = "select * from member m where m.account_id = :account_id", nativeQuery = true)
    Optional<Member> findMemberByAccount(
            @Param("account_id") Integer accountId
    );

}
