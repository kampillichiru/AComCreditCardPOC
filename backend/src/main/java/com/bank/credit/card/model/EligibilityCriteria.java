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
@Table(name = "ELIGIBILITY_CRITERIA")
public class EligibilityCriteria implements Serializable {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Integer ageLimit;
    private Integer annualSalary;
    private Integer creditScore;
    private String  residentialStatus;
    private String  typeOfEmployment;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "creditCardTypeId", referencedColumnName = "creditCardTypeId")
    private CreditCardType creditCardType;
}
