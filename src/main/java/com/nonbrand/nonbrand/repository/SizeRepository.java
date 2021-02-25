package com.nonbrand.nonbrand.repository;

import com.nonbrand.nonbrand.entity.product.Model;
import com.nonbrand.nonbrand.entity.product.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeRepository extends JpaRepository<Size,Long> {
    Size findByName(String name);
}
