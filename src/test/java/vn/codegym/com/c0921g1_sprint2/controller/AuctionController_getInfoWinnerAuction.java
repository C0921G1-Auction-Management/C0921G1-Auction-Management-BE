package vn.codegym.com.c0921g1_sprint2.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import vn.codegym.com.c0921g1_sprint2.model.Auction;

import javax.mail.MessagingException;

@SpringBootTest
public class AuctionController_getInfoWinnerAuction {

    @Autowired
    AuctionController auctionController;

    //    Trường hợp database có giá trị
    @Test
    public void getInformationAuction_10() throws MessagingException {
        ResponseEntity<Auction> responseEntity
                = this.auctionController.getInfoWinnerAuction();
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }
}
