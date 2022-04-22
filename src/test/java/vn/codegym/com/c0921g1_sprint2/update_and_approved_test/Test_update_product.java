package vn.codegym.com.c0921g1_sprint2.update_and_approved_test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import vn.codegym.com.c0921g1_sprint2.dto.ProductDto;
import vn.codegym.com.c0921g1_sprint2.model.Category;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
public class Test_update_product {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @Test
    //test null -------------------------------------------------------------------------->
    // test name null
    public  void edit_13_name_null() throws  Exception{
        ProductDto productDto = new ProductDto();
        productDto.setName(null);
        productDto.setStartBid((long) 15000000);
        productDto.setBidRange((long) 100000);
        productDto.setFinalBid((long) 20000000);
        productDto.setImageUrl("https://cdn01.dienmaycholon.vn/filewebdmclnew/DMCL21/Picture//Apro/Apro_product_26361/may-rua-chen-53_multi_0_37_1020.png.webp");
        productDto.setStartDate("2022-05-23 08:00:00");
        productDto.setEndDate("2022-05-25 08:00:00");
        productDto.setApprovedStatus(1);
        productDto.setDescription("chưa có");
        productDto.setPaymentStatus(1);
        productDto.setTimeRemaining("36:00:00");
        productDto.setProductAddress("chưa thêm địa chỉ");

        Category category = new Category();
        productDto.setId((long) 1);
        productDto.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/film/createFilm")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    // test startBid null
    public  void edit_13_setStartBid_null() throws  Exception{
        ProductDto productDto = new ProductDto();
        productDto.setName("Galaxy Note 20 Ultra");
        productDto.setStartBid(null);
        productDto.setBidRange((long) 100000);
        productDto.setFinalBid((long) 20000000);
        productDto.setImageUrl("https://cdn01.dienmaycholon.vn/filewebdmclnew/DMCL21/Picture//Apro/Apro_product_26361/may-rua-chen-53_multi_0_37_1020.png.webp");
        productDto.setStartDate("2022-05-23 08:00:00");
        productDto.setEndDate("2022-05-25 08:00:00");
        productDto.setApprovedStatus(1);
        productDto.setDescription("chưa có");
        productDto.setPaymentStatus(1);
        productDto.setTimeRemaining("36:00:00");
        productDto.setProductAddress("chưa thêm địa chỉ");

        Category category = new Category();
        productDto.setId((long) 1);
        productDto.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/film/createFilm")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    // test bidRange null
    public  void edit_13_BidRange_null() throws  Exception{
        ProductDto productDto = new ProductDto();
        productDto.setName("Galaxy Note 20 Ultra");
        productDto.setStartBid((long) 15000000);
        productDto.setBidRange(null);
        productDto.setFinalBid((long) 20000000);
        productDto.setImageUrl("https://cdn01.dienmaycholon.vn/filewebdmclnew/DMCL21/Picture//Apro/Apro_product_26361/may-rua-chen-53_multi_0_37_1020.png.webp");
        productDto.setStartDate("2022-05-23 08:00:00");
        productDto.setEndDate("2022-05-25 08:00:00");
        productDto.setApprovedStatus(1);
        productDto.setDescription("chưa có");
        productDto.setPaymentStatus(1);
        productDto.setTimeRemaining("36:00:00");
        productDto.setProductAddress("chưa thêm địa chỉ");

        Category category = new Category();
        productDto.setId((long) 1);
        productDto.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/film/createFilm")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    // test finalBid null
    public  void edit_13_finalBid_null() throws  Exception{
        ProductDto productDto = new ProductDto();
        productDto.setName("Galaxy Note 20 Ultra");
        productDto.setStartBid((long) 15000000);
        productDto.setBidRange((long) 100000);
        productDto.setFinalBid(null);
        productDto.setImageUrl("https://cdn01.dienmaycholon.vn/filewebdmclnew/DMCL21/Picture//Apro/Apro_product_26361/may-rua-chen-53_multi_0_37_1020.png.webp");
        productDto.setStartDate("2022-05-23 08:00:00");
        productDto.setEndDate("2022-05-25 08:00:00");
        productDto.setApprovedStatus(1);
        productDto.setDescription("chưa có");
        productDto.setPaymentStatus(1);
        productDto.setTimeRemaining("36:00:00");
        productDto.setProductAddress("chưa thêm địa chỉ");

        Category category = new Category();
        productDto.setId((long) 1);
        productDto.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/film/createFilm")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    // test imageUrl null
    public  void edit_13_imageUrl_null() throws  Exception{
        ProductDto productDto = new ProductDto();
        productDto.setName("Galaxy Note 20 Ultra");
        productDto.setStartBid((long) 15000000);
        productDto.setBidRange((long) 100000);
        productDto.setFinalBid((long) 20000000);
        productDto.setImageUrl(null);
        productDto.setStartDate("2022-05-23 08:00:00");
        productDto.setEndDate("2022-05-25 08:00:00");
        productDto.setApprovedStatus(1);
        productDto.setDescription("chưa có");
        productDto.setPaymentStatus(1);
        productDto.setTimeRemaining("36:00:00");
        productDto.setProductAddress("chưa thêm địa chỉ");

        Category category = new Category();
        productDto.setId((long) 1);
        productDto.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/film/createFilm")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    // test startDate null
    public  void edit_13_startDate_null() throws  Exception{
        ProductDto productDto = new ProductDto();
        productDto.setName("Galaxy Note 20 Ultra");
        productDto.setStartBid((long) 15000000);
        productDto.setBidRange((long) 100000);
        productDto.setFinalBid((long) 20000000);
        productDto.setImageUrl("https://cdn01.dienmaycholon.vn/filewebdmclnew/DMCL21/Picture//Apro/Apro_product_26361/may-rua-chen-53_multi_0_37_1020.png.webp");
        productDto.setStartDate(null);
        productDto.setEndDate("2022-05-25 08:00:00");
        productDto.setApprovedStatus(1);
        productDto.setDescription("chưa có");
        productDto.setPaymentStatus(1);
        productDto.setTimeRemaining("36:00:00");
        productDto.setProductAddress("chưa thêm địa chỉ");

        Category category = new Category();
        productDto.setId((long) 1);
        productDto.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/film/createFilm")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    // test startDate null
    public  void edit_13_endDate_null() throws  Exception{
        ProductDto productDto = new ProductDto();
        productDto.setName("Galaxy Note 20 Ultra");
        productDto.setStartBid((long) 15000000);
        productDto.setBidRange((long) 100000);
        productDto.setFinalBid((long) 20000000);
        productDto.setImageUrl("https://cdn01.dienmaycholon.vn/filewebdmclnew/DMCL21/Picture//Apro/Apro_product_26361/may-rua-chen-53_multi_0_37_1020.png.webp");
        productDto.setStartDate("2022-05-25 08:00:00");
        productDto.setEndDate(null);
        productDto.setApprovedStatus(1);
        productDto.setDescription("chưa có");
        productDto.setPaymentStatus(1);
        productDto.setTimeRemaining("36:00:00");
        productDto.setProductAddress("chưa thêm địa chỉ");

        Category category = new Category();
        productDto.setId((long) 1);
        productDto.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/film/createFilm")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    //test rong -------------------------------------------------------------------------->
    @Test
    // test name null
    public  void edit_14_name_rong() throws  Exception{
        ProductDto productDto = new ProductDto();
        productDto.setName("");
        productDto.setStartBid((long) 15000000);
        productDto.setBidRange((long) 100000);
        productDto.setFinalBid((long) 20000000);
        productDto.setImageUrl("https://cdn01.dienmaycholon.vn/filewebdmclnew/DMCL21/Picture//Apro/Apro_product_26361/may-rua-chen-53_multi_0_37_1020.png.webp");
        productDto.setStartDate("2022-05-23 08:00:00");
        productDto.setEndDate("2022-05-25 08:00:00");
        productDto.setApprovedStatus(1);
        productDto.setDescription("chưa có");
        productDto.setPaymentStatus(1);
        productDto.setTimeRemaining("36:00:00");
        productDto.setProductAddress("chưa thêm địa chỉ");

        Category category = new Category();
        productDto.setId((long) 1);
        productDto.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/film/createFilm")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    // test imageUrl rong
    public  void edit_14_imageUrl_rong() throws  Exception{
        ProductDto productDto = new ProductDto();
        productDto.setName("Galaxy Note 20 Ultra");
        productDto.setStartBid((long) 15000000);
        productDto.setBidRange((long) 100000);
        productDto.setFinalBid((long) 20000000);
        productDto.setImageUrl("");
        productDto.setStartDate("2022-05-23 08:00:00");
        productDto.setEndDate("2022-05-25 08:00:00");
        productDto.setApprovedStatus(1);
        productDto.setDescription("chưa có");
        productDto.setPaymentStatus(1);
        productDto.setTimeRemaining("36:00:00");
        productDto.setProductAddress("chưa thêm địa chỉ");

        Category category = new Category();
        productDto.setId((long) 1);
        productDto.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/film/createFilm")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    // test startDate rong
    public  void edit_14_startDate_rong() throws  Exception{
        ProductDto productDto = new ProductDto();
        productDto.setName("Galaxy Note 20 Ultra");
        productDto.setStartBid((long) 15000000);
        productDto.setBidRange((long) 100000);
        productDto.setFinalBid((long) 20000000);
        productDto.setImageUrl("https://cdn01.dienmaycholon.vn/filewebdmclnew/DMCL21/Picture//Apro/Apro_product_26361/may-rua-chen-53_multi_0_37_1020.png.webp");
        productDto.setStartDate("");
        productDto.setEndDate("2022-05-25 08:00:00");
        productDto.setApprovedStatus(1);
        productDto.setDescription("chưa có");
        productDto.setPaymentStatus(1);
        productDto.setTimeRemaining("36:00:00");
        productDto.setProductAddress("chưa thêm địa chỉ");

        Category category = new Category();
        productDto.setId((long) 1);
        productDto.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/film/createFilm")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    // test startDate rong
    public  void edit_14_endDate_rong() throws  Exception{
        ProductDto productDto = new ProductDto();
        productDto.setName("Galaxy Note 20 Ultra");
        productDto.setStartBid((long) 15000000);
        productDto.setBidRange((long) 100000);
        productDto.setFinalBid((long) 20000000);
        productDto.setImageUrl("https://cdn01.dienmaycholon.vn/filewebdmclnew/DMCL21/Picture//Apro/Apro_product_26361/may-rua-chen-53_multi_0_37_1020.png.webp");
        productDto.setStartDate("2022-05-25 08:00:00");
        productDto.setEndDate("");
        productDto.setApprovedStatus(1);
        productDto.setDescription("chưa có");
        productDto.setPaymentStatus(1);
        productDto.setTimeRemaining("36:00:00");
        productDto.setProductAddress("chưa thêm địa chỉ");

        Category category = new Category();
        productDto.setId((long) 1);
        productDto.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/film/createFilm")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //test format -------------------------------------------------------------------------->
    @Test
    // test approvedStatus sai format
    public  void edit_16_approvedStatus() throws  Exception{
        ProductDto productDto = new ProductDto();
        productDto.setName("Galaxy Note 20 Ultra");
        productDto.setStartBid((long) 15000000);
        productDto.setBidRange((long) 100000);
        productDto.setFinalBid((long) 20000000);
        productDto.setImageUrl("https://cdn01.dienmaycholon.vn/filewebdmclnew/DMCL21/Picture//Apro/Apro_product_26361/may-rua-chen-53_multi_0_37_1020.png.webp");
        productDto.setStartDate("2022-05-25 08:00:00");
        productDto.setEndDate("2022-05-25 08:00:00");
        productDto.setApprovedStatus(2);
        productDto.setDescription("chưa có");
        productDto.setPaymentStatus(1);
        productDto.setTimeRemaining("36:00:00");
        productDto.setProductAddress("chưa thêm địa chỉ");

        Category category = new Category();
        productDto.setId((long) 1);
        productDto.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/film/createFilm")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //test min length -------------------------------------------------------------------------->
    @Test
    // test image sai Min length
    public  void edit_17_imageUrl_min() throws  Exception{
        ProductDto productDto = new ProductDto();
        productDto.setName("Galaxy Note 20 Ultra");
        productDto.setStartBid((long) 45000);
        productDto.setBidRange((long) 100000);
        productDto.setFinalBid((long) 20000000);
        productDto.setImageUrl("http");
        productDto.setStartDate("2022-05-25 08:00:00");
        productDto.setEndDate("2022-05-25 08:00:00");
        productDto.setApprovedStatus(2);
        productDto.setDescription("chưa có");
        productDto.setPaymentStatus(1);
        productDto.setTimeRemaining("36:00:00");
        productDto.setProductAddress("chưa thêm địa chỉ");

        Category category = new Category();
        productDto.setId((long) 1);
        productDto.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/film/createFilm")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    //test min length -------------------------------------------------------------------------->
    @Test
    // test imageUrl sai Max length
    public  void edit_17_imageUrl_max() throws  Exception{
        ProductDto productDto = new ProductDto();
        productDto.setName("Galaxy Note 20 Ultra");
        productDto.setStartBid((long) 15000000);
        productDto.setBidRange((long) 100000);
        productDto.setFinalBid((long) 20000000);
        productDto.setImageUrl("Nguyễn Đức Lam Thảo, sinh viên ngành Văn học, Trường ĐH Khoa học Xã hội & Nhân văn, ĐH Quốc gia TP.HCM.\n" +
                "\n" +
                "Sau hơn 5 năm hoạt động, hiện Blog Chuyên Văn đã đạt đến con số hơn 110.000 lượt theo dõi. Thảo cho biết, đội ngũ Blog Chuyên Văn rất mong muốn fanpage sẽ là nơi kết nối, lan tỏa niềm đam mê và truyền cảm hứng cho các bạn học sinh, sinh viên yêu văn chương.\n" +
                "\n" +
                "Không dừng lại ở những nội dung về kiến thức, Blog còn chú trọng đến việc chia sẻ về phương pháp dạy và học nhằm “góp phần kiến tạo nên giờ văn hạnh phúc”.\n" +
                "\n" +
                "“Có một số hiểu lầm rằng Blog Chuyên Văn chỉ dành cho giáo viên, học sinh chuyên Văn, nhưng thật ra đây là một kênh dành cho tất cả mọi người. “Chuyên Văn” chỉ đơn giản là “chuyên viết về Văn”, tức người đọc có thể tìm thấy mọi những nội dung về văn chương khi truy cập vào Blog. Đôi khi, đó là những nội dung có phần học thuật, nhưng cũng có khi, Blog sẽ đăng tải những bài viết, góc nhìn mới lạ về cuộc sống hay giới thiệu những trang sách hay...”, Lam Thảo bày tỏ.\n" +
                "\n" +
                "Đến thời điểm hiện tại, Thảo cho biết, Blog Chuyên Văn vẫn cố gắng chia sẻ thật nhiều thông tin, kinh nghiệm hữu ích cho cả người dạy và học văn. Không chỉ lan tỏa tri thức bằng những bài viết, Blog cũng đang tập trung phát triển kênh Youtube - nơi các thầy cô, các bạn học sinh có thể tiếp cận các bài giảng văn học bằng cả hình ảnh, âm thanh để tăng cao hiệu quả.\n" +
                "\n" +
                "“Mình hy vọng, Blog Chuyên Văn sẽ trở thành một cầu nối giữa những người yêu văn. Và, không chỉ đội ngũ điều hành Blog mới có thể xây dựng nội dung mà bất kỳ ai có khả năng, yêu thích và muốn chia sẻ những kiến thức văn học bổ ích tới cộng đồng đều có thể tìm đến Blog để cùng trao đổi và sẻ chia với mọi người”, Lam Thảo cho biết.\n" +
                "\n" +
                "Phố cũ văn chương\n" +
                "\n" +
                "Phố cũ văn chương là một dự án chia sẻ kiến thức văn học do Hồ Huyền Nga, sinh viên năm thứ Nhất, ngành Truyền thông đại chúng, Học viện Báo chí & Tuyên truyền thực hiện. Từng đoạt giải Nhì trong kỳ thi HSG quốc gia môn Ngữ văn khi còn theo học tại Trường THPT Chuyên Thái Nguyên, Huyền Nga mong muốn có thể chia sẻ và lan tỏa những kiến thức mình đã tiếp thu được trong suốt quãng thời gian đi học tới nhiều người hơn, đồng thời có thể giúp đỡ cho những bạn học sinh có chung niềm đam mê văn chương trong quá trình tìm hiểu môn học này.\n" +
                "\n" +
                "Đầu tháng 2/2021, Phố cũ văn chương chính thức ra đời. Huyền Nga chia sẻ: “Cái tên Phố cũ văn chương đến với mình cũng rất tình cờ. Khi ấy, mình bất chợt nghĩ đến một nơi mà ở đó, con người được sống trong những khoảnh khắc bình yên, thư thái nhất. Và thế là mình nghĩ tới “phố cũ”, mang dáng dấp của những con phố nhỏ nơi mình đang ở. Mình mong khi tìm đến Phố cũ văn chương, các bạn có thể vừa học, vừa chơi, vừa tiếp thu kiến thức vừa thư giãn và tìm lại cảm hứng học tập cho mình, từ đó thêm yêu văn chương hơn nhiều lần”.Nguyễn Đức Lam Thảo, sinh viên ngành Văn học, Trường ĐH Khoa học Xã hội & Nhân văn, ĐH Quốc gia TP.HCM.\n" +
                "\n" +
                "Sau hơn 5 năm hoạt động, hiện Blog Chuyên Văn đã đạt đến con số hơn 110.000 lượt theo dõi. Thảo cho biết, đội ngũ Blog Chuyên Văn rất mong muốn fanpage sẽ là nơi kết nối, lan tỏa niềm đam mê và truyền cảm hứng cho các bạn học sinh, sinh viên yêu văn chương.\n" +
                "\n" +
                "Không dừng lại ở những nội dung về kiến thức, Blog còn chú trọng đến việc chia sẻ về phương pháp dạy và học nhằm “góp phần kiến tạo nên giờ văn hạnh phúc”.\n" +
                "\n" +
                "“Có một số hiểu lầm rằng Blog Chuyên Văn chỉ dành cho giáo viên, học sinh chuyên Văn, nhưng thật ra đây là một kênh dành cho tất cả mọi người. “Chuyên Văn” chỉ đơn giản là “chuyên viết về Văn”, tức người đọc có thể tìm thấy mọi những nội dung về văn chương khi truy cập vào Blog. Đôi khi, đó là những nội dung có phần học thuật, nhưng cũng có khi, Blog sẽ đăng tải những bài viết, góc nhìn mới lạ về cuộc sống hay giới thiệu những trang sách hay...”, Lam Thảo bày tỏ.\n" +
                "\n" +
                "Đến thời điểm hiện tại, Thảo cho biết, Blog Chuyên Văn vẫn cố gắng chia sẻ thật nhiều thông tin, kinh nghiệm hữu ích cho cả người dạy và học văn. Không chỉ lan tỏa tri thức bằng những bài viết, Blog cũng đang tập trung phát triển kênh Youtube - nơi các thầy cô, các bạn học sinh có thể tiếp cận các bài giảng văn học bằng cả hình ảnh, âm thanh để tăng cao hiệu quả.\n" +
                "\n" +
                "“Mình hy vọng, Blog Chuyên Văn sẽ trở thành một cầu nối giữa những người yêu văn. Và, không chỉ đội ngũ điều hành Blog mới có thể xây dựng nội dung mà bất kỳ ai có khả năng, yêu thích và muốn chia sẻ những kiến thức văn học bổ ích tới cộng đồng đều có thể tìm đến Blog để cùng trao đổi và sẻ chia với mọi người”, Lam Thảo cho biết.\n" +
                "\n" +
                "Phố cũ văn chương\n" +
                "\n" +
                "Phố cũ văn chương là một dự án chia sẻ kiến thức văn học do Hồ Huyền Nga, sinh viên năm thứ Nhất, ngành Truyền thông đại chúng, Học viện Báo chí & Tuyên truyền thực hiện. Từng đoạt giải Nhì trong kỳ thi HSG quốc gia môn Ngữ văn khi còn theo học tại Trường THPT Chuyên Thái Nguyên, Huyền Nga mong muốn có thể chia sẻ và lan tỏa những kiến thức mình đã tiếp thu được trong suốt quãng thời gian đi học tới nhiều người hơn, đồng thời có thể giúp đỡ cho những bạn học sinh có chung niềm đam mê văn chương trong quá trình tìm hiểu môn học này.\n" +
                "\n" +
                "Đầu tháng 2/2021, Phố cũ văn chương chính thức ra đời. Huyền Nga chia sẻ: “Cái tên Phố cũ văn chương đến với mình cũng rất tình cờ. Khi ấy, mình bất chợt nghĩ đến một nơi mà ở đó, con người được sống trong những khoảnh khắc bình yên, thư thái nhất. Và thế là mình nghĩ tới “phố cũ”, mang dáng dấp của những con phố nhỏ nơi mình đang ở. Mình mong khi tìm đến Phố cũ văn chương, các bạn có thể vừa học, vừa chơi, vừa tiếp thu kiến thức vừa thư giãn và tìm lại cảm hứng học tập cho mình, từ đó thêm yêu văn chương hơn nhiều lần”.Nguyễn Đức Lam Thảo, sinh viên ngành Văn học, Trường ĐH Khoa học Xã hội & Nhân văn, ĐH Quốc gia TP.HCM.\n" +
                "\n" +
                "Sau hơn 5 năm hoạt động, hiện Blog Chuyên Văn đã đạt đến con số hơn 110.000 lượt theo dõi. Thảo cho biết, đội ngũ Blog Chuyên Văn rất mong muốn fanpage sẽ là nơi kết nối, lan tỏa niềm đam mê và truyền cảm hứng cho các bạn học sinh, sinh viên yêu văn chương.\n" +
                "\n" +
                "Không dừng lại ở những nội dung về kiến thức, Blog còn chú trọng đến việc chia sẻ về phương pháp dạy và học nhằm “góp phần kiến tạo nên giờ văn hạnh phúc”.\n" +
                "\n" +
                "“Có một số hiểu lầm rằng Blog Chuyên Văn chỉ dành cho giáo viên, học sinh chuyên Văn, nhưng thật ra đây là một kênh dành cho tất cả mọi người. “Chuyên Văn” chỉ đơn giản là “chuyên viết về Văn”, tức người đọc có thể tìm thấy mọi những nội dung về văn chương khi truy cập vào Blog. Đôi khi, đó là những nội dung có phần học thuật, nhưng cũng có khi, Blog sẽ đăng tải những bài viết, góc nhìn mới lạ về cuộc sống hay giới thiệu những trang sách hay...”, Lam Thảo bày tỏ.\n" +
                "\n" +
                "Đến thời điểm hiện tại, Thảo cho biết, Blog Chuyên Văn vẫn cố gắng chia sẻ thật nhiều thông tin, kinh nghiệm hữu ích cho cả người dạy và học văn. Không chỉ lan tỏa tri thức bằng những bài viết, Blog cũng đang tập trung phát triển kênh Youtube - nơi các thầy cô, các bạn học sinh có thể tiếp cận các bài giảng văn học bằng cả hình ảnh, âm thanh để tăng cao hiệu quả.\n" +
                "\n" +
                "“Mình hy vọng, Blog Chuyên Văn sẽ trở thành một cầu nối giữa những người yêu văn. Và, không chỉ đội ngũ điều hành Blog mới có thể xây dựng nội dung mà bất kỳ ai có khả năng, yêu thích và muốn chia sẻ những kiến thức văn học bổ ích tới cộng đồng đều có thể tìm đến Blog để cùng trao đổi và sẻ chia với mọi người”, Lam Thảo cho biết.\n" +
                "\n" +
                "Phố cũ văn chương\n" +
                "\n" +
                "Phố cũ văn chương là một dự án chia sẻ kiến thức văn học do Hồ Huyền Nga, sinh viên năm thứ Nhất, ngành Truyền thông đại chúng, Học viện Báo chí & Tuyên truyền thực hiện. Từng đoạt giải Nhì trong kỳ thi HSG quốc gia môn Ngữ văn khi còn theo học tại Trường THPT Chuyên Thái Nguyên, Huyền Nga mong muốn có thể chia sẻ và lan tỏa những kiến thức mình đã tiếp thu được trong suốt quãng thời gian đi học tới nhiều người hơn, đồng thời có thể giúp đỡ cho những bạn học sinh có chung niềm đam mê văn chương trong quá trình tìm hiểu môn học này.\n" +
                "\n" +
                "Đầu tháng 2/2021, Phố cũ văn chương chính thức ra đời. Huyền Nga chia sẻ: “Cái tên Phố cũ văn chương đến với mình cũng rất tình cờ. Khi ấy, mình bất chợt nghĩ đến một nơi mà ở đó, con người được sống trong những khoảnh khắc bình yên, thư thái nhất. Và thế là mình nghĩ tới “phố cũ”, mang dáng dấp của những con phố nhỏ nơi mình đang ở. Mình mong khi tìm đến Phố cũ văn chương, các bạn có thể vừa học, vừa chơi, vừa tiếp thu kiến thức vừa thư giãn và tìm lại cảm hứng học tập cho mình, từ đó thêm yêu văn chương hơn nhiều lần”." +
                "Nguyễn Đức Lam Thảo, sinh viên ngành Văn học, Trường ĐH Khoa học Xã hội & Nhân văn, ĐH Quốc gia TP.HCM.\n" +
                "\n" +
                "Sau hơn 5 năm hoạt động, hiện Blog Chuyên Văn đã đạt đến con số hơn 110.000 lượt theo dõi. Thảo cho biết, đội ngũ Blog Chuyên Văn rất mong muốn fanpage sẽ là nơi kết nối, lan tỏa niềm đam mê và truyền cảm hứng cho các bạn học sinh, sinh viên yêu văn chương.\n" +
                "\n" +
                "Không dừng lại ở những nội dung về kiến thức, Blog còn chú trọng đến việc chia sẻ về phương pháp dạy và học nhằm “góp phần kiến tạo nên giờ văn hạnh phúc”.\n" +
                "\n" +
                "“Có một số hiểu lầm rằng Blog Chuyên Văn chỉ dành cho giáo viên, học sinh chuyên Văn, nhưng thật ra đây là một kênh dành cho tất cả mọi người. “Chuyên Văn” chỉ đơn giản là “chuyên viết về Văn”, tức người đọc có thể tìm thấy mọi những nội dung về văn chương khi truy cập vào Blog. Đôi khi, đó là những nội dung có phần học thuật, nhưng cũng có khi, Blog sẽ đăng tải những bài viết, góc nhìn mới lạ về cuộc sống hay giới thiệu những trang sách hay...”, Lam Thảo bày tỏ.\n" +
                "\n" +
                "Đến thời điểm hiện tại, Thảo cho biết, Blog Chuyên Văn vẫn cố gắng chia sẻ thật nhiều thông tin, kinh nghiệm hữu ích cho cả người dạy và học văn. Không chỉ lan tỏa tri thức bằng những bài viết, Blog cũng đang tập trung phát triển kênh Youtube - nơi các thầy cô, các bạn học sinh có thể tiếp cận các bài giảng văn học bằng cả hình ảnh, âm thanh để tăng cao hiệu quả.\n" +
                "\n" +
                "“Mình hy vọng, Blog Chuyên Văn sẽ trở thành một cầu nối giữa những người yêu văn. Và, không chỉ đội ngũ điều hành Blog mới có thể xây dựng nội dung mà bất kỳ ai có khả năng, yêu thích và muốn chia sẻ những kiến thức văn học bổ ích tới cộng đồng đều có thể tìm đến Blog để cùng trao đổi và sẻ chia với mọi người”, Lam Thảo cho biết.\n" +
                "\n" +
                "Phố cũ văn chương\n" +
                "\n" +
                "Phố cũ văn chương là một dự án chia sẻ kiến thức văn học do Hồ Huyền Nga, sinh viên năm thứ Nhất, ngành Truyền thông đại chúng, Học viện Báo chí & Tuyên truyền thực hiện. Từng đoạt giải Nhì trong kỳ thi HSG quốc gia môn Ngữ văn khi còn theo học tại Trường THPT Chuyên Thái Nguyên, Huyền Nga mong muốn có thể chia sẻ và lan tỏa những kiến thức mình đã tiếp thu được trong suốt quãng thời gian đi học tới nhiều người hơn, đồng thời có thể giúp đỡ cho những bạn học sinh có chung niềm đam mê văn chương trong quá trình tìm hiểu môn học này.\n" +
                "\n" +
                "Đầu tháng 2/2021, Phố cũ văn chương chính thức ra đời. Huyền Nga chia sẻ: “Cái tên Phố cũ văn chương đến với mình cũng rất tình cờ. Khi ấy, mình bất chợt nghĩ đến một nơi mà ở đó, con người được sống trong những khoảnh khắc bình yên, thư thái nhất. Và thế là mình nghĩ tới “phố cũ”, mang dáng dấp của những con phố nhỏ nơi mình đang ở. Mình mong khi tìm đến Phố cũ văn chương, các bạn có thể vừa học, vừa chơi, vừa tiếp thu kiến thức vừa thư giãn và tìm lại cảm hứng học tập cho mình, từ đó thêm yêu văn chương hơn nhiều lần”." +
                "Nguyễn Đức Lam Thảo, sinh viên ngành Văn học, Trường ĐH Khoa học Xã hội & Nhân văn, ĐH Quốc gia TP.HCM.\n" +
                "\n" +
                "Sau hơn 5 năm hoạt động, hiện Blog Chuyên Văn đã đạt đến con số hơn 110.000 lượt theo dõi. Thảo cho biết, đội ngũ Blog Chuyên Văn rất mong muốn fanpage sẽ là nơi kết nối, lan tỏa niềm đam mê và truyền cảm hứng cho các bạn học sinh, sinh viên yêu văn chương.\n" +
                "\n" +
                "Không dừng lại ở những nội dung về kiến thức, Blog còn chú trọng đến việc chia sẻ về phương pháp dạy và học nhằm “góp phần kiến tạo nên giờ văn hạnh phúc”.\n" +
                "\n" +
                "“Có một số hiểu lầm rằng Blog Chuyên Văn chỉ dành cho giáo viên, học sinh chuyên Văn, nhưng thật ra đây là một kênh dành cho tất cả mọi người. “Chuyên Văn” chỉ đơn giản là “chuyên viết về Văn”, tức người đọc có thể tìm thấy mọi những nội dung về văn chương khi truy cập vào Blog. Đôi khi, đó là những nội dung có phần học thuật, nhưng cũng có khi, Blog sẽ đăng tải những bài viết, góc nhìn mới lạ về cuộc sống hay giới thiệu những trang sách hay...”, Lam Thảo bày tỏ.\n" +
                "\n" +
                "Đến thời điểm hiện tại, Thảo cho biết, Blog Chuyên Văn vẫn cố gắng chia sẻ thật nhiều thông tin, kinh nghiệm hữu ích cho cả người dạy và học văn. Không chỉ lan tỏa tri thức bằng những bài viết, Blog cũng đang tập trung phát triển kênh Youtube - nơi các thầy cô, các bạn học sinh có thể tiếp cận các bài giảng văn học bằng cả hình ảnh, âm thanh để tăng cao hiệu quả.\n" +
                "\n" +
                "“Mình hy vọng, Blog Chuyên Văn sẽ trở thành một cầu nối giữa những người yêu văn. Và, không chỉ đội ngũ điều hành Blog mới có thể xây dựng nội dung mà bất kỳ ai có khả năng, yêu thích và muốn chia sẻ những kiến thức văn học bổ ích tới cộng đồng đều có thể tìm đến Blog để cùng trao đổi và sẻ chia với mọi người”, Lam Thảo cho biết.\n" +
                "\n" +
                "Phố cũ văn chương\n" +
                "\n" +
                "Phố cũ văn chương là một dự án chia sẻ kiến thức văn học do Hồ Huyền Nga, sinh viên năm thứ Nhất, ngành Truyền thông đại chúng, Học viện Báo chí & Tuyên truyền thực hiện. Từng đoạt giải Nhì trong kỳ thi HSG quốc gia môn Ngữ văn khi còn theo học tại Trường THPT Chuyên Thái Nguyên, Huyền Nga mong muốn có thể chia sẻ và lan tỏa những kiến thức mình đã tiếp thu được trong suốt quãng thời gian đi học tới nhiều người hơn, đồng thời có thể giúp đỡ cho những bạn học sinh có chung niềm đam mê văn chương trong quá trình tìm hiểu môn học này.\n" +
                "\n" +
                "Đầu tháng 2/2021, Phố cũ văn chương chính thức ra đời. Huyền Nga chia sẻ: “Cái tên Phố cũ văn chương đến với mình cũng rất tình cờ. Khi ấy, mình bất chợt nghĩ đến một nơi mà ở đó, con người được sống trong những khoảnh khắc bình yên, thư thái nhất. Và thế là mình nghĩ tới “phố cũ”, mang dáng dấp của những con phố nhỏ nơi mình đang ở. Mình mong khi tìm đến Phố cũ văn chương, các bạn có thể vừa học, vừa chơi, vừa tiếp thu kiến thức vừa thư giãn và tìm lại cảm hứng học tập cho mình, từ đó thêm yêu văn chương hơn nhiều lần”." +
                "Nguyễn Đức Lam Thảo, sinh viên ngành Văn học, Trường ĐH Khoa học Xã hội & Nhân văn, ĐH Quốc gia TP.HCM.\n" +
                "\n" +
                "Sau hơn 5 năm hoạt động, hiện Blog Chuyên Văn đã đạt đến con số hơn 110.000 lượt theo dõi. Thảo cho biết, đội ngũ Blog Chuyên Văn rất mong muốn fanpage sẽ là nơi kết nối, lan tỏa niềm đam mê và truyền cảm hứng cho các bạn học sinh, sinh viên yêu văn chương.\n" +
                "\n" +
                "Không dừng lại ở những nội dung về kiến thức, Blog còn chú trọng đến việc chia sẻ về phương pháp dạy và học nhằm “góp phần kiến tạo nên giờ văn hạnh phúc”.\n" +
                "\n" +
                "“Có một số hiểu lầm rằng Blog Chuyên Văn chỉ dành cho giáo viên, học sinh chuyên Văn, nhưng thật ra đây là một kênh dành cho tất cả mọi người. “Chuyên Văn” chỉ đơn giản là “chuyên viết về Văn”, tức người đọc có thể tìm thấy mọi những nội dung về văn chương khi truy cập vào Blog. Đôi khi, đó là những nội dung có phần học thuật, nhưng cũng có khi, Blog sẽ đăng tải những bài viết, góc nhìn mới lạ về cuộc sống hay giới thiệu những trang sách hay...”, Lam Thảo bày tỏ.\n" +
                "\n" +
                "Đến thời điểm hiện tại, Thảo cho biết, Blog Chuyên Văn vẫn cố gắng chia sẻ thật nhiều thông tin, kinh nghiệm hữu ích cho cả người dạy và học văn. Không chỉ lan tỏa tri thức bằng những bài viết, Blog cũng đang tập trung phát triển kênh Youtube - nơi các thầy cô, các bạn học sinh có thể tiếp cận các bài giảng văn học bằng cả hình ảnh, âm thanh để tăng cao hiệu quả.\n" +
                "\n" +
                "“Mình hy vọng, Blog Chuyên Văn sẽ trở thành một cầu nối giữa những người yêu văn. Và, không chỉ đội ngũ điều hành Blog mới có thể xây dựng nội dung mà bất kỳ ai có khả năng, yêu thích và muốn chia sẻ những kiến thức văn học bổ ích tới cộng đồng đều có thể tìm đến Blog để cùng trao đổi và sẻ chia với mọi người”, Lam Thảo cho biết.\n" +
                "\n" +
                "Phố cũ văn chương\n" +
                "\n" +
                "Phố cũ văn chương là một dự án chia sẻ kiến thức văn học do Hồ Huyền Nga, sinh viên năm thứ Nhất, ngành Truyền thông đại chúng, Học viện Báo chí & Tuyên truyền thực hiện. Từng đoạt giải Nhì trong kỳ thi HSG quốc gia môn Ngữ văn khi còn theo học tại Trường THPT Chuyên Thái Nguyên, Huyền Nga mong muốn có thể chia sẻ và lan tỏa những kiến thức mình đã tiếp thu được trong suốt quãng thời gian đi học tới nhiều người hơn, đồng thời có thể giúp đỡ cho những bạn học sinh có chung niềm đam mê văn chương trong quá trình tìm hiểu môn học này.\n" +
                "\n" +
                "Đầu tháng 2/2021, Phố cũ văn chương chính thức ra đời. Huyền Nga chia sẻ: “Cái tên Phố cũ văn chương đến với mình cũng rất tình cờ. Khi ấy, mình bất chợt nghĩ đến một nơi mà ở đó, con người được sống trong những khoảnh khắc bình yên, thư thái nhất. Và thế là mình nghĩ tới “phố cũ”, mang dáng dấp của những con phố nhỏ nơi mình đang ở. Mình mong khi tìm đến Phố cũ văn chương, các bạn có thể vừa học, vừa chơi, vừa tiếp thu kiến thức vừa thư giãn và tìm lại cảm hứng học tập cho mình, từ đó thêm yêu văn chương hơn nhiều lần”." +
                "Nguyễn Đức Lam Thảo, sinh viên ngành Văn học, Trường ĐH Khoa học Xã hội & Nhân văn, ĐH Quốc gia TP.HCM.\n" +
                "\n" +
                "Sau hơn 5 năm hoạt động, hiện Blog Chuyên Văn đã đạt đến con số hơn 110.000 lượt theo dõi. Thảo cho biết, đội ngũ Blog Chuyên Văn rất mong muốn fanpage sẽ là nơi kết nối, lan tỏa niềm đam mê và truyền cảm hứng cho các bạn học sinh, sinh viên yêu văn chương.\n" +
                "\n" +
                "Không dừng lại ở những nội dung về kiến thức, Blog còn chú trọng đến việc chia sẻ về phương pháp dạy và học nhằm “góp phần kiến tạo nên giờ văn hạnh phúc”.\n" +
                "\n" +
                "“Có một số hiểu lầm rằng Blog Chuyên Văn chỉ dành cho giáo viên, học sinh chuyên Văn, nhưng thật ra đây là một kênh dành cho tất cả mọi người. “Chuyên Văn” chỉ đơn giản là “chuyên viết về Văn”, tức người đọc có thể tìm thấy mọi những nội dung về văn chương khi truy cập vào Blog. Đôi khi, đó là những nội dung có phần học thuật, nhưng cũng có khi, Blog sẽ đăng tải những bài viết, góc nhìn mới lạ về cuộc sống hay giới thiệu những trang sách hay...”, Lam Thảo bày tỏ.\n" +
                "\n" +
                "Đến thời điểm hiện tại, Thảo cho biết, Blog Chuyên Văn vẫn cố gắng chia sẻ thật nhiều thông tin, kinh nghiệm hữu ích cho cả người dạy và học văn. Không chỉ lan tỏa tri thức bằng những bài viết, Blog cũng đang tập trung phát triển kênh Youtube - nơi các thầy cô, các bạn học sinh có thể tiếp cận các bài giảng văn học bằng cả hình ảnh, âm thanh để tăng cao hiệu quả.\n" +
                "\n" +
                "“Mình hy vọng, Blog Chuyên Văn sẽ trở thành một cầu nối giữa những người yêu văn. Và, không chỉ đội ngũ điều hành Blog mới có thể xây dựng nội dung mà bất kỳ ai có khả năng, yêu thích và muốn chia sẻ những kiến thức văn học bổ ích tới cộng đồng đều có thể tìm đến Blog để cùng trao đổi và sẻ chia với mọi người”, Lam Thảo cho biết.\n" +
                "\n" +
                "Phố cũ văn chương\n" +
                "\n" +
                "Phố cũ văn chương là một dự án chia sẻ kiến thức văn học do Hồ Huyền Nga, sinh viên năm thứ Nhất, ngành Truyền thông đại chúng, Học viện Báo chí & Tuyên truyền thực hiện. Từng đoạt giải Nhì trong kỳ thi HSG quốc gia môn Ngữ văn khi còn theo học tại Trường THPT Chuyên Thái Nguyên, Huyền Nga mong muốn có thể chia sẻ và lan tỏa những kiến thức mình đã tiếp thu được trong suốt quãng thời gian đi học tới nhiều người hơn, đồng thời có thể giúp đỡ cho những bạn học sinh có chung niềm đam mê văn chương trong quá trình tìm hiểu môn học này.\n" +
                "\n" +
                "Đầu tháng 2/2021, Phố cũ văn chương chính thức ra đời. Huyền Nga chia sẻ: “Cái tên Phố cũ văn chương đến với mình cũng rất tình cờ. Khi ấy, mình bất chợt nghĩ đến một nơi mà ở đó, con người được sống trong những khoảnh khắc bình yên, thư thái nhất. Và thế là mình nghĩ tới “phố cũ”, mang dáng dấp của những con phố nhỏ nơi mình đang ở. Mình mong khi tìm đến Phố cũ văn chương, các bạn có thể vừa học, vừa chơi, vừa tiếp thu kiến thức vừa thư giãn và tìm lại cảm hứng học tập cho mình, từ đó thêm yêu văn chương hơn nhiều lần”.");
        productDto.setStartDate("2022-05-25 08:00:00");
        productDto.setEndDate("2022-05-25 08:00:00");
        productDto.setApprovedStatus(2);
        productDto.setDescription("chưa có");
        productDto.setPaymentStatus(1);
        productDto.setTimeRemaining("36:00:00");
        productDto.setProductAddress("chưa thêm địa chỉ");

        Category category = new Category();
        productDto.setId((long) 1);
        productDto.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/film/createFilm")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //test min length -------------------------------------------------------------------------->
    @Test
    // test imageUrl sai Max length
    public  void edit_17_imageUrl() throws  Exception{
        ProductDto productDto = new ProductDto();
        productDto.setName("Galaxy Note 20 Ultra");
        productDto.setStartBid((long) 15000000);
        productDto.setBidRange((long) 100000);
        productDto.setFinalBid((long) 20000000);
        productDto.setImageUrl("sffs");
        productDto.setStartDate("2022-05-25 08:00:00");
        productDto.setEndDate("2022-05-25 08:00:00");
        productDto.setApprovedStatus(2);
        productDto.setDescription("chưa có");
        productDto.setPaymentStatus(1);
        productDto.setTimeRemaining("36:00:00");
        productDto.setProductAddress("chưa thêm địa chỉ");

        Category category = new Category();
        productDto.setId((long) 1);
        productDto.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/film/createFilm")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // test all ko hợp lệ -------------------------------------------------------------------------->
    @Test
    // test all ko hợp lệ
    public  void edit_18_all() throws  Exception{
        ProductDto productDto = new ProductDto();
        productDto.setName("");
        productDto.setStartBid(0l);
        productDto.setBidRange(0l);
        productDto.setFinalBid(0l);
        productDto.setImageUrl("");
        productDto.setStartDate("");
        productDto.setEndDate("");
        productDto.setApprovedStatus(2);
        productDto.setDescription("");
        productDto.setPaymentStatus(2);
        productDto.setTimeRemaining("");
        productDto.setProductAddress("");

        Category category = new Category();
        productDto.setId((long) 1);
        productDto.setCategory(category);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/film/createFilm")
                        .content(this.objectMapper.writeValueAsString(productDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
