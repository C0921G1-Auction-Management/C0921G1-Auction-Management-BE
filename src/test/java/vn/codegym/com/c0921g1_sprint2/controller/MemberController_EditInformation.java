package vn.codegym.com.c0921g1_sprint2.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import vn.codegym.com.c0921g1_sprint2.dto.MemberDTO;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MemberController_EditInformation {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    //    Trường hợp tham số id truyền vào bị null
    @Test
    public void getEditInformation_1() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/member/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //    Trường hợp tham số id truyền vào bị rỗng
    @Test
    public void getEditInformation_2() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/member/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //    Trường hợp tham số id truyền vào không có trong database
    @Test
    public void getEditInformation_3() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/member/{id}", "100"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //    Trường hợp tham số truyền vào tồn tại trong database
    @Test
    public void getEditInformation_4() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/member/{id}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.id").value(1));
    }


    //    Trường hợp item bị null
    @Test
    public void getEditInformation_19() throws Exception {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("Nguyễn Hải Nam");
        memberDTO.setDayOfBirth("2001-12-03");
        memberDTO.setAddress("Quảng Nam");
        memberDTO.setPhoneNumber("0988888888");
        memberDTO.setGender(1);
        memberDTO.setEmail("abc@gmail.com");
        memberDTO.setPoint(null);
        memberDTO.setLockFlag(1);
        memberDTO.setDeleteFlag(0);
        memberDTO.setWarning(1);
        memberDTO.setTotalMoney(100l);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/member/1")
                        .content(this.objectMapper.writeValueAsString(memberDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //    Trường hợp item bị rỗng
    @Test
    public void getEditInformation_20() throws Exception {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("Nguyễn Hải Nam");
        memberDTO.setDayOfBirth("2001-12-03");
        memberDTO.setAddress("Quảng Nam");
        memberDTO.setPhoneNumber("0988888888");
        memberDTO.setGender(1);
        memberDTO.setEmail("");
        memberDTO.setPoint(100l);
        memberDTO.setLockFlag(1);
        memberDTO.setDeleteFlag(0);
        memberDTO.setWarning(1);
        memberDTO.setTotalMoney(100l);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/member/1")
                        .content(this.objectMapper.writeValueAsString(memberDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //    Trường hợp item bị rỗng
    @Test
    public void getEditInformation_21() throws Exception {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("Nguyễn Hải Nam");
        memberDTO.setDayOfBirth("2001-12-03");
        memberDTO.setAddress("Quảng Nam");
        memberDTO.setPhoneNumber("09888");
        memberDTO.setGender(1);
        memberDTO.setEmail("abc@gmail.com");
        memberDTO.setPoint(100l);
        memberDTO.setLockFlag(1);
        memberDTO.setDeleteFlag(0);
        memberDTO.setWarning(1);
        memberDTO.setTotalMoney(100l);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/member/1")
                        .content(this.objectMapper.writeValueAsString(memberDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //    Trường hợp item không >= minlength
    @Test
    public void getEditInformation_22() throws Exception {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("Ng");
        memberDTO.setDayOfBirth("2001-12-03");
        memberDTO.setAddress("Quảng Nam");
        memberDTO.setPhoneNumber("0988888888");
        memberDTO.setGender(1);
        memberDTO.setEmail("abc@gmail.com");
        memberDTO.setPoint(100l);
        memberDTO.setLockFlag(1);
        memberDTO.setDeleteFlag(0);
        memberDTO.setWarning(1);
        memberDTO.setTotalMoney(100l);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/member/1")
                        .content(this.objectMapper.writeValueAsString(memberDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //    Trường hợp item không <= maxlength
    @Test
    public void getEditInformation_23() throws Exception {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("Nguyễn Minh Minh Minh Minh Minh Minh Minh Minh Minh Minh Minh Minh Minh Minh Minh Minh Minh Minh Minh Minh Minh Minh Minh Minh ");
        memberDTO.setDayOfBirth("2001-12-03");
        memberDTO.setAddress("Quảng Nam");
        memberDTO.setPhoneNumber("0988888888");
        memberDTO.setGender(1);
        memberDTO.setEmail("abc@gmail.com");
        memberDTO.setPoint(100l);
        memberDTO.setLockFlag(1);
        memberDTO.setDeleteFlag(0);
        memberDTO.setWarning(1);
        memberDTO.setTotalMoney(100l);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/member/1")
                        .content(this.objectMapper.writeValueAsString(memberDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //    Trường hợp item hợp lệ
    @Test
    public void getEditInformation_24() throws Exception {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("Nguyễn Minh Quân");
        memberDTO.setDayOfBirth("2001-12-03");
        memberDTO.setAddress("Quảng Nam");
        memberDTO.setPhoneNumber("0988888888");
        memberDTO.setGender(1);
        memberDTO.setEmail("abc@gmail.com");
        memberDTO.setPoint(100l);
        memberDTO.setLockFlag(1);
        memberDTO.setDeleteFlag(0);
        memberDTO.setWarning(1);
        memberDTO.setTotalMoney(100l);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/member/1")
                        .content(this.objectMapper.writeValueAsString(memberDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
