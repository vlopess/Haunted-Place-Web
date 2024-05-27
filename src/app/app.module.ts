import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';
import {MatCardModule} from '@angular/material/card';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { CardComponent } from './components/home/card/card.component';
import {NgOptimizedImage} from "@angular/common";
import { RegisterComponent } from './components/register/register.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import {MatFormField} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {ChipsTagComponent} from "./components/register/chips-tag/chips-tag.component";

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    CardComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatCardModule,
    NgOptimizedImage,
    MatFormField,
    MatInput,
    ChipsTagComponent
  ],
  providers: [
    provideClientHydration(),
    provideAnimationsAsync(),
    provideAnimationsAsync('noop')
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
