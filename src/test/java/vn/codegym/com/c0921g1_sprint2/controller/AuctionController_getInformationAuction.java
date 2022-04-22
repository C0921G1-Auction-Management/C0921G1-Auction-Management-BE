package vn.codegym.com.c0921g1_sprint2.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import vn.codegym.com.c0921g1_sprint2.model.Auction;

@SpringBootTest
public class AuctionController_getInformationAuction {
    @Autowired
    AuctionController auctionController;

    //    Trường hợp tất cả tham số đều null
    @Test
    public void getInformationAuction_page_seeMore_7() {
        ResponseEntity<Page<Auction>> responseEntity
                = this.auctionController.getInformationAuction(null, null);
        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

    //    Trường hợp tham số page null, seeMore có giá trị
    @Test
    public void getInformationAuction_page_7() {
        ResponseEntity<Page<Auction>> responseEntity
                = this.auctionController.getInformationAuction(null, 5);
        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

    //    Trường hợp tham số page có giá trị, seeMore null
    @Test
    public void getInformationAuction_seeMore_7() {
        ResponseEntity<Page<Auction>> responseEntity
                = this.auctionController.getInformationAuction(0, null);
        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

//    //    Trường hợp tất cả tham số đều rỗng. Lỗi compile
//    @Test
//    public void getInformationAuction_page_seeMore_8() {
//        ResponseEntity<Page<Auction>> responseEntity
//                = this.auctionController.getInformationAuction("", "");
//        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
//    }

    //    Trường hợp tham số page rỗng, seeMore có giá trị. Lỗi compile. Lỗi compile
//    @Test
//    public void getInformationAuction_page_8() {
//        ResponseEntity<Page<Auction>> responseEntity
//                = this.auctionController.getInformationAuction("", 5);
//        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
//    }

    //    Trường hợp tham số page có giá trị, seeMore rỗng. Lỗi compile
//    @Test
//    public void getInformationAuction_seeMore_8() {
//        ResponseEntity<Page<Auction>> responseEntity
//                = this.auctionController.getInformationAuction(0, "");
//        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
//    }

    //        Trường hợp tham số page và seeMore có giá trị
    @Test
    public void getInformationAuction_seeMore_11() {
        ResponseEntity<Page<Auction>> responseEntity
                = this.auctionController.getInformationAuction(0, 5);
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals(9000000,
                responseEntity.getBody().getContent().get(0).getCurrentBid());
        Assertions.assertEquals("2022-04-22",
                responseEntity.getBody().getContent().get(0).getAuctionTime());
        Assertions.assertEquals(1,
                responseEntity.getBody().getContent().get(0).getQuantity());
        Assertions.assertEquals(1,
                responseEntity.getBody().getContent().get(0).getMembers().getId());
    }

    //    Trường hợp database trống
    @Test
    public void getInformationAuction_10() {
        ResponseEntity<Page<Auction>> responseEntity
                = this.auctionController.getInformationAuction(0, 5);
        Assertions.assertEquals(0, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(0, responseEntity.getBody().getTotalElements());
    }

}
