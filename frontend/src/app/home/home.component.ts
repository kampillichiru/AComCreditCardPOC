import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { first } from 'rxjs/operators';
import { HomeService } from '../_services/home.service';

@Component({ templateUrl: 'home.component.html' })
export class HomeComponent {
    imageSRC = 'assets/card1.PNG';
    cards;

    constructor(private router: Router,
      private homeService: HomeService) {
        this.homeService.getJSON()
        .pipe(first())
        .subscribe(cards => this.cards = cards);
    }

    selectedCard(selectedCard: any) {
        console.log(selectedCard.imagePrefix);
        this.router.navigate(['/login'],{state: {id:selectedCard.id,cardName:selectedCard.cardName}});
      }
}