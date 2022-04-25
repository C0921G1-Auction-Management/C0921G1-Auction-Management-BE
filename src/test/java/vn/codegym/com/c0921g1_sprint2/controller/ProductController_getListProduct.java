package vn.codegym.com.c0921g1_sprint2.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import vn.codegym.com.c0921g1_sprint2.model.Category;
import vn.codegym.com.c0921g1_sprint2.model.Product;

@SpringBootTest
public class ProductController_getListProduct {
    @Autowired
    ProductController productController;

    /*DatTC - Lấy list với các tham số đều null*/
    @Test
    public void getAllByOptions_7_1() {
        ResponseEntity<Page<Product>> responseEntity = productController.getAllByOptions(null, null, null, null);
        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());

    }

    /*DatTC - Lấy list với tham số name là null*/
    @Test
    public void getAllByOptions_7_2(){
        ResponseEntity<Page<Product>> responseEntity = productController.getAllByOptions(null,"","","");
        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

    /*DatTC - Lấy list với tham số category là null*/
    @Test
    public void getAllByOptions_7_3(){
        ResponseEntity<Page<Product>> responseEntity = productController.getAllByOptions("",null,"","");
        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

    /*DatTC - Lấy list với tham số price là null*/
    @Test
    public void getAllByOptions_7_4(){
        ResponseEntity<Page<Product>> responseEntity = productController.getAllByOptions("","",null,"");
        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

    /*DatTC - Lấy list với tham số page là null*/
    @Test
    public void getAllByOptions_7_5(){
        ResponseEntity<Page<Product>> responseEntity = productController.getAllByOptions("","","",null);
        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

    /*DatTC - Lấy list với tham số đều rỗng*/
    @Test
    public void getAllByOptions_8_1(){
        ResponseEntity<Page<Product>> responseEntity = productController.getAllByOptions("","","","");
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }

    /*DatTC - Lấy list với tham số name*/
    @Test
    public void getAllByOptions_8_2(){
        ResponseEntity<Page<Product>> responseEntity = productController.getAllByOptions("q","","","");
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getContent().get(0).getId());
        Assertions.assertEquals(50000, responseEntity.getBody().getContent().get(0).getBidRange());
        Assertions.assertEquals("abc", responseEntity.getBody().getContent().get(0).getDescription());
        Assertions.assertEquals("2022-05-30", responseEntity.getBody().getContent().get(0).getEndDate());
        Assertions.assertEquals(1000000, responseEntity.getBody().getContent().get(0).getFinalBid());
        Assertions.assertEquals("Quần lót", responseEntity.getBody().getContent().get(0).getName());
        Assertions.assertEquals(1, responseEntity.getBody().getContent().get(0).getPaymentStatus());
        Assertions.assertEquals("abc", responseEntity.getBody().getContent().get(0).getProductAddress());
        Assertions.assertEquals(50000, responseEntity.getBody().getContent().get(0).getStartBid());
        Assertions.assertEquals("2022-04-25", responseEntity.getBody().getContent().get(0).getStartDate());
        Assertions.assertEquals("200000000", responseEntity.getBody().getContent().get(0).getTimeRemaining());
        Assertions.assertEquals(1, responseEntity.getBody().getContent().get(0).getCategory().getId());
    }

    /*DatTC - Lấy list với tham số category*/
    @Test
    public void getAllByOptions_8_3(){
        ResponseEntity<Page<Product>> responseEntity = productController.getAllByOptions("","1","","");
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getContent().get(0).getId());
        Assertions.assertEquals(50000, responseEntity.getBody().getContent().get(0).getBidRange());
        Assertions.assertEquals("abc", responseEntity.getBody().getContent().get(0).getDescription());
        Assertions.assertEquals("2022-05-30", responseEntity.getBody().getContent().get(0).getEndDate());
        Assertions.assertEquals(1000000, responseEntity.getBody().getContent().get(0).getFinalBid());
        Assertions.assertEquals("Quần lót", responseEntity.getBody().getContent().get(0).getName());
        Assertions.assertEquals(1, responseEntity.getBody().getContent().get(0).getPaymentStatus());
        Assertions.assertEquals("abc", responseEntity.getBody().getContent().get(0).getProductAddress());
        Assertions.assertEquals(50000, responseEntity.getBody().getContent().get(0).getStartBid());
        Assertions.assertEquals("2022-04-25", responseEntity.getBody().getContent().get(0).getStartDate());
        Assertions.assertEquals("200000000", responseEntity.getBody().getContent().get(0).getTimeRemaining());
        Assertions.assertEquals(1, responseEntity.getBody().getContent().get(0).getCategory().getId());
    }

    /*DatTC - Lấy list với tham số price*/
    @Test
    public void getAllByOptions_8_4(){
        ResponseEntity<Page<Product>> responseEntity = productController.getAllByOptions("","","500000-1500000","");
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getContent().get(0).getId());
        Assertions.assertEquals(50000, responseEntity.getBody().getContent().get(0).getBidRange());
        Assertions.assertEquals("abc", responseEntity.getBody().getContent().get(0).getDescription());
        Assertions.assertEquals("2022-05-30", responseEntity.getBody().getContent().get(0).getEndDate());
        Assertions.assertEquals(1000000, responseEntity.getBody().getContent().get(0).getFinalBid());
        Assertions.assertEquals("Quần lót", responseEntity.getBody().getContent().get(0).getName());
        Assertions.assertEquals(1, responseEntity.getBody().getContent().get(0).getPaymentStatus());
        Assertions.assertEquals("abc", responseEntity.getBody().getContent().get(0).getProductAddress());
        Assertions.assertEquals(50000, responseEntity.getBody().getContent().get(0).getStartBid());
        Assertions.assertEquals("2022-04-25", responseEntity.getBody().getContent().get(0).getStartDate());
        Assertions.assertEquals("200000000", responseEntity.getBody().getContent().get(0).getTimeRemaining());
        Assertions.assertEquals(1, responseEntity.getBody().getContent().get(0).getCategory().getId());
    }

    /*DatTC - Lấy list với tham số page*/
    @Test
    public void getAllByOptions_8_5(){
        ResponseEntity<Page<Product>> responseEntity = productController.getAllByOptions("","","","0");
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getContent().get(0).getId());
        Assertions.assertEquals(50000, responseEntity.getBody().getContent().get(0).getBidRange());
        Assertions.assertEquals("abc", responseEntity.getBody().getContent().get(0).getDescription());
        Assertions.assertEquals("2022-05-30", responseEntity.getBody().getContent().get(0).getEndDate());
        Assertions.assertEquals(1000000, responseEntity.getBody().getContent().get(0).getFinalBid());
        Assertions.assertEquals("Quần lót", responseEntity.getBody().getContent().get(0).getName());
        Assertions.assertEquals(1, responseEntity.getBody().getContent().get(0).getPaymentStatus());
        Assertions.assertEquals("abc", responseEntity.getBody().getContent().get(0).getProductAddress());
        Assertions.assertEquals(50000, responseEntity.getBody().getContent().get(0).getStartBid());
        Assertions.assertEquals("2022-04-25", responseEntity.getBody().getContent().get(0).getStartDate());
        Assertions.assertEquals("200000000", responseEntity.getBody().getContent().get(0).getTimeRemaining());
        Assertions.assertEquals(1, responseEntity.getBody().getContent().get(0).getCategory().getId());
    }

    /*DatTC - Lấy list với tham số name không tồn tại*/
    @Test
    public void getAllByOptions_9_1(){
        ResponseEntity<Page<Product>> responseEntity = productController.getAllByOptions("z","","","");
        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    /*DatTC - Lấy list với tham số category không tồn tại*/
    @Test
    public void getAllByOptions_9_2(){
        ResponseEntity<Page<Product>> responseEntity = productController.getAllByOptions("","2","","");
        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    /*DatTC - Lấy list với tham số price không tồn tại*/
    @Test
    public void getAllByOptions_9_3(){
        ResponseEntity<Page<Product>> responseEntity = productController.getAllByOptions("","","5000000-10000000","");
        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    /*DatTC - Lấy list với tham số page không tồn tại*/
    @Test
    public void getAllByOptions_9_4(){
        ResponseEntity<Page<Product>> responseEntity = productController.getAllByOptions("","","","1");
        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    /*DatTC - Lấy list với size = 0*/
    @Test
    public void getAllByOptions_10(){
        ResponseEntity<Page<Product>> responseEntity = productController.getAllByOptions("","","","1");
        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    /*DatTC - Lấy list với size > 0*/
    @Test
    public void getAllByOptions_11(){
        ResponseEntity<Page<Product>> responseEntity = productController.getAllByOptions("","","","0");
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }
}
