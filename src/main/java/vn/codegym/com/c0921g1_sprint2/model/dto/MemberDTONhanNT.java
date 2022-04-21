package vn.codegym.com.c0921g1_sprint2.model.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public interface MemberDTONhanNT {

    Long getId();
    String getName();
    String getAddress();
    String getPhoneNumber();
    String getEmail();
    Long getPoint();
    Integer getLockFlag();



}
