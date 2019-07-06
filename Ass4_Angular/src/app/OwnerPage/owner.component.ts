import { Component } from '@angular/core';
import { OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OwnerService } from '../owner.service';
import { Owner } from '../Owner';

@Component({
    selector: 'owner-select',
    templateUrl: 'owner.component.html',
    styleUrls: ['owner.component.css'],
})


export class OwnerComponent implements OnInit{
    
constructor(private router: Router, private OwnerService: OwnerService) { }
owner : Owner = new Owner();

ngOnInit(): void
    {
        this.getOwner()
    }
    async  getOwner(){
        await this.OwnerService.getOwner(JSON.parse(localStorage.getItem("username"))).then((data: Owner) =>{this.owner = data});
        }
}