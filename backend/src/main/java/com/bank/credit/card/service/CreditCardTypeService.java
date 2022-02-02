package com.bank.credit.card.service;


import com.bank.credit.card.resources.request.CreditCardTypeReq;
import com.bank.credit.card.resources.view.CreditCardTypeView;

import java.util.List;
import java.util.Optional;

public interface CreditCardTypeService {

    Optional<CreditCardTypeView> getCreditCardTypeById(Long creditCardTypeId);

    List<CreditCardTypeView> getAllCreditCardTypeList();

    Optional<CreditCardTypeView> addCreditCardType(CreditCardTypeReq creditCardTypeReq);

    Optional<CreditCardTypeView> updateCreditCardType(Long creditCardTypeId, CreditCardTypeReq creditCardTypeReq);


    void deleteCreditCardType(Long creditCardTypeId);
}
