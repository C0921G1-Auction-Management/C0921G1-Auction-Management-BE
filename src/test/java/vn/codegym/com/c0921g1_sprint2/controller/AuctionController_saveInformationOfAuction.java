package vn.codegym.com.c0921g1_sprint2.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class AuctionController_saveInformationOfAuction {

    @Autowired
    private AuctionController auctionController;

    //    Trường hợp đối tượng auction bị null
    @Test
    public void saveInformationOfAuction_13() {
        ResponseEntity<?> responseEntity
                = this.auctionController.saveInformationOfAuction(null);
        Assertions.assertEquals(400, responseEntity.getStatusCodeValue());
    }

    //    Trường hợp đối tượng auction bị rỗng
    @Test
    public void saveInformationOfAuction_14() {
        ResponseEntity<?> responseEntity
                = this.auctionController.saveInformationOfAuction(null);
        Assertions.assertEquals(400, responseEntity.getStatusCodeValue());
    }
}
