package vn.codegym.com.c0921g1_sprint2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.com.c0921g1_sprint2.repository.MemberRepository;
import vn.codegym.com.c0921g1_sprint2.service.MemberService;
@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberRepository memberRepository;
}
