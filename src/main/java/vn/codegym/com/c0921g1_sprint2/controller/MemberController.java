package vn.codegym.com.c0921g1_sprint2.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vn.codegym.com.c0921g1_sprint2.dto.MemberDTO;
import vn.codegym.com.c0921g1_sprint2.model.Member;
import vn.codegym.com.c0921g1_sprint2.service.MemberService;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@Controller
@RequestMapping("/member/")
public class MemberController {
    @Autowired
    MemberService memberService;

    //    AnhVN edit member theo id
    @PatchMapping("{id}")
    public ResponseEntity<Member> editDetailMember(@Valid @RequestBody MemberDTO memberDTO, @PathVariable Long id) {
        Optional<Member> memberOptional = this.memberService.findByIdMember(id);
        if (!memberOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        memberDTO.setId(memberOptional.get().getId());
        Member member = new Member();
        BeanUtils.copyProperties(memberDTO, member);
        this.memberService.editMember(member);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
