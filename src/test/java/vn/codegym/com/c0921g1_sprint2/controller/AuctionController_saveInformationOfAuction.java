package vn.codegym.com.c0921g1_sprint2.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import vn.codegym.com.c0921g1_sprint2.dto.AuctionDto;
import vn.codegym.com.c0921g1_sprint2.model.Member;
import vn.codegym.com.c0921g1_sprint2.model.Product;

@SpringBootTest
public class AuctionController_saveInformationOfAuction {

    @Autowired
    private AuctionController auctionController;

    BindingResult bindingResult;

    //    Trường hợp đối tượng auction bị null
    @Test
    public void saveInformationOfAuction_13() {
        ResponseEntity<?> responseEntity
                = this.auctionController.saveInformationOfAuction(null,bindingResult);
        Assertions.assertEquals(400, responseEntity.getStatusCodeValue());
    }

    //    *Note: Không có trường hợp đối tượng thuộc tính id của auction null vì không cho nhập

    //    Trường hợp member_id bị null
    @Test
    public void saveInformationOfAuction_memberId_13() {
        Member member = new Member();
        member.setId(null);

        AuctionDto auctionDto = new AuctionDto();
        auctionDto.setMembers(member);
        auctionDto.setQuantity(2);
        auctionDto.setCurrentBid(4000);
        auctionDto.setAuctionTime("2022-04-22 17:09:08");

        ResponseEntity<?> responseEntity
                = this.auctionController.saveInformationOfAuction(auctionDto,bindingResult);
        Assertions.assertEquals(400, responseEntity.getStatusCodeValue());
    }

    //    Trường hợp product_id bị null
    @Test
    public void saveInformationOfAuction_productId_13() {
        Product product = new Product();
        product.setId(null);

        AuctionDto auctionDto = new AuctionDto();
        auctionDto.setProduct(product);
        auctionDto.setQuantity(2);
        auctionDto.setCurrentBid(4000);
        auctionDto.setAuctionTime("2022-04-22 17:09:08");

        ResponseEntity<?> responseEntity
                = this.auctionController.saveInformationOfAuction(auctionDto,bindingResult);
        Assertions.assertEquals(400, responseEntity.getStatusCodeValue());
    }

    //    Trường hợp currentBid bị null
    @Test
    public void saveInformationOfAuction_currentBid_13() {
        Product product = new Product();
        product.setId(1L);
        Member member = new Member();
        member.setId(1L);

        AuctionDto auctionDto = new AuctionDto();
        auctionDto.setProduct(product);
        auctionDto.setMembers(member);
        auctionDto.setQuantity(2);
        auctionDto.setCurrentBid(null);
        auctionDto.setAuctionTime("2022-04-22 17:09:08");

        ResponseEntity<?> responseEntity
                = this.auctionController.saveInformationOfAuction(auctionDto,bindingResult);
        Assertions.assertEquals(400, responseEntity.getStatusCodeValue());
    }

    //    Trường hợp quantity bị null
    @Test
    public void saveInformationOfAuction_quantity_13() {
        Product product = new Product();
        product.setId(1L);
        Member member = new Member();
        member.setId(1L);

        AuctionDto auctionDto = new AuctionDto();
        auctionDto.setProduct(product);
        auctionDto.setMembers(member);
        auctionDto.setQuantity(null);
        auctionDto.setCurrentBid(4000);
        auctionDto.setAuctionTime("2022-04-22 17:09:08");

        ResponseEntity<?> responseEntity
                = this.auctionController.saveInformationOfAuction(auctionDto,bindingResult);
        Assertions.assertEquals(400, responseEntity.getStatusCodeValue());
    }

    //    Trường hợp auctionTime bị null
    @Test
    public void saveInformationOfAuction_auctionTime_13() {
        Product product = new Product();
        product.setId(1L);
        Member member = new Member();
        member.setId(1L);

        AuctionDto auctionDto = new AuctionDto();
        auctionDto.setProduct(product);
        auctionDto.setMembers(member);
        auctionDto.setQuantity(1);
        auctionDto.setCurrentBid(4000);
        auctionDto.setAuctionTime(null);

        ResponseEntity<?> responseEntity
                = this.auctionController.saveInformationOfAuction(auctionDto,bindingResult);
        Assertions.assertEquals(400, responseEntity.getStatusCodeValue());
    }

//    *Note: Những trường hợp còn lại là bị null nhiều trường thì cũng nhảy vào NullPointerException và đều return
//    về BAD_REQUEST hết nên chỉ test cho những trường hợp ở trên .

 // Note: Auction sẽ không có các trường hợp rỗng vì không cho nhập mà sẽ xử lý để lưu xuống database. ngoại trừ trường hợp được nhập là giá dấu.


//    //    Trường hợp auctionTime bị rỗng. trường hợp này sẽ return http status 400 vì xảy ra number Exception nhưng không check được
//    //    vì lỗi compile string mà khai báo kiểu Long. Comment lại để chạy chương trình không bị lỗi.
//    @Test
//    public void saveInformationOfAuction_currentBid_14() {
//        Product product = new Product();
//        product.setId(1L);
//        Member member = new Member();
//        member.setId(1L);
//
//        AuctionDto auctionDto = new AuctionDto();
//        auctionDto.setProduct(product);
//        auctionDto.setMembers(member);
//        auctionDto.setQuantity(1);
//        auctionDto.setCurrentBid("");
//        auctionDto.setAuctionTime("2022-04-22 17:09:08");
//
//        ResponseEntity<?> responseEntity
//                = this.auctionController.saveInformationOfAuction(auctionDto,bindingResult);
//        Assertions.assertEquals(400, responseEntity.getStatusCodeValue());
//    }

    //    Trường hợp giá đấu nhập vào nhỏ hơn giá hiện tại đang đấu.
    @Test
    public void saveInformationOfAuction_currentBid_15() {
        Product product = new Product();
        product.setId(1L);
        Member member = new Member();
        member.setId(1L);

        AuctionDto auctionDto = new AuctionDto();
        auctionDto.setProduct(product);
        auctionDto.setMembers(member);
        auctionDto.setQuantity(1);
        auctionDto.setCurrentBid(1000);
        auctionDto.setAuctionTime("2022-04-22 17:09:08");

        ResponseEntity<?> responseEntity
                = this.auctionController.saveInformationOfAuction(auctionDto,bindingResult);
        Assertions.assertEquals(406, responseEntity.getStatusCodeValue());
    }

    //    Trường hợp tất cả các trường đều hợp lệ
    @Test
    public void saveInformationOfAuction_auctionTime_18() {
        Product product = new Product();
        product.setId(1L);
        Member member = new Member();
        member.setId(1L);

        AuctionDto auctionDto = new AuctionDto();
        auctionDto.setProduct(product);
        auctionDto.setMembers(member);
        auctionDto.setQuantity(1);
        auctionDto.setCurrentBid(15000);
        auctionDto.setAuctionTime("2022-04-22 17:09:08");

        ResponseEntity<?> responseEntity
                = this.auctionController.saveInformationOfAuction(auctionDto,bindingResult);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }

}
