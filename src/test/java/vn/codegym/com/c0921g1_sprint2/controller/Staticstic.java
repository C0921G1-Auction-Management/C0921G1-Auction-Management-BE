package vn.codegym.com.c0921g1_sprint2.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest
public class Staticstic {
    @Autowired
    private StatisticController statisticController;

    // Trường hợp các tham số đều null
    @Test
    public void getNumberOfTransactionByDate_7_1() {
        ResponseEntity<List<Integer>> responseEntity = this.statisticController.getNumberOfTransaction(null, null);
        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

    // Trường hợp các tham số dateStart = null
    @Test
    public void getNumberOfTransactionByDate_7_2() {
        ResponseEntity<List<Integer>> responseEntity = this.statisticController.getNumberOfTransaction(null, "2022-04-20");
        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

    // Trường hợp các tham số dateEnd = null
    @Test
    public void getNumberOfTransactionByDate_7_3() {
        ResponseEntity<List<Integer>> responseEntity = this.statisticController.getNumberOfTransaction("2022-04-20", null);
        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

    // Trường hợp các tham số dateStart là ngày không hợp lệ
    @Test
    public void getNumberOfTransactionByDate_9_1() {
        ResponseEntity<List<Integer>> responseEntity = this.statisticController.getNumberOfTransaction("2000-04-10", "2022-04-30");
        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

    // Trường hợp các tham số dateEnd là ngày không hợp lệ
    @Test
    public void getNumberOfTransactionByDate_9_2() {
        ResponseEntity<List<Integer>> responseEntity = this.statisticController.getNumberOfTransaction("20022-04-10", "2023-04-30");
        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

    // Trường hợp các tham số là hợp lệ, nhưng không có dữ liệu trong DB
    @Test
    public void getNumberOfTransactionByDate_10() {
        ResponseEntity<List<Integer>> responseEntity = this.statisticController.getNumberOfTransaction("2022-04-10", "2022-04-12");
        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

    // Trường hợp các tham số là hợp lệ, lấy được danh sách số lượng hợp đồng thành công
    @Test
    public void getNumberOfTransactionByDate() {
        ResponseEntity<List<Integer>> responseEntity = this.statisticController.getNumberOfTransaction("2022-04-10", "2022-04-30");
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }
}
