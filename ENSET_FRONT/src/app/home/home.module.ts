import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ContactComponent } from './components/contact/contact.component';
import { AboutComponent } from './components/about/about.component';
import { AppointmentComponent } from './components/appointment/appointment.component';
import { DoctorsSectionComponent } from './components/doctors-section/doctors-section.component';
import { GalleryComponent } from './components/gallery/gallery.component';
import { DepartmentsComponent } from './components/departments/departments.component';
import { TestimonialsComponent } from './components/testimonials/testimonials.component';
import { WhySectionComponent } from './components/why-section/why-section.component';
import { ServicesComponent } from './components/services/services.component';
import { CountsSectionComponent } from './components/counts-section/counts-section.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';



@NgModule({
  declarations: [
    ContactComponent,
    AboutComponent,
    AppointmentComponent,
    DoctorsSectionComponent,
    GalleryComponent,
    DepartmentsComponent,
    TestimonialsComponent,
    WhySectionComponent,
    ServicesComponent,
    CountsSectionComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    HttpClientModule,
    BrowserModule,
    ReactiveFormsModule
  ],
  exports: [
    ContactComponent,
    AboutComponent,
    AppointmentComponent,
    DoctorsSectionComponent,
    GalleryComponent,
    DepartmentsComponent,
    TestimonialsComponent,
    WhySectionComponent,
    ServicesComponent,
    CountsSectionComponent
  ]
})
export class HomeModule { }
