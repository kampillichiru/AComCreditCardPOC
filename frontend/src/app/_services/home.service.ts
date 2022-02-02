import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class HomeService {

    constructor(private http: HttpClient) {}

    public getJSON(){
        return this.http.get("./assets/mockData/cardsInfo.json");
    }

    
}