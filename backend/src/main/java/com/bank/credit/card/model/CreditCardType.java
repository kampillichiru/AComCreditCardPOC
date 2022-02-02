package com.bank.credit.card.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CREDIT_CARD_TYPE")
public class CreditCardType implements Serializable {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long creditCardTypeId;
    private String cardName;
    private String basicOffers;
    private Integer pricing;
    private Integer annualFee;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "creditCardType", cascade = CascadeType.ALL)
    private List<EligibilityCriteria> eligibilityCriteria=new ArrayList<>();


}
