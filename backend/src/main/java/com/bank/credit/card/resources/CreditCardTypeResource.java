package com.bank.credit.card.resources;

import com.bank.credit.card.resources.request.CreditCardTypeReq;
import com.bank.credit.card.resources.view.CreditCardTypeView;
import com.bank.credit.card.service.CreditCardTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.NonNull;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Api(value = "CreditCardTypeResource", description = "REST Apis related to CreditCard Type Entity!!!!")
@Slf4j
@RestController
public class CreditCardTypeResource {

    @Autowired
    private CreditCardTypeService creditCardTypeService;



    @ApiOperation(value = "Create Credit Card Type and Eligible Criteria", response = Iterable.class, tags = "CreateUpDateDelete")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @PostMapping("/creditCardType")
    public ResponseEntity<CreditCardTypeView> createCreditCardType(
            @Valid @RequestBody CreditCardTypeReq creditCardTypeReq) {

        log.info("Creating creditCardTypeReq, name {}", creditCardTypeReq.toString());

        try {
            Optional<CreditCardTypeView> creditCardTypeView = creditCardTypeService.addCreditCardType(creditCardTypeReq);
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

    @ApiOperation(value = "Update Credit Card Type and Eligible Criteria", response = Iterable.class, tags = "CreateUpDateDelete")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @PutMapping("/creditCardType/{creditCardTypeId}")
    public ResponseEntity<CreditCardTypeView> updateCreditCardType(
            @PathVariable @NonNull Long creditCardTypeId,
            @Valid @RequestBody CreditCardTypeReq creditCardTypeReq) {

        log.info("Updating CreditCardTypeReq, name {}, {}", creditCardTypeId, creditCardTypeReq.toString());
        Optional<CreditCardTypeView> creditCardTypeView = creditCardTypeService.updateCreditCardType(creditCardTypeId, creditCardTypeReq);

        if (creditCardTypeView.isPresent()) {
            return new ResponseEntity<>(creditCardTypeView.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Fetch Credit Card Type and Eligible Criteria by Id", response = Iterable.class, tags = "Fetch")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping("/creditCardType/{creditCardTypeId}")
    public ResponseEntity<CreditCardTypeView> getCreditCardTypeById(@PathVariable @NonNull Long creditCardTypeId) {

        log.info("Getting CreditCardTypeReq, id {}", creditCardTypeId);

        Optional<CreditCardTypeView> creditCardType = creditCardTypeService.getCreditCardTypeById(creditCardTypeId);

        if (creditCardType.isPresent()) {
            return new ResponseEntity<>(creditCardType.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @ApiOperation(value = "Fetch All Credit Card Type and Eligible Criteria", response = Iterable.class, tags = "Fetch")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping("/creditCardTypeList")
    public ResponseEntity<List<CreditCardTypeView>> listCreditCardTypes() {

        log.info("Getting all creditCardType");

        try {
            List<CreditCardTypeView> creditCardTypeViewList = creditCardTypeService.getAllCreditCardTypeList();


            if (creditCardTypeViewList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(creditCardTypeViewList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @ApiOperation(value = "Delete Credit Card Type and Eligible Criteria", response = Iterable.class, tags = "CreateUpDateDelete")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @DeleteMapping("/creditCardType/{creditCardTypeId}")
    public ResponseEntity<Void> deleteCreditCardType(@PathVariable @NonNull Long creditCardTypeId) {

        log.info("Deleting creditCardTypeId, id {}", creditCardTypeId);

        try {
            creditCardTypeService.deleteCreditCardType(creditCardTypeId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
