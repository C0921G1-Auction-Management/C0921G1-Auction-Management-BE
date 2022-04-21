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

import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

@CrossOrigin("*")
@RestController
@RequestMapping("payment")
public class PaymentCotrollerLongTK {
    @Autowired
    ProductService productService;

    @Autowired
    MemberService memberService;

    @Autowired
    TransactionService transactionService;


    //LongTK
    //lấy ra danh sách sản phẩm đã đấu giá thành công theo member id
    @GetMapping("productList/{id}")
    public ResponseEntity<Page<Product>> getProductByid(@PathVariable Long id,
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
    @GetMapping("getPrice/{id}")
    public ResponseEntity<Long> getPrice(@PathVariable Long id) {
        Long price = transactionService.findPriceByProductId(id);
        if (!(price > 0)) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        } else return new ResponseEntity<>(price,HttpStatus.OK);
    }

    @GetMapping("sendmail")
    private void send(@RequestParam String to,
                      @RequestParam Long total) {
        String sub = "Đấu giá thành công";
        String user = "c0921g1.sprint@gmail.com";
        String pass = "123456@b";
        String msg = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "  <meta charset=\"UTF-8\">\n" +
                "  <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h3>\n" +
                "  THANH TOÁN THÀNH CÔNG\n" +
                "</h3>\n" +
                "<p style=\"color: red\">\n" +
                "  Cảm ơn bạn đã sử dụng dịch vụ của chúng tôi\n" +
                "</p>\n" +
                "<p><strong>\n" +
                "  Tổng giá:" + total + "\n" +
                "</strong></p>\n" +
                "<p>\n" +
                "  Thời gian dự kiến giao hàng là khoảng 15 ngày kể từ khi bạn nhận được mail này\n" +
                "</p>\n" +
                "\n" +
                "<p style=\"font-style: italic\">\n" +
                "  Trân trọng!\n" +
                "</p>\n" +
                "\n" +
                "</body>\n" +
                "</html>\n";
        //create an instance of Properties Class
        Properties props = new Properties();

        /* Specifies the IP address of your default mail server
     	   for e.g if you are using gmail server as an email sever
           you will pass smtp.gmail.com as value of mail.smtp host.
           As shown here in the code.
           Change accordingly, if your email id is not a gmail id
         */
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

            /* Create an instance of MimeMessage,
 	      it accept MIME types and headers
             */
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(sub);
            message.setContent(msg, "text/html");

            /* Transport class is used to deliver the message to the recipients */
            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}






