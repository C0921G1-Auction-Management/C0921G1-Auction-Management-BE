package vn.codegym.com.c0921g1_sprint2.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;
import vn.codegym.com.c0921g1_sprint2.dto.AuctionDto;
import vn.codegym.com.c0921g1_sprint2.model.Auction;
import vn.codegym.com.c0921g1_sprint2.model.Product;
import vn.codegym.com.c0921g1_sprint2.service.AuctionService;
import vn.codegym.com.c0921g1_sprint2.service.impl.AuctionServiceImpl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/c09/user/auction")
public class AuctionController {
    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    AuctionService auctionService;


    //    lấy thông tin chi tiết sản phẩm
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = auctionService.getProductById(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
    }

    //    lấy danh sách giá để chọn giá đấu
    @GetMapping("/list-current-price")
    public ResponseEntity<List<Integer>> priceCurrentList(Long productId, Integer price) {
        Product product = auctionService.getProductById(productId);
        List<Integer> priceCurrentList = new ArrayList<>();
        Integer currentPrice;

        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (price == null) {
            currentPrice = product.getStartBid();
        } else {
            currentPrice = price;
        }

        for (int i = 0; i < 15; i++) {
            currentPrice += product.getBidRange();
            priceCurrentList.add(currentPrice);
        }
        return new ResponseEntity<>(priceCurrentList, HttpStatus.OK);
    }

    //    lưu thông tin đấu giá xuống database
    @PostMapping("/save-info-auction")
    public ResponseEntity<?> saveInformationOfAuction(@RequestBody AuctionDto auctionDto) {
        Auction auction = new Auction();
        BeanUtils.copyProperties(auctionDto, auction);
        auctionService.saveInfoAuction(auction.getProduct().getId(), auction.getMembers().getId(), auction.getCurrentBid(), auction.getQuantity(), auction.getAuctionTime());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //    lấy danh sách thông tin đấu giá của sản phẩm đang đấu giá
    @GetMapping("/get-info-auction")
    public ResponseEntity<Page<Auction>> getInformationAuction(@RequestParam(defaultValue = "0") Integer size,
                                                               @RequestParam(defaultValue = "0") Integer seeMore) {
        try {
            Pageable pageable = PageRequest.of(size, seeMore);
            Page<Auction> listAuction = auctionService.findAll(pageable);
            if (listAuction.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(listAuction, HttpStatus.OK);
            }
        } catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get-info-winner")
    public ResponseEntity<?> getInfoWinnerAuction() throws MessagingException {
        Auction auction = auctionService.findAllEndAuction();
        sendMail(auction);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    void sendMail(Auction auction) throws MessagingException {
        System.err.println(auction.getMembers().getEmail());

        MimeMessage message = javaMailSender.createMimeMessage();

        message.setSubject("Auction Winning Announcement");
        MimeMessageHelper helper;
        helper = new MimeMessageHelper(message, true);
        helper.setFrom("hung1509nguyenmanh@gmail.com");
        helper.setTo(auction.getMembers().getEmail());
        helper.setText("<h3 style=\"color: red\">" + "Dear " + auction.getMembers().getName() + ",</h3>\n" +
                "<h3 style=\"color: green\">Congratulation for auction successfully!</h3>\n" +
                "<h4 style=\"color: #14ce14\">Auction information:</h4>\n" +
                "<p>Customer Name: " + auction.getMembers().getName() + "</p>\n" +
                "<p>BirthDay: " + auction.getMembers().getDayOfBirth() + "</p>\n" +
                "<p>Phone Number: " + auction.getMembers().getPhoneNumber() + "</p>\n" +
                "<p>Address : " + auction.getMembers().getAddress() + "</p>\n" +
                "<p>Product Name: " + auction.getProduct().getName() + "</p>\n" +
                "<p>Start price: " + auction.getProduct().getStartBid() + "</p>\n" +
                "<p>winner price: " + auction.getCurrentBid() + "</p>\n" +
                "<p>Quantity: " + auction.getQuantity() + "</p>\n" +
                "<p>Time: " + auction.getAuctionTime() + "</p>", true);
        javaMailSender.send(message);
    }
}
