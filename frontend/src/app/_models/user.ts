
export class UserApplicationDetails {
    cardId: number;
    firstName: string;
    lastName: string;
    email: string;
    phoneNumber: number;  
    address: string;
    creditScore: number;  
    annualSalary: number;  
    residentialSatus: string;  
    typeOfEmployment: string;  
}

export class CardsInfo {
    cardsInfo: ReadonlyArray<CardInfo>;
}

export class CardInfo {
    creditCardTypeId: number;
    cardName: string;
    basicOffers: string;
    pricing: number;
    annualFee: number;  
    eligibilityCriteriaList: ReadonlyArray<EligibilityCriteria>;
}

export class EligibilityCriteria {
    id: number;
    ageLimit: number;
    annualSalary: number;
    creditScore: number;
    residentialStatus: string;  
    typeOfEmployment: string;
}