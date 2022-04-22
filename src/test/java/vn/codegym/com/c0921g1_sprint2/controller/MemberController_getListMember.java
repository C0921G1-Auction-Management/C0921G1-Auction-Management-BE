package vn.codegym.com.c0921g1_sprint2.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import vn.codegym.com.c0921g1_sprint2.model.dto.MemberDTONhanNT;

@SpringBootTest
public class MemberController_getListMember {
    @Autowired
    private MemberController memberController;

    //trường hợp tham số null
    @Test
    public void getListMember_7_1(){
        ResponseEntity<Iterable<MemberDTONhanNT>> responseEntity =
                this.memberController.getListMember(null,1L,"","","",0);

        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }
    @Test
    public void getListMember_7_2(){
        ResponseEntity<Iterable<MemberDTONhanNT>> responseEntity =
                this.memberController.getListMember(0,null,"","","",0);

        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }
    @Test
    public void getListMember_7_3(){
        ResponseEntity<Iterable<MemberDTONhanNT>> responseEntity =
                this.memberController.getListMember(0,0L,null,"","",0);

        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }
    @Test
    public void getListMember_7_4(){
        ResponseEntity<Iterable<MemberDTONhanNT>> responseEntity =
                this.memberController.getListMember(0,0L,"",null,"",0);

        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }
    @Test
    public void getListMember_7_5(){
        ResponseEntity<Iterable<MemberDTONhanNT>> responseEntity =
                this.memberController.getListMember(0,0L,"","",null,0);

        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }
    @Test
    public void getListMember_7_6(){
        ResponseEntity<Iterable<MemberDTONhanNT>> responseEntity =
                this.memberController.getListMember(0,0L,"","","",null);

        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }
    @Test
    public void getListMember_9_1(){
        ResponseEntity<Iterable<MemberDTONhanNT>> responseEntity =
                this.memberController.getListMember(0,1L,"Test","","",0);

        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }
    @Test
    public void getListMember_10_1(){
        ResponseEntity<Iterable<MemberDTONhanNT>> responseEntity =
                this.memberController.getListMember(0,0L,"","","",0);

        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }
    @Test
    public void getListMember_11_1(){
        ResponseEntity<Iterable<MemberDTONhanNT>> responseEntity =
                this.memberController.getListMember(0,1L,"","","",0);

        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }


}
