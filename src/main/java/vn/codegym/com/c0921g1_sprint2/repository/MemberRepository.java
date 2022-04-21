package vn.codegym.com.c0921g1_sprint2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import vn.codegym.com.c0921g1_sprint2.model.Member;
import vn.codegym.com.c0921g1_sprint2.model.dto.MemberDTONhanNT;

import javax.transaction.Transactional;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    //NhanNT list member
    @Query(value = "SELECT id, address, email, lock_flag as lockFlag, `name`, phone_number as phoneNumber, `point` \n" +
            "FROM member \n "+
            "Where id like %?1% && `name` like %?2% && address like %?3% && email like %?4% && point between ?5 and ?6", nativeQuery = true)
    Page<MemberDTONhanNT> getListMember(Long id, String name, String address, String email, Long point1, Long point2, Pageable pageable);

    //NhanNT tim member by ID
    @Query(value = "select * from member where member.id = ?1 and lock_flag =0 ", nativeQuery = true)
    Optional<Member> findByIdMember( Integer id);

    //NhanNT khoá member
    @Modifying
    @Transactional
    @Query(value = "update member\n" +
            "set lock_flag =1\n" +
            "where id = ?1", nativeQuery = true)
    void lockMember(Integer id);

}
