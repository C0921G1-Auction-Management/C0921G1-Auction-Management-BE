package vn.codegym.com.c0921g1_sprint2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.codegym.com.c0921g1_sprint2.model.Category;
import vn.codegym.com.c0921g1_sprint2.model.Product;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Long> {

//    Đăng ký sản phẩm-TaiLM
    @Modifying
    @Query(value="insert into product ( approved_status, bid_range, `description`, end_date, final_bid, image_url, `name`, payment_status, product_address, start_bid, start_date, time_remaining, category_id)\n" +
            "value\n" +
            "(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12,?13)",nativeQuery=true)
    void saveProduct(Integer approvedStatus, Long bidRange, String description,  String endDate,  Long finalBid, String imageUrl, String name, Integer paymentStatus, String productAddress, Long startBid, String startDate, String timeRemaining, Long categoryId);
}
