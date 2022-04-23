package vn.codegym.com.c0921g1_sprint2.DTO.member;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vn.codegym.com.c0921g1_sprint2.model.Auction;
import vn.codegym.com.c0921g1_sprint2.model.Transaction;
import vn.codegym.com.c0921g1_sprint2.model.security.Account;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

public class MemberDTO implements Validator {

    private Long id;

    @NotBlank(message = "Dữ liệu còn trống! Mời bạn nhập vào!")
    @Pattern(regexp = RegexMember.REGEX_MEMBER_NAME,
            message = "Dữ liệu không hợp lệ! Tên không bao gồm số hoặc kí tự đặc biệt!")
    private String name;

    @NotBlank(message = "Dữ liệu còn trống! Mời bạn nhập vào!")
    private String dayOfBirth;

    @NotBlank(message = "Dữ liệu còn trống! Mời bạn nhập vào!")
    private String address;

    @NotBlank(message = "Dữ liệu còn trống! Mời bạn nhập vào!")
    @Pattern(regexp = RegexMember.REGEX_PHONE_NUMBER,
            message = "Dữ liệu không hợp lệ! Số điện thoại phải tuân theo chuẩn của Việt Nam!")
    private String phoneNumber;

    private Integer gender;

    @NotBlank(message = "Dữ liệu còn trống! Mời bạn nhập vào!")
    @Email(message = "Dữ liệu không hợp lệ! Email phải tuân theo chuẩn quy ước!")
    private String email;

    @NotBlank(message = "Dữ liệu còn trống! Mời bạn nhập vào!")
    @Pattern(regexp = RegexMember.REGEX_IDENTITY_NUMBER,
            message = "Dữ liệu không hợp lệ! Số chứng minh nhân dân phải tuân theo chuẩn quy ước!")
    private String identityNumber;

    @NotBlank(message = "Dữ liệu còn trống! Mời bạn nhập vào!")
    private String password;

    private Long point;
    private Integer lockFlag;
    private Integer deleteFlag;
    private Integer warning;
    private Long totalMoney;

    private List<Transaction> transactions;
    List<Auction> auctions;
    private Account account;

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

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
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

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Auction> getAuctions() {
        return auctions;
    }

    public void setAuctions(List<Auction> auctions) {
        this.auctions = auctions;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return MemberDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MemberDTO memberDTO = (MemberDTO) target;

        String dayOfBirth = memberDTO.dayOfBirth;
//        System.out.println(RegexMember.checkAgeMember(dateOfBirth));
        if (RegexMember.checkAgeMember(dayOfBirth)) {
            errors.rejectValue("dayOfBirth","dayOfBirth.age");
        }
    }


}
