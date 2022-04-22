package vn.codegym.com.c0921g1_sprint2.model.security;

import javax.persistence.*;

@Entity(name = "account_role")
@Table
public class AccountRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = Account.class)
    private Account account;

    @ManyToOne(targetEntity = Role.class)
    private Role role;

    public AccountRole() {
    }

    public AccountRole(Integer id, Account account, Role role) {
        this.id = id;
        this.account = account;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
