package com.deutsche.telco.repository;

import com.deutsche.telco.model.Otp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OtpRepository extends JpaRepository<Otp, Long> {
    @Query("SELECT o FROM Otp o WHERE o.otp = :otp AND o.email = :email ORDER BY o.id DESC")
    Page<Otp> findLatestByOtpAndEmail(@Param("otp") Long otp, @Param("email") String email, Pageable pageable);
}
