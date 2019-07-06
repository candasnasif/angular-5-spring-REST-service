import { Component,  Injectable } from '@angular/core';
import { OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {LoginService} from "../login.service";
import { User } from '../User';
import { HttpEventType } from '@angular/common/http';

@Component({
    selector: 'login-select',
    templateUrl: 'login.component.html',
    styleUrls: ['login.component.css'],
})

export class LoginComponent {
    
    user: User = new User();
    account: User;
 constructor(private router: Router, private loginService:LoginService) { }
  
    
    async login() {
        this.account = await this.loginService.authenticator(this.user);
        localStorage.setItem("username", JSON.stringify(this.account.username));

        if(this.account == null){
            this.router.navigate(['/login']);
        }
        else if (this.account.role.role == "customer") {
            this.router.navigate(['/customer']);
        } else  if(this.account.role.role == "owner"){
            this.router.navigate(['/owner']);
        }
     
    
        
    }

}