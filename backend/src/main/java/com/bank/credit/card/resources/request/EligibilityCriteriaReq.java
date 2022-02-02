package com.bank.credit.card.resources.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EligibilityCriteriaReq implements Serializable {

    @ApiModelProperty(
            value = "0",
            name = "id",
            dataType = "Integer",
            example = "0")
    private Integer id;
    @ApiModelProperty(
            value = "Age Limit",
            name = "ageLimit",
            dataType = "Integer",
            example = "35")
    private Integer ageLimit;
    @ApiModelProperty(
            value = "Annual Salary",
            name = "annualSalary",
            dataType = "Integer",
            example = "350000")
    private Integer annualSalary;
    @ApiModelProperty(
            value = "Credit Score",
            name = "creditScore",
            dataType = "Integer",
            example = "750")
    private Integer creditScore;
    @ApiModelProperty(
            value = "Residential Status",
            name = "residentialStatus",
            dataType = "String",
            example = "Indian")
    private String  residentialStatus;
    @ApiModelProperty(
            value = "Type Of Employment",
            name = "typeOfEmployment",
            dataType = "String",
            example = "Permanent")
    private String  typeOfEmployment;
}
