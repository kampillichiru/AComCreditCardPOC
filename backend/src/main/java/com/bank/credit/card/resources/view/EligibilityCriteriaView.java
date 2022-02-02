package com.bank.credit.card.resources.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EligibilityCriteriaView implements Serializable {
    private Long id;
    @ApiModelProperty(
            value = "Age Limit",
            name = "ageLimit",
            dataType = "Integer",
            example = "35")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer ageLimit;
    @ApiModelProperty(
            value = "Annual Salary",
            name = "annualSalary",
            dataType = "Integer",
            example = "350000")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer annualSalary;
    @ApiModelProperty(
            value = "Credit Score",
            name = "creditScore",
            dataType = "Integer",
            example = "750")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer creditScore;
    @ApiModelProperty(
            value = "Residential Status",
            name = "residentialStatus",
            dataType = "String",
            example = "Indian")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String residentialStatus;
    @ApiModelProperty(
            value = "Type Of Employment",
            name = "typeOfEmployment",
            dataType = "String",
            example = "Permanent")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String typeOfEmployment;
}
