package vn.codegym.com.c0921g1_sprint2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.com.c0921g1_sprint2.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
