import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule }   from '@angular/forms';
import { HttpModule }    from '@angular/http';
import { JsonpModule }    from '@angular/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";

import { CustomerComponent }  from './CustomerPage/customer.component';
import { LoginComponent }  from './Login/login.component';
import { OwnerComponent }  from './OwnerPage/owner.component';
import { LoginService } from './login.service';
import {CustomerRegisterComponent} from './CustomerRegister/customerRegister.component';
import {OwnerRegisterComponent} from './OwnerRegister/ownerRegister.component';
import { RegisterService } from './register.service';
import {OwnerOrderComponent} from './OwnerOrder/ownerOrder.component';
import {OwnerProductComponent} from './OwnerProduct/ownerProduct.component';
import {OwnerCustomerComponent} from './OwnerCustomer/ownerCustomer.component';
import {OwnerService} from './owner.service';
import{CustomerService} from './customer.service'
import {CustomerOrderComponent} from './CustomerOrder/customerOrder.component';
import {CustomerUpdateInformationComponent} from './CustomerUpdateInformation/customerUpdateInformation.component'
@NgModule({
  declarations: [
    AppComponent,
    CustomerComponent,
    LoginComponent,
    OwnerComponent,
    CustomerRegisterComponent,
    OwnerRegisterComponent,
    OwnerOrderComponent,
    OwnerProductComponent,
    OwnerCustomerComponent,
    CustomerOrderComponent,
    CustomerUpdateInformationComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    HttpModule,
    JsonpModule,
    AppRoutingModule
  ],
  providers: [LoginService,RegisterService,OwnerService,CustomerService],
  bootstrap: [AppComponent]
})
export class AppModule { }



