package vn.codegym.com.c0921g1_sprint2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.codegym.com.c0921g1_sprint2.model.Member;

import java.util.Optional;

@Repository
@Transactional
public interface MemberRepository extends JpaRepository<Member, Long> {

    //    AnhVN detail member theo id
    @Query(value = "select * from member where member.id = :ids", nativeQuery = true)
    Optional<Member> findByIdMember(@Param("ids") Long id);


    //    AnhVN edit member
    @Modifying
    @Query(value = "UPDATE `c0921g1_sprint_2`.`member` SET `address` = :address, `day_of_birth` = :date_Of_Birth, `delete_flag` = :flag_delete, \n" +
            " `email` = :email, `gender` = :gender, `lock_flag` = :flag_lock, `name` = :name, `phone_number` = :phone_number,\n" +
            " `point` = :point, `total_money` = :total_money, `warning` = :warning WHERE (`id` = :id)", nativeQuery = true)
    void editMember(
            @Param("address") String address,
            @Param("date_Of_Birth") String date_Of_Birth,
            @Param("flag_delete") Integer flag_delete,
            @Param("email") String email,
            @Param("gender") Integer gender,
            @Param("flag_lock") Integer flag_lock,
            @Param("name") String name,
            @Param("phone_number") String phone_number,
            @Param("point") Long point,
            @Param("total_money") Long total_money,
            @Param("warning") Integer warning,
            @Param("id") Long id);
}