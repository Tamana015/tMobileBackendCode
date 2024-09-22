package com.deutsche.telco.repository;

import com.deutsche.telco.model.RechargePlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RechargePlanRepository extends JpaRepository<RechargePlan, Integer> {
}
