import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { Http, Response } from '@angular/http';
import { User } from '../app/User';
import { Customer } from '../app/Customer';
import { Owner } from '../app/Owner';
import {Orders} from '../app/Orders';
import {Product} from '../app/Product';


import { Observable } from 'rxjs/Rx';
import  'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';

const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  @Injectable()
  export class CustomerService {
  
    private loginUrl : string = "/customer";
    constructor(private router: Router,private http : HttpClient) {
        
    }
    public getCustomer(username : String):Promise<Customer>{
        return this.http.post<Customer>(this.loginUrl+"/getCustomer",username).toPromise().then(function(data : Customer){
            return data;
       });
    }
    public createOrder(order){
        this.http.post(this.loginUrl+"/createOrder", order).subscribe(data => {alert("Order created successfully.")});
    }
    public checkStatus(order){
        this.http.post(this.loginUrl+"/checkStatus", order).subscribe((data : Orders) =>{alert("Order id : "+data.orderID+"\nProduct Name: "+data.product.productName+"\nStatus: " + data.status);});
    }
    public listProducts():Promise<Product[]>{
        return this.http.get<Product[]>(this.loginUrl+"/listProducts").toPromise().then(function(data : Product[]){
            return data;
       });
    }
    public listOrders(username : String):Promise<Orders[]>{
        return this.http.post<Orders[]>(this.loginUrl+"/listOrders",username).toPromise().then(function(data : Orders[]){
            return data;
       });
    }
    public updateInformation(customer){
        this.http.post<Customer>(this.loginUrl+"/updateInformation", customer).subscribe(data => {alert("Account updated successfully.")});
    }

}

