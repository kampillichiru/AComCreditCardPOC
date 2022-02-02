package com.bank.credit.card.service;

import com.bank.credit.card.model.CreditCardType;
import com.bank.credit.card.repository.CreditCardTypeRepository;
import com.bank.credit.card.resources.request.CreditCardTypeReq;
import com.bank.credit.card.resources.view.CreditCardTypeView;
import com.bank.credit.card.service.impl.CreditCardTypeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CreditCardTypeServiceImplTest {


    @Autowired
    @InjectMocks
    private CreditCardTypeServiceImpl creditCardTypeService;
    @Mock
    private CreditCardTypeRepository creditCardTypeRepository;
    private CreditCardTypeView creditCardTypeView;
    private CreditCardTypeReq creditCardTypeReq;
    private CreditCardType updateCreditCardType;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeEach
    public void setUp() {


        creditCardTypeView = CreditCardTypeView.builder().creditCardTypeId(1L).cardName("Regilla").build();
        creditCardTypeReq = CreditCardTypeReq.builder().cardName("Regilla").build();
    }

    @AfterEach
    public void tearDown() {
        creditCardTypeView = null;
        creditCardTypeReq = null;
    }

    @Test
    public void testCreditCardTypeById() {
        updateCreditCardType = CreditCardType.builder().creditCardTypeId(1L).cardName("Regilla").build();
        creditCardTypeService.setCreditCardTypeRepository(creditCardTypeRepository);
        Mockito.when(
                creditCardTypeRepository.findById(any())).thenReturn(Optional.ofNullable(updateCreditCardType));
        Optional<CreditCardTypeView> creditCardTypeView = creditCardTypeService.getCreditCardTypeById(1L);

        assertTrue(creditCardTypeView.isPresent());
        assertEquals("Regilla", creditCardTypeView.get().getCardName());
    }

    @Test
    public void testAllCreditCardTypeList() {
        updateCreditCardType = CreditCardType.builder().creditCardTypeId(1L).cardName("Regilla").build();
        List<CreditCardType> creditCardTypeList = new ArrayList<>();
        creditCardTypeList.add(updateCreditCardType);
        creditCardTypeService.setCreditCardTypeRepository(creditCardTypeRepository);
        Mockito.when(
                creditCardTypeRepository.findAll()).thenReturn(creditCardTypeList);
        List<CreditCardTypeView> creditCardTypeViewList = creditCardTypeService.getAllCreditCardTypeList();

        assertEquals(1, creditCardTypeViewList.size());
    }

    @Test
    public void testAllCreditCardTypeListNoRecords() {
        List<CreditCardType> creditCardTypeList = new ArrayList<>();
        creditCardTypeService.setCreditCardTypeRepository(creditCardTypeRepository);
        Mockito.when(
                creditCardTypeRepository.findAll()).thenReturn(creditCardTypeList);
        List<CreditCardTypeView> creditCardTypeViewList = creditCardTypeService.getAllCreditCardTypeList();

        assertEquals(0, creditCardTypeViewList.size());
    }

    @Test
    public void testDeleteCreditCardType() {

        Mockito.doNothing().when(creditCardTypeRepository).deleteById(any());
       creditCardTypeService.deleteCreditCardType(1L);
        verify(creditCardTypeRepository, times(1)).deleteById(1L);
    }


}
