package com.bank.credit.card.resources.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

import static com.bank.credit.card.util.SystemConstants.EMAIL_REGEXP;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustCreditCardApplicationReq implements Serializable {


    @ApiModelProperty(
            value = "First Name",
            name = "firstName",
            dataType = "String",
            example = "Chiranjeevi",required = true)
    private String firstName;
    @ApiModelProperty(
            value = "Last Name",
            name = "lastName",
            dataType = "String",
            example = "Kampili",required = true)
    private String lastName;
    @ApiModelProperty(
            value = "Email",
            name = "lastName",
            dataType = "String",
            example = "hiru@gmail.com",required = true)
    @Pattern(regexp = EMAIL_REGEXP, message = "Invalid email address.")
    @NotNull(message = "Email must be provided.")
    private String email;
    @ApiModelProperty(
            value = "Phone Number",
            name = "phoneNumber",
            dataType = "String",
            example = "90008000",required = true)
    private String phoneNumber;
    @ApiModelProperty(
            value = "Age",
            name = "age",
            dataType = "Integer",
            example = "35",required = true)
    private Integer age;
    @ApiModelProperty(
            value = "Street Name",
            name = "street",
            dataType = "String",
            example = "HG Layout",required = true)
    private String street;
    @ApiModelProperty(
            value = "City Name",
            name = "city",
            dataType = "String",
            example = "Bangalore",required = true)
    private String city;
    @ApiModelProperty(
            value = "State Name",
            name = "state",
            dataType = "String",
            example = "KA",required = true)
    private String state;
    @ApiModelProperty(
            value = "Zip Code",
            name = "zipCode",
            dataType = "String",
            example = "580002",required = true)
    private String zipCode;
    @ApiModelProperty(
            value = "Credit Card Name",
            name = "cardName",
            dataType = "String",
            example = "Regalia",required = true)
    private String country;
    @ApiModelProperty(
            value = "Annual Salary",
            name = "annualSalary",
            dataType = "Integer",
            example = "300000",required = true)
    private Integer annualSalary;
    @ApiModelProperty(
            value = "Credit Score",
            name = "creditScore",
            dataType = "Integer",
            example = "950",required = true)
    private Integer creditScore;
    @ApiModelProperty(
            value = "Residential Status",
            name = "residentialStatus",
            dataType = "String",
            example = "Indian",required = true)
    private String residentialStatus;
    @ApiModelProperty(
            value = "Type Of Employment",
            name = "typeOfEmployment",
            dataType = "String",
            example = "Permanent",required = true)
    private String typeOfEmployment;
    @ApiModelProperty(
            value = "Credit Card Type Id",
            name = "creditCardTypeId",
            dataType = "String",
            example = "1",required = true)
    private Long creditCardTypeId;


}
