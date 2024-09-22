package com.deutsche.telco.repository;

import com.deutsche.telco.model.TokenBlacklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenBlacklistRepository extends JpaRepository<TokenBlacklist, Long> {
    // Custom query methods can be added here if needed
    TokenBlacklist findByToken(String token);
}
