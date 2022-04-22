package vn.codegym.com.c0921g1_sprint2.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import vn.codegym.com.c0921g1_sprint2.model.Product;

@SpringBootTest
public class AuctionController_getProductById {
    @Autowired
    private AuctionController auctionController;

    //    Trường hợp tham số id bị null
    @Test
    public void getProductById_1() {
        ResponseEntity<Product> responseEntity
                = this.auctionController.getProductById(null);
        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

    //    Trường hợp tham số id bị rỗng. *Note: case này ko test được vì khai báo kiểu Long mà truyền vào kiểu
    //String nên bị lỗi compile. nên comment lại để chạy chương trình ko bị lỗi
//    @Test
//    public void getProductById_2() {
//        ResponseEntity<Product> responseEntity
//                = this.auctionController.getProductById("");
//        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
//    }


    //    Trường hợp tham số id không tồn tại trong database
    @Test
    public void getProductById_3() {
        ResponseEntity<Product> responseEntity
                = this.auctionController.getProductById(99L);
        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }


    //    Trường hợp tham số id tồn tại trong database
    @Test
    public void getProductById_4() {
        ResponseEntity<Product> responseEntity
                = this.auctionController.getProductById(1L);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals("Ly sứ",
                responseEntity.getBody().getName());
        Assertions.assertEquals(50000,
                responseEntity.getBody().getStartBid());
        Assertions.assertEquals("2022-04-29",
                responseEntity.getBody().getEndDate());
    }

}