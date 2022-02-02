package com.bank.credit.card.service.impl;


import com.bank.credit.card.model.CreditCardType;
import com.bank.credit.card.model.EligibilityCriteria;
import com.bank.credit.card.resources.request.CreditCardTypeReq;
import com.bank.credit.card.resources.request.EligibilityCriteriaReq;
import com.bank.credit.card.resources.view.CreditCardTypeView;
import com.bank.credit.card.repository.CreditCardTypeRepository;
import com.bank.credit.card.resources.view.EligibilityCriteriaView;
import com.bank.credit.card.service.CreditCardTypeService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CreditCardTypeServiceImpl implements CreditCardTypeService {

    @Autowired
    @Setter
    private CreditCardTypeRepository creditCardTypeRepository;


    @Override
    public Optional<CreditCardTypeView> getCreditCardTypeById(Long creditCardTypeId) {

        return Optional.of(getUpdateCreditCardTypeView(creditCardTypeRepository.findById(creditCardTypeId).orElse(null)));
    }

    @Override
    public List<CreditCardTypeView> getAllCreditCardTypeList() {
        List<CreditCardType> creditCardTypeList = creditCardTypeRepository.findAll();
        List<CreditCardTypeView> creditCardTypeViewList = new ArrayList<>();

        creditCardTypeList.forEach(creditCardType ->
        {
            creditCardTypeViewList.add(getUpdateCreditCardTypeView(creditCardType));

        });
        return creditCardTypeViewList;
    }

    @Override
    public Optional<CreditCardTypeView> addCreditCardType(CreditCardTypeReq creditCardTypeReq) {

        CreditCardType creditCardType = CreditCardType.builder()
                .cardName(creditCardTypeReq.getCardName())
                .annualFee(creditCardTypeReq.getAnnualFee())
                .pricing(creditCardTypeReq.getPricing())
                .basicOffers(creditCardTypeReq.getBasicOffers())
                .build();

        List<EligibilityCriteria> eligibilityCriteriaList = new ArrayList<>();

        for (EligibilityCriteriaReq eligibilityCriteriaReq : creditCardTypeReq.getEligibilityCriterionReqs()) {
            EligibilityCriteria eligibilityCriteria = EligibilityCriteria.builder()
                    .ageLimit(eligibilityCriteriaReq.getAgeLimit())
                    .annualSalary(eligibilityCriteriaReq.getAnnualSalary())
                    .creditScore(eligibilityCriteriaReq.getCreditScore())
                    .creditCardType(creditCardType)
                    .residentialStatus(eligibilityCriteriaReq.getResidentialStatus())
                    .typeOfEmployment(eligibilityCriteriaReq.getTypeOfEmployment())
                    .build();
            eligibilityCriteriaList.add(eligibilityCriteria);
        }

        creditCardType.setEligibilityCriteria(eligibilityCriteriaList);

        CreditCardType updateCreditCardType = creditCardTypeRepository.save(creditCardType);
        return Optional.of(getUpdateCreditCardTypeView(updateCreditCardType));
    }

    @Override
    public Optional<CreditCardTypeView> updateCreditCardType(Long creditCardTypeId, CreditCardTypeReq creditCardTypeReq) {
        Optional<CreditCardType> creditCardType = creditCardTypeRepository.findById(creditCardTypeId);

        if (creditCardType.isPresent()) {
            creditCardType.get().setCardName(creditCardTypeReq.getCardName());
            creditCardType.get().setAnnualFee(creditCardTypeReq.getAnnualFee());
            creditCardType.get().setPricing(creditCardTypeReq.getPricing());
            creditCardType.get().setBasicOffers(creditCardTypeReq.getBasicOffers());
            List<EligibilityCriteria> updatedEligibilityCriteriaList = new ArrayList<>();
            List<EligibilityCriteria> eligibilityCriteriaList = creditCardType.get().getEligibilityCriteria();


            if (creditCardTypeReq.getEligibilityCriterionReqs() != null) {
                for (EligibilityCriteriaReq eligibilityCriteriaReq : creditCardTypeReq.getEligibilityCriterionReqs()) {

                    Optional<EligibilityCriteria> eligibilityCriteria = eligibilityCriteriaList
                            .stream()
                            .filter(e -> e.getId().intValue() == eligibilityCriteriaReq.getId())
                            .findFirst();
                    if (eligibilityCriteria.isPresent()) {
                        eligibilityCriteria.get().setAgeLimit(eligibilityCriteriaReq.getAgeLimit());
                        eligibilityCriteria.get().setAnnualSalary(eligibilityCriteriaReq.getAnnualSalary());
                        eligibilityCriteria.get().setCreditScore(eligibilityCriteriaReq.getCreditScore());
                        eligibilityCriteria.get().setCreditCardType(creditCardType.get());
                        eligibilityCriteria.get().setResidentialStatus(eligibilityCriteriaReq.getResidentialStatus());
                        eligibilityCriteria.get().setTypeOfEmployment(eligibilityCriteriaReq.getTypeOfEmployment());
                        updatedEligibilityCriteriaList.add(eligibilityCriteria.get());
                        creditCardType.get().setEligibilityCriteria(updatedEligibilityCriteriaList);
                    }
                }


            }
        }
        CreditCardType updateCreditCardType = creditCardTypeRepository.save(creditCardType.get());
        return Optional.of(getUpdateCreditCardTypeView(updateCreditCardType));
    }

    private CreditCardTypeView getUpdateCreditCardTypeView(CreditCardType updateCreditCardType) {

        if (updateCreditCardType == null) {

            return null;
        }

        CreditCardTypeView creditCardTypeView = CreditCardTypeView.builder()
                .creditCardTypeId(updateCreditCardType.getCreditCardTypeId())
                .cardName(updateCreditCardType.getCardName())
                .annualFee(updateCreditCardType.getAnnualFee())
                .pricing(updateCreditCardType.getPricing()).build();

        List<EligibilityCriteriaView> eligibilityCriteriaList = new ArrayList<>();
        if (updateCreditCardType.getEligibilityCriteria() != null) {
            for (EligibilityCriteria eligibilityCriteria : updateCreditCardType.getEligibilityCriteria()) {
                EligibilityCriteriaView eligibilityCriteriaRes = EligibilityCriteriaView.builder()
                        .id(eligibilityCriteria.getId())
                        .ageLimit(eligibilityCriteria.getAgeLimit())
                        .annualSalary(eligibilityCriteria.getAnnualSalary())
                        .creditScore(eligibilityCriteria.getCreditScore())
                        .residentialStatus(eligibilityCriteria.getResidentialStatus())
                        .typeOfEmployment(eligibilityCriteria.getTypeOfEmployment())
                        .build();
                eligibilityCriteriaList.add(eligibilityCriteriaRes);
            }
            creditCardTypeView.setEligibilityCriteriaList(eligibilityCriteriaList);
        }
        return creditCardTypeView;
    }


    @Override
    public void deleteCreditCardType(Long creditCardTypeId) {
        creditCardTypeRepository.deleteById(creditCardTypeId);
    }
}
