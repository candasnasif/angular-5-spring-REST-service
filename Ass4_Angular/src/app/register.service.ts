import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { Http, Response } from '@angular/http';
import { User } from '../app/User';
import { Customer } from '../app/Customer';
import { Owner } from '../app/Owner';


import { Observable } from 'rxjs/Rx';
import  'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';

const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

@Injectable()
export class RegisterService {

    private loginUrl : string = "/register";
    constructor(private router: Router,private http : HttpClient) {
        
    }
        public customerRegister( customer :Customer )  {
            console.log(customer);
             this.http.post(this.loginUrl+"/customerRegister", customer).subscribe(data =>{alert("User "+customer.username+" created successfully.");});
        }
        public ownerRegister( owner : Owner )  {
            this.http.post(this.loginUrl+"/ownerRegister", owner).subscribe(data =>{alert("User "+owner.username+" created successfully.");});
       }
    


}
