package vn.codegym.com.c0921g1_sprint2.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import vn.codegym.com.c0921g1_sprint2.model.Member;
import vn.codegym.com.c0921g1_sprint2.model.dto.MemberDTONhanNT;

import java.util.List;

@SpringBootTest
public class MemberController_lockMember {
    @Autowired
    private MemberController memberController;


    //trường hợp tham số null
    @Test
    public void lockMember_7(){
        ResponseEntity<?> responseEntity =
                this.memberController.lockMember(null);

        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }
    //trường hợp tham số rỗng
    @Test
    public void lockMember_8(){
        ResponseEntity<?> responseEntity =
                this.memberController.lockMember("");

        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }
    //trường hợp tham số không tồn tại
    @Test
    public void lockMember_9(){
        ResponseEntity<?> responseEntity =
                this.memberController.lockMember("3");

        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }
    //trường hợp thành công
    @Test
    public void lockMember_11(){
        ResponseEntity<?> responseEntity =
                this.memberController.lockMember("1,2");

        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }
}
