package vn.codegym.com.c0921g1_sprint2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.codegym.com.c0921g1_sprint2.DTO.member.MemberDTO;
import vn.codegym.com.c0921g1_sprint2.model.Member;
import vn.codegym.com.c0921g1_sprint2.service.MemberService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/c09")
@CrossOrigin(origins = "*")
public class MemberController {

    @Autowired
    private MemberService memberService;

    //create member - KhanhLDQ
    @PostMapping(value = "/public/member", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> createMember(
            @Validated @RequestBody MemberDTO memberDTO,
            BindingResult bindingResult) {

        new MemberDTO().validate(memberDTO,bindingResult);

        Optional<Member> existedMemberByEmail = memberService.findMemberByEmail(memberDTO.getEmail());

        List<FieldError> errorList = new ArrayList<>();

        if (bindingResult.hasFieldErrors())
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.NOT_ACCEPTABLE);

        if (existedMemberByEmail.isPresent()) {
            errorList.add(new FieldError("emailDup","email",
                    "Dữ liệu đã tồn tại! Mời bạn nhập lại!"));

            return new ResponseEntity<>(errorList, HttpStatus.NOT_ACCEPTABLE);
        }

        memberService.createMember(memberDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //check existed member by email - KhanhLDQ
    @GetMapping("/public/member/email")
    public ResponseEntity<Member> getMemberByEmail(@RequestParam("email") String email) {
        Optional<Member> member = memberService.findMemberByEmail(email);

        if (!member.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(member.get(),HttpStatus.OK);
    }


}
