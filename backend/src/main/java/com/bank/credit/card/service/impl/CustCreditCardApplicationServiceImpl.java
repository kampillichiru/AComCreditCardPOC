package com.bank.credit.card.service.impl;

import com.bank.credit.card.model.CustCreditCardApplication;
import com.bank.credit.card.repository.CustCreditCardApplicationRepository;
import com.bank.credit.card.resources.request.CustCreditCardApplicationReq;
import com.bank.credit.card.resources.view.CustCreditCardApplicationView;
import com.bank.credit.card.service.CustCreditCardApplicationService;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.bank.credit.card.util.CreditCardConstants.SUBMITTED;


@Service
public class CustCreditCardApplicationServiceImpl implements CustCreditCardApplicationService {


    @Autowired @Setter
    private CustCreditCardApplicationRepository custCreditCardApplicationRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public Optional<CustCreditCardApplicationView> getCustCreditCardApplicationById(Long custCreditCardApplicationId) {
        return Optional.of(getUpdateCustCreditCardApplicationView(
                custCreditCardApplicationRepository.findById(custCreditCardApplicationId).orElse(null)));
    }

    @Override
    public List<CustCreditCardApplicationView> getAllCustCreditCardApplicationList() {
        List<CustCreditCardApplication> custCreditCardApplicationList = custCreditCardApplicationRepository.findAll();
        List<CustCreditCardApplicationView> custCreditCardApplicationViewList = new ArrayList<>();

        custCreditCardApplicationList.forEach(custCreditCardApplication ->
        {
            custCreditCardApplicationViewList.add(getUpdateCustCreditCardApplicationView(custCreditCardApplication));

        });
        return custCreditCardApplicationViewList;
    }

    @Override
    public Optional<CustCreditCardApplicationView> addCustCreditCardApplication(CustCreditCardApplicationReq custCreditCardApplicationReq) {
        CustCreditCardApplication custCreditCardApplication = custCreditCardApplicationRepository.save(
                modelMapper.map(custCreditCardApplicationReq, CustCreditCardApplication.class));
        return Optional.of(getUpdateCustCreditCardApplicationView(custCreditCardApplication));
    }

    @Override
    public Optional<CustCreditCardApplicationView> updateCustCreditCardApplication(Long custCreditCardApplicationId, CustCreditCardApplicationReq custCreditCardApplicationReq) {
        return Optional.empty();
    }

    @Override
    public void deleteCustCreditCardApplication(Long custCreditCardApplicationId) {
        custCreditCardApplicationRepository.deleteById(custCreditCardApplicationId);

    }

    private CustCreditCardApplicationView getUpdateCustCreditCardApplicationView(CustCreditCardApplication updatedCustCreditCardApplication) {

        if (updatedCustCreditCardApplication == null) {

            return null;
        }

        return CustCreditCardApplicationView.builder()
                .applicationId(updatedCustCreditCardApplication.getApplicationId())
                .applicationStatus(SUBMITTED)
                .firstName(updatedCustCreditCardApplication.getFirstName())
                .lastName(updatedCustCreditCardApplication.getLastName())
                .email(updatedCustCreditCardApplication.getEmail())
                .phoneNumber(updatedCustCreditCardApplication.getPhoneNumber())
                .annualSalary(updatedCustCreditCardApplication.getAnnualSalary())
                .creditScore(updatedCustCreditCardApplication.getCreditScore())
                .residentialStatus(updatedCustCreditCardApplication.getResidentialStatus())
                .typeOfEmployment(updatedCustCreditCardApplication.getTypeOfEmployment())
                .street(updatedCustCreditCardApplication.getStreet())
                .state(updatedCustCreditCardApplication.getState())
                .zipCode(updatedCustCreditCardApplication.getZipCode())
                .country(updatedCustCreditCardApplication.getCountry())
                .build();

    }

}
