package vn.codegym.com.c0921g1_sprint2.model.security;

import com.fasterxml.jackson.annotation.JsonBackReference;
import vn.codegym.com.c0921g1_sprint2.model.Member;

import javax.persistence.*;
import java.util.List;

@Entity(name = "account")
@Table
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String encryptPw;
    private Integer isEnabled;
    private String email;

    @OneToMany(mappedBy = "account")
    @JsonBackReference(value = "account_RoleSet")
    private List<AccountRole> accountRoleList;

    @OneToOne(mappedBy = "account")
    @JsonBackReference(value = "account_member")
    private Member member;

    public Account() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEncryptPw() {
        return encryptPw;
    }

    public void setEncryptPw(String encryptPw) {
        this.encryptPw = encryptPw;
    }

    public Integer getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Integer isEnabled) {
        this.isEnabled = isEnabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<AccountRole> getAccountRoleList() {
        return accountRoleList;
    }

    public void setAccountRoleList(List<AccountRole> accountRoleList) {
        this.accountRoleList = accountRoleList;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}