import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';
import {MatCardModule} from '@angular/material/card';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import {NgOptimizedImage} from "@angular/common";
import { RegisterComponent } from './components/register/register.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import {MatFormField} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {ChipsTagComponent} from "./components/register/chips-tag/chips-tag.component";
import {CardComponent} from "./components/home/card/card.component";
import { EditProfileComponent } from './components/edit-profile/edit-profile.component';
import {MatTab, MatTabGroup} from "@angular/material/tabs";
import { ChipSocialNetworkComponent } from './components/edit-profile/chip-social-network/chip-social-network.component';
import { AddSocialNetworkDialogComponent } from './components/edit-profile/add-social-network-dialog/add-social-network-dialog.component';
import {MatDialogModule} from "@angular/material/dialog";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {ReactiveFormsModule} from "@angular/forms";
import { ProfileComponent } from './components/profile/profile.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    RegisterComponent,
    CardComponent,
    EditProfileComponent,
    ProfileComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatCardModule,
    NgOptimizedImage,
    MatFormField,
    MatInput,
    ChipsTagComponent,
    MatTabGroup,
    MatTab,
    ChipSocialNetworkComponent,
    AddSocialNetworkDialogComponent,
    MatDialogModule,
    BrowserAnimationsModule,
    ReactiveFormsModule
  ],
  providers: [
    provideClientHydration(),
    provideAnimationsAsync(),
    provideAnimationsAsync('noop')
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
