package com.bank.credit.card.resources;

import com.bank.credit.card.resources.request.CustCreditCardApplicationReq;

import com.bank.credit.card.resources.view.CustCreditCardApplicationView;
import com.bank.credit.card.service.CustCreditCardApplicationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Api(value = "CustCreditCardApplicationResource", description = "REST Apis related to CreditCard Application Entity!!!!")

@Slf4j
@RestController
public class CustCreditCardApplicationResource {
    @Autowired
    private CustCreditCardApplicationService custCreditCardApplicationService;


    @ApiOperation(value = "Submit credit card application for a customer", response = Iterable.class, tags = "CreateUpDateDelete")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @PostMapping("/custCreditCardApplication")
    public ResponseEntity<CustCreditCardApplicationView> createCustCreditCardApplication(
            @Valid @RequestBody CustCreditCardApplicationReq custCreditCardApplicationReq) {

        log.info("Creating creditCardTypeReq, name {}", custCreditCardApplicationReq.toString());

        try {
            Optional<CustCreditCardApplicationView> creditCardTypeView = custCreditCardApplicationService
                    .addCustCreditCardApplication(custCreditCardApplicationReq);
            if (creditCardTypeView.isPresent()) {
                return new ResponseEntity<>(creditCardTypeView.get(), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @ApiOperation(value = "Update credit card application for a customer", response = Iterable.class, tags = "CreateUpDateDelete")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @PutMapping("/custCreditCardApplication/{custCreditCardApplicationId}")
    public ResponseEntity<CustCreditCardApplicationView> updateCustCreditCardApplication(
            @PathVariable @NonNull Long custCreditCardApplicationId,
            @Valid @RequestBody CustCreditCardApplicationReq custCreditCardApplicationReq) {

        log.info("Updating custCreditCardApplicationId, custCreditCardApplicationReq {}, {}", custCreditCardApplicationId,
                custCreditCardApplicationReq.toString());
        Optional<CustCreditCardApplicationView> creditCardTypeView = custCreditCardApplicationService
                .updateCustCreditCardApplication(custCreditCardApplicationId, custCreditCardApplicationReq);

        if (creditCardTypeView.isPresent()) {
            return new ResponseEntity<>(creditCardTypeView.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Fetch credit card application of a customer", response = Iterable.class, tags = "Fetch")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping("/custCreditCardApplication/{custCreditCardApplicationId}")
    public ResponseEntity<CustCreditCardApplicationView> getCustCreditCardApplicationById(@PathVariable @NonNull Long custCreditCardApplicationId) {

        log.info("Getting CustCreditCardApplicationReq, id {}", custCreditCardApplicationId);

        Optional<CustCreditCardApplicationView> creditCardType = custCreditCardApplicationService
                .getCustCreditCardApplicationById(custCreditCardApplicationId);

        if (creditCardType.isPresent()) {
            return new ResponseEntity<>(creditCardType.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @ApiOperation(value = "Fetch All credit card application of  customers", response = Iterable.class, tags = "Fetch")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping("/custCreditCardApplicationList")
    public ResponseEntity<List<CustCreditCardApplicationView>> listCustCreditCardApplications() {

        log.info("Getting all creditCardType");

        try {
            List<CustCreditCardApplicationView> creditCardTypeViewList = custCreditCardApplicationService
                    .getAllCustCreditCardApplicationList();


            if (creditCardTypeViewList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(creditCardTypeViewList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @ApiOperation(value = "Delete  credit card application of a customers", response = Iterable.class, tags = "CreateUpDateDelete")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @DeleteMapping("/custCreditCardApplication/{custCreditCardApplicationId}")
    public ResponseEntity<Void> deleteCustCreditCardApplication(@PathVariable @NonNull Long custCreditCardApplicationId) {

        log.info("Deleting custCreditCardApplicationId, id {}", custCreditCardApplicationId);

        try {
            custCreditCardApplicationService.deleteCustCreditCardApplication(custCreditCardApplicationId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
