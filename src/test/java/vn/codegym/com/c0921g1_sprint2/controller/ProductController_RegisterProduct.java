package vn.codegym.com.c0921g1_sprint2.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import vn.codegym.com.c0921g1_sprint2.dto.ProductDTOTaiLM;
import vn.codegym.com.c0921g1_sprint2.model.Category;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductController_RegisterProduct {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    //All [item] đều hợp lệ
    @Test
    public void registerProduct_18() throws Exception{
        ProductDTOTaiLM productDTOTaiLM = new ProductDTOTaiLM();
        Category category = new Category();

        productDTOTaiLM.setName("Máy Bay");
        productDTOTaiLM.setStartBid(5000L);
        productDTOTaiLM.setBidRange(10000L);
        productDTOTaiLM.setFinalBid(1000000L);
        productDTOTaiLM.setImageUrl("abcabcabc");
        productDTOTaiLM.setStartDate("2022-04-30 08:00:00");
        productDTOTaiLM.setEndDate("2022-05-20 08:00:00");
        productDTOTaiLM.setDescription("Bền, đẹp");
        category.setId(4L);
        category.setName("Phương tiện");
        productDTOTaiLM.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/product/register")
                        .content(this.objectMapper.writeValueAsString(productDTOTaiLM))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    // trường hợp trường name null
    @Test
    public void registerProduct_13_a() throws Exception{
        ProductDTOTaiLM productDTOTaiLM = new ProductDTOTaiLM();
        Category category = new Category();

        productDTOTaiLM.setName(null);
        productDTOTaiLM.setStartBid(5000L);
        productDTOTaiLM.setBidRange(10000L);
        productDTOTaiLM.setFinalBid(1000000L);
        productDTOTaiLM.setImageUrl("abcabcabc");
        productDTOTaiLM.setStartDate("2022-04-30 08:00:00");
        productDTOTaiLM.setEndDate("2022-05-20 08:00:00");
        productDTOTaiLM.setDescription("Bền, đẹp");
        category.setId(4L);
        category.setName("Phương tiện");
        productDTOTaiLM.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/product/register")
                        .content(this.objectMapper.writeValueAsString(productDTOTaiLM))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // trường hợp trường startBid null
    @Test
    public void registerProduct_13_b() throws Exception{
        ProductDTOTaiLM productDTOTaiLM = new ProductDTOTaiLM();
        Category category = new Category();

        productDTOTaiLM.setName("Máy Bay");
        productDTOTaiLM.setStartBid(null);
        productDTOTaiLM.setBidRange(10000L);
        productDTOTaiLM.setFinalBid(1000000L);
        productDTOTaiLM.setImageUrl("abcabcabc");
        productDTOTaiLM.setStartDate("2022-04-30 08:00:00");
        productDTOTaiLM.setEndDate("2022-05-20 08:00:00");
        productDTOTaiLM.setDescription("Bền, đẹp");
        category.setId(4L);
        category.setName("Phương tiện");
        productDTOTaiLM.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/product/register")
                        .content(this.objectMapper.writeValueAsString(productDTOTaiLM))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // trường hợp trường bidRange null
    @Test
    public void registerProduct_13_c() throws Exception{
        ProductDTOTaiLM productDTOTaiLM = new ProductDTOTaiLM();
        Category category = new Category();

        productDTOTaiLM.setName("Máy Bay");
        productDTOTaiLM.setStartBid(5000L);
        productDTOTaiLM.setBidRange(null);
        productDTOTaiLM.setFinalBid(1000000L);
        productDTOTaiLM.setImageUrl("abcabcabc");
        productDTOTaiLM.setStartDate("2022-04-30 08:00:00");
        productDTOTaiLM.setEndDate("2022-05-20 08:00:00");
        productDTOTaiLM.setDescription("Bền, đẹp");
        category.setId(4L);
        category.setName("Phương tiện");
        productDTOTaiLM.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/product/register")
                        .content(this.objectMapper.writeValueAsString(productDTOTaiLM))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // trường hợp trường finalBid null
    @Test
    public void registerProduct_13_d() throws Exception{
        ProductDTOTaiLM productDTOTaiLM = new ProductDTOTaiLM();
        Category category = new Category();

        productDTOTaiLM.setName("Máy Bay");
        productDTOTaiLM.setStartBid(5000L);
        productDTOTaiLM.setBidRange(10000L);
        productDTOTaiLM.setFinalBid(null);
        productDTOTaiLM.setImageUrl("abcabcabc");
        productDTOTaiLM.setStartDate("2022-04-30 08:00:00");
        productDTOTaiLM.setEndDate("2022-05-20 08:00:00");
        productDTOTaiLM.setDescription("Bền, đẹp");
        category.setId(4L);
        category.setName("Phương tiện");
        productDTOTaiLM.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/product/register")
                        .content(this.objectMapper.writeValueAsString(productDTOTaiLM))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // trường hợp trường imageUrl null
    @Test
    public void registerProduct_13_e() throws Exception{
        ProductDTOTaiLM productDTOTaiLM = new ProductDTOTaiLM();
        Category category = new Category();

        productDTOTaiLM.setName("Máy Bay");
        productDTOTaiLM.setStartBid(5000L);
        productDTOTaiLM.setBidRange(10000L);
        productDTOTaiLM.setFinalBid(1000000L);
        productDTOTaiLM.setImageUrl(null);
        productDTOTaiLM.setStartDate("2022-04-30 08:00:00");
        productDTOTaiLM.setEndDate("2022-05-20 08:00:00");
        productDTOTaiLM.setDescription("Bền, đẹp");
        category.setId(4L);
        category.setName("Phương tiện");
        productDTOTaiLM.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/product/register")
                        .content(this.objectMapper.writeValueAsString(productDTOTaiLM))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // trường hợp trường startDate null
    @Test
    public void registerProduct_13_f() throws Exception{
        ProductDTOTaiLM productDTOTaiLM = new ProductDTOTaiLM();
        Category category = new Category();

        productDTOTaiLM.setName("Máy Bay");
        productDTOTaiLM.setStartBid(5000L);
        productDTOTaiLM.setBidRange(10000L);
        productDTOTaiLM.setFinalBid(1000000L);
        productDTOTaiLM.setImageUrl("abcabcabc");
        productDTOTaiLM.setStartDate(null);
        productDTOTaiLM.setEndDate("2022-05-20 08:00:00");
        productDTOTaiLM.setDescription("Bền, đẹp");
        category.setId(4L);
        category.setName("Phương tiện");
        productDTOTaiLM.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/product/register")
                        .content(this.objectMapper.writeValueAsString(productDTOTaiLM))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // trường hợp trường endDate null
    @Test
    public void registerProduct_13_g() throws Exception{
        ProductDTOTaiLM productDTOTaiLM = new ProductDTOTaiLM();
        Category category = new Category();

        productDTOTaiLM.setName("Máy Bay");
        productDTOTaiLM.setStartBid(5000L);
        productDTOTaiLM.setBidRange(10000L);
        productDTOTaiLM.setFinalBid(1000000L);
        productDTOTaiLM.setImageUrl("abcabcabc");
        productDTOTaiLM.setStartDate("2022-04-30 08:00:00");
        productDTOTaiLM.setEndDate(null);
        productDTOTaiLM.setDescription("Bền, đẹp");
        category.setId(4L);
        category.setName("Phương tiện");
        productDTOTaiLM.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/product/register")
                        .content(this.objectMapper.writeValueAsString(productDTOTaiLM))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // trường hợp trường description null
    @Test
    public void registerProduct_13_h() throws Exception{
        ProductDTOTaiLM productDTOTaiLM = new ProductDTOTaiLM();
        Category category = new Category();

        productDTOTaiLM.setName("Máy Bay");
        productDTOTaiLM.setStartBid(5000L);
        productDTOTaiLM.setBidRange(10000L);
        productDTOTaiLM.setFinalBid(1000000L);
        productDTOTaiLM.setImageUrl("abcabcabc");
        productDTOTaiLM.setStartDate("2022-04-30 08:00:00");
        productDTOTaiLM.setEndDate("2022-05-30 08:00:00");
        productDTOTaiLM.setDescription(null);
        category.setId(4L);
        category.setName("Phương tiện");
        productDTOTaiLM.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/product/register")
                        .content(this.objectMapper.writeValueAsString(productDTOTaiLM))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // trường hợp trường category null
    @Test
    public void registerProduct_13_i() throws Exception{
        ProductDTOTaiLM productDTOTaiLM = new ProductDTOTaiLM();
        Category category = new Category();

        productDTOTaiLM.setName("Máy Bay");
        productDTOTaiLM.setStartBid(5000L);
        productDTOTaiLM.setBidRange(10000L);
        productDTOTaiLM.setFinalBid(1000000L);
        productDTOTaiLM.setImageUrl("abcabcabc");
        productDTOTaiLM.setStartDate("2022-04-30 08:00:00");
        productDTOTaiLM.setEndDate("2022-05-30 08:00:00");
        productDTOTaiLM.setDescription("Bền, đẹp");
        category.setId(4L);
        category.setName("Phương tiện");
        productDTOTaiLM.setCategory(null);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/product/register")
                        .content(this.objectMapper.writeValueAsString(productDTOTaiLM))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // trường hợp trường name rỗng
    @Test
    public void registerProduct_14_a() throws Exception{
        ProductDTOTaiLM productDTOTaiLM = new ProductDTOTaiLM();
        Category category = new Category();

        productDTOTaiLM.setName("");
        productDTOTaiLM.setStartBid(5000L);
        productDTOTaiLM.setBidRange(10000L);
        productDTOTaiLM.setFinalBid(1000000L);
        productDTOTaiLM.setImageUrl("abcabcabc");
        productDTOTaiLM.setStartDate("2022-04-30 08:00:00");
        productDTOTaiLM.setEndDate("2022-05-20 08:00:00");
        productDTOTaiLM.setDescription("Bền, đẹp");
        category.setId(4L);
        category.setName("Phương tiện");
        productDTOTaiLM.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/product/register")
                        .content(this.objectMapper.writeValueAsString(productDTOTaiLM))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // trường hợp trường startBid giá trị 0
    @Test
    public void registerProduct_14_b() throws Exception{
        ProductDTOTaiLM productDTOTaiLM = new ProductDTOTaiLM();
        Category category = new Category();

        productDTOTaiLM.setName("Máy Bay");
        productDTOTaiLM.setStartBid(0L);
        productDTOTaiLM.setBidRange(10000L);
        productDTOTaiLM.setFinalBid(1000000L);
        productDTOTaiLM.setImageUrl("abcabcabc");
        productDTOTaiLM.setStartDate("2022-04-30 08:00:00");
        productDTOTaiLM.setEndDate("2022-05-20 08:00:00");
        productDTOTaiLM.setDescription("Bền, đẹp");
        category.setId(4L);
        category.setName("Phương tiện");
        productDTOTaiLM.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/product/register")
                        .content(this.objectMapper.writeValueAsString(productDTOTaiLM))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // trường hợp trường bidRange giá trị 0
    @Test
    public void registerProduct_14_c() throws Exception{
        ProductDTOTaiLM productDTOTaiLM = new ProductDTOTaiLM();
        Category category = new Category();

        productDTOTaiLM.setName("Máy Bay");
        productDTOTaiLM.setStartBid(5000L);
        productDTOTaiLM.setBidRange(0L);
        productDTOTaiLM.setFinalBid(1000000L);
        productDTOTaiLM.setImageUrl("abcabcabc");
        productDTOTaiLM.setStartDate("2022-04-30 08:00:00");
        productDTOTaiLM.setEndDate("2022-05-20 08:00:00");
        productDTOTaiLM.setDescription("Bền, đẹp");
        category.setId(4L);
        category.setName("Phương tiện");
        productDTOTaiLM.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/product/register")
                        .content(this.objectMapper.writeValueAsString(productDTOTaiLM))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // trường hợp trường finalBid null
    @Test
    public void registerProduct_14_d() throws Exception{
        ProductDTOTaiLM productDTOTaiLM = new ProductDTOTaiLM();
        Category category = new Category();

        productDTOTaiLM.setName("Máy Bay");
        productDTOTaiLM.setStartBid(5000L);
        productDTOTaiLM.setBidRange(10000L);
        productDTOTaiLM.setFinalBid(0L);
        productDTOTaiLM.setImageUrl("abcabcabc");
        productDTOTaiLM.setStartDate("2022-04-30 08:00:00");
        productDTOTaiLM.setEndDate("2022-05-20 08:00:00");
        productDTOTaiLM.setDescription("Bền, đẹp");
        category.setId(4L);
        category.setName("Phương tiện");
        productDTOTaiLM.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/product/register")
                        .content(this.objectMapper.writeValueAsString(productDTOTaiLM))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // trường hợp trường imageUrl rỗng
    @Test
    public void registerProduct_14_e() throws Exception{
        ProductDTOTaiLM productDTOTaiLM = new ProductDTOTaiLM();
        Category category = new Category();

        productDTOTaiLM.setName("Máy Bay");
        productDTOTaiLM.setStartBid(5000L);
        productDTOTaiLM.setBidRange(10000L);
        productDTOTaiLM.setFinalBid(1000000L);
        productDTOTaiLM.setImageUrl("");
        productDTOTaiLM.setStartDate("2022-04-30 08:00:00");
        productDTOTaiLM.setEndDate("2022-05-20 08:00:00");
        productDTOTaiLM.setDescription("Bền, đẹp");
        category.setId(4L);
        category.setName("Phương tiện");
        productDTOTaiLM.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/product/register")
                        .content(this.objectMapper.writeValueAsString(productDTOTaiLM))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // trường hợp trường startDate rỗng
    @Test
    public void registerProduct_14_f() throws Exception{
        ProductDTOTaiLM productDTOTaiLM = new ProductDTOTaiLM();
        Category category = new Category();

        productDTOTaiLM.setName("Máy Bay");
        productDTOTaiLM.setStartBid(5000L);
        productDTOTaiLM.setBidRange(10000L);
        productDTOTaiLM.setFinalBid(1000000L);
        productDTOTaiLM.setImageUrl("abcabcabc");
        productDTOTaiLM.setStartDate("");
        productDTOTaiLM.setEndDate("2022-05-20 08:00:00");
        productDTOTaiLM.setDescription("Bền, đẹp");
        category.setId(4L);
        category.setName("Phương tiện");
        productDTOTaiLM.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/product/register")
                        .content(this.objectMapper.writeValueAsString(productDTOTaiLM))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // trường hợp trường endDate rỗng
    @Test
    public void registerProduct_14_g() throws Exception{
        ProductDTOTaiLM productDTOTaiLM = new ProductDTOTaiLM();
        Category category = new Category();

        productDTOTaiLM.setName("Máy Bay");
        productDTOTaiLM.setStartBid(5000L);
        productDTOTaiLM.setBidRange(10000L);
        productDTOTaiLM.setFinalBid(1000000L);
        productDTOTaiLM.setImageUrl("abcabcabc");
        productDTOTaiLM.setStartDate("2022-04-30 08:00:00");
        productDTOTaiLM.setEndDate("");
        productDTOTaiLM.setDescription("Bền, đẹp");
        category.setId(4L);
        category.setName("Phương tiện");
        productDTOTaiLM.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/product/register")
                        .content(this.objectMapper.writeValueAsString(productDTOTaiLM))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // trường hợp trường description rỗng
    @Test
    public void registerProduct_14_h() throws Exception{
        ProductDTOTaiLM productDTOTaiLM = new ProductDTOTaiLM();
        Category category = new Category();

        productDTOTaiLM.setName("Máy Bay");
        productDTOTaiLM.setStartBid(5000L);
        productDTOTaiLM.setBidRange(10000L);
        productDTOTaiLM.setFinalBid(1000000L);
        productDTOTaiLM.setImageUrl("abcabcabc");
        productDTOTaiLM.setStartDate("2022-04-30 08:00:00");
        productDTOTaiLM.setEndDate("2022-05-30 08:00:00");
        productDTOTaiLM.setDescription("");
        category.setId(4L);
        category.setName("Phương tiện");
        productDTOTaiLM.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/product/register")
                        .content(this.objectMapper.writeValueAsString(productDTOTaiLM))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // trường hợp trường name invalid
    @Test
    public void registerProduct_15_a() throws Exception{
        ProductDTOTaiLM productDTOTaiLM = new ProductDTOTaiLM();
        Category category = new Category();

        productDTOTaiLM.setName("abcdfv");
        productDTOTaiLM.setStartBid(5000L);
        productDTOTaiLM.setBidRange(10000L);
        productDTOTaiLM.setFinalBid(1000000L);
        productDTOTaiLM.setImageUrl("abcabcabc");
        productDTOTaiLM.setStartDate("2022-04-30 08:00:00");
        productDTOTaiLM.setEndDate("2022-05-20 08:00:00");
        productDTOTaiLM.setDescription("Bền, đẹp");
        category.setId(4L);
        category.setName("Phương tiện");
        productDTOTaiLM.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/product/register")
                        .content(this.objectMapper.writeValueAsString(productDTOTaiLM))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // trường hợp trường startBid invaild
    @Test
    public void registerProduct_15_b() throws Exception{
        ProductDTOTaiLM productDTOTaiLM = new ProductDTOTaiLM();
        Category category = new Category();

        productDTOTaiLM.setName("Máy Bay");
        productDTOTaiLM.setStartBid(-12L);
        productDTOTaiLM.setBidRange(10000L);
        productDTOTaiLM.setFinalBid(1000000L);
        productDTOTaiLM.setImageUrl("abcabcabc");
        productDTOTaiLM.setStartDate("2022-04-30 08:00:00");
        productDTOTaiLM.setEndDate("2022-05-20 08:00:00");
        productDTOTaiLM.setDescription("Bền, đẹp");
        category.setId(4L);
        category.setName("Phương tiện");
        productDTOTaiLM.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/product/register")
                        .content(this.objectMapper.writeValueAsString(productDTOTaiLM))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // trường hợp trường bidRange invalid
    @Test
    public void registerProduct_15_c() throws Exception{
        ProductDTOTaiLM productDTOTaiLM = new ProductDTOTaiLM();
        Category category = new Category();

        productDTOTaiLM.setName("Máy Bay");
        productDTOTaiLM.setStartBid(5000L);
        productDTOTaiLM.setBidRange(-12L);
        productDTOTaiLM.setFinalBid(1000000L);
        productDTOTaiLM.setImageUrl("abcabcabc");
        productDTOTaiLM.setStartDate("2022-04-30 08:00:00");
        productDTOTaiLM.setEndDate("2022-05-20 08:00:00");
        productDTOTaiLM.setDescription("Bền, đẹp");
        category.setId(4L);
        category.setName("Phương tiện");
        productDTOTaiLM.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/product/register")
                        .content(this.objectMapper.writeValueAsString(productDTOTaiLM))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // trường hợp trường finalBid invalid
    @Test
    public void registerProduct_15_d() throws Exception{
        ProductDTOTaiLM productDTOTaiLM = new ProductDTOTaiLM();
        Category category = new Category();

        productDTOTaiLM.setName("Máy Bay");
        productDTOTaiLM.setStartBid(5000L);
        productDTOTaiLM.setBidRange(10000L);
        productDTOTaiLM.setFinalBid(null);
        productDTOTaiLM.setImageUrl("abcabcabc");
        productDTOTaiLM.setStartDate("2022-04-30 08:00:00");
        productDTOTaiLM.setEndDate("2022-05-20 08:00:00");
        productDTOTaiLM.setDescription("Bền, đẹp");
        category.setId(4L);
        category.setName("Phương tiện");
        productDTOTaiLM.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/product/register")
                        .content(this.objectMapper.writeValueAsString(productDTOTaiLM))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // trường hợp trường imageUrl invalid
    @Test
    public void registerProduct_15_e() throws Exception{
        ProductDTOTaiLM productDTOTaiLM = new ProductDTOTaiLM();
        Category category = new Category();

        productDTOTaiLM.setName("Máy Bay");
        productDTOTaiLM.setStartBid(5000L);
        productDTOTaiLM.setBidRange(10000L);
        productDTOTaiLM.setFinalBid(1000000L);
        productDTOTaiLM.setImageUrl(" ");
        productDTOTaiLM.setStartDate("2022-04-30 08:00:00");
        productDTOTaiLM.setEndDate("2022-05-20 08:00:00");
        productDTOTaiLM.setDescription("Bền, đẹp");
        category.setId(4L);
        category.setName("Phương tiện");
        productDTOTaiLM.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/product/register")
                        .content(this.objectMapper.writeValueAsString(productDTOTaiLM))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // trường hợp trường startDate invalid
    @Test
    public void registerProduct_15_f() throws Exception{
        ProductDTOTaiLM productDTOTaiLM = new ProductDTOTaiLM();
        Category category = new Category();

        productDTOTaiLM.setName("Máy Bay");
        productDTOTaiLM.setStartBid(5000L);
        productDTOTaiLM.setBidRange(10000L);
        productDTOTaiLM.setFinalBid(1000000L);
        productDTOTaiLM.setImageUrl("abcabcabc");
        productDTOTaiLM.setStartDate("abc");
        productDTOTaiLM.setEndDate("2022-05-20 08:00:00");
        productDTOTaiLM.setDescription("Bền, đẹp");
        category.setId(4L);
        category.setName("Phương tiện");
        productDTOTaiLM.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/product/register")
                        .content(this.objectMapper.writeValueAsString(productDTOTaiLM))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // trường hợp trường endDate invalid
    @Test
    public void registerProduct_15_g() throws Exception{
        ProductDTOTaiLM productDTOTaiLM = new ProductDTOTaiLM();
        Category category = new Category();

        productDTOTaiLM.setName("Máy Bay");
        productDTOTaiLM.setStartBid(5000L);
        productDTOTaiLM.setBidRange(10000L);
        productDTOTaiLM.setFinalBid(1000000L);
        productDTOTaiLM.setImageUrl("abcabcabc");
        productDTOTaiLM.setStartDate("2022-04-30 08:00:00");
        productDTOTaiLM.setEndDate("abc");
        productDTOTaiLM.setDescription("Bền, đẹp");
        category.setId(4L);
        category.setName("Phương tiện");
        productDTOTaiLM.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/product/register")
                        .content(this.objectMapper.writeValueAsString(productDTOTaiLM))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // trường hợp trường description invalid
    @Test
    public void registerProduct_15_h() throws Exception{
        ProductDTOTaiLM productDTOTaiLM = new ProductDTOTaiLM();
        Category category = new Category();

        productDTOTaiLM.setName("Máy Bay");
        productDTOTaiLM.setStartBid(5000L);
        productDTOTaiLM.setBidRange(10000L);
        productDTOTaiLM.setFinalBid(1000000L);
        productDTOTaiLM.setImageUrl("abcabcabc");
        productDTOTaiLM.setStartDate("2022-04-30 08:00:00");
        productDTOTaiLM.setEndDate("2022-05-30 08:00:00");
        productDTOTaiLM.setDescription(" ");
        category.setId(4L);
        category.setName("Phương tiện");
        productDTOTaiLM.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/product/register")
                        .content(this.objectMapper.writeValueAsString(productDTOTaiLM))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // trường hợp trường name nhở hơn minLength
    @Test
    public void registerProduct_16_a() throws Exception{
        ProductDTOTaiLM productDTOTaiLM = new ProductDTOTaiLM();
        Category category = new Category();

        productDTOTaiLM.setName("A");
        productDTOTaiLM.setStartBid(5000L);
        productDTOTaiLM.setBidRange(10000L);
        productDTOTaiLM.setFinalBid(1000000L);
        productDTOTaiLM.setImageUrl("abcabcabc");
        productDTOTaiLM.setStartDate("2022-04-30 08:00:00");
        productDTOTaiLM.setEndDate("2022-05-20 08:00:00");
        productDTOTaiLM.setDescription("Bền, đẹp");
        category.setId(4L);
        category.setName("Phương tiện");
        productDTOTaiLM.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/product/register")
                        .content(this.objectMapper.writeValueAsString(productDTOTaiLM))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // trường hợp trường startBid nhỏ hơn minLength
    @Test
    public void registerProduct_16_b() throws Exception{
        ProductDTOTaiLM productDTOTaiLM = new ProductDTOTaiLM();
        Category category = new Category();

        productDTOTaiLM.setName("Máy Bay");
        productDTOTaiLM.setStartBid(5L);
        productDTOTaiLM.setBidRange(10000L);
        productDTOTaiLM.setFinalBid(1000000L);
        productDTOTaiLM.setImageUrl("abcabcabc");
        productDTOTaiLM.setStartDate("2022-04-30 08:00:00");
        productDTOTaiLM.setEndDate("2022-05-20 08:00:00");
        productDTOTaiLM.setDescription("Bền, đẹp");
        category.setId(4L);
        category.setName("Phương tiện");
        productDTOTaiLM.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/product/register")
                        .content(this.objectMapper.writeValueAsString(productDTOTaiLM))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // trường hợp trường bidRange nhỏ hơn minLength
    @Test
    public void registerProduct_16_c() throws Exception{
        ProductDTOTaiLM productDTOTaiLM = new ProductDTOTaiLM();
        Category category = new Category();

        productDTOTaiLM.setName("Máy Bay");
        productDTOTaiLM.setStartBid(5000L);
        productDTOTaiLM.setBidRange(3L);
        productDTOTaiLM.setFinalBid(1000000L);
        productDTOTaiLM.setImageUrl("abcabcabc");
        productDTOTaiLM.setStartDate("2022-04-30 08:00:00");
        productDTOTaiLM.setEndDate("2022-05-20 08:00:00");
        productDTOTaiLM.setDescription("Bền, đẹp");
        category.setId(4L);
        category.setName("Phương tiện");
        productDTOTaiLM.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/product/register")
                        .content(this.objectMapper.writeValueAsString(productDTOTaiLM))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // trường hợp trường finalBid nhỏ hơn minLength
    @Test
    public void registerProduct_16_d() throws Exception{
        ProductDTOTaiLM productDTOTaiLM = new ProductDTOTaiLM();
        Category category = new Category();

        productDTOTaiLM.setName("Máy Bay");
        productDTOTaiLM.setStartBid(5000L);
        productDTOTaiLM.setBidRange(10000L);
        productDTOTaiLM.setFinalBid(3L);
        productDTOTaiLM.setImageUrl("abcabcabc");
        productDTOTaiLM.setStartDate("2022-04-30 08:00:00");
        productDTOTaiLM.setEndDate("2022-05-20 08:00:00");
        productDTOTaiLM.setDescription("Bền, đẹp");
        category.setId(4L);
        category.setName("Phương tiện");
        productDTOTaiLM.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/product/register")
                        .content(this.objectMapper.writeValueAsString(productDTOTaiLM))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // trường hợp trường imageUrl nhỏ hơn minLength
    @Test
    public void registerProduct_16_e() throws Exception{
        ProductDTOTaiLM productDTOTaiLM = new ProductDTOTaiLM();
        Category category = new Category();

        productDTOTaiLM.setName("Máy Bay");
        productDTOTaiLM.setStartBid(5000L);
        productDTOTaiLM.setBidRange(10000L);
        productDTOTaiLM.setFinalBid(1000000L);
        productDTOTaiLM.setImageUrl("a");
        productDTOTaiLM.setStartDate("2022-04-30 08:00:00");
        productDTOTaiLM.setEndDate("2022-05-20 08:00:00");
        productDTOTaiLM.setDescription("Bền, đẹp");
        category.setId(4L);
        category.setName("Phương tiện");
        productDTOTaiLM.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/product/register")
                        .content(this.objectMapper.writeValueAsString(productDTOTaiLM))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // trường hợp trường startDate nhỏ hơn minLength
    @Test
    public void registerProduct_16_f() throws Exception{
        ProductDTOTaiLM productDTOTaiLM = new ProductDTOTaiLM();
        Category category = new Category();

        productDTOTaiLM.setName("Máy Bay");
        productDTOTaiLM.setStartBid(5000L);
        productDTOTaiLM.setBidRange(10000L);
        productDTOTaiLM.setFinalBid(1000000L);
        productDTOTaiLM.setImageUrl("abcabcabc");
        productDTOTaiLM.setStartDate("2022-04-30");
        productDTOTaiLM.setEndDate("2022-05-20 08:00:00");
        productDTOTaiLM.setDescription("Bền, đẹp");
        category.setId(4L);
        category.setName("Phương tiện");
        productDTOTaiLM.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/product/register")
                        .content(this.objectMapper.writeValueAsString(productDTOTaiLM))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // trường hợp trường endDate nhỏ hơn minLength
    @Test
    public void registerProduct_16_g() throws Exception{
        ProductDTOTaiLM productDTOTaiLM = new ProductDTOTaiLM();
        Category category = new Category();

        productDTOTaiLM.setName("Máy Bay");
        productDTOTaiLM.setStartBid(5000L);
        productDTOTaiLM.setBidRange(10000L);
        productDTOTaiLM.setFinalBid(1000000L);
        productDTOTaiLM.setImageUrl("abcabcabc");
        productDTOTaiLM.setStartDate("2022-04-30 08:00:00");
        productDTOTaiLM.setEndDate("2022-05-20");
        productDTOTaiLM.setDescription("Bền, đẹp");
        category.setId(4L);
        category.setName("Phương tiện");
        productDTOTaiLM.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/product/register")
                        .content(this.objectMapper.writeValueAsString(productDTOTaiLM))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // trường hợp trường description nhỏ hơn minLength
    @Test
    public void registerProduct_16_h() throws Exception{
        ProductDTOTaiLM productDTOTaiLM = new ProductDTOTaiLM();
        Category category = new Category();

        productDTOTaiLM.setName("Máy Bay");
        productDTOTaiLM.setStartBid(5000L);
        productDTOTaiLM.setBidRange(10000L);
        productDTOTaiLM.setFinalBid(1000000L);
        productDTOTaiLM.setImageUrl("abcabcabc");
        productDTOTaiLM.setStartDate("2022-04-30 08:00:00");
        productDTOTaiLM.setEndDate("2022-05-30 08:00:00");
        productDTOTaiLM.setDescription("a");
        category.setId(4L);
        category.setName("Phương tiện");
        productDTOTaiLM.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/product/register")
                        .content(this.objectMapper.writeValueAsString(productDTOTaiLM))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // trường hợp trường name lớn hơn maxLength
    @Test
    public void registerProduct_17_a() throws Exception{
        ProductDTOTaiLM productDTOTaiLM = new ProductDTOTaiLM();
        Category category = new Category();

        productDTOTaiLM.setName("Aaaaa Bbbb Acccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc");
        productDTOTaiLM.setStartBid(5000L);
        productDTOTaiLM.setBidRange(10000L);
        productDTOTaiLM.setFinalBid(1000000L);
        productDTOTaiLM.setImageUrl("abcabcabc");
        productDTOTaiLM.setStartDate("2022-04-30 08:00:00");
        productDTOTaiLM.setEndDate("2022-05-20 08:00:00");
        productDTOTaiLM.setDescription("Bền, đẹp");
        category.setId(4L);
        category.setName("Phương tiện");
        productDTOTaiLM.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/product/register")
                        .content(this.objectMapper.writeValueAsString(productDTOTaiLM))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // trường hợp trường startBid lớn hơn maxLength
    @Test
    public void registerProduct_17_b() throws Exception{
        ProductDTOTaiLM productDTOTaiLM = new ProductDTOTaiLM();
        Category category = new Category();

        productDTOTaiLM.setName("Máy Bay");
        productDTOTaiLM.setStartBid(900000000L);
        productDTOTaiLM.setBidRange(10000L);
        productDTOTaiLM.setFinalBid(1000000L);
        productDTOTaiLM.setImageUrl("abcabcabc");
        productDTOTaiLM.setStartDate("2022-04-30 08:00:00");
        productDTOTaiLM.setEndDate("2022-05-20 08:00:00");
        productDTOTaiLM.setDescription("Bền, đẹp");
        category.setId(4L);
        category.setName("Phương tiện");
        productDTOTaiLM.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/product/register")
                        .content(this.objectMapper.writeValueAsString(productDTOTaiLM))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // trường hợp trường bidRange lớn hơn maxLength
    @Test
    public void registerProduct_17_c() throws Exception{
        ProductDTOTaiLM productDTOTaiLM = new ProductDTOTaiLM();
        Category category = new Category();

        productDTOTaiLM.setName("Máy Bay");
        productDTOTaiLM.setStartBid(5000L);
        productDTOTaiLM.setBidRange(1000000000000000L);
        productDTOTaiLM.setFinalBid(1000000L);
        productDTOTaiLM.setImageUrl("abcabcabc");
        productDTOTaiLM.setStartDate("2022-04-30 08:00:00");
        productDTOTaiLM.setEndDate("2022-05-20 08:00:00");
        productDTOTaiLM.setDescription("Bền, đẹp");
        category.setId(4L);
        category.setName("Phương tiện");
        productDTOTaiLM.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/product/register")
                        .content(this.objectMapper.writeValueAsString(productDTOTaiLM))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // trường hợp trường finalBid nhỏ hơn minLength
    @Test
    public void registerProduct_17_d() throws Exception{
        ProductDTOTaiLM productDTOTaiLM = new ProductDTOTaiLM();
        Category category = new Category();

        productDTOTaiLM.setName("Máy Bay");
        productDTOTaiLM.setStartBid(5000L);
        productDTOTaiLM.setBidRange(10000L);
        productDTOTaiLM.setFinalBid(10000000000000000L);
        productDTOTaiLM.setImageUrl("abcabcabc");
        productDTOTaiLM.setStartDate("2022-04-30 08:00:00");
        productDTOTaiLM.setEndDate("2022-05-20 08:00:00");
        productDTOTaiLM.setDescription("Bền, đẹp");
        category.setId(4L);
        category.setName("Phương tiện");
        productDTOTaiLM.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/product/register")
                        .content(this.objectMapper.writeValueAsString(productDTOTaiLM))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // trường hợp trường imageUrl lớn hơn maxLength
    @Test
    public void registerProduct_17_e() throws Exception{
        ProductDTOTaiLM productDTOTaiLM = new ProductDTOTaiLM();
        Category category = new Category();

        productDTOTaiLM.setName("Máy Bay");
        productDTOTaiLM.setStartBid(5000L);
        productDTOTaiLM.setBidRange(10000L);
        productDTOTaiLM.setFinalBid(1000000L);
        productDTOTaiLM.setImageUrl("Cuộc đời con người là hành trình tìm kiếm cái đẹp, cái đẹp trở thành đích đến trên đường đời, ta vì cái đẹp mà tồn tại. “Cái đẹp là thứ duy nhất mà thời gian không thể làm tổn hại” (Oscar Wilde). Không nằm ngoài lẽ đó, văn chương là lĩnh vực của cái đẹp. Tự thân văn học đã là hoạt động sáng tạo tuân thủ theo quy luật cái đẹp. Nhà phê bình Nga Belinsky khẳng định “Cái đẹp là điều kiện không thể thiếu được của nghệ thuật, nếu thiếu cái đẹp thì không có và không thể có nghệ thuật”. Cùng bàn về đối tượng văn học phản ánh, nhà văn Nguyễn Khải cho rằng: “Văn chương có quyền nhưng không chỉ miêu tả cái xấu xa, cái ghê tởm, cái hèn nhát. Thanh nam châm thu hút mọi thế hệ vẫn là cái cao thượng, cái tốt đẹp, cái thuỷ chung”. Nguyễn Khải khẳng định văn chương không chỉ viết về cái xấu, cái ác, mà điều sống mãi trong lòng người đọc vẫn là cái đẹp, cái thiện. Dẫu văn chương có phản ánh cái ác thì cái đẹp luôn là yếu tố thu hút bạn đọc đến với văn chương." +
                "sfsdfsadfsgdfghdhgrfhhfghfhfgghfghdfghdgdfgdfgdsfgfsdfsdafasf" +
                "Trước tiên, Nguyễn Khải thừa nhận văn chương hoàn toàn “có quyền” được viết về “cái xấu xa, cái ghê tởm, cái hèn nhát”. Văn chương được phép phản ánh những điều bất nhân, giả dối, hèn hạ bởi bản chất cuộc sống và con người là bất toàn. Không thể nói nhà văn viết về cái xấu, cái chưa đẹp là “bôi xấu”, “tô đen” vì hiện thực còn nhiều điều “xấu xa, ghê tởm”. Nhưng không vì thế mà văn chương toàn những trang viết về cái xấu, cái ác, “cái đẹp là cuộc sống” (Secnusepxki) chứ không ở đâu xa. Hơn hết, Nguyễn Khải muốn khẳng định yếu tố làm nên sức hấp dẫn của văn chương chính là “cái cao thượng, cái tốt đẹp, cái thuỷ chung”. Người ta tìm đến văn chương để khám phá những điều tốt đẹp. Văn chương lôi cuốn người đọc bởi những điều cao cả, đẹp đẽ, bền bỉ với thời gian." +
                "sdfsadfsafsdfsafdgdfgmdlnlmdfgbkdsfngbdsknfgbkdsbfgkdbfgksdfbgkdfbgksndbgkdnfngkdsfngmdng,m" +
                "Đúng như Tố Hữu từng nói: “Văn học thực chất là cuộc đời. Văn học sẽ không là gì cả nếu không vì cuộc đời mà có. Cuộc đời là nơi xuất phát và cũng là nơi đi tới của văn học”. Đặc trưng của văn học cũng như các bộ môn nghệ thuật khác là phản ánh hiện thực. Văn học tái hiện cuộc đời trên trang viết, nhưng cuộc sống đâu chỉ có những bông hoa mà còn có cả những hàng rào dây thép, xung quanh ta đâu chỉ tồn tại cái lương thiện, tốt đẹp mà còn có cả đau đớn, xấu xa. Vì thế mà Nguyễn Khải khẳng định văn chương không từ chối hay né tránh “cái xấu xa, cái ghê tởm, cái hèn nhát”. Văn chương không thể không miêu tả khi cái xấu, cái ác vẫn hiện hữu trong cuộc sống con người. Tác phẩm phải mang hơi thở cuộc đời với bao thật giả, trắng đen còn trộn lẫn, cả niềm vui, hạnh phúc và cả nỗi buồn, sự đắng cay. Cái tốt và cái xấu đan xen, cái được và cái mất tồn tại cạnh nhau, gắn chặt với nhau, vì vậy nếu chỉ nói cái tốt là chỉ mới nói một phần sự thật. Văn chương chân chính phải phản ánh được trọn vẹn, sâu sắc đời sống, kể cả màu tối lẫn mảng sáng. Sự tức giận khi chứng kiến lòng tự trọng, công lí, tình yêu và cái đẹp bị xúc phạm nhiều khi thúc đẩy người ta cầm bút không kém gì cảm hứng về chính nghĩa và cái đẹp. Vậy, văn chương hoàn toàn “có quyền miêu tả cái xấu xa, cái ghê tởm, cái hèn nhát” bởi cái xấu cũng là một phần hiện thực." +
                "dsgdfgdskgnalnfglgnlsdjgnsdpkfnga;lkfnglsdfnglsjfgnsldfjgnsdofgjndofjg" +
                "Nhưng “Tác phẩm nghệ thuật sẽ chết nếu nó miêu tả cuộc sống chỉ để miêu tả” (Belinsky). Văn chương sẽ “chết yểu” nếu phản ánh chỉ đơn thuần để phản ánh mà thôi. Giữa cuộc sống thiện ác lẫn lộn, tốt xấu giao tranh, nhiệm vụ của văn học là miêu tả cái xấu để người ta nhận diện từ đó mạnh mẽ chống lại nó. Văn học miêu tả cái xấu để thể hiện khát vọng hướng tâm hồn con người về cái đẹp, cái thiện của nhà văn. Muốn “ý nghĩa thực sự của văn học là nhân đạo hóa con người”, trước tiên văn học cần giúp con người nhận thức cái xấu trước đã. Vốn dĩ cái đẹp thì mong manh, dễ vỡ, lòng tốt thì vụng dại, ngây thơ, còn cái ác lại thì dạn dĩ, nham hiểm, cái đểu cáng thì liều lĩnh, xảo quyệt. Không những thế, sức tàn phá của cái xấu lại lớn hơn gấp trăm lần sức mạnh của cái đẹp. Nhà văn nói thật, nói sâu về cái xấu, cái ác bởi bằng cách đó văn chương hỗ trợ cho cuộc đấu tranh không cân sức giữa thiện và ác muôn đời.  Văn học “được quyền miêu tả cái xấu xa, cái ghê tởm, cái hèn nhát” để giúp con người nhận thức và ngăn chặn cái xấu, cái ác. Khi cảm nhận cái xấu, con người nên cao hơn cả cái xấu và hướng tới cái tốt, cái đẹp. Nghệ thuật phán xét cái xấu một cách đúng đắn chính là “bông hoa của văn minh, rau quả của tinh thần xã hội phát triển” (Belinsky). Tiếp xúc với cái xấu trong nghệ thuật, con người trở nên từng trải hơn, hiểu sâu sắc hơn về cái xấu cũng như tập đối mặt với sức mạnh của cái ác. Vậy là bằng cách phản ánh “cái xấu xa, cái ghê tởm, cái hèn nhát”, văn chương đã thực hiện nhiệm vụ “nâng cao tinh thần ta lên” (Napoluye)" +
                "gdfkngdslkfngdsljfngsldjgndslkjfgndljkkfgnksldjfgbksdbgksdhgbdfhgb" +
                "Cũng như Nguyễn Khuyến, Cao Bá Quát,… Tú Xương lên tiếng giễu cợt, đả kích gay gắt bọn giặc Tây và bè lũ tay sai gian ác. Ông lên án những chuyện xấu xa của thời buổi Tây Tàu lố lăng, đặc biệt là vấn nạn khoa cử. Không còn nữa hình ảnh trang trọng, “hài văn lần bước dặm xanh” (“Truyện Kiều”) của sĩ tử ngày nào, cũng không thấy đâu không khí trang nghiêm chốn trường thi thuở trước. Trong “Vịnh khoa thi hương”, Tú Xương chỉ thấy một bức tranh nhốn nháo, “ghê tởm” như những trò hề không hơn không kém:\n" +
                "dfgsdkfgjdsfklgnsdgfjnhdfogsndgojsdnfgljdsngsljkdngldjnglsjdngldsjgndslkjgnlsojgnolgnaojbgiajhbgf" +
                "“Lôi thôi sĩ tử vai đeo lọ," +
                "Ậm ọe quan trường miệng thét loa." +
                "Lọng cắm rợp trời quan sứ đến," +
                "Váy lê quét đất mụ đầm ra.”" +
                "gsdfkgndslfjgnsdfljgnlkfngs;odfgjnop;fnao;gfnsofjgnafgjosdbghskdbg" +
                "Tú Xương chua chát trước cảnh sĩ tử “lôi thôi”, quan trường “ậm ọe” – hình ảnh đại diện cho Hán học trở nên nhếch nhác chưa từng thấy. Trong khi đó quan sứ lại xuất hiện với một sự long trọng quá thể: “lọng cắm rợp trời”, “váy lê quét đất” hoành tráng, áp đảo cả nhân vật chính - sĩ tử. Trường thi vốn là nơi nghiêm túc, hiên ngang nhưng chỉ còn những điều xấu xa, nhục nhã. Vai chính trong vở tuồng thi cử lại dành cho kẻ xấu, cái ác - quan lại, bọn tay sai thực dân Pháp. Ẩn sâu thực trạng đáng hổ thẹn ấy chính là tiếng lòng cay đắng của nhà thơ trước cảnh nhiễu nhương Tây Tàu. Sự cay đắng ấy cũng là khao khát của nhà thơ yêu nước tha thiết về độc lập và bình yên của đất nước. Phản ánh cái xấu xa trong hiện thực thời đó, Tú Xương không chỉ giúp ta nhận diện cái xấu, cái ác mà còn khơi gợi lòng yêu nước trong lòng người đọc, giúp ta biết đứng lên chống lại cái xấu, cái bất nhân.\n" +
                "dfgsdfgkpanfg[pgoknsfgojwngjiongjkdfhbsljfgnaogfngjsndgsljkdngskjgnskjdbgsdbgd" +
                "Không chỉ Tú Xương “có quyền miêu tả cái xấu xa, cái ghê tởm, cái hèn nhát” mà Chekhov cũng không ngần ngại chỉ ra căn bệnh tinh thần của thời đại ông mang tên “Người trong bao”. Belikov có một nếp sống thật lạ kì, “con người này có khát vọng mãnh liệt thu mình vào trong một cái vỏ, tạo cho mình một thứ bao có thể ngăn cách, bảo vệ hắn khỏi những ảnh hưởng bên ngoài”. Hoá ra, con người ấy sợ “nhỡ lại xảy ra chuyện gì”, ý nghĩ này lặp lại đến năm lần. Đó là cách sống “hèn nhát”: luôn trốn tránh, sống trong sợ hãi gây nên sự ngột ngạt cho những người xung quanh. Tâm lí nô lệ, bạc nhược, tự ti, cái lối sống không đúng đắn ấy là hình ảnh cuộc sống công chức Nga cuối thế kỉ XIX, một lối sống thảm hại, bạc nhược, khiếp sợ trước cường quyền. Bằng cách phản ánh cái “hèn nhát” của Belikov, của căn bệnh sống “trong bao”, Chekhov cất lên tiếng chuông cần thay đổi, “Không thể sống mãi như thế được!”. Để vượt qua được tâm lí đó, chữa khỏi căn bệnh “trong bao”, người dân rất cần thay đổi, cần có một lối sống khác. Người thực hiện hiệu quả nhất chính là những con người dũng cảm đứng ra chữa trị căn bệnh tinh thần của thế hệ mình và phải cùng nhau xây dựng một chế độ tốt đẹp. Can đảm viết về căn bệnh thời đại mình, Chekhov giúp độc giả ý thức “cái hèn nhát”, qua đó gợi suy ngẫm về con đường tiêu diệt căn bệnh này." +
                "dsfgskdnfga;slkdfnga;lkgna;lgknofgjnrothnsdjlnglkdnga;lk;angojngsdfgdfg" +
                "Nguyễn Khải thừa nhận quyền được miêu tả cái xấu của văn chương, nhưng như vậy là chỉ phản ánh một mặt đời sống. Văn chương chân chính “không chỉ miêu tả cái xấu xa, cái ghê tởm, cái hèn nhát. Thanh nam châm thu hút mọi thế hệ vẫn là cái cao thượng, cái tốt đẹp, cái thuỷ chung”. Con người luôn có nhu cầu cảm thụ, thưởng thức cái đẹp cũng con người luôn muốn cuộc sống đẹp hơn. Văn học có khả năng phát hiện và miêu tả những vẻ đẹp của cuộc sống toàn diện và sâu sắc hơn. Thông qua đó, tác phẩm giúp bạn đọc không chỉ cảm nhận được mà còn biết rung động trước những vẻ đẹp đó. Bởi nhu cầu thỏa mãn thẩm mĩ, khơi dậy những khoái cảm nghệ thuật nơi người đọc nên giá trị thẩm mỹ trở thành mục tiêu của nghệ thuật, “Văn học, đó là tư tưởng đi tìm cái đẹp trong ánh sáng” (Charles Dubos). Những tình điệu thẩm mỹ trong văn học mang bóng dáng vẻ đẹp muôn hình muôn vẻ của cuộc đời: vẻ đẹp trong thiên nhiên, cảnh vật, vẻ đẹp của những cảnh đời, vẻ đẹp văn hoá, phong tục ... Cái đẹp Nguyễn Khải muốn nhấn mạnh là “cái cao thượng, cái tốt đẹp, cái thuỷ chung” - vẻ đẹp tư tưởng, tình cảm của thế giới nội tâm con người. Bên cạnh đó, soi chiếu dưới góc độ người cầm bút, những nghệ sĩ chân chính viết nên những tác phẩm khẳng định tư tưởng tiến bộ, nhằm phục vụ điều thiện và chính nghĩa. Bởi “Niềm vui của nhà văn chân chính là được làm người dẫn đường đến xứ sở của cái đẹp” (Paustovsky)." +
                "dfgsdfkgnaopwpgjnisrutgnljwnojengojnfdljgndlgjnsgjndgjdsngkjsdng" +
                "Bên cạnh thỏa mãn nhu cầu về cái đẹp, văn học cũng là nơi bồi dưỡng cảm xúc, thẩm mĩ của con người, nó giúp người đọc có thị hiếu thẩm mĩ lành mạnh, tinh tế. “Tác phẩm văn học lớn hấp dẫn người ta bởi cách nhìn nhận mới, tình cảm mới về những điều, những việc mà ai cũng biết cả rồi” (Nguyễn Đình Thi) nên mỗi nhà văn chân chính bao giờ cũng mang đến cho văn học một “cách nhìn nhận mới, tình cảm mới” của vẻ đẹp của đời sống. Cho nên, văn học bồi đắp kinh nghiệm thẩm mỹ chúng ta thêm sâu sắc, phong phú. Kinh nghiệm ấy giúp con người không chỉ biết nhận ra cái hay, cái đẹp trong tác phẩm mà còn biết tự khám phá ra cái đẹp của thế giới, đời sống tâm hồn độc giả thêm giàu có. Văn chương là nơi nuôi dưỡng những cảm xúc đẹp của con người, khơi dậy và tiếp sức cho những rung động về cái đẹp. Chính cái đẹp tiếp lửa cho sức mạnh tâm hồn con người luôn nhạy cảm, mới mẻ với vẻ đẹp muôn màu muôn vẻ của đời sống. Vì vậy mà trái tim con người không thể dửng dưng, thờ ơ, nguội lạnh với số phận con người. Bằng cách khiến người đọc rung động trước cái đẹp, văn học làm lòng người phong phú hơn, đó cũng là lí do vì sao Dostoevsky khẳng định: “Cái đẹp sẽ cứu rỗi thế giới”.\n" +
                "dfgdsfgkm[ưmgo;sntgot;rjtungsldjgns;dlkfgns;lgknsdl;fgknsdlgjndfljgnsdjfgnsgs" +
                "Với Thạch Lam: “Công việc của nhà văn là phát hiện cái đẹp chính ở chỗ mà không ai ngờ, tìm cái đẹp kín đáo che lấp của sự vật, cho người khác một bài học về trông nhìn thưởng thức”. Giữa cảnh phố huyện nghèo nàn và những kiếp người cùng khổ trong “Hai đứa trẻ”, ông đã “phát hiện cái đẹp chính ở chỗ mà không ai ngờ”, chính là vẻ đẹp ánh lên từ tâm hồn Liên, ánh lên từ lòng trắc ẩn và niềm hy vọng của chị. Liên chăm chú quan sát những đứa trẻ nhà nghèo, “trông thấy động lòng thương nhưng chính chị cũng không có tiền để mà cho chúng nó”. Liên dù muốn cụ Thi chóng đi nhưng vẫn rót cho cụ đầy cút rượu. Liên quan tâm đến thời gian chị Tí thường dọn hàng, Liên để mắt đến vợ chồng bác xẩm. Dẫu chính mình vẫn đang ngụp lặn trong cái ao đời phẳng lặng, Liên vẫn dành sự quan tâm, yêu thương, chia sẻ với những người nơi phố huyện. Đó là cái đẹp vừa của một lòng trắc ẩn đã biết nghĩ, vừa chân thành của một đứa trẻ vẫn chưa hết thơ ngây. Không những thế, vẻ đẹp tâm hồn Liên còn thể hiện bằng niềm tin, niềm hy vọng không tắt giữa bóng tối phố huyện nghèo. Ánh mắt chị luôn luôn hướng về ánh sáng, tâm hồn chị hướng về Hà Nội xa xăm. Đôi mắt Liên bắt lấy ánh sáng, từ khe sáng, hột sáng đến vùng sáng, quầng sáng. Đó là niềm tin về tương lai của một đứa trẻ chưa bị cái quẩn quanh của đời sống làm mờ đi, cũng là một tâm hồn từng được vui, được hạnh phúc. Liên và An vẫn biết tìm vui, vẫn nuôi hy vọng về “Hà Nội sáng rực, vui vẻ và huyên náo”. Bóng tối phố huyện đâu thể nhấn chìm niềm vui và động lực sống của Liên, khi chị đang cố thoát khỏi kiếm đời u ám để hướng về bầu trời mộng tưởng, hướng về quá khứ đã từng hạnh phúc. Đọc “Hai đứa trẻ”, ta thêm yêu và thêm tin vào vẻ đẹp tâm hồn con người, dẫu khuất lấp sau bóng tối nhưng chưa bao giờ tàn lụi." +
                "dfgdsfk;gmsdf;gkpnsd;fgfnwp;gnklotgujnrohujnjsglknhljdsng;dlagnadlgjndflgjdsnfgljsdfngl;sdjgndsljfgn" +
                "Nếu trang văn Thạch Lam “thu hút mọi thế hệ” bởi tấm lòng tốt đẹp của Liên, thì “thanh nam châm” của “Những người khốn khổ” là vẻ đẹp từ lòng nhân ái của Jean Valjean. Cũng là một con người khốn khổ, phải chịu bao đau đớn tù đày nhưng Jean Valjean lại có một trái tim nhân hậu và tinh tế. Không muốn Fantine đau đớn khi biết mình bị bắt, Jean Valjean nhún nhường cầu xin Javert bằng những lời lẽ vòng vo: “Tôi biết là anh muốn gì rồi”, “Tôi cầu xin ông một điều”. Đến khi Fantine ra đi, “Trong nét mặt và dáng điệu ông chỉ thấy một nỗi thương xót khôn tả”. Ông thương xót một kiếp người bất hạnh đã ra đi mãi mãi hay cũng chính là đang thương xót cho kiếp người “bị ruồng bỏ” của mình ? “Như một người mẹ sửa sang cho con”, ông trân trọng nâng đầu Fantine, thắt lại dây rút cổ áo chị, vén tóc và vuốt mắt chị. Vẻ đẹp thu hút cũng như làm xúc động người đọc chính là lòng tốt đáng trân trọng của Jean Valjean, lòng tốt đến từ những người cùng khổ. Đọc “Những người khốn khổ”, ta được đánh thức từ tình cảm tốt đẹp ấy, từ đó biết yêu thêm mọi người xung quanh, lan\n" +
                "fdgdsfknga;lgns;dlfgnds;lkgnsd;fpignsw;ôngurbgdjhbgjfdgnalkdnfg;lskfm;aksdfm;áklngfokjfngdjfogndf" +
                "“Thơ là sự thể hiện con người và thời đại một cách cao đẹp.” (Sóng Hồng). Và cũng chính cái “cao đẹp” ấy đã lôi cuốn, níu giữ tâm hồn người đọc. Thi phẩm “Tôi yêu em” (Puskin) tạo cơ hội cho độc giả gặp gỡ tình yêu chân thành, đằm thắm và cao thượng:\n" +
                "dfgsdfkngws[pkgnwpoehgnoghnsdoigjakfapofkpinfgosdfgbjsongpakfjgmnkpdngosenfdgdfg" +
                "“Tôi yêu em, yêu chân thành, đằm thắm," +
                "Cầu em được người tình như tôi đã yêu em”" +
                "dfgdgipjsdpfgijpwoihtouhyokgnds;fgm;sdlkfgnd;lkgnd;lkfngdslknfg;songaonflajsnflfnasldfn" +
                "Điệp khúc “tôi yêu em” khẳng định bản chất mối tình này là “chân thành, đằm thắm”. Trong nguyên bản tiếng Nga, động từ “yêu” được để ở thể chưa hoàn thành, cũng có nghĩa là tình yêu của “tôi” sẽ không bao giờ tắt, không bao giờ nhạt phai. Đó cũng chính là cái gốc của tấm lòng cao thượng trong tình yêu này. Từ xưa đến nay, tâm lí thông thường trong tình yêu là:" +
                "sfgdsfgksdpnfgs;dnfkgjlsdnglsdnglsjdngsljdngdsljngljngsljdfng;sldgnjsd" +
                "“Yêu nhau thì ném bã trầu," +
                "Ghét nhau ném đá vỡ đầu nhau ra”" +
                "fgsdgknsdfpgonseopgnja;knaspkfaptinhtobnogjnfdgolnflkdnsfadsfhghf" +
                "(Ca dao)" +
                "sgkfdngdljgnsdlkgna;lkfnsad;lkfnmsd;lkfn;ljgnodjhbdsojgnfgnalkfnaldkfnlkdnfalnfojenjgnkjbgbgsdbgjnfadjfqnopj" +
                "Tình yêu một khi không được đền đáp sẽ mang đến khổ đau, nếu là một người ích kỉ thì có thể sinh ra hận thù. Nhưng trong “Tôi yêu em” lại là tình yêu của một trái tim chân thật, dù đã bị cự tuyệt giữ sự cao thượng: cầu cho em được hạnh phúc. Chính có tinh thần cao thượng trong tình yêu là vẻ đẹp hấp dẫn bạn đọc, một vẻ đẹp rất mới mẻ. Đây là minh chứng nhân cách cao thượng của Puskin, đồng thời là tinh hoa của nền văn học Nga, một nền văn học nhân đạo và lí tưởng. Quả thật, “Thơ ca làm cho tất cả những gì tốt đẹp nhất trên đời trở thành bất tử.” (Shelly). Văn chương vừa bất tử hoá giá trị thẩm mỹ, và cũng chính giá trị thẩm mỹ làm văn chương vượt ra khỏi quy luật cái chết." +
                "dsgfksngsljdfnakmfkqowfnoerugndfjgna;lkfnsdl;kfnadlvnvja;alfjnoufbugbdfgfgadff" +
                "Để “cái cao thượng, cái tốt đẹp, cái thuỷ chung” có thể trở thành “thanh nam châm thu hút mọi thế hệ”, nhà văn phải “lấy ngôn ngữ làm cứu cánh” (Jakobson). Cái đẹp, cái thiện có bừng sáng đến đâu mà chỉ truyền tải bằng những con chữ cứng đơ trên trang giấy, liệu cái đẹp, cái thiện có thắp lên lửa trong lòng người đọc ? Chế Lan Viên từng viết: “Đi tìm cái thiện, cái chân nhưng phải biểu hiện ra bằng hình thức đẹp”. Điều độc giả bao đời tìm kiếm trong văn chương đâu chỉ là cái đẹp nội dung mà còn là cái đẹp về hình thức, vẻ đẹp lấp lánh của ngôn từ. Bên cạnh đó, cái đẹp trong nghệ thuật mang tính hoàn thiện: “Ðến như văn thơ, thì lại là sắc đẹp ngoài cả sắc đẹp, vị ngon ngoài cả vị ngon, không thể dùng mắt tầm thường mà xem, miệng tầm thường mà nếm được” (Hoàng Đức Lương). Điều này thúc đẩy người đọc phải có tri thức và tâm hồn sâu sắc, nhạy cảm trước cái đẹp. Có thế cái đẹp mới chạm đến phần sâu nhất của tấm lòng người đọc." +
                "fgdsfkgna;fkandfljqnorutbgbfakjgbnbkv janfklasnflaksnfaslnfouabfbasjgndfgsdfgsd" +
                "Nguyên Ngọc từng viết: “Đã là văn chương thì phải đẹp, đẹp là chức năng hàng đầu, là đạo đức của văn chương”. Nhận định khẳng định một trong những yếu tố hàng đầu của văn chương là cái đẹp. Đồng nghĩa với việc “Văn chương có quyền nhưng không chỉ miêu tả cái xấu xa, cái ghê tởm, cái hèn nhát. Thanh nam châm thu hút mọi thế hệ vẫn là cái cao thượng, cái tốt đẹp, cái thuỷ chung” (Nguyễn Khải). Với tôi, viết về cái đẹp hay cái xấu, miêu tả cái thiện hay cái ác, suy cho cùng mục đích của văn chương vẫn là làm sao cho cuộc sống con người tốt đẹp hơn, hướng con người đến bến bờ chân - thiện - mỹ. Viết về cái đẹp để tôn vinh chúng, hay viết về cái xấu để ca ngợi cái đẹp đều cùng một đích đến, chính là “làm cho người gần người hơn" + "(Nam Cao)" +
                "sdfaksdfnaso;djgntoeeuroqunbiqwhbriwernjsdkfnsjkdfnsadlfjnsdjflnskjlfnasljdfnasdf" +
                "NGUYỄN TRẦN PHƯƠNG NGHI" +
                "sdfsdflasjdkfnlasjdfnajodboqfubtroubteiwhgrbihbfgjsfnasljdfnasljfnasljfndfjlasdfdasdf" +
                "HỌC SINH LỚP 11CV TRƯỜNG THTH ĐHSP TPHCM" +
                "sdfasfjasljfnsaofjnsfouansfoasnfsjonfasfjnasljfnalsjfnasldjfbalifhgbaljfnsldojfnasiljfnakjsnfasjdbfiehbgfeerihygbabnskjfbsnkfhbasdjfhasjhfbsah" +
                "NIÊN KHÓA 2020-2023");
        productDTOTaiLM.setStartDate("2022-04-30 08:00:00");
        productDTOTaiLM.setEndDate("2022-05-20 08:00:00");
        productDTOTaiLM.setDescription("Bền, đẹp");
        category.setId(4L);
        category.setName("Phương tiện");
        productDTOTaiLM.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/product/register")
                        .content(this.objectMapper.writeValueAsString(productDTOTaiLM))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // trường hợp trường startDate lớn hơn maxLength
    @Test
    public void registerProduct_17_f() throws Exception{
        ProductDTOTaiLM productDTOTaiLM = new ProductDTOTaiLM();
        Category category = new Category();

        productDTOTaiLM.setName("Máy Bay");
        productDTOTaiLM.setStartBid(5000L);
        productDTOTaiLM.setBidRange(10000L);
        productDTOTaiLM.setFinalBid(1000000L);
        productDTOTaiLM.setImageUrl("abcabcabc");
        productDTOTaiLM.setStartDate("2022-04-30 08:00:00aaaaaaaaaafsdfsfs");
        productDTOTaiLM.setEndDate("2022-05-20 08:00:00");
        productDTOTaiLM.setDescription("Bền, đẹp");
        category.setId(4L);
        category.setName("Phương tiện");
        productDTOTaiLM.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/product/register")
                        .content(this.objectMapper.writeValueAsString(productDTOTaiLM))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // trường hợp trường endDate lớn hơn maxLength
    @Test
    public void registerProduct_17_g() throws Exception{
        ProductDTOTaiLM productDTOTaiLM = new ProductDTOTaiLM();
        Category category = new Category();

        productDTOTaiLM.setName("Máy Bay");
        productDTOTaiLM.setStartBid(5000L);
        productDTOTaiLM.setBidRange(10000L);
        productDTOTaiLM.setFinalBid(1000000L);
        productDTOTaiLM.setImageUrl("abcabcabc");
        productDTOTaiLM.setStartDate("2022-04-30 08:00:00");
        productDTOTaiLM.setEndDate("2022-05-20 08:00:00 sadfsadfsadfas");
        productDTOTaiLM.setDescription("Bền, đẹp");
        category.setId(4L);
        category.setName("Phương tiện");
        productDTOTaiLM.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/product/register")
                        .content(this.objectMapper.writeValueAsString(productDTOTaiLM))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // trường hợp trường description lớn hơn maxLength
    @Test
    public void registerProduct_17_h() throws Exception{
        ProductDTOTaiLM productDTOTaiLM = new ProductDTOTaiLM();
        Category category = new Category();

        productDTOTaiLM.setName("Máy Bay");
        productDTOTaiLM.setStartBid(5000L);
        productDTOTaiLM.setBidRange(10000L);
        productDTOTaiLM.setFinalBid(1000000L);
        productDTOTaiLM.setImageUrl("abcabcabc");
        productDTOTaiLM.setStartDate("2022-04-30 08:00:00");
        productDTOTaiLM.setEndDate("2022-05-30 08:00:00");
        productDTOTaiLM.setDescription("Cuộc đời con người là hành trình tìm kiếm cái đẹp, cái đẹp trở thành đích đến trên đường đời, ta vì cái đẹp mà tồn tại. “Cái đẹp là thứ duy nhất mà thời gian không thể làm tổn hại” (Oscar Wilde). Không nằm ngoài lẽ đó, văn chương là lĩnh vực của cái đẹp. Tự thân văn học đã là hoạt động sáng tạo tuân thủ theo quy luật cái đẹp. Nhà phê bình Nga Belinsky khẳng định “Cái đẹp là điều kiện không thể thiếu được của nghệ thuật, nếu thiếu cái đẹp thì không có và không thể có nghệ thuật”. Cùng bàn về đối tượng văn học phản ánh, nhà văn Nguyễn Khải cho rằng: “Văn chương có quyền nhưng không chỉ miêu tả cái xấu xa, cái ghê tởm, cái hèn nhát. Thanh nam châm thu hút mọi thế hệ vẫn là cái cao thượng, cái tốt đẹp, cái thuỷ chung”. Nguyễn Khải khẳng định văn chương không chỉ viết về cái xấu, cái ác, mà điều sống mãi trong lòng người đọc vẫn là cái đẹp, cái thiện. Dẫu văn chương có phản ánh cái ác thì cái đẹp luôn là yếu tố thu hút bạn đọc đến với văn chương." +
                "sfsdfsadfsgdfghdhgrfhhfghfhfgghfghdfghdgdfgdfgdsfgfsdfsdafasf" +
                "Trước tiên, Nguyễn Khải thừa nhận văn chương hoàn toàn “có quyền” được viết về “cái xấu xa, cái ghê tởm, cái hèn nhát”. Văn chương được phép phản ánh những điều bất nhân, giả dối, hèn hạ bởi bản chất cuộc sống và con người là bất toàn. Không thể nói nhà văn viết về cái xấu, cái chưa đẹp là “bôi xấu”, “tô đen” vì hiện thực còn nhiều điều “xấu xa, ghê tởm”. Nhưng không vì thế mà văn chương toàn những trang viết về cái xấu, cái ác, “cái đẹp là cuộc sống” (Secnusepxki) chứ không ở đâu xa. Hơn hết, Nguyễn Khải muốn khẳng định yếu tố làm nên sức hấp dẫn của văn chương chính là “cái cao thượng, cái tốt đẹp, cái thuỷ chung”. Người ta tìm đến văn chương để khám phá những điều tốt đẹp. Văn chương lôi cuốn người đọc bởi những điều cao cả, đẹp đẽ, bền bỉ với thời gian." +
                "sdfsadfsafsdfsafdgdfgmdlnlmdfgbkdsfngbdsknfgbkdsbfgkdbfgksdfbgkdfbgksndbgkdnfngkdsfngmdng,m" +
                "Đúng như Tố Hữu từng nói: “Văn học thực chất là cuộc đời. Văn học sẽ không là gì cả nếu không vì cuộc đời mà có. Cuộc đời là nơi xuất phát và cũng là nơi đi tới của văn học”. Đặc trưng của văn học cũng như các bộ môn nghệ thuật khác là phản ánh hiện thực. Văn học tái hiện cuộc đời trên trang viết, nhưng cuộc sống đâu chỉ có những bông hoa mà còn có cả những hàng rào dây thép, xung quanh ta đâu chỉ tồn tại cái lương thiện, tốt đẹp mà còn có cả đau đớn, xấu xa. Vì thế mà Nguyễn Khải khẳng định văn chương không từ chối hay né tránh “cái xấu xa, cái ghê tởm, cái hèn nhát”. Văn chương không thể không miêu tả khi cái xấu, cái ác vẫn hiện hữu trong cuộc sống con người. Tác phẩm phải mang hơi thở cuộc đời với bao thật giả, trắng đen còn trộn lẫn, cả niềm vui, hạnh phúc và cả nỗi buồn, sự đắng cay. Cái tốt và cái xấu đan xen, cái được và cái mất tồn tại cạnh nhau, gắn chặt với nhau, vì vậy nếu chỉ nói cái tốt là chỉ mới nói một phần sự thật. Văn chương chân chính phải phản ánh được trọn vẹn, sâu sắc đời sống, kể cả màu tối lẫn mảng sáng. Sự tức giận khi chứng kiến lòng tự trọng, công lí, tình yêu và cái đẹp bị xúc phạm nhiều khi thúc đẩy người ta cầm bút không kém gì cảm hứng về chính nghĩa và cái đẹp. Vậy, văn chương hoàn toàn “có quyền miêu tả cái xấu xa, cái ghê tởm, cái hèn nhát” bởi cái xấu cũng là một phần hiện thực." +
                "dsgdfgdskgnalnfglgnlsdjgnsdpkfnga;lkfnglsdfnglsjfgnsldfjgnsdofgjndofjg" +
                "Nhưng “Tác phẩm nghệ thuật sẽ chết nếu nó miêu tả cuộc sống chỉ để miêu tả” (Belinsky). Văn chương sẽ “chết yểu” nếu phản ánh chỉ đơn thuần để phản ánh mà thôi. Giữa cuộc sống thiện ác lẫn lộn, tốt xấu giao tranh, nhiệm vụ của văn học là miêu tả cái xấu để người ta nhận diện từ đó mạnh mẽ chống lại nó. Văn học miêu tả cái xấu để thể hiện khát vọng hướng tâm hồn con người về cái đẹp, cái thiện của nhà văn. Muốn “ý nghĩa thực sự của văn học là nhân đạo hóa con người”, trước tiên văn học cần giúp con người nhận thức cái xấu trước đã. Vốn dĩ cái đẹp thì mong manh, dễ vỡ, lòng tốt thì vụng dại, ngây thơ, còn cái ác lại thì dạn dĩ, nham hiểm, cái đểu cáng thì liều lĩnh, xảo quyệt. Không những thế, sức tàn phá của cái xấu lại lớn hơn gấp trăm lần sức mạnh của cái đẹp. Nhà văn nói thật, nói sâu về cái xấu, cái ác bởi bằng cách đó văn chương hỗ trợ cho cuộc đấu tranh không cân sức giữa thiện và ác muôn đời.  Văn học “được quyền miêu tả cái xấu xa, cái ghê tởm, cái hèn nhát” để giúp con người nhận thức và ngăn chặn cái xấu, cái ác. Khi cảm nhận cái xấu, con người nên cao hơn cả cái xấu và hướng tới cái tốt, cái đẹp. Nghệ thuật phán xét cái xấu một cách đúng đắn chính là “bông hoa của văn minh, rau quả của tinh thần xã hội phát triển” (Belinsky). Tiếp xúc với cái xấu trong nghệ thuật, con người trở nên từng trải hơn, hiểu sâu sắc hơn về cái xấu cũng như tập đối mặt với sức mạnh của cái ác. Vậy là bằng cách phản ánh “cái xấu xa, cái ghê tởm, cái hèn nhát”, văn chương đã thực hiện nhiệm vụ “nâng cao tinh thần ta lên” (Napoluye)" +
                "gdfkngdslkfngdsljfngsldjgndslkjfgndljkkfgnksldjfgbksdbgksdhgbdfhgb" +
                "Cũng như Nguyễn Khuyến, Cao Bá Quát,… Tú Xương lên tiếng giễu cợt, đả kích gay gắt bọn giặc Tây và bè lũ tay sai gian ác. Ông lên án những chuyện xấu xa của thời buổi Tây Tàu lố lăng, đặc biệt là vấn nạn khoa cử. Không còn nữa hình ảnh trang trọng, “hài văn lần bước dặm xanh” (“Truyện Kiều”) của sĩ tử ngày nào, cũng không thấy đâu không khí trang nghiêm chốn trường thi thuở trước. Trong “Vịnh khoa thi hương”, Tú Xương chỉ thấy một bức tranh nhốn nháo, “ghê tởm” như những trò hề không hơn không kém:\n" +
                "dfgsdkfgjdsfklgnsdgfjnhdfogsndgojsdnfgljdsngsljkdngldjnglsjdngldsjgndslkjgnlsojgnolgnaojbgiajhbgf" +
                "“Lôi thôi sĩ tử vai đeo lọ," +
                "Ậm ọe quan trường miệng thét loa." +
                "Lọng cắm rợp trời quan sứ đến," +
                "Váy lê quét đất mụ đầm ra.”" +
                "gsdfkgndslfjgnsdfljgnlkfngs;odfgjnop;fnao;gfnsofjgnafgjosdbghskdbg" +
                "Tú Xương chua chát trước cảnh sĩ tử “lôi thôi”, quan trường “ậm ọe” – hình ảnh đại diện cho Hán học trở nên nhếch nhác chưa từng thấy. Trong khi đó quan sứ lại xuất hiện với một sự long trọng quá thể: “lọng cắm rợp trời”, “váy lê quét đất” hoành tráng, áp đảo cả nhân vật chính - sĩ tử. Trường thi vốn là nơi nghiêm túc, hiên ngang nhưng chỉ còn những điều xấu xa, nhục nhã. Vai chính trong vở tuồng thi cử lại dành cho kẻ xấu, cái ác - quan lại, bọn tay sai thực dân Pháp. Ẩn sâu thực trạng đáng hổ thẹn ấy chính là tiếng lòng cay đắng của nhà thơ trước cảnh nhiễu nhương Tây Tàu. Sự cay đắng ấy cũng là khao khát của nhà thơ yêu nước tha thiết về độc lập và bình yên của đất nước. Phản ánh cái xấu xa trong hiện thực thời đó, Tú Xương không chỉ giúp ta nhận diện cái xấu, cái ác mà còn khơi gợi lòng yêu nước trong lòng người đọc, giúp ta biết đứng lên chống lại cái xấu, cái bất nhân.\n" +
                "dfgsdfgkpanfg[pgoknsfgojwngjiongjkdfhbsljfgnaogfngjsndgsljkdngskjgnskjdbgsdbgd" +
                "Không chỉ Tú Xương “có quyền miêu tả cái xấu xa, cái ghê tởm, cái hèn nhát” mà Chekhov cũng không ngần ngại chỉ ra căn bệnh tinh thần của thời đại ông mang tên “Người trong bao”. Belikov có một nếp sống thật lạ kì, “con người này có khát vọng mãnh liệt thu mình vào trong một cái vỏ, tạo cho mình một thứ bao có thể ngăn cách, bảo vệ hắn khỏi những ảnh hưởng bên ngoài”. Hoá ra, con người ấy sợ “nhỡ lại xảy ra chuyện gì”, ý nghĩ này lặp lại đến năm lần. Đó là cách sống “hèn nhát”: luôn trốn tránh, sống trong sợ hãi gây nên sự ngột ngạt cho những người xung quanh. Tâm lí nô lệ, bạc nhược, tự ti, cái lối sống không đúng đắn ấy là hình ảnh cuộc sống công chức Nga cuối thế kỉ XIX, một lối sống thảm hại, bạc nhược, khiếp sợ trước cường quyền. Bằng cách phản ánh cái “hèn nhát” của Belikov, của căn bệnh sống “trong bao”, Chekhov cất lên tiếng chuông cần thay đổi, “Không thể sống mãi như thế được!”. Để vượt qua được tâm lí đó, chữa khỏi căn bệnh “trong bao”, người dân rất cần thay đổi, cần có một lối sống khác. Người thực hiện hiệu quả nhất chính là những con người dũng cảm đứng ra chữa trị căn bệnh tinh thần của thế hệ mình và phải cùng nhau xây dựng một chế độ tốt đẹp. Can đảm viết về căn bệnh thời đại mình, Chekhov giúp độc giả ý thức “cái hèn nhát”, qua đó gợi suy ngẫm về con đường tiêu diệt căn bệnh này." +
                "dsfgskdnfga;slkdfnga;lkgna;lgknofgjnrothnsdjlnglkdnga;lk;angojngsdfgdfg" +
                "Nguyễn Khải thừa nhận quyền được miêu tả cái xấu của văn chương, nhưng như vậy là chỉ phản ánh một mặt đời sống. Văn chương chân chính “không chỉ miêu tả cái xấu xa, cái ghê tởm, cái hèn nhát. Thanh nam châm thu hút mọi thế hệ vẫn là cái cao thượng, cái tốt đẹp, cái thuỷ chung”. Con người luôn có nhu cầu cảm thụ, thưởng thức cái đẹp cũng con người luôn muốn cuộc sống đẹp hơn. Văn học có khả năng phát hiện và miêu tả những vẻ đẹp của cuộc sống toàn diện và sâu sắc hơn. Thông qua đó, tác phẩm giúp bạn đọc không chỉ cảm nhận được mà còn biết rung động trước những vẻ đẹp đó. Bởi nhu cầu thỏa mãn thẩm mĩ, khơi dậy những khoái cảm nghệ thuật nơi người đọc nên giá trị thẩm mỹ trở thành mục tiêu của nghệ thuật, “Văn học, đó là tư tưởng đi tìm cái đẹp trong ánh sáng” (Charles Dubos). Những tình điệu thẩm mỹ trong văn học mang bóng dáng vẻ đẹp muôn hình muôn vẻ của cuộc đời: vẻ đẹp trong thiên nhiên, cảnh vật, vẻ đẹp của những cảnh đời, vẻ đẹp văn hoá, phong tục ... Cái đẹp Nguyễn Khải muốn nhấn mạnh là “cái cao thượng, cái tốt đẹp, cái thuỷ chung” - vẻ đẹp tư tưởng, tình cảm của thế giới nội tâm con người. Bên cạnh đó, soi chiếu dưới góc độ người cầm bút, những nghệ sĩ chân chính viết nên những tác phẩm khẳng định tư tưởng tiến bộ, nhằm phục vụ điều thiện và chính nghĩa. Bởi “Niềm vui của nhà văn chân chính là được làm người dẫn đường đến xứ sở của cái đẹp” (Paustovsky)." +
                "dfgsdfkgnaopwpgjnisrutgnljwnojengojnfdljgndlgjnsgjndgjdsngkjsdng" +
                "Bên cạnh thỏa mãn nhu cầu về cái đẹp, văn học cũng là nơi bồi dưỡng cảm xúc, thẩm mĩ của con người, nó giúp người đọc có thị hiếu thẩm mĩ lành mạnh, tinh tế. “Tác phẩm văn học lớn hấp dẫn người ta bởi cách nhìn nhận mới, tình cảm mới về những điều, những việc mà ai cũng biết cả rồi” (Nguyễn Đình Thi) nên mỗi nhà văn chân chính bao giờ cũng mang đến cho văn học một “cách nhìn nhận mới, tình cảm mới” của vẻ đẹp của đời sống. Cho nên, văn học bồi đắp kinh nghiệm thẩm mỹ chúng ta thêm sâu sắc, phong phú. Kinh nghiệm ấy giúp con người không chỉ biết nhận ra cái hay, cái đẹp trong tác phẩm mà còn biết tự khám phá ra cái đẹp của thế giới, đời sống tâm hồn độc giả thêm giàu có. Văn chương là nơi nuôi dưỡng những cảm xúc đẹp của con người, khơi dậy và tiếp sức cho những rung động về cái đẹp. Chính cái đẹp tiếp lửa cho sức mạnh tâm hồn con người luôn nhạy cảm, mới mẻ với vẻ đẹp muôn màu muôn vẻ của đời sống. Vì vậy mà trái tim con người không thể dửng dưng, thờ ơ, nguội lạnh với số phận con người. Bằng cách khiến người đọc rung động trước cái đẹp, văn học làm lòng người phong phú hơn, đó cũng là lí do vì sao Dostoevsky khẳng định: “Cái đẹp sẽ cứu rỗi thế giới”.\n" +
                "dfgdsfgkm[ưmgo;sntgot;rjtungsldjgns;dlkfgns;lgknsdl;fgknsdlgjndfljgnsdjfgnsgs" +
                "Với Thạch Lam: “Công việc của nhà văn là phát hiện cái đẹp chính ở chỗ mà không ai ngờ, tìm cái đẹp kín đáo che lấp của sự vật, cho người khác một bài học về trông nhìn thưởng thức”. Giữa cảnh phố huyện nghèo nàn và những kiếp người cùng khổ trong “Hai đứa trẻ”, ông đã “phát hiện cái đẹp chính ở chỗ mà không ai ngờ”, chính là vẻ đẹp ánh lên từ tâm hồn Liên, ánh lên từ lòng trắc ẩn và niềm hy vọng của chị. Liên chăm chú quan sát những đứa trẻ nhà nghèo, “trông thấy động lòng thương nhưng chính chị cũng không có tiền để mà cho chúng nó”. Liên dù muốn cụ Thi chóng đi nhưng vẫn rót cho cụ đầy cút rượu. Liên quan tâm đến thời gian chị Tí thường dọn hàng, Liên để mắt đến vợ chồng bác xẩm. Dẫu chính mình vẫn đang ngụp lặn trong cái ao đời phẳng lặng, Liên vẫn dành sự quan tâm, yêu thương, chia sẻ với những người nơi phố huyện. Đó là cái đẹp vừa của một lòng trắc ẩn đã biết nghĩ, vừa chân thành của một đứa trẻ vẫn chưa hết thơ ngây. Không những thế, vẻ đẹp tâm hồn Liên còn thể hiện bằng niềm tin, niềm hy vọng không tắt giữa bóng tối phố huyện nghèo. Ánh mắt chị luôn luôn hướng về ánh sáng, tâm hồn chị hướng về Hà Nội xa xăm. Đôi mắt Liên bắt lấy ánh sáng, từ khe sáng, hột sáng đến vùng sáng, quầng sáng. Đó là niềm tin về tương lai của một đứa trẻ chưa bị cái quẩn quanh của đời sống làm mờ đi, cũng là một tâm hồn từng được vui, được hạnh phúc. Liên và An vẫn biết tìm vui, vẫn nuôi hy vọng về “Hà Nội sáng rực, vui vẻ và huyên náo”. Bóng tối phố huyện đâu thể nhấn chìm niềm vui và động lực sống của Liên, khi chị đang cố thoát khỏi kiếm đời u ám để hướng về bầu trời mộng tưởng, hướng về quá khứ đã từng hạnh phúc. Đọc “Hai đứa trẻ”, ta thêm yêu và thêm tin vào vẻ đẹp tâm hồn con người, dẫu khuất lấp sau bóng tối nhưng chưa bao giờ tàn lụi." +
                "dfgdsfk;gmsdf;gkpnsd;fgfnwp;gnklotgujnrohujnjsglknhljdsng;dlagnadlgjndflgjdsnfgljsdfngl;sdjgndsljfgn" +
                "Nếu trang văn Thạch Lam “thu hút mọi thế hệ” bởi tấm lòng tốt đẹp của Liên, thì “thanh nam châm” của “Những người khốn khổ” là vẻ đẹp từ lòng nhân ái của Jean Valjean. Cũng là một con người khốn khổ, phải chịu bao đau đớn tù đày nhưng Jean Valjean lại có một trái tim nhân hậu và tinh tế. Không muốn Fantine đau đớn khi biết mình bị bắt, Jean Valjean nhún nhường cầu xin Javert bằng những lời lẽ vòng vo: “Tôi biết là anh muốn gì rồi”, “Tôi cầu xin ông một điều”. Đến khi Fantine ra đi, “Trong nét mặt và dáng điệu ông chỉ thấy một nỗi thương xót khôn tả”. Ông thương xót một kiếp người bất hạnh đã ra đi mãi mãi hay cũng chính là đang thương xót cho kiếp người “bị ruồng bỏ” của mình ? “Như một người mẹ sửa sang cho con”, ông trân trọng nâng đầu Fantine, thắt lại dây rút cổ áo chị, vén tóc và vuốt mắt chị. Vẻ đẹp thu hút cũng như làm xúc động người đọc chính là lòng tốt đáng trân trọng của Jean Valjean, lòng tốt đến từ những người cùng khổ. Đọc “Những người khốn khổ”, ta được đánh thức từ tình cảm tốt đẹp ấy, từ đó biết yêu thêm mọi người xung quanh, lan\n" +
                "fdgdsfknga;lgns;dlfgnds;lkgnsd;fpignsw;ôngurbgdjhbgjfdgnalkdnfg;lskfm;aksdfm;áklngfokjfngdjfogndf" +
                "“Thơ là sự thể hiện con người và thời đại một cách cao đẹp.” (Sóng Hồng). Và cũng chính cái “cao đẹp” ấy đã lôi cuốn, níu giữ tâm hồn người đọc. Thi phẩm “Tôi yêu em” (Puskin) tạo cơ hội cho độc giả gặp gỡ tình yêu chân thành, đằm thắm và cao thượng:\n" +
                "dfgsdfkngws[pkgnwpoehgnoghnsdoigjakfapofkpinfgosdfgbjsongpakfjgmnkpdngosenfdgdfg" +
                "“Tôi yêu em, yêu chân thành, đằm thắm," +
                "Cầu em được người tình như tôi đã yêu em”" +
                "dfgdgipjsdpfgijpwoihtouhyokgnds;fgm;sdlkfgnd;lkgnd;lkfngdslknfg;songaonflajsnflfnasldfn" +
                "Điệp khúc “tôi yêu em” khẳng định bản chất mối tình này là “chân thành, đằm thắm”. Trong nguyên bản tiếng Nga, động từ “yêu” được để ở thể chưa hoàn thành, cũng có nghĩa là tình yêu của “tôi” sẽ không bao giờ tắt, không bao giờ nhạt phai. Đó cũng chính là cái gốc của tấm lòng cao thượng trong tình yêu này. Từ xưa đến nay, tâm lí thông thường trong tình yêu là:" +
                "sfgdsfgksdpnfgs;dnfkgjlsdnglsdnglsjdngsljdngdsljngljngsljdfng;sldgnjsd" +
                "“Yêu nhau thì ném bã trầu," +
                "Ghét nhau ném đá vỡ đầu nhau ra”" +
                "fgsdgknsdfpgonseopgnja;knaspkfaptinhtobnogjnfdgolnflkdnsfadsfhghf" +
                "(Ca dao)" +
                "sgkfdngdljgnsdlkgna;lkfnsad;lkfnmsd;lkfn;ljgnodjhbdsojgnfgnalkfnaldkfnlkdnfalnfojenjgnkjbgbgsdbgjnfadjfqnopj" +
                "Tình yêu một khi không được đền đáp sẽ mang đến khổ đau, nếu là một người ích kỉ thì có thể sinh ra hận thù. Nhưng trong “Tôi yêu em” lại là tình yêu của một trái tim chân thật, dù đã bị cự tuyệt giữ sự cao thượng: cầu cho em được hạnh phúc. Chính có tinh thần cao thượng trong tình yêu là vẻ đẹp hấp dẫn bạn đọc, một vẻ đẹp rất mới mẻ. Đây là minh chứng nhân cách cao thượng của Puskin, đồng thời là tinh hoa của nền văn học Nga, một nền văn học nhân đạo và lí tưởng. Quả thật, “Thơ ca làm cho tất cả những gì tốt đẹp nhất trên đời trở thành bất tử.” (Shelly). Văn chương vừa bất tử hoá giá trị thẩm mỹ, và cũng chính giá trị thẩm mỹ làm văn chương vượt ra khỏi quy luật cái chết." +
                "dsgfksngsljdfnakmfkqowfnoerugndfjgna;lkfnsdl;kfnadlvnvja;alfjnoufbugbdfgfgadff" +
                "Để “cái cao thượng, cái tốt đẹp, cái thuỷ chung” có thể trở thành “thanh nam châm thu hút mọi thế hệ”, nhà văn phải “lấy ngôn ngữ làm cứu cánh” (Jakobson). Cái đẹp, cái thiện có bừng sáng đến đâu mà chỉ truyền tải bằng những con chữ cứng đơ trên trang giấy, liệu cái đẹp, cái thiện có thắp lên lửa trong lòng người đọc ? Chế Lan Viên từng viết: “Đi tìm cái thiện, cái chân nhưng phải biểu hiện ra bằng hình thức đẹp”. Điều độc giả bao đời tìm kiếm trong văn chương đâu chỉ là cái đẹp nội dung mà còn là cái đẹp về hình thức, vẻ đẹp lấp lánh của ngôn từ. Bên cạnh đó, cái đẹp trong nghệ thuật mang tính hoàn thiện: “Ðến như văn thơ, thì lại là sắc đẹp ngoài cả sắc đẹp, vị ngon ngoài cả vị ngon, không thể dùng mắt tầm thường mà xem, miệng tầm thường mà nếm được” (Hoàng Đức Lương). Điều này thúc đẩy người đọc phải có tri thức và tâm hồn sâu sắc, nhạy cảm trước cái đẹp. Có thế cái đẹp mới chạm đến phần sâu nhất của tấm lòng người đọc." +
                "fgdsfkgna;fkandfljqnorutbgbfakjgbnbkv janfklasnflaksnfaslnfouabfbasjgndfgsdfgsd" +
                "Nguyên Ngọc từng viết: “Đã là văn chương thì phải đẹp, đẹp là chức năng hàng đầu, là đạo đức của văn chương”. Nhận định khẳng định một trong những yếu tố hàng đầu của văn chương là cái đẹp. Đồng nghĩa với việc “Văn chương có quyền nhưng không chỉ miêu tả cái xấu xa, cái ghê tởm, cái hèn nhát. Thanh nam châm thu hút mọi thế hệ vẫn là cái cao thượng, cái tốt đẹp, cái thuỷ chung” (Nguyễn Khải). Với tôi, viết về cái đẹp hay cái xấu, miêu tả cái thiện hay cái ác, suy cho cùng mục đích của văn chương vẫn là làm sao cho cuộc sống con người tốt đẹp hơn, hướng con người đến bến bờ chân - thiện - mỹ. Viết về cái đẹp để tôn vinh chúng, hay viết về cái xấu để ca ngợi cái đẹp đều cùng một đích đến, chính là “làm cho người gần người hơn" + "(Nam Cao)" +
                "sdfaksdfnaso;djgntoeeuroqunbiqwhbriwernjsdkfnsjkdfnsadlfjnsdjflnskjlfnasljdfnasdf" +
                "NGUYỄN TRẦN PHƯƠNG NGHI" +
                "sdfsdflasjdkfnlasjdfnajodboqfubtroubteiwhgrbihbfgjsfnasljdfnasljfnasljfndfjlasdfdasdf" +
                "HỌC SINH LỚP 11CV TRƯỜNG THTH ĐHSP TPHCM" +
                "sdfasfjasljfnsaofjnsfouansfoasnfsjonfasfjnasljfnalsjfnasldjfbalifhgbaljfnsldojfnasiljfnakjsnfasjdbfiehbgfeerihygbabnskjfbsnkfhbasdjfhasjhfbsah" +
                "NIÊN KHÓA 2020-2023");
        category.setId(4L);
        category.setName("Phương tiện");
        productDTOTaiLM.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/product/register")
                        .content(this.objectMapper.writeValueAsString(productDTOTaiLM))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
