package com.deutsche.telco.repository;

import com.deutsche.telco.model.DevicePlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevicePlanRespository extends JpaRepository<DevicePlan, Integer> {
}
