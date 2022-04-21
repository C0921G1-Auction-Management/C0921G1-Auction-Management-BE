package vn.codegym.com.c0921g1_sprint2.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    @JoinTable (name = "auction_member", joinColumns = @JoinColumn(name = "auction_id"), inverseJoinColumns = @JoinColumn(name = "member_id"))
    private List<Member> members;
    @ManyToOne (targetEntity = Product.class)
    private Product product;
    private Long currentBid;

    public Auction() {
    }


}
