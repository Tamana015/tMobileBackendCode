package com.deutsche.telco.repository;

import com.deutsche.telco.model.ParentCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentCartRepository extends JpaRepository<ParentCart, Integer> {
}
