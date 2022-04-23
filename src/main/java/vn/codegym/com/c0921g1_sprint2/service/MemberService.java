package vn.codegym.com.c0921g1_sprint2.service;

import vn.codegym.com.c0921g1_sprint2.DTO.member.MemberDTO;
import vn.codegym.com.c0921g1_sprint2.model.Member;

import java.util.Optional;

public interface MemberService {

    //find member by account - KhanhLDQ
    Optional<Member> findMemberByAccount(Integer accountId);

    //create member - KhanhLDQ
    void createMember(MemberDTO memberDTO);

    //check existed email - KhanhLDQ
    Optional<Member> findMemberByEmail(String email);

}
