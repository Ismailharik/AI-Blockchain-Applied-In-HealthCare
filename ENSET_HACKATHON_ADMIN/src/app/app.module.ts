import { APP_INITIALIZER, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavarBarComponent } from './home/components/navar-bar/navar-bar.component';
import { PatientListComponent } from './home/components/patient-list/patient-list.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PatientDetailsComponent } from './home/components/patient-details/patient-details.component';


@NgModule({
  declarations: [
    AppComponent,
    NavarBarComponent,
    PatientListComponent,
    PatientDetailsComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    
    
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
