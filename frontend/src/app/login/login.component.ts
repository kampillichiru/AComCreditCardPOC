import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormControl,FormGroup, Validators } from '@angular/forms';
import { Location } from '@angular/common';
import { first } from 'rxjs/operators';

@Component({ templateUrl: 'login.component.html' })
export class LoginComponent implements OnInit {
    cardDetails: any;
    cardApplicationForm: FormGroup;
    loading = false;
    submitted = false;
    returnUrl: string;

    constructor(
        private fb: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private location: Location
    ) { }

    ngOnInit() {
        this.cardDetails = this.location.getState();
        this.cardApplicationForm = this.fb.group({
            'cardId': new FormControl(''),
            'firstName': ['',Validators.required],
            'lastName': ['',Validators.required],
            'email': ['',Validators.required],
            'phoneNumber': ['',Validators.required],
            'address': ['',Validators.required],
            'creditScore': ['',Validators.required],
            'annualSalary': ['',Validators.required],
            'residentialSatus': ['',Validators.required],
            'typeOfEmployment': ['',Validators.required]
          });

        // get return url from route parameters or default to '/'
        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
    }

    // convenience getter for easy access to form fields

    onSubmit(formData) {
        this.submitted = true;
        console.log(formData);
        alert("Submitted Succesfully");
        this.router.navigate(['/home']);
    }
}