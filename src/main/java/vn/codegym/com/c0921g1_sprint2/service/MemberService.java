package vn.codegym.com.c0921g1_sprint2.service;

import vn.codegym.com.c0921g1_sprint2.model.Member;

import java.util.Optional;

public interface MemberService {
    Optional<Member>findById(Long id);
}
