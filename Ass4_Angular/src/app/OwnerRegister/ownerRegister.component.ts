import { Component,  Injectable } from '@angular/core';
import { OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {LoginService} from "../login.service";
import { User } from '../User';
import { HttpEventType } from '@angular/common/http';
import { Owner } from '../Owner';
import {RegisterService} from '../register.service';

@Component({
    selector: 'ownerRegister-select',
    templateUrl: 'ownerRegister.component.html',
    styleUrls: ['ownerRegister.component.css'],
})

export class OwnerRegisterComponent {
    owner : Owner = new Owner();
    

 constructor(private router: Router, private RegisterService:RegisterService) { }
  
         ownerRegister() {
         this.RegisterService.ownerRegister(this.owner); 
         this.router.navigate(['/login']);
  
    }

}