package vn.codegym.com.c0921g1_sprint2.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StaticsticService {
    List<Integer> getNumberOfTransactionByDate(String dateStart, String dateEnd);
}
