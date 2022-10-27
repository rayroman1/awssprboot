import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-mensstore',
  templateUrl: './mensstore.component.html',
  styleUrls: ['./mensstore.component.css']
})
export class MensstoreComponent implements OnInit {

  constructor() {}
  
  ngOnInit(): void {
    var greet: string = "Greetings";
    var geeks: string = "Man Town";
    console.log(greet + " from " + geeks);
}

 addNumbers(a: number, b: number)  {

  return a + b;
}




}