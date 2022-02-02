package com.bank.credit.card.resources.view;

import com.bank.credit.card.model.EligibilityCriteria;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardTypeView implements Serializable {


    private Long creditCardTypeId;
    @ApiModelProperty(
            value = "Credit Card Name",
            name = "cardName",
            dataType = "String",
            example = "Regalia")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String cardName;
    @ApiModelProperty(
            value = "Basic Offers",
            name = "basicOffers",
            dataType = "String",
            example = "Assured flat 25% off at 2000+ premium restaurants")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String basicOffers;
    @ApiModelProperty(
            value = "Processing Fee",
            name = "pricing",
            dataType = "Integer",
            example = "0")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer pricing;
   @ApiModelProperty(
            value = "Annual Fee",
            name = "annualFee",
            dataType = "Integer",
            example = "1500")
   @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer annualFee;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<EligibilityCriteriaView> eligibilityCriteriaList;


}
