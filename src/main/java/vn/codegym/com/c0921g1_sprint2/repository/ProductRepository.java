package vn.codegym.com.c0921g1_sprint2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.codegym.com.c0921g1_sprint2.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    /*DatTC - Tìm kiếm sản phẩm theo tên, danh mục, mức giá*/
    @Query(value = "SELECT * FROM product WHERE `name` LIKE '%:name%' AND category_id LIKE '%:category%' AND final_bid BETWEEN :price1 AND :price2", nativeQuery = true)
    Page<Product> findProductByOption(String name, String category, String price1, String price2, Pageable pageable);
}
