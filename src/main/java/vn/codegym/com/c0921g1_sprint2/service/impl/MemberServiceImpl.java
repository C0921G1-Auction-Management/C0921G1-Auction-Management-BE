package vn.codegym.com.c0921g1_sprint2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.com.c0921g1_sprint2.model.Member;
import vn.codegym.com.c0921g1_sprint2.repository.MemberRepository;
import vn.codegym.com.c0921g1_sprint2.service.MemberService;

import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberRepository memberRepository;

    //    AnhVN detail member theo id
    @Override
    public Optional<Member> findByIdMember(Long id) {
        return memberRepository.findByIdMember(id);
    }

    //    AnhVN edit member theo id
    @Override
    public void editMember(Member member) {
        memberRepository.editMember(member.getAddress(), member.getDayOfBirth(),
                member.getDeleteFlag(), member.getEmail(), member.getGender(), member.getLockFlag(),
                member.getName(), member.getPhoneNumber(), member.getPoint(), member.getTotalMoney(),
                member.getWarning(), member.getId());
    }
}
