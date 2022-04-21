package vn.codegym.com.c0921g1_sprint2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vn.codegym.com.c0921g1_sprint2.model.Member;
import vn.codegym.com.c0921g1_sprint2.model.dto.MemberDTONhanNT;
import vn.codegym.com.c0921g1_sprint2.service.MemberService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/c09")
@CrossOrigin(origins = "*")
public class MemberController {
    @Autowired
    MemberService memberService;

    //get list member NhanNT
    @GetMapping("/member/list")
    public ResponseEntity<Iterable<MemberDTONhanNT>> getTradingHistory(@RequestParam(defaultValue = "0") int page,
                                                                       @RequestParam(defaultValue = "") Long memberID,
                                                                       @RequestParam(defaultValue = "") String memberName,
                                                                       @RequestParam(defaultValue = "") String memberAddress,
                                                                       @RequestParam(defaultValue = "") String memberEmail,
                                                                       @RequestParam(defaultValue = "0") int memberRank){

        Pageable pageable = PageRequest.of(page, 5);
        Page<MemberDTONhanNT> memberDTOList = memberService.getListMember(memberID,memberName,memberAddress,memberEmail,memberRank,pageable);

        if (memberDTOList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(memberDTOList, HttpStatus.OK);
    }

    @GetMapping("/member/lock")
    public ResponseEntity<?> lockMember(@RequestParam(defaultValue = "") String listMember){

        List<Member> memberList = memberService.findByIdMember(listMember);
        if (memberList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            memberService.lockMember(listMember);
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }
//    //TaiLM xóa phim
//    @GetMapping("delete/{id}")
//    public ResponseEntity<?> delete(@PathVariable Integer id) {
//        Optional<Film> filmOptional = filmService.findByIdFilm(id);
//
//        if (filmOptional.isPresent()) {
//            filmService.deleteFilm(filmOptional.get().getId());
//            return new ResponseEntity<>(HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//    }
}
