package vn.codegym.com.c0921g1_sprint2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PatchMapping;
import vn.codegym.com.c0921g1_sprint2.model.Category;
import vn.codegym.com.c0921g1_sprint2.model.Product;

import javax.transaction.Transactional;
import java.util.Optional;

//CaHm lấy list product
@Transactional
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "select * \n" +
            "from product\n" +
            "join transaction on product.id = transaction.product_id\n" +
            "join member on transaction.member_id = member.id\n" +
            "join category on product.category_id = category.id\n" +
            "where product.name like %?1% and member.name like %?2% and category.name like %?3% and product.start_bid like %?4% and product.approved_status like %?5%\n" +
            "order by product.id desc" , nativeQuery = true)
    Page<Product> getFieldProduct(String nameProduct, String nameMember, String category_id, String start_bid, String approved_status, Pageable pageable);


//CaHM findByIdProduct
    @Query(value="select * from product\n" +
            "where product.id like %?1",nativeQuery=true)
    Optional<Product> findByIdProduct(Long id);

    //CaHM update product
    @Modifying
    @Query(value="update product set name = :name, start_bid = :start_bid,bid_range = :bid_range, final_bid = :final_bid, image_url = :image_url,\n" +
            "start_date = :start_date, end_date = :end_date, approved_status = :approved_status, description = :description,\n" +
            "payment_status = :payment_status, time_remaining = :time_remaining, product_address = :product_address,\n" +
            "category_id = :category_id\n" +
            "where product.id = :id", nativeQuery = true)
    void updateProduct(
            @Param("name") String name,
            @Param("start_bid") Long start_bid,
            @Param("bid_range") Long bid_range,
            @Param("final_bid") Long final_bid,
            @Param("image_url") String image_url,
            @Param("start_date") String start_date,
            @Param("end_date") String end_date,
            @Param("approved_status") Integer approved_status,
            @Param("description") String description,
            @Param("payment_status") Integer payment_status,
            @Param("time_remaining") String time_remaining,
            @Param("product_address") String product_address,
            @Param("category_id") Category category_id,
            @Param("id") Long id
    );



}
