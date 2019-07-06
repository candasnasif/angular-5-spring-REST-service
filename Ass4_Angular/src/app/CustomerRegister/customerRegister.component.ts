import { Component,  Injectable } from '@angular/core';
import { OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {LoginService} from "../login.service";
import { User } from '../User';
import { HttpEventType } from '@angular/common/http';
import { Customer } from '../Customer';
import {RegisterService} from '../register.service';

@Component({
    selector: 'customerRegister-select',
    templateUrl: 'customerRegister.component.html',
    styleUrls: ['customerRegister.component.css'],
})

export class CustomerRegisterComponent {
    customer : Customer  = new Customer();   
    

 constructor(private router: Router, private RegisterService:RegisterService) { }
  
    
     customerRegister() {
         console.log("girdi");
         this.RegisterService.customerRegister(this.customer);   
         this.router.navigate(['/login']);

    }

}