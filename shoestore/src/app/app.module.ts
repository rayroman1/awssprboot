import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Routes, RouterModule } from '@angular/router'; 
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MensstoreComponent } from './mensstore/mensstore.component';
import { TitlebarComponent } from './titlebar/titlebar.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';
import { WomensstoreComponent } from './womensstore/womensstore.component';
import {HttpClientModule} from '@angular/common/http';
import { ConnectionService } from './connection.service';
import { FormsModule } from '@angular/forms';
const routes: Routes = [{path: 'mensstore', component: MensstoreComponent }];


@NgModule({
  declarations: [
    AppComponent,
    MensstoreComponent,
    TitlebarComponent,
    NavbarComponent,
   
    FooterComponent,
    WomensstoreComponent,
    
  ],
  imports: [
    HttpClientModule, 
    FormsModule,
    BrowserModule,
    AppRoutingModule,RouterModule.forRoot(routes)
    
  ],exports: [RouterModule],
  providers: [
    ConnectionService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
