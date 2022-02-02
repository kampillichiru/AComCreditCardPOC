package com.bank.credit.card.rest;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;

import com.bank.credit.card.resources.CustCreditCardApplicationResource;
import com.bank.credit.card.resources.request.CustCreditCardApplicationReq;
import com.bank.credit.card.resources.view.CustCreditCardApplicationView;
import com.bank.credit.card.service.CustCreditCardApplicationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
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

@RunWith(SpringRunner.class)
@WebMvcTest(value = CustCreditCardApplicationResource.class)
@WithMockUser
public class CustCreditCardApplicationReqResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    @Autowired
    private CustCreditCardApplicationService custCreditCardApplicationService;



    CustCreditCardApplicationView custCreditCardApplicationView = CustCreditCardApplicationView.builder().applicationStatus("SUBMITTED").build();


    String testJson = "{\"firstName\":\"Chiru\"}";

    @Test
    public void retrieveDetailsForCreditCarApp() throws Exception {

        List<CustCreditCardApplicationView> custCreditCardApplicationViewList = new ArrayList<>();
        custCreditCardApplicationViewList.add(custCreditCardApplicationView);

        Mockito.when(
                custCreditCardApplicationService.getAllCustCreditCardApplicationList()).thenReturn(custCreditCardApplicationViewList);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/custCreditCardApplicationList").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
        String expected = "[{\"applicationStatus\":\"SUBMITTED\"}]";


        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);
    }

    @Test
    public void retrieveDetailsForZeroCreditCarApp() throws Exception {

        List<CustCreditCardApplicationView> custCreditCardApplicationViewList = new ArrayList<>();
        custCreditCardApplicationViewList.add(custCreditCardApplicationView);

        Mockito.when(
                custCreditCardApplicationService.getAllCustCreditCardApplicationList()).thenReturn(null);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/custCreditCardApplicationList").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
        String expected = "";

        assertEquals(expected, result.getResponse().getContentAsString());
    }


    @Test
    public void createCreditCarAppAndReqSuccess() throws Exception {


        Mockito.when(
                custCreditCardApplicationService
                        .addCustCreditCardApplication(
                                any(CustCreditCardApplicationReq.class))).thenReturn(Optional.ofNullable(custCreditCardApplicationView));

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/custCreditCardApplication")
                .accept(MediaType.APPLICATION_JSON).content(testJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.CREATED.value(), response.getStatus());


    }

    @Test
    public void deletedCreditCarAppAndReqSuccess() throws Exception {


        Mockito.doNothing().when(custCreditCardApplicationService).deleteCustCreditCardApplication(any());

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/custCreditCardApplication/1")
                .accept(MediaType.APPLICATION_JSON).content(testJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.NO_CONTENT.value(), response.getStatus());


    }

    @Test
    public void createCreditCarAppAndReqFail() throws Exception {


        Mockito.when(
                custCreditCardApplicationService
                        .addCustCreditCardApplication(
                                any(CustCreditCardApplicationReq.class))).thenReturn(Optional.ofNullable(null));

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/custCreditCardApplication")
                .accept(MediaType.APPLICATION_JSON).content(testJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), response.getStatus());


    }

}
