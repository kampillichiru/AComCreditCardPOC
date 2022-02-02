package com.bank.credit.card.service;

import com.bank.credit.card.model.CustCreditCardApplication;
import com.bank.credit.card.repository.CustCreditCardApplicationRepository;
import com.bank.credit.card.resources.request.CustCreditCardApplicationReq;
import com.bank.credit.card.resources.view.CustCreditCardApplicationView;
import com.bank.credit.card.service.impl.CustCreditCardApplicationServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CustCreditCardApplicationServiceImplTest {


    @Autowired
    @InjectMocks
    private CustCreditCardApplicationServiceImpl custCreditCardApplicationService;
    @Mock
    private CustCreditCardApplicationRepository custCreditCardApplicationRepository;
    private CustCreditCardApplicationView custCreditCardApplicationView;
    private CustCreditCardApplicationReq custCreditCardApplicationReq;
    private CustCreditCardApplication custCreditCardApplication;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeEach
    public void setUp() {


        custCreditCardApplicationView = CustCreditCardApplicationView.builder().applicationStatus("SUBMITTED").firstName("Chiru").build();
        custCreditCardApplicationReq = CustCreditCardApplicationReq.builder().firstName("Chiru").build();
    }

    @AfterEach
    public void tearDown() {
        custCreditCardApplicationView = null;
        custCreditCardApplicationReq = null;
    }

    @Test
    public void testCustCreditCardApplicationById() {
        custCreditCardApplication = CustCreditCardApplication.builder().applicationStatus("SUBMITTED").firstName("Chiru").build();
        custCreditCardApplicationService.setCustCreditCardApplicationRepository(custCreditCardApplicationRepository);
        Mockito.when(
                custCreditCardApplicationRepository.findById(any())).thenReturn(Optional.ofNullable(custCreditCardApplication));
        Optional<CustCreditCardApplicationView> custCreditCardApplicationView = custCreditCardApplicationService.getCustCreditCardApplicationById(1L);

        assertTrue(custCreditCardApplicationView.isPresent());
        assertEquals("Chiru", custCreditCardApplicationView.get().getFirstName());
        assertEquals("SUBMITTED", custCreditCardApplicationView.get().getApplicationStatus());
    }

    @Test
    public void testAllCreditCardTypeList() {
        custCreditCardApplication = CustCreditCardApplication.builder().applicationStatus("SUBMITTED").firstName("Chiru").build();
        List<CustCreditCardApplication> custCreditCardApplicationList = new ArrayList<>();
        custCreditCardApplicationList.add(custCreditCardApplication);
        custCreditCardApplicationService.setCustCreditCardApplicationRepository(custCreditCardApplicationRepository);
        Mockito.when(
                custCreditCardApplicationRepository.findAll()).thenReturn(custCreditCardApplicationList);
        List<CustCreditCardApplicationView> custCreditCardApplicationViewList = custCreditCardApplicationService.getAllCustCreditCardApplicationList();

        assertEquals(1, custCreditCardApplicationViewList.size());
    }

    @Test
    public void testAllCreditCardTypeListNoRecords() {
        List<CustCreditCardApplication> custCreditCardApplicationList = new ArrayList<>();
        custCreditCardApplicationService.setCustCreditCardApplicationRepository(custCreditCardApplicationRepository);
        Mockito.when(
                custCreditCardApplicationRepository.findAll()).thenReturn(custCreditCardApplicationList);
        List<CustCreditCardApplicationView> custCreditCardApplicationViewList = custCreditCardApplicationService.getAllCustCreditCardApplicationList();

        assertEquals(0, custCreditCardApplicationViewList.size());
    }

    @Test
    public void testDeleteCreditCardType() {

        Mockito.doNothing().when(custCreditCardApplicationRepository).deleteById(any());
        custCreditCardApplicationService.deleteCustCreditCardApplication(1L);
        verify(custCreditCardApplicationRepository, times(1)).deleteById(1L);
    }
}
