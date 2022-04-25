package vn.codegym.com.c0921g1_sprint2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.codegym.com.c0921g1_sprint2.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * FROM product WHERE `name` LIKE CONCAT('%',?1,'%') AND category_id LIKE CONCAT('%',?2,'%') AND final_bid BETWEEN ?3 AND ?4", nativeQuery = true)
    Page<Product> findProductByOptions(String name, String category, Long minPrice, Long maxPrice, Pageable pageable);
}
