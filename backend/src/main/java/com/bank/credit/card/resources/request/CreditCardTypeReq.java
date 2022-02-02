package com.bank.credit.card.resources.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardTypeReq implements Serializable {


    @ApiModelProperty(
            value = "Credit Card Name",
            name = "cardName",
            dataType = "String",
            example = "Regalia",
            required = true)
    private String cardName;
    @ApiModelProperty(
            value = "Basic Offers",
            name = "basicOffers",
            dataType = "String",
            example = "Assured flat 25% off at 2000+ premium restaurants",
            required = true)
    private String basicOffers;
    @ApiModelProperty(
            value = "Processing Fee",
            name = "pricing",
            dataType = "Integer",
            example = "0",
            required = true)
    private Integer pricing;
    @ApiModelProperty(
            value = "Annual Fee",
            name = "annualFee",
            dataType = "Integer",
            example = "1500",
            required = true)
    private Integer annualFee;
    private List<EligibilityCriteriaReq> eligibilityCriterionReqs;


}
