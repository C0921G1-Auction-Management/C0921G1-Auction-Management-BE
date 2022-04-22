package vn.codegym.com.c0921g1_sprint2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.codegym.com.c0921g1_sprint2.model.Auction;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AuctionRepository extends JpaRepository<Auction, Long> {

    @Query(value = "select * from auction", nativeQuery =true)
    Page<Auction> findAllAuction(Pageable pageable);

    @Modifying
    @Query(value = "insert into auction values (?1,?2,?3,?4,?5)", nativeQuery = true)
    void saveInfoAuction(Long productId,Long memberId ,Integer price, Integer quantity, String time);


    @Modifying
    @Query(value = "update auction set price = ?3 quantity = ?4, `time` = ?5 ", nativeQuery = true)
    void updateInfoAuction(Long productId,Long memberId ,Integer price, Integer quantity, String time);

    @Query(value = "select * from auction order by auction.current_bid desc limit 1", nativeQuery = true)
    Auction findMemBerFinal();
}
