package vn.codegym.com.c0921g1_sprint2.dto;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class MemberDTO implements Validator {
    private Long id;

    @Pattern(message ="Tên phải đặt theo dạng VD : Nguyen Van A" ,regexp ="^([A-ZĐ][a-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ]+)( [A-ZĐ][a-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ]*)*$")
    private String name;

    @NotBlank(message = "Không được để trống ô này !")
    private String dayOfBirth;

    @NotBlank(message = "Không được để trống ô này !")
    private String address;

    @Pattern(message ="Số điện thoại phải đúng định dạng VD : 09xxxxxxxx" ,regexp ="(84|0[3|5|7|8|9])+([0-9]{8})\\b")
    private String phoneNumber;

    @NotNull(message = "Không được để trống ô này !")
    private Integer gender;

    @NotBlank(message = "Không được để trống ô này !")
    @Email(message = "Dữ liệu không hợp lệ! Email phải tuân theo chuẩn quy ước!")
    private String email;

    @NotNull(message = "Không được để trống ô này !")
    private Long point;

    @NotNull(message = "Không được để trống ô này !")
    private Integer lockFlag;

    @NotNull(message = "Không được để trống ô này !")
    private Integer deleteFlag;

    @NotNull(message = "Không được để trống ô này !")
    private Integer warning;

    @NotNull(message = "Không được để trống ô này !")
    private Long totalMoney;

    public MemberDTO() {
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

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPoint() {
        return point;
    }

    public void setPoint(Long point) {
        this.point = point;
    }

    public Integer getLockFlag() {
        return lockFlag;
    }

    public void setLockFlag(Integer lockFlag) {
        this.lockFlag = lockFlag;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getWarning() {
        return warning;
    }

    public void setWarning(Integer warning) {
        this.warning = warning;
    }

    public Long getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Long totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
    MemberDTO memberDTO = (MemberDTO) target;
    String dateOfBirth = memberDTO.dayOfBirth;
        if (RegexMember.checkAgeMember(dateOfBirth)) {
            errors.rejectValue("dateOfBirth","dateOfBirth.age");
        }
    }
}
