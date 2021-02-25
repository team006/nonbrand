package com.nonbrand.nonbrand.repository;

import com.nonbrand.nonbrand.entity.product.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
}
