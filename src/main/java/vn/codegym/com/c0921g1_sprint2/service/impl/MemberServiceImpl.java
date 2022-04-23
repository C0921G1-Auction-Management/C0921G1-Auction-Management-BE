package vn.codegym.com.c0921g1_sprint2.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import vn.codegym.com.c0921g1_sprint2.DTO.member.MemberDTO;
import vn.codegym.com.c0921g1_sprint2.model.Member;
import vn.codegym.com.c0921g1_sprint2.model.security.Account;
import vn.codegym.com.c0921g1_sprint2.repository.MemberRepository;
import vn.codegym.com.c0921g1_sprint2.service.MemberService;

import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //find member by account - KhanhLDQ
    @Override
    public Optional<Member> findMemberByAccount(Integer accountId) {
        return memberRepository.findMemberByAccount(accountId);
    }

    //create member - KhanhLDQ
    @Override
    public void createMember(MemberDTO memberDTO) {
        Member member = new Member();
        BeanUtils.copyProperties(memberDTO,member);

        Account account = new Account();
        String encodedPassword = bCryptPasswordEncoder.encode(memberDTO.getPassword());

        account.setEmail(member.getEmail());
        account.setEncryptPw(encodedPassword);
        account.setIsEnabled(1);
        account.setUsername(member.getEmail());

        member.setAccount(account);
        member.setPoint(0L);

        memberRepository.save(member);
        memberRepository.createAccount(account.getId());
    }

    //check existed email for member - KhanhLDQ
    @Override
    public Optional<Member> findMemberByEmail(String email) {
        return memberRepository.findMemberByEmail(email);
    }

}
