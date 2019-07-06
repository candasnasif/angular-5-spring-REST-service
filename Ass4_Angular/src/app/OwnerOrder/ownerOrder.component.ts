import { Component } from '@angular/core';
import { OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from '../Customer';
import {OwnerService} from '../owner.service';
import { LoginComponent } from '../Login/login.component';
import { Owner } from '../Owner';
import { Product } from '../Product';
import { Orders } from '../Orders';

@Component({
    selector: 'ownerOrder-select',
    templateUrl: 'ownerOrder.component.html',
    styleUrls: ['ownerOrder.component.css'],
})


export class OwnerOrderComponent implements OnInit{
    
constructor(private router: Router, private OwnerService: OwnerService) { }
owner : Owner = new Owner();
orders : Orders[];
orderID;
newStatus;
customerUserName;
customerOrders : Orders[];
 ngOnInit(): void
 {
     this.getOwner()
    
 }
    async  getOwner(){
    await this.OwnerService.getOwner(JSON.parse(localStorage.getItem("username"))).then((data: Owner) =>{this.owner = data});
    }
    async viewOrders(){
        await this.OwnerService.viewOrders(this.owner.username).then((data: Orders[]) =>{this.orders = data});
      
    }
    updateOrder(){
        this.OwnerService.updateOrder(this.newStatus +" " +this.orderID);
    }
    async viewCustomerOrderHistory(){
        await this.OwnerService.viewCustomerOrderHistory(this.customerUserName).then((data : Orders[]) => {this.customerOrders = data});
    }
}