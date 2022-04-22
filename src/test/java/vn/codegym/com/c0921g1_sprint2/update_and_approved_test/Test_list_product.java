package vn.codegym.com.c0921g1_sprint2.update_and_approved_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import vn.codegym.com.c0921g1_sprint2.controller.ProductController;
import vn.codegym.com.c0921g1_sprint2.model.Product;

public class Test_list_product {
    @Autowired
    private ProductController productController;

    //trường hợp tham số page null
    @Test
    public void getAllProduct_1_a(){
        ResponseEntity<Page<Product>> responseEntity =
                this.productController.getAllProduct("","","","","",null);

        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

    //trường hợp tham số name của product null
    @Test
    public void getAllProduct_1_b(){
        ResponseEntity<Page<Product>> responseEntity =
                this.productController.getAllProduct(null,"","","","",0);

        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }
    //trường hợp tham số name của member null
    @Test
    public void getAllProduct_1_b1(){
        ResponseEntity<Page<Product>> responseEntity =
                this.productController.getAllProduct("",null,"","","",0);

        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    //trường hợp tham số loại sản phẩm của product null
    @Test
    public void getAllProduct_1_c(){
        ResponseEntity<Page<Product>> responseEntity =
                this.productController.getAllProduct("","",null,"","",0);

        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }
    //trường hợp tham số giá ban đầu của product null
    @Test
    public void getAllProduct_1_d(){
        ResponseEntity<Page<Product>> responseEntity =
                this.productController.getAllProduct("","","",null,"",0);

        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }
    //trường hợp tham số duyệt của product null
    @Test
    public void getAllProduct_1_e(){
        ResponseEntity<Page<Product>> responseEntity =
                this.productController.getAllProduct("","","","","",0);

        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }


    //tất cả tham số đều null
    @Test
    public void getAllProduct_1_f(){
        ResponseEntity<Page<Product>> responseEntity =
                this.productController.getAllProduct(null,null,null,null,null,null);

        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }


    //trường hợp tham số name của product rỗng
    @Test
    public void getAllProduct_2_b(){
        ResponseEntity<Page<Product>> responseEntity =
                this.productController.getAllProduct("",null,null,null,null,0);

        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }
    //trường hợp tham số name của member rỗng
    @Test
    public void getAllProduct_2_b1(){
        ResponseEntity<Page<Product>> responseEntity =
                this.productController.getAllProduct(null,"",null,null,null,0);

        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    //trường hợp tham số loại sản phẩm của product rõng
    @Test
    public void getAllProduct_2_c(){
        ResponseEntity<Page<Product>> responseEntity =
                this.productController.getAllProduct(null,null,"",null,null,0);

        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }
    //trường hợp tham số giá ban đầu của product rỗng
    @Test
    public void getAllProduct_2_d(){
        ResponseEntity<Page<Product>> responseEntity =
                this.productController.getAllProduct(null,null,null,"",null,0);

        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }
    //trường hợp tham số duyệt của product rỗng
    @Test
    public void getAllProduct_2_e(){
        ResponseEntity<Page<Product>> responseEntity =
                this.productController.getAllProduct(null,null,null,null,"",0);

        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }


    //tất cả tham số đều rỗng
    @Test
    public void getAllProduct_2_f(){
        ResponseEntity<Page<Product>> responseEntity =
                this.productController.getAllProduct("","","","","",0);

        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }


    //trường hợp tham số page sai
    @Test
    public void getAllProduct_3_a(){
        ResponseEntity<Page<Product>> responseEntity =
                this.productController.getAllProduct("","","","","",7);

        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }

    //trường hợp tham số name của product sai
    @Test
    public void getAllProduct_3_b(){
        ResponseEntity<Page<Product>> responseEntity =
                this.productController.getAllProduct("jhfjkghfghfjk","","","","",0);

        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }
    //trường hợp tham số name của member sai
    @Test
    public void getAllProduct_3_b1(){
        ResponseEntity<Page<Product>> responseEntity =
                this.productController.getAllProduct("","hfggbrhgbrh","","","",0);

        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    //trường hợp tham số loại sản phẩm của product sai
    @Test
    public void getAllProduct_3_c(){
        ResponseEntity<Page<Product>> responseEntity =
                this.productController.getAllProduct("","","fsdhgbfhjgb$$$%%%","","",0);

        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }
    //trường hợp tham số giá ban đầu của product sai
    @Test
    public void getAllProduct_3_d(){
        ResponseEntity<Page<Product>> responseEntity =
                this.productController.getAllProduct("","","","fghhgfgf","",0);

        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }
    //trường hợp tham số duyệt của product sai
    @Test
    public void getAllProduct_3_e(){
        ResponseEntity<Page<Product>> responseEntity =
                this.productController.getAllProduct("","","","","5",0);

        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }


    //tất cả tham số đều sai
    @Test
    public void getAllProduct_3_f(){
        ResponseEntity<Page<Product>> responseEntity =
                this.productController.getAllProduct("null","null","null","null","8",9);

        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
    }


    //trường hợp tham số page đúng
    @Test
    public void getAllProduct_4_a(){
        ResponseEntity<Page<Product>> responseEntity =
                this.productController.getAllProduct("","","","","",9);

        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(5, responseEntity.getBody().getTotalElements());
    }

    //trường hợp tham số name của product đúng
    @Test
    public void getAllProduct_4_b(){
        ResponseEntity<Page<Product>> responseEntity =
                this.productController.getAllProduct("Note 20","","","","",0);

        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("Note 20",
                responseEntity.getBody().getContent().get(0).getName());
        Assertions.assertEquals("2022-05-25 08:00:00",

                responseEntity.getBody().getContent().get(0).getStartDate());
        Assertions.assertEquals("2022-05-23 08:00:00",
                responseEntity.getBody().getContent().get(0).getEndDate());
        Assertions.assertEquals("1",
                responseEntity.getBody().getContent().get(0).getCategory());
        Assertions.assertEquals("1",
                responseEntity.getBody().getContent().get(0).getApprovedStatus());
    }

    //trường hợp tham số nameMember đúng
    @Test
    public void getAllProduct_4_c(){
        ResponseEntity<Page<Product>> responseEntity =
                this.productController.getAllProduct("","Nguyen van C","","","",0);

        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("Note 20",
                responseEntity.getBody().getContent().get(0).getName());
        Assertions.assertEquals("2022-05-25 08:00:00",

                responseEntity.getBody().getContent().get(0).getStartDate());
        Assertions.assertEquals("2022-05-23 08:00:00",
                responseEntity.getBody().getContent().get(0).getEndDate());
        Assertions.assertEquals("1",
                responseEntity.getBody().getContent().get(0).getCategory());
        Assertions.assertEquals("1",
                responseEntity.getBody().getContent().get(0).getApprovedStatus());
    }

    //trường hợp tham số endDate đúng
    @Test
    public void getAllProduct_4_d(){
        ResponseEntity<Page<Product>> responseEntity =
                this.productController.getAllProduct("","","SmartPhone","","",0);

        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("Note 20",
                responseEntity.getBody().getContent().get(0).getName());
        Assertions.assertEquals("2022-05-25 08:00:00",

                responseEntity.getBody().getContent().get(0).getStartDate());
        Assertions.assertEquals("2022-05-23 08:00:00",
                responseEntity.getBody().getContent().get(0).getEndDate());
        Assertions.assertEquals("1",
                responseEntity.getBody().getContent().get(0).getCategory());
        Assertions.assertEquals("1",
                responseEntity.getBody().getContent().get(0).getApprovedStatus());
    }

    //trường hợp các start_bid đúng đều đúng đúng
    @Test
    public void getAllProduct_4_e(){
        ResponseEntity<Page<Product>> responseEntity =
                this.productController.getAllProduct("","","","Trên 10 triệu","",0);

        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("Note 20",
                responseEntity.getBody().getContent().get(0).getName());
        Assertions.assertEquals("2022-05-25 08:00:00",

                responseEntity.getBody().getContent().get(0).getStartDate());
        Assertions.assertEquals("2022-05-23 08:00:00",
                responseEntity.getBody().getContent().get(0).getEndDate());
        Assertions.assertEquals("1",
                responseEntity.getBody().getContent().get(0).getCategory());
        Assertions.assertEquals("1",
                responseEntity.getBody().getContent().get(0).getApprovedStatus());
    }

    //trường hợp các start_bid đúng đều đúng đúng
    @Test
    public void getAllProduct_4_f(){
        ResponseEntity<Page<Product>> responseEntity =
                this.productController.getAllProduct("","","","","Đã duyệt",0);

        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("Note 20",
                responseEntity.getBody().getContent().get(0).getName());
        Assertions.assertEquals("2022-05-25 08:00:00",

                responseEntity.getBody().getContent().get(0).getStartDate());
        Assertions.assertEquals("2022-05-23 08:00:00",
                responseEntity.getBody().getContent().get(0).getEndDate());
        Assertions.assertEquals("1",
                responseEntity.getBody().getContent().get(0).getCategory());
        Assertions.assertEquals("1",
                responseEntity.getBody().getContent().get(0).getApprovedStatus());
    }
}
