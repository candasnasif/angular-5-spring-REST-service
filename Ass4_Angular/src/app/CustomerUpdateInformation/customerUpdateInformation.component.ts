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
    selector: 'customerUpdateInformation-select',
    templateUrl: 'customerUpdateInformation.component.html',
    styleUrls: ['customerUpdateInformation.component.css'],
})


export class CustomerUpdateInformationComponent implements OnInit{
    
constructor(private router: Router, private CustomerService: CustomerService) { }
customer : Customer = new Customer();
updateCustomer : Customer = new Customer();
ngOnInit(): void
    {
        this.getCustomer();
    }
    async  getCustomer(){
        await this.CustomerService.getCustomer(JSON.parse(localStorage.getItem("username"))).then((data: Customer) =>{this.customer = data; this.updateCustomer.username = data.username;});
    }
    updateInformation(){
        this.CustomerService.updateInformation(this.updateCustomer);
    }
}