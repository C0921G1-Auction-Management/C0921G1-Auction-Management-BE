package vn.codegym.com.c0921g1_sprint2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import vn.codegym.com.c0921g1_sprint2.controller.PaymentCotrollerLongTK;
import vn.codegym.com.c0921g1_sprint2.model.Product;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class Controller_get_product_list {

    @Autowired
    private PaymentCotrollerLongTK paymentCotroller;

    @Autowired
    MockMvc mockMvc;

    //trường hợp id null
    @Test
    public void getProductOfMember_id_1() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/payment/productList/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //trường hợp id rỗng
    @Test
    public void getProductOfMember_id_2() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/payment/productList/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //trường hợp id không có trong database
    @Test
    public void getProductOfMember_id_3() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/payment/productList/{id}", "40"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //List có size 0
    @Test
    public void getProductOfMember_pageNo_5() throws Exception {
        ResponseEntity<Page<Product>> responseEntity
                = this.paymentCotroller.getProductOfMember(1L, 300);
        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    //Trường hợp Trả về list có size > 0
    @Test
    public void getProductOfMember_pageNo_6() throws Exception {
        ResponseEntity<Page<Product>> responseEntity
                = this.paymentCotroller.getProductOfMember(1L, 0);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());

    }


}
