import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Hyperglycemia } from '../../models/Hyperglycemia';
import { Patient } from '../../models/Patient';
import { HomeService } from '../../services/home.service';

@Component({
  selector: 'app-appointment',
  templateUrl: './appointment.component.html',
  styleUrls: ['./appointment.component.css']
})
export class AppointmentComponent implements OnInit {
  patientForm!: FormGroup;
  analysisForm!: FormGroup;
  hyperglycemia!: Hyperglycemia
  name: any;
  console: any;

  // result of AI model
  result!: number
  showResult: boolean = false

  constructor(
    private homeService: HomeService,
    private fb: FormBuilder) { }

  ngOnInit(): void {
    this.initializeForm()
    this.initializeForm2()
  }

  initializeForm(patient?: Patient) {
    this.patientForm = this.fb.group({

      fullName: [patient?.fullName],
      email: [patient?.email],
      phone: [patient?.phone],
      birthdate: [patient?.birthdate],
      blockChainId: [patient?.blockChainId]
    })
  }
  initializeForm2(hyperglycemia?: Hyperglycemia) {
    this.analysisForm = this.fb.group({

      pregnancies: [this.hyperglycemia?.pregnancies],
      glucose: [this.hyperglycemia?.glucose],
      bloodPressure: [this.hyperglycemia?.bloodPressure],
      skinThickness: [this.hyperglycemia?.skinThickness],
      insulin: [this.hyperglycemia?.insulin],
      bmi: [this.hyperglycemia?.bmi],
      diabetesPedigreeFunction: [this.hyperglycemia?.diabetesPedigreeFunction],
      age: [this.hyperglycemia?.age],
      dateOfAnalysis: [this.hyperglycemia?.dateOfAnalysis],
      patientBlockChainId: [this.hyperglycemia?.patientBlockChainId],
      outcome: [this.hyperglycemia?.outcome]
    })
  }

  savePatient() {
    console.log(this.patientForm.value);
    console.log(this.analysisForm.value);
    this.analysisForm.value.patientBlockChainId = this.patientForm.value.blockChainId
    this.homeService.savePatient(this.patientForm.value).subscribe({
      next: resp => {
        console.log(resp);
        this.saveAnalysis()
      },error : err=>{
        console.log(err);
        
      }
    })
    

  }
  saveAnalysis() {
    console.log("Save Analysis method called ");
    // console.log(this.analysisForm.value);
    
    this.homeService.saveUserAnalysis(this.analysisForm.value).subscribe({
      next: resp => {
        console.log(resp);
        alert("Your information registred successfully")
      }
    })
    //NOW I SHOULD SAVE DATA IN DB
  }
  checkAnalysis() {
    // console.log(this.analysisForm.value);
    this.homeService.checkAnaysis(this.analysisForm.value).subscribe({
      next: (resp) => {
        this.result = parseFloat(resp[0][0])
        console.log(this.result);
        this.showResult = true
        this.analysisForm.value.outcome = this.result // if the result of the AI model > 0.5 then the user is affected which mean outcome =1

      }
    })
  }
}
