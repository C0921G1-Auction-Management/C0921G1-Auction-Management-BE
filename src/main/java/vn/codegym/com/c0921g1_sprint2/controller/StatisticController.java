package vn.codegym.com.c0921g1_sprint2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.com.c0921g1_sprint2.service.StaticsticService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "c09/admin/staticstic")
public class StatisticController {
    @Autowired
    private StaticsticService staticsticService;

    @GetMapping()
    public ResponseEntity<List<Integer>> getNumberOfTransaction(@RequestParam(defaultValue = "") String dateStart,
                                                                @RequestParam(defaultValue = "") String dateEnd){
        List<Integer> numberOfTransactions = this.staticsticService.getNumberOfTransactionByDate(dateStart, dateEnd);
        if (numberOfTransactions.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(numberOfTransactions, HttpStatus.OK);
    }

}
