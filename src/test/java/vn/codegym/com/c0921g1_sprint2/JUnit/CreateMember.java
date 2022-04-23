package vn.codegym.com.c0921g1_sprint2.JUnit;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import vn.codegym.com.c0921g1_sprint2.DTO.member.MemberDTO;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CreateMember {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    //creating successfully - KhanhLDQ
    @Test
    public void createMember_18()throws Exception{
        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setName("Test Name");
        memberDTO.setGender(1);
        memberDTO.setPhoneNumber("0901234567");
        memberDTO.setEmail("test@test.com");
        memberDTO.setAddress("test");
        memberDTO.setDayOfBirth("2000-02-02");
        memberDTO.setIdentityNumber("123456789");
        memberDTO.setPassword("123456");


        this.mockMvc.perform(MockMvcRequestBuilders.post("/c09/public/member")
                .content(this.objectMapper.writeValueAsString(memberDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    //test name null - KhanhLDQ
    @Test
    public void createMember_name_13()throws Exception{
        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setName(null);
        memberDTO.setGender(1);
        memberDTO.setPhoneNumber("0901234567");
        memberDTO.setEmail("test@test.com");
        memberDTO.setAddress("test");
        memberDTO.setDayOfBirth("2000-02-02");
        memberDTO.setIdentityNumber("123456789");
        memberDTO.setPassword("123456");


        this.mockMvc.perform(MockMvcRequestBuilders.post("/c09/public/member")
                .content(this.objectMapper.writeValueAsString(memberDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //test name blank - KhanhLDQ
    @Test
    public void createMember_name_14()throws Exception{
        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setName("");
        memberDTO.setGender(1);
        memberDTO.setPhoneNumber("0901234567");
        memberDTO.setEmail("test@test.com");
        memberDTO.setAddress("test");
        memberDTO.setDayOfBirth("2000-02-02");
        memberDTO.setIdentityNumber("123456789");
        memberDTO.setPassword("123456");


        this.mockMvc.perform(MockMvcRequestBuilders.post("/c09/public/member")
                .content(this.objectMapper.writeValueAsString(memberDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //test name format - KhanhLDQ
    @Test
    public void createMember_name_15()throws Exception{
        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setName("Nguyen Van A1");
        memberDTO.setGender(1);
        memberDTO.setPhoneNumber("0901234567");
        memberDTO.setEmail("test@test.com");
        memberDTO.setAddress("test");
        memberDTO.setDayOfBirth("2000-02-02");
        memberDTO.setIdentityNumber("123456789");
        memberDTO.setPassword("123456");


        this.mockMvc.perform(MockMvcRequestBuilders.post("/c09/public/member")
                .content(this.objectMapper.writeValueAsString(memberDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //test phone null - KhanhLDQ
    @Test
    public void createMember_phone_13()throws Exception{
        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setName("Nguyen Van A");
        memberDTO.setGender(1);
        memberDTO.setPhoneNumber(null);
        memberDTO.setEmail("test@test.com");
        memberDTO.setAddress("test");
        memberDTO.setDayOfBirth("2000-02-02");
        memberDTO.setIdentityNumber("123456789");
        memberDTO.setPassword("123456");


        this.mockMvc.perform(MockMvcRequestBuilders.post("/c09/public/member")
                .content(this.objectMapper.writeValueAsString(memberDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //test phone blank - KhanhLDQ
    @Test
    public void createMember_phone_14()throws Exception{
        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setName("Nguyen Van A");
        memberDTO.setGender(1);
        memberDTO.setPhoneNumber("");
        memberDTO.setEmail("test@test.com");
        memberDTO.setAddress("test");
        memberDTO.setDayOfBirth("2000-02-02");
        memberDTO.setIdentityNumber("123456789");
        memberDTO.setPassword("123456");


        this.mockMvc.perform(MockMvcRequestBuilders.post("/c09/public/member")
                .content(this.objectMapper.writeValueAsString(memberDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //test phone format - KhanhLDQ
    @Test
    public void createMember_phone_15()throws Exception{
        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setName("Nguyen Van A");
        memberDTO.setGender(1);
        memberDTO.setPhoneNumber("0781234567");
        memberDTO.setEmail("test@test.com");
        memberDTO.setAddress("test");
        memberDTO.setDayOfBirth("2000-02-02");
        memberDTO.setIdentityNumber("123456789");
        memberDTO.setPassword("123456");


        this.mockMvc.perform(MockMvcRequestBuilders.post("/c09/public/member")
                .content(this.objectMapper.writeValueAsString(memberDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //test email null - KhanhLDQ
    @Test
    public void createMember_email_13()throws Exception{
        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setName("Nguyen Van A");
        memberDTO.setGender(1);
        memberDTO.setPhoneNumber("0901234567");
        memberDTO.setEmail(null);
        memberDTO.setAddress("test");
        memberDTO.setDayOfBirth("2000-02-02");
        memberDTO.setIdentityNumber("123456789");
        memberDTO.setPassword("123456");


        this.mockMvc.perform(MockMvcRequestBuilders.post("/c09/public/member")
                .content(this.objectMapper.writeValueAsString(memberDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //test email blank - KhanhLDQ
    @Test
    public void createMember_email_14()throws Exception{
        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setName("Nguyen Van A");
        memberDTO.setGender(1);
        memberDTO.setPhoneNumber("0901234567");
        memberDTO.setEmail("");
        memberDTO.setAddress("test");
        memberDTO.setDayOfBirth("2000-02-02");
        memberDTO.setIdentityNumber("123456789");
        memberDTO.setPassword("123456");


        this.mockMvc.perform(MockMvcRequestBuilders.post("/c09/public/member")
                .content(this.objectMapper.writeValueAsString(memberDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //test email format - KhanhLDQ
    @Test
    public void createMember_email_15()throws Exception{
        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setName("Nguyen Van A");
        memberDTO.setGender(1);
        memberDTO.setPhoneNumber("0901234567");
        memberDTO.setEmail("nguyenA@");
        memberDTO.setAddress("test");
        memberDTO.setDayOfBirth("2000-02-02");
        memberDTO.setIdentityNumber("123456789");
        memberDTO.setPassword("123456");


        this.mockMvc.perform(MockMvcRequestBuilders.post("/c09/public/member")
                .content(this.objectMapper.writeValueAsString(memberDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //test email existed - KhanhLDQ
    @Test
    public void createMember_email_16()throws Exception{
        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setName("Nguyen Van A");
        memberDTO.setGender(1);
        memberDTO.setPhoneNumber("0901234567");
        memberDTO.setEmail("nguyenA@gmail.com");
        memberDTO.setAddress("test");
        memberDTO.setDayOfBirth("2000-02-02");
        memberDTO.setIdentityNumber("123456789");
        memberDTO.setPassword("123456");


        this.mockMvc.perform(MockMvcRequestBuilders.post("/c09/public/member")
                .content(this.objectMapper.writeValueAsString(memberDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //test address null - KhanhLDQ
    @Test
    public void createMember_address_13()throws Exception{
        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setName("Nguyen Van A");
        memberDTO.setGender(1);
        memberDTO.setPhoneNumber("0901234567");
        memberDTO.setEmail("nguyenA@gmail.com");
        memberDTO.setAddress(null);
        memberDTO.setDayOfBirth("2000-02-02");
        memberDTO.setIdentityNumber("123456789");
        memberDTO.setPassword("123456");


        this.mockMvc.perform(MockMvcRequestBuilders.post("/c09/public/member")
                .content(this.objectMapper.writeValueAsString(memberDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //test address blank - KhanhLDQ
    @Test
    public void createMember_address_14()throws Exception{
        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setName("Nguyen Van A");
        memberDTO.setGender(1);
        memberDTO.setPhoneNumber("0901234567");
        memberDTO.setEmail("nguyenA@gmail.com");
        memberDTO.setAddress("");
        memberDTO.setDayOfBirth("2000-02-02");
        memberDTO.setIdentityNumber("123456789");
        memberDTO.setPassword("123456");


        this.mockMvc.perform(MockMvcRequestBuilders.post("/c09/public/member")
                .content(this.objectMapper.writeValueAsString(memberDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //test date of birth blank - KhanhLDQ
    @Test
    public void createMember_dateOfBirth_14()throws Exception{
        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setName("Nguyen Van A");
        memberDTO.setGender(1);
        memberDTO.setPhoneNumber("0901234567");
        memberDTO.setEmail("nguyenA@gmail.com");
        memberDTO.setAddress("Da Nang");
        memberDTO.setDayOfBirth("");
        memberDTO.setIdentityNumber("123456789");
        memberDTO.setPassword("123456");


        this.mockMvc.perform(MockMvcRequestBuilders.post("/c09/public/member")
                .content(this.objectMapper.writeValueAsString(memberDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //test age 18 - KhanhLDQ
    @Test
    public void createMember_dateOfBirth_15()throws Exception{
        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setName("Nguyen Van A");
        memberDTO.setGender(1);
        memberDTO.setPhoneNumber("0901234567");
        memberDTO.setEmail("nguyenA@gmail.com");
        memberDTO.setAddress("Da Nang");
        memberDTO.setDayOfBirth("2015-10-02");
        memberDTO.setIdentityNumber("123456789");
        memberDTO.setPassword("123456");


        this.mockMvc.perform(MockMvcRequestBuilders.post("/c09/public/member")
                .content(this.objectMapper.writeValueAsString(memberDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //test identity number null - KhanhLDQ
    @Test
    public void createMember_identityNumber_13()throws Exception{
        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setName("Nguyen Van A");
        memberDTO.setGender(1);
        memberDTO.setPhoneNumber("0901234567");
        memberDTO.setEmail("nguyenA@gmail.com");
        memberDTO.setAddress("Da Nang");
        memberDTO.setDayOfBirth("2005-10-02");
        memberDTO.setIdentityNumber(null);
        memberDTO.setPassword("123456");


        this.mockMvc.perform(MockMvcRequestBuilders.post("/c09/public/member")
                .content(this.objectMapper.writeValueAsString(memberDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //test identity number blank - KhanhLDQ
    @Test
    public void createMember_identityNumber_14()throws Exception{
        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setName("Nguyen Van A");
        memberDTO.setGender(1);
        memberDTO.setPhoneNumber("0901234567");
        memberDTO.setEmail("nguyenA@gmail.com");
        memberDTO.setAddress("Da Nang");
        memberDTO.setDayOfBirth("2005-10-02");
        memberDTO.setIdentityNumber("");
        memberDTO.setPassword("123456");


        this.mockMvc.perform(MockMvcRequestBuilders.post("/c09/public/member")
                .content(this.objectMapper.writeValueAsString(memberDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //test identity number format - KhanhLDQ
    @Test
    public void createMember_identityNumber_15()throws Exception{
        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setName("Nguyen Van A");
        memberDTO.setGender(1);
        memberDTO.setPhoneNumber("0901234567");
        memberDTO.setEmail("nguyenA@gmail.com");
        memberDTO.setAddress("Da Nang");
        memberDTO.setDayOfBirth("2005-10-02");
        memberDTO.setIdentityNumber("12312345");
        memberDTO.setPassword("123456");


        this.mockMvc.perform(MockMvcRequestBuilders.post("/c09/public/member")
                .content(this.objectMapper.writeValueAsString(memberDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
