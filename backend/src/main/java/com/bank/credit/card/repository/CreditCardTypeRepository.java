package com.bank.credit.card.repository;

import com.bank.credit.card.model.CreditCardType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardTypeRepository extends JpaRepository<CreditCardType, Long> {

}
