package com.cards.dao;

import com.cards.entity.Cards;
import jakarta.persistence.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardsRepository extends JpaRepository<Cards, Long> {

    Optional<Cards> findByMobileNumber(String mobileNumber);

    Optional<Cards> findByCardNumber(String cardNumber);

    @Query("SELECT c FROM Cards c WHERE c.cardType = :cardType")
    Page<Cards> findByCardTypeWithPagination(@Param("cardType") String cardType, Pageable pageable);
}
