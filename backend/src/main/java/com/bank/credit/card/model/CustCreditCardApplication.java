package com.bank.credit.card.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CUST_CREDIT_CARD_APPLICATION")
public class CustCreditCardApplication implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long applicationId;
    private String applicationStatus;
    private Long creditCardTypeId;
    private Integer annualSalary;
    private Integer creditScore;
    private String  residentialStatus;
    private String  typeOfEmployment;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Integer age;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;


}
