package vn.codegym.com.c0921g1_sprint2.dto;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vn.codegym.com.c0921g1_sprint2.model.Category;

import javax.validation.constraints.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductDTOTaiLM implements Validator {
    @Pattern(message ="Tên không được chứa ký tự đặc biệt" ,regexp ="^([A-ZĐ][a-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ]+)( [A-ZĐ\\d][a-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ]*)*$")
    @Length(max = 30,message = "Tên không quá 30 ký tự")
    @NotBlank
    private String name;

    @Min(value = 5000,message = "Giá khởi đầu không không được nhỏ hơn 5.000 đồng")
    @NotNull(message = "Vui lòng chọn")
    @Max(value=5000000,message = "Giá khởi đầu không quá 5.000.000 đ")
    private Long startBid;

    @NotNull(message = "Vui lòng chọn")
    @Min(value = 5000,message = "Giá khởi đầu không không được nhỏ hơn 5.000 đồng")
    private Long bidRange;

    @Min(value = 1000,message = "Giá trị không đúng")
    @Max(value = 10000000,message = "Giá trị không quá 10.000.000 đ")
    private Long finalBid;

    @NotBlank(message = "Vui lòng chọn")
    @Length(min = 5,message = "Không đúng định dạng")
    @Length(min = 5000,message = "Không quá 1000 ký tự")
    private String imageUrl;

    private String startDate;
    private String endDate;
    private Integer approvedStatus;
    @NotBlank(message = "Vui lòng không để trống")
    @Length(min=10, max=150, message="Ký tự trong khoảng 10-150")
    private String description;

    private Integer paymentStatus;
    private String timeRemaining;
    private String productAddress;

    @NotNull(message = "Vui lòng chọn")
    private Category category;

    public ProductDTOTaiLM() {
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

    public static Boolean checkNgay(String startDate, String endDate) {
        boolean flag;
        Date ngayBatDau = null;
        Date ngayKetThuc = null;
        Date localDateTime = new Date();

        try {
            ngayBatDau = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startDate);
            ngayKetThuc = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endDate);
        } catch (ParseException e) {
            flag = false;
        }
        if (ngayBatDau.after(localDateTime)){
            flag =false;
        } else if (ngayBatDau.compareTo(ngayKetThuc) >= 0) {
            flag = false;
        } else {
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductDTOTaiLM productDTOTaiLM = (ProductDTOTaiLM) target;
        String startDate = productDTOTaiLM.startDate;
        String endDate = productDTOTaiLM.endDate;
        if(checkNgay(startDate,endDate)){
            errors.rejectValue("startDate","startDate.CheckDate","Ngày bắt đầu phải nhỏ hơn ngày kết thúc");
        }
    }
}
