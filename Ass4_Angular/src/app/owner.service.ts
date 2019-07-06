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
export class OwnerService {

    private loginUrl : string = "/owner";
    constructor(private router: Router,private http : HttpClient) {
        
    }

    public editCustomer(customer: Customer){
           this.http.post(this.loginUrl+"/editCustomer", customer).subscribe(data =>{alert("User updated successfully.");});
    }
    public listCustomers():Promise<Customer[]>{
            return this.http.get<Customer[]>(this.loginUrl+"/listCustomers").toPromise().then(function(data : Customer[]){
            return data;
       });
    }
    public getOwner(username : String):Promise<Owner>{
        return this.http.post<Owner>(this.loginUrl+"/getOwner",username).toPromise().then(function(data : Owner){
            return data;
       });
    }
    public createProduct(product ){
            this.http.post(this.loginUrl+"/createProduct", product).subscribe(data =>{alert("Product  created successfully.");});
    }
    public deleteProduct( product : String){
           this.http.post(this.loginUrl+"/deleteProduct", product).subscribe(data =>{alert("Product  deleted successfully.");});
    }
    public updateProduct( product : String){
        this.http.post(this.loginUrl+"/updateProduct", product).subscribe(data =>{alert("Product  updated successfully.");});
    }
    public listProducts():Promise<Product[]>{
        return this.http.get<Product[]>(this.loginUrl+"/listProducts").toPromise().then(function(data : Product[]){
        return data;
        });
    }
    public viewOrders( username ): Promise<Orders[]>{
        return this.http.post<Orders[]>(this.loginUrl+"/viewOrders",username).toPromise().then(function(data : Orders[]){
            return data;
        });
    }
    public updateOrder( order ){
        this.http.post(this.loginUrl+"/updateOrder", order).subscribe(data =>{alert("Order updated succesfully.");});
    }
    public viewCustomerOrderHistory(username):Promise<Orders[]>{
        return this.http.post<Orders[]>(this.loginUrl+"/viewCustomerOrderHistory", username).toPromise().then(function(data : Orders[]){
            return data;
        });
        
    }


}
