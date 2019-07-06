import { Component } from '@angular/core';
import { OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerService } from '../customer.service';
import { Customer } from '../Customer';

@Component({
    selector: 'customer-select',
    templateUrl: 'customer.component.html',
    styleUrls: ['customer.component.css'],
})


export class CustomerComponent implements OnInit{
    
    constructor(private router: Router, private CustomerService: CustomerService) { }
    customer : Customer = new Customer();

ngOnInit(): void
    {
        this.getCustomer();

    }

    async  getCustomer(){
        await this.CustomerService.getCustomer(JSON.parse(localStorage.getItem("username"))).then((data: Customer) =>{this.customer = data});
        }

}