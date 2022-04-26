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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.codegym.com.c0921g1_sprint2.dto.AuctionDto;
import vn.codegym.com.c0921g1_sprint2.model.Auction;
import vn.codegym.com.c0921g1_sprint2.model.Product;
import vn.codegym.com.c0921g1_sprint2.service.AuctionService;
import vn.codegym.com.c0921g1_sprint2.service.impl.AuctionServiceImpl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;
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
        try {
            if (product == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(product, HttpStatus.OK);
            }
        } catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //    lấy danh sách giá để chọn giá đấu
    @GetMapping("/list-current-price")
    public ResponseEntity<List<Integer>> getPriceCurrentList(Long productId, Integer price) {
        Product product = auctionService.getProductById(productId);
        List<Integer> priceCurrentList = new ArrayList<>();
        Integer currentPrice;

        try {
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
                if (i == 0 && price == null) {
                    currentPrice = product.getStartBid();
                }
                priceCurrentList.add(currentPrice);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(priceCurrentList, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(priceCurrentList, HttpStatus.OK);
    }

    //    lưu thông tin đấu giá xuống database
    @PostMapping("/save-info-auction")
    public ResponseEntity<?> saveInformationOfAuction(@Valid @RequestBody AuctionDto auctionDto, BindingResult bindingResult) {
        try {
            if (auctionDto == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            new AuctionDto().validate(auctionDto, bindingResult);
            if (bindingResult.hasFieldErrors()) {
                return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            } else {
                Auction auction = new Auction();
                BeanUtils.copyProperties(auctionDto, auction);
                auctionService.saveInfoAuction(auction.getProduct().getId(), auction.getMembers().getId(),
                        auction.getCurrentBid(), auction.getQuantity(), auction.getAuctionTime());
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //    lấy danh sách thông tin đấu giá của sản phẩm đang đấu giá
    @GetMapping("/get-info-auction")
    public ResponseEntity<Page<Auction>> getInformationAuction(@RequestParam(defaultValue = "0") Integer page,
                                                               @RequestParam(defaultValue = "0") Integer seeMore,
                                                               Long productId) {
        try {
            Pageable pageable = PageRequest.of(page, seeMore);
            Page<Auction> listAuction = auctionService.findAll(productId ,pageable);
            if (listAuction.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(listAuction, HttpStatus.OK);
            }
        } catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get-info-winner")
    public ResponseEntity<Auction> getInfoWinnerAuction() throws MessagingException {
        try{
            Auction auction = auctionService.findAllEndAuction();
            sendMail(auction);
            return new ResponseEntity<>(auction,HttpStatus.OK);
        }catch (NullPointerException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/get-info-winner-temp")
    public ResponseEntity<Auction> getInfoWinnerTempAuction() {
        try{
            Auction auction = auctionService.findAllEndAuction();
            return new ResponseEntity<>(auction,HttpStatus.OK);
        }catch (NullPointerException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    void sendMail(Auction auction) throws MessagingException {
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
