package com.nonbrand.nonbrand.repository;

import com.nonbrand.nonbrand.entity.product.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type,Long> {
    Type findByName(String name);
    Type findTypeById(Long id);
}
