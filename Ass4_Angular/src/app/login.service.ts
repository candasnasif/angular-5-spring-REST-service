import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { Http, Response } from '@angular/http';
import { User } from '../app/User';
import { Observable } from 'rxjs/Rx';
import  'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';

const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

@Injectable()
export class LoginService {

    private loginUrl : string = "/login";
    
    constructor(private router: Router,private http : HttpClient) {
        
    }
        public authenticator( user  ) : Promise<User> {

            return this.http.post(this.loginUrl+"/auth", user).toPromise().then(function(data : User){
                 return data;
            });
            
        }


}
