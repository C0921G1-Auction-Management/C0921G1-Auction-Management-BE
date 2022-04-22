package vn.codegym.com.c0921g1_sprint2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.com.c0921g1_sprint2.model.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
