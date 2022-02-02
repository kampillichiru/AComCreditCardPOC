package com.bank.credit.card.repository;


import com.bank.credit.card.model.CustCreditCardApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustCreditCardApplicationRepository extends JpaRepository<CustCreditCardApplication, Long> {
}