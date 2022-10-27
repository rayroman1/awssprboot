import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-womensstore',
  templateUrl: './womensstore.component.html',
  styleUrls: ['./womensstore.component.css']
})
export class WomensstoreComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  username="";
  clearValue() {
    this.username="";
  }
  
}
