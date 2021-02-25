package com.nonbrand.nonbrand.repository;

import com.nonbrand.nonbrand.entity.product.Color;
import com.nonbrand.nonbrand.entity.product.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<Color , Long> {
    Color findByName(String name);
}
