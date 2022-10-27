import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { ConnectionService } from './connection.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'shoestore';
  posts:any;
  constructor( private svc: ConnectionService, private http: HttpClient)//private 
  {
this.svc.printtoConsole("Services");
    
  }

  ngOnInit()
  {
   let obs=this.http.get('https://api.github.com/users/koushikkothagal');
   obs.subscribe((response) => console.log(response));
   
   
   this.svc.getPosts()
   .subscribe(response => {
     this.posts = response;
   });


  }
}
