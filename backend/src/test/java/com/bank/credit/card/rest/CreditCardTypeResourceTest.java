package com.bank.credit.card.rest;

import com.bank.credit.card.resources.CreditCardTypeResource;
import com.bank.credit.card.resources.request.CreditCardTypeReq;
import com.bank.credit.card.resources.view.CreditCardTypeView;
import com.bank.credit.card.service.CreditCardTypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CreditCardTypeResource.class)
@WithMockUser
public class CreditCardTypeResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    @Autowired
    private CreditCardTypeService creditCardTypeService;


    CreditCardTypeView creditCardTypeView = CreditCardTypeView.builder().creditCardTypeId(1L).cardName("Regilla").build();


    String testJson = "{\"cardName\":\"Regilla\", \"basicOffers\":\"Test\"}";

    @Test
    public void retrieveDetailsForCreditCardType() throws Exception {

        List<CreditCardTypeView> creditCardTypeViewList = new ArrayList<>();
        creditCardTypeViewList.add(creditCardTypeView);

        Mockito.when(
                creditCardTypeService.getAllCreditCardTypeList()).thenReturn(creditCardTypeViewList);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/creditCardTypeList").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
        String expected = "[{\"creditCardTypeId\":1,\"cardName\":\"Regilla\"}]";


        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);
    }

    @Test
    public void retrieveDetailsForZeroCreditCardType() throws Exception {

        List<CreditCardTypeView> creditCardTypeViewList = new ArrayList<>();
        creditCardTypeViewList.add(creditCardTypeView);

        Mockito.when(
                creditCardTypeService.getAllCreditCardTypeList()).thenReturn(null);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/creditCardTypeList").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
        String expected = "";

        assertEquals(expected, result.getResponse().getContentAsString());
    }


    @Test
    public void createCreditCardTypeAndReqSuccess() throws Exception {


        Mockito.when(
                creditCardTypeService
                        .addCreditCardType(
                                any(CreditCardTypeReq.class))).thenReturn(Optional.ofNullable(creditCardTypeView));

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/creditCardType")
                .accept(MediaType.APPLICATION_JSON).content(testJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.CREATED.value(), response.getStatus());


    }

    @Test
    public void deletedCreditCardTypeAndReqSuccess() throws Exception {


        Mockito.doNothing().when(creditCardTypeService).deleteCreditCardType(any());

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/creditCardType/1")
                .accept(MediaType.APPLICATION_JSON).content(testJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.NO_CONTENT.value(), response.getStatus());


    }

    @Test
    public void createCreditCardTypeAndReqFail() throws Exception {


        Mockito.when(
                creditCardTypeService
                        .addCreditCardType(
                                any(CreditCardTypeReq.class))).thenReturn(Optional.ofNullable(null));

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/creditCardType")
                .accept(MediaType.APPLICATION_JSON).content(testJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), response.getStatus());


    }

}
