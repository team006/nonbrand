package com.nonbrand.nonbrand.repository;

import com.nonbrand.nonbrand.entity.product.Model;
import com.nonbrand.nonbrand.entity.product.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model,Long> {
    Model findByName(String name);
}
