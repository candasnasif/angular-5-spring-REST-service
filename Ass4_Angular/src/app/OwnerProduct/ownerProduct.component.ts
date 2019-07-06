import { Component } from '@angular/core';
import { OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from '../Customer';
import {OwnerService} from '../owner.service';
import { LoginComponent } from '../Login/login.component';
import { Owner } from '../Owner';
import { Product } from '../Product';

@Component({
    selector: 'ownerProduct-select',
    templateUrl: 'ownerProduct.component.html',
    styleUrls: ['ownerProduct.component.css'],
})


export class OwnerProductComponent implements OnInit{
    
    constructor(private router: Router, private OwnerService: OwnerService) { }
    owner : Owner = new Owner();
    newProduct : string;
    productName ;
    delProductID ;
    upProductID ;
    upProductName ;
    products : Product[];
ngOnInit(): void
    {
        this.getOwner()
       
    }
    async  getOwner(){
         await this.OwnerService.getOwner(JSON.parse(localStorage.getItem("username"))).then((data: Owner) =>{this.owner = data});
    }
    createProduct(){
        
        this.OwnerService.createProduct(this.newProduct+" "+this.owner.id);
    }
    updateProduct(){
        this.OwnerService.updateProduct(this.upProductName +" " +this.upProductID);
    }
    deleteProduct(){
        this.OwnerService.deleteProduct(this.delProductID)
    }
    async listProducts(){
        await this.OwnerService.listProducts().then((data: Product[]) =>{this.products = data});
      
     }

}