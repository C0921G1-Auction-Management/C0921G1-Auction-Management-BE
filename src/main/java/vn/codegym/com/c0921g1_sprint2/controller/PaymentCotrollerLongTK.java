package vn.codegym.com.c0921g1_sprint2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.com.c0921g1_sprint2.model.Member;
import vn.codegym.com.c0921g1_sprint2.model.Product;
import vn.codegym.com.c0921g1_sprint2.service.MemberService;
import vn.codegym.com.c0921g1_sprint2.service.ProductService;
import vn.codegym.com.c0921g1_sprint2.service.TransactionService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;


import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

@CrossOrigin("*")
@RestController
@RequestMapping("payment")
public class PaymentCotrollerLongTK {
    @Autowired
    private ProductService productService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private TransactionService transactionService;


    //LongTK
    //lấy ra danh sách sản phẩm đã đấu giá thành công theo member id có phân trang
    @GetMapping("productList/{id}")
    public ResponseEntity<Page<Product>> getProductOfMember(@PathVariable Long id,
                                                            @RequestParam int pageNo) {

        System.out.println("is member present? = 0" + memberService.findById(id).isPresent());

        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<Product> productList = productService.getProductListByMemberId(id, pageable);

        //trả về kết quả
        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }
    }

    //LongTK
    //lấy ra danh sách sản phẩm đã đấu giá thành công theo member id. dạng lít
    @GetMapping("findAllProduct/{id}")
    public ResponseEntity<List<Product>> findAllProdByMemberId(@PathVariable Long id) {
        List<Product> productList = productService.findAllByMemberId(id);
        //trả về kết quả
        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }
    }

    //LongTK lấy ra giá tiề từng sản phẩm
    @GetMapping("getPrice/{id}")
    public ResponseEntity<Long> getPrice(@PathVariable Long id) {
        Long price = transactionService.findPriceByProductId(id);
        if (!(price > 0)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else return new ResponseEntity<>(price, HttpStatus.OK);
    }

    //LongTK tìm member theo id
    @GetMapping("findMemer/{id}")
    public ResponseEntity<Member> findMemberById(@PathVariable Long id) {
        Optional<Member> foundMem = memberService.findById(id);
        if (foundMem.isPresent()) {
            return new ResponseEntity<>(foundMem.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //LongTK gửi mail
    @GetMapping("sendmail")
    private void send(@RequestParam String to,
                      @RequestParam String totalPrice,
                      @RequestParam String quantity,
                      @RequestParam String deliveryNote) {
        String sub = "Payment for auction products";
        String user = "c0921g1.sprint@gmail.com";
        String pass = "123456@b";


        String msg = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h3> Complete payment </h3>\n" +
                "<p>Thank you for using our service</p>\n" +
                "  <strong> \n" +
                "    Total\n" + totalPrice + " $" +
                "  </strong>\n" +

                "  <strong> \n" +
                "    Product quantity\n" + quantity +
                "  </strong>\n" +

                "<p style=\"font-style: italic\">\n" +
                "Delivery note: " + deliveryNote +
                "</p>\n" +

                "<p>The product will be delivered within 15 days from the time you receive this mail</p>\n" +
                "\n" +
                "<p style=\"font-style: italic\">\n" +
                "  Best regards!\n" +
                "</p>\n" +
                "\n" +
                "</body>\n" +
                "</html>\n";
        //create an instance of Properties Class
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        //below mentioned mail.smtp.port is optional
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        /* Pass Properties object(props) and Authenticator object
           for authentication to Session instance
         */
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
//            message.setHeader("Content-Type", "text/plain; charset=UTF-8");
            message.setHeader("Content-Type", "text/plain; charset=UTF-8");
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(sub);
            message.setSubject(sub, "utf-8");
            message.setContent(msg, "text/html");
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}






