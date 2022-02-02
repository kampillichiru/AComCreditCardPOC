package com.bank.credit.card.service;


import com.bank.credit.card.resources.request.CreditCardTypeReq;
import com.bank.credit.card.resources.request.CustCreditCardApplicationReq;
import com.bank.credit.card.resources.view.CustCreditCardApplicationView;

import java.util.List;
import java.util.Optional;

public interface CustCreditCardApplicationService {

    Optional<CustCreditCardApplicationView> getCustCreditCardApplicationById(Long custCreditCardApplicationId);

    List<CustCreditCardApplicationView> getAllCustCreditCardApplicationList();

    Optional<CustCreditCardApplicationView> addCustCreditCardApplication(CustCreditCardApplicationReq custCreditCardApplicationReq);

    Optional<CustCreditCardApplicationView> updateCustCreditCardApplication(Long custCreditCardApplicationId, CustCreditCardApplicationReq custCreditCardApplicationReq);


    void deleteCustCreditCardApplication(Long custCreditCardApplicationId);
}
