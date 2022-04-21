package vn.codegym.com.c0921g1_sprint2.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.com.c0921g1_sprint2.model.Member;
import vn.codegym.com.c0921g1_sprint2.model.dto.MemberDTONhanNT;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    Page<MemberDTONhanNT> getListMember(Long id, String name, String address, String email, int rank, Pageable pageable);
    void lockMember(String id);
    List<Member> findByIdMember(String id);
}
