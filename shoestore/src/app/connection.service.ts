import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';

import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ConnectionService {

  apiUrl : string = 'http://Springdemo-env.eba-ubi6qqji.us-east-2.elasticbeanstalk.com';/**'http://localhost:5000/';*/ /**ROute 53 dns name */
  headers = new HttpHeaders().set('Content-Type', 'application/json');


  constructor(private http: HttpClient) { }

  printtoConsole(arg: any)
  {
    console.log(arg);
  }

  list() {
    return this.http.get(`${this.apiUrl}`);
 }

 getPosts(){
  return this.http.get(this.apiUrl);
}


}
