package vn.codegym.com.c0921g1_sprint2.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest
public class AuctionController_getPriceCurrentList {

    @Autowired
    private AuctionController auctionController;

    //    Trường hợp cả 2 tham số productId và price bị null
    @Test
    public void getPriceCurrentList_productId_price_7() {
        ResponseEntity<List<Integer>> responseEntity
                = this.auctionController.getPriceCurrentList(null, null);
        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

    //    Trường hợp productId bị null, price có giá trị
    @Test
    public void getPriceCurrentList_productId_7() {
        ResponseEntity<List<Integer>> responseEntity
                = this.auctionController.getPriceCurrentList(null, 5000);
        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

    //    Trường hợp price bị null, productId có giá trị
    @Test
    public void getPriceCurrentList_price_7() {
        ResponseEntity<List<Integer>> responseEntity
                = this.auctionController.getPriceCurrentList(1L, null);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(50000,
                responseEntity.getBody().get(0));
        Assertions.assertEquals(55000,
                responseEntity.getBody().get(1));
        Assertions.assertEquals(60000,
                responseEntity.getBody().get(2));
        Assertions.assertEquals(65000,
                responseEntity.getBody().get(3));
        Assertions.assertEquals(120000,
                responseEntity.getBody().get(14));
    }

    //    Trường hợp cả 2 tham số productId và price bị rỗng, test sẽ bị lỗi compile nên comment lại để chạy chương trình, thực tế nếu 2 tham số cùng
    //rỗng sẽ return 404
//    @Test
//    public void getPriceCurrentList_productId_price_8() {
//        ResponseEntity<List<Integer>> responseEntity
//                = this.auctionController.getPriceCurrentList("", "");
//        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
//    }

    //    Trường hợp tham số productId bị rỗng, test sẽ bị lỗi compile nên comment lại để chạy chương trình, thực tế nếu productId
    //rỗng sẽ return 404
//    @Test
//    public void getPriceCurrentList_productId_8() {
//        ResponseEntity<List<Integer>> responseEntity
//                = this.auctionController.getPriceCurrentList("", 5000);
//        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
//    }

    //    Trường hợp tham số price bị rỗng, test sẽ bị lỗi compile nên comment lại để chạy chương trình, thực tế nếu price
    //rỗng sẽ return 404
//    @Test
//    public void getPriceCurrentList_price_8() {
//        ResponseEntity<List<Integer>> responseEntity
//                = this.auctionController.getPriceCurrentList("", "");
//        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
//    }

    //    Trường hợp productId không tồn tại trong database
    @Test
    public void getPriceCurrentList_productId_3() {
        ResponseEntity<List<Integer>> responseEntity
                = this.auctionController.getPriceCurrentList(99L, 5000);
        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }


    //   *Note: Không có trường hợp price không tồn tại trong database vì price không xuất hiện trong database mà là tự nhập
    //   *Note: Không có trường hợp product_id tồn tại trong database mà trả về list bằng 0 nên ko bắt trường hợp 10


    //    Trường hợp productId tồn tại trong database và price có giá trị thì trả về list có 15 phần
    //    tử là giá để khách hàng chọn, giá tăng theo bước giá(trong trường hợp này bước giá là 5000)
    @Test
    public void getPriceCurrentList_productId_11() {
        ResponseEntity<List<Integer>> responseEntity
                = this.auctionController.getPriceCurrentList(1L, 10000);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(15000,
                responseEntity.getBody().get(0));
        Assertions.assertEquals(20000,
                responseEntity.getBody().get(1));
        Assertions.assertEquals(25000,
                responseEntity.getBody().get(2));
        Assertions.assertEquals(30000,
                responseEntity.getBody().get(3));
        Assertions.assertEquals(85000,
                responseEntity.getBody().get(14));
    }
}

