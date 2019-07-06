import { Component } from '@angular/core';
import { OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from '../Customer';
import {OwnerService} from '../owner.service';
import { LoginComponent } from '../Login/login.component';
import { Owner } from '../Owner';
import { Product } from '../Product';
import { Orders } from '../Orders';
import {CustomerService} from '../customer.service'

@Component({
    selector: 'customerOrder-select',
    templateUrl: 'customerOrder.component.html',
    styleUrls: ['customerOrder.component.css'],
})


export class CustomerOrderComponent implements OnInit{
    
    constructor(private router: Router, private CustomerService: CustomerService) { }

username :String = JSON.parse(localStorage.getItem("username"));
customer : Customer = new Customer();
orderID;
productID;
numberOfPieces;
orders : Orders[];
products : Product[];

ngOnInit(): void
{
    this.getCustomer();
   this.listProducts();
}
   async  getCustomer(){
   await this.CustomerService.getCustomer(JSON.parse(localStorage.getItem("username"))).then((data: Customer) =>{this.customer = data});
   }
   createOrder(){
        this.CustomerService.createOrder(this.username+" "+this.numberOfPieces+" "+this.productID);
   }
   async listOrders(){
        await this.CustomerService.listOrders(this.username).then((data : Orders[]) => {this.orders = data});
   }
   async checkStatus(){
    await this.CustomerService.checkStatus(this.username+" "+this.orderID);

   }
   async listProducts(){

        await this.CustomerService.listProducts().then((data : Product[]) => {this.products = data});
   }

}