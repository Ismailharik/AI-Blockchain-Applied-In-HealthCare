import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { HomeService } from '../home.service';
import { DiseaseHistory } from '../models/DiseaseHistory.model';
import { doctorReport } from '../models/doctorReport.model';
import { Hyperglycemia } from '../models/hyperglycemia.model';
import { Patient } from '../models/patient.model';

@Component({
  selector: 'app-patient-details',
  templateUrl: './patient-details.component.html',
  styleUrls: ['./patient-details.component.css']
})
export class PatientDetailsComponent implements OnInit {
  patientId!: number;
  patient!: Patient
  hyperglycemia!: Hyperglycemia
  DocterReportForm!: FormGroup
  diseaseHistory!:DiseaseHistory

  constructor(private route: ActivatedRoute,
    private homeService: HomeService,
    private fb: FormBuilder) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.patientId = params['id'];
      console.log(this.patientId); // this will log the patient id in the console
      this.getPatientDetails();

      
    });

  }
  getPatientDetails() {
    this.homeService.getPatientById(this.patientId).subscribe({
      next: resp => {
        this.patient = resp
        this.getPatientDiabeticAnalysis()
        this.getPatientHistory()
        this.inlitializeForm()
      },
      error: err => {
        console.log(err);
      }
    })
  }

  getPatientDiabeticAnalysis() {
    console.log(this.patient);
    console.log("call from get patient Analysis"+this.patient.blockChainId);
    
  
    this.homeService.getHyperglycemiaAnalysis(this.patient.blockChainId).subscribe({
      next: resp => {

        this.hyperglycemia = resp
        console.log(this.hyperglycemia);
        console.log("ddddd");
        
      },
      error: err => {
        console.log(err);
      }
    })
  }

  inlitializeForm(doctorReport?: doctorReport) {
    this.DocterReportForm = this.fb.group({
      // this data will be registred to the user block chain
      userId: this.patient.blockChainId,
      doctorName: [doctorReport?.doctorName],
      hospitalName: [doctorReport?.hospitalName],
      diseaseReport: [doctorReport?.diseaseReport],

    })
  }
  sumbmitDoctorReport() {
    console.log(this.DocterReportForm.value);
    console.log(this.diseaseHistory);
    this.homeService.saveDoctorReportOnBlockChain(this.DocterReportForm.value).subscribe({
      next : resp=>{
        alert("Doctor informations registred successfully ");
      },
      error : err=>{
        console.log(err);
      }
    })
    
  }

  // this method will get user history from the block chain 
  getPatientHistory(){
    this.homeService.getUserHistoryChain(this.patient.blockChainId).subscribe({
      next: resp =>{
        console.log("patient history call");
        console.log(resp);
        this.diseaseHistory = resp
      },
      error : err =>{
        console.log(err);
        
      }
    })
  }
}
