import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomerComponent }   from './CustomerPage/customer.component';
import { OwnerComponent }   from './OwnerPage/owner.component';
import { LoginComponent }   from './Login/login.component';
import {CustomerRegisterComponent} from './CustomerRegister/customerRegister.component';
import {OwnerRegisterComponent} from './OwnerRegister/ownerRegister.component';
import {OwnerOrderComponent} from './OwnerOrder/ownerOrder.component';
import {OwnerProductComponent} from './OwnerProduct/ownerProduct.component';
import {OwnerCustomerComponent} from './OwnerCustomer/ownerCustomer.component';
import {CustomerOrderComponent} from './CustomerOrder/customerOrder.component';
import {CustomerUpdateInformationComponent} from './CustomerUpdateInformation/customerUpdateInformation.component'

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login',  component: LoginComponent },
  { path: 'customer',  component: CustomerComponent },
  { path: 'owner',  component: OwnerComponent },
  {path: 'customerRegister', component : CustomerRegisterComponent},
  {path: 'ownerRegister', component : OwnerRegisterComponent},
  {path: 'ownerOrder', component : OwnerOrderComponent},
  {path: 'ownerProduct', component : OwnerProductComponent},
  {path : 'ownerCustomer', component : OwnerCustomerComponent},
  {path : 'customerOrder', component : CustomerOrderComponent},
  {path : 'customerUpdateInformation', component : CustomerUpdateInformationComponent},
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})

export class AppRoutingModule {}