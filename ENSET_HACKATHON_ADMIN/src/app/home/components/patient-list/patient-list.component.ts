import { Component, OnInit } from '@angular/core';
import { HomeService } from '../home.service';
import { Patient } from '../models/patient.model';

@Component({
  selector: 'app-patient-list',
  templateUrl: './patient-list.component.html',
  styleUrls: ['./patient-list.component.css']
})
export class PatientListComponent implements OnInit {

  constructor(private homeService:HomeService) { }
  patients!:Patient[]
  ngOnInit(): void {
    this.getAllWaitingPatients()
  }

  getAllWaitingPatients(){
    this.homeService.getWaitingPatients().subscribe({
      next: resp =>{
        console.log(resp);
        this.patients = resp
      },
      error: err =>{
        console.log(err);
        
      }
    })
  }
}
