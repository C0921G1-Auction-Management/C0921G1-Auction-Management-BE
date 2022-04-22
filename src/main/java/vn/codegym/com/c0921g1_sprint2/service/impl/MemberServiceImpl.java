package vn.codegym.com.c0921g1_sprint2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.com.c0921g1_sprint2.model.Member;
import vn.codegym.com.c0921g1_sprint2.model.dto.MemberDTONhanNT;
import vn.codegym.com.c0921g1_sprint2.repository.MemberRepository;
import vn.codegym.com.c0921g1_sprint2.service.MemberService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Override
    public Page<MemberDTONhanNT> getListMember(Long id, String name, String address, String email, int rank, Pageable pageable) {
        Long point1;
        Long point2;
        switch (rank) {
            case 1:
                point1 = 0l;
                point2 = 10l;
                break;
            case 2:
                point1 = 11l;
                point2 = 20l;
                break;
            case 3:
                point1 = 21l;
                point2 = 30l;
                break;
            case 4:
                point1 = 31l;
                point2 = 40l;
                break;
            case 5:
                point1 = 41l;
                point2 = 100000l;
                break;
            default:
                point1 = 0l;
                point2 = 100000l;
        }

        return memberRepository.getListMember(id, name, address, email, point1, point2, pageable);
    }

    @Override
    public void lockMember(List<Member> members) {
//        String[] parts = members.split(",");
        for (int i = 0; i < members.size(); i++) {
//            System.out.println(parts[i]);
            memberRepository.lockMember(members.get(i).getId());
        }
    }

    @Override
    public List<Member> findByIdMember(String id) {
        List<Member> listThis = new ArrayList<>();
        String[] parts = id.split(",");
        for (int i = 0; i < parts.length; i++) {
            if (memberRepository.findByIdMember(Integer.parseInt(parts[i])).isPresent()) {
                listThis.add(
                        memberRepository.findByIdMember(Integer.parseInt(parts[i])).get()
                );
            }
        }
        return listThis;
    }

//    public static void main(String[] args) {
//        String list = "1,2,3,4,5";
//        MemberService memberService = new MemberServiceImpl();
//        List<Member> loser = memberService.findByIdMember(list);
//
//        for (int j = 0; j < loser.size(); j++) {
//            System.out.println(j);
//        }
//
//    }
}
