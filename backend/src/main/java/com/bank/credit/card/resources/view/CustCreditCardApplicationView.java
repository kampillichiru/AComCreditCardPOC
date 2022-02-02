package com.bank.credit.card.resources.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustCreditCardApplicationView implements Serializable {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long applicationId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String applicationStatus;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String firstName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String lastName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String email;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String phoneNumber;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer age;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer annualSalary;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer creditScore;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String residentialStatus;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String typeOfEmployment;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String street;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String city;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String state;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String zipCode;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String country;


}
