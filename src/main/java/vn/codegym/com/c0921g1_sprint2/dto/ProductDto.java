package vn.codegym.com.c0921g1_sprint2.dto;


import org.hibernate.validator.constraints.Length;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vn.codegym.com.c0921g1_sprint2.model.Category;

import javax.validation.MessageInterpolator;
import javax.validation.constraints.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ProductDto implements Validator {
    private Long id;
    @NotBlank(message = "tên sản phẩm không được để trống")
    private String name;
    @NotNull(message = "giá khởi điểm không được để trống")
    @Min(message = "giá trị ban đầu của sản phẩm nhỏ nhất là 50000", value = 50000)
    private Long startBid;
    @NotNull(message = "bước giá không được để trống")
    @Min(message = "bước giá nhỏ nhất là 5000", value = 5000)
    private Long bidRange;
    @NotNull(message = "Giá chiến thắng tuyệt đối không được để trống")
    @Max(value = 1000000000000L,message = "giá trị lớn nhất là 1000 tỷ")
    private Long finalBid;
    @NotBlank(message = "hình ảnh không được để trống")
    @Length(min = 5,max = 5000,message = "độ dài của chuổi nhỏ nhất 5 ký tự và lớn nhất 5000 ký tự")
    private String imageUrl;
    @NotBlank(message = "ngày bắt đầu không được để trống")
    private String startDate;
    @NotBlank(message = "ngày kết thúc không được để trống")
    private String endDate;
    @NotNull(message = "tình trạng duyệt không được để trống")
    @Pattern(message = "nhập 1 là duyệt nhập 0 là không duyệt",regexp = "^[0-1]$")
    private Integer approvedStatus;
    @NotBlank(message = "mô tả không được để trống")
    private String description;
    private Integer paymentStatus;
    private String timeRemaining;
    @NotBlank(message = "địa chỉ nhận hàng không được để trống")
    private String productAddress;
    private Category category;

    public ProductDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getStartBid() {
        return startBid;
    }

    public void setStartBid(Long startBid) {
        this.startBid = startBid;
    }

    public Long getBidRange() {
        return bidRange;
    }

    public void setBidRange(Long bidRange) {
        this.bidRange = bidRange;
    }

    public Long getFinalBid() {
        return finalBid;
    }

    public void setFinalBid(Long finalBid) {
        this.finalBid = finalBid;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getApprovedStatus() {
        return approvedStatus;
    }

    public void setApprovedStatus(Integer approvedStatus) {
        this.approvedStatus = approvedStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getTimeRemaining() {
        return timeRemaining;
    }

    public void setTimeRemaining(String timeRemaining) {
        this.timeRemaining = timeRemaining;
    }

    public String getProductAddress() {
        return productAddress;
    }

    public void setProductAddress(String productAddress) {
        this.productAddress = productAddress;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean checkDate(String startDate, String endDate) {

        Date start = null;
        Date end = null;
        Date now = new Date();
        try {
             start = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startDate);
            end = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(start.compareTo(end) < 0 && start.compareTo(now) > 0){
          return false;
        }
        return true;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
    ProductDto productDto = (ProductDto) target;
    String startDate = productDto.startDate;
    String endDate = productDto.endDate;
    if(checkDate(startDate,endDate)){
        errors.rejectValue("startDate","errorMessage");
    }
    }
}
