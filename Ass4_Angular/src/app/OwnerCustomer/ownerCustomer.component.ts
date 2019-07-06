import { Component, OnInit } from '@angular/core';
import { OnChanges } from '@angular/core';
import { Router } from '@angular/router';
import {RegisterService} from '../register.service';
import { Customer } from '../Customer';
import {OwnerService} from '../owner.service';
import { Owner } from '../Owner';

@Component({
    selector: 'ownerCustomer-select',
    templateUrl: 'ownerCustomer.component.html',
    styleUrls: ['ownerCustomer.component.css'],
})


export class OwnerCustomerComponent  implements OnInit{
    
    constructor(private router: Router, private RegisterService:RegisterService, private OwnerService: OwnerService) { }
    newCustomer : Customer  = new Customer();   
    editCustomer : Customer  = new Customer();   
    customers : Customer[];
    owner : Owner = new Owner();
    ngOnInit(): void
    {
        this.getOwner()
       
    }

    async  getOwner(){
        await this.OwnerService.getOwner(JSON.parse(localStorage.getItem("username"))).then((data: Owner) =>{this.owner = data});
   }
    
    customerRegister() {
        this.RegisterService.customerRegister(this.newCustomer);   
   }
   updateCustomer(){
        this.OwnerService.editCustomer(this.editCustomer);
        this.router.navigate(['/ownerCustomer'])
   }
   async listCustomers(){
      await this.OwnerService.listCustomers().then((data: Customer[]) =>{this.customers = data});
    
   }


}