package com.nonbrand.nonbrand.repository;

import com.nonbrand.nonbrand.entity.product.Category;
import com.nonbrand.nonbrand.entity.product.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findByName(String name);

}
