package vn.codegym.com.c0921g1_sprint2.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import vn.codegym.com.c0921g1_sprint2.model.Transaction;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TransactionController_listTransaction {
    @Autowired
    private TransactionController transactionController;

    @Autowired
    MockMvc mockMvc;

    //        Trường hợp trả về list có size = 0
    @Test
    public void getListTransaction_5() {
        ResponseEntity<Page<Transaction>> responseEntity =
                this.transactionController.listTransaction
                        (0, "0", "0", "0", "0", "0");
        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    //    Trường hợp trả về list có size > 0
    @Test
    public void getListTransaction_6() {
        ResponseEntity<Page<Transaction>> responseEntity =
                this.transactionController.listTransaction
                        (0, "", "", "Mercedes", "", "");
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }

    //    Trường hợp tham số id truyền vào bị null
    @Test
    public void getDeleteTransaction_25() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/transaction/delete/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //    Trường hợp tham số id truyền vào bị rỗng
    @Test
    public void getDeleteTransaction_26() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/transaction/delete/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //    Trường hợp tham số id truyền vào không có trong database
    @Test
    public void getDeleteTransaction_27() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/transaction/delete/{id}", "100"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //    Trường hợp tham số id truyền vào có trong database
    @Test
    public void getDeleteTransaction_28() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/transaction/delete/{id}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
