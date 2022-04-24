package vn.codegym.com.c0921g1_sprint2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.com.c0921g1_sprint2.repository.StaticsticRepository;
import vn.codegym.com.c0921g1_sprint2.service.StaticsticService;

import java.util.List;
@Service
public class StaticsticServiceImpl implements StaticsticService {
    @Autowired
    private StaticsticRepository repository;
    @Override
    public List<Integer> getNumberOfTransactionByDate(String dateStart, String dateEnd) {
        return this.repository.getNumberOfTransactionByDate(dateStart, dateEnd);
    }
}
