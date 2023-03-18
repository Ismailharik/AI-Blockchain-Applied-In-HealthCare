import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Diabets } from '../../models/diabets';
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
  diabets!: Diabets
  name: any;
  console: any;
  result!:number
  constructor(
    private homeService: HomeService,
    private fb: FormBuilder) { }

  ngOnInit(): void {
    this.initializeForm()
    this.initializeForm2()
  }

  initializeForm(patient?: Patient) {
    this.patientForm = this.fb.group({
      id: [patient?.id],
      fullName: [patient?.fullName],
      email: [patient?.email],
      phone: [patient?.phone],
      birthdate: [patient?.birthdate],
    })
  }
    initializeForm2(diabets ?: Diabets){
      this.analysisForm = this.fb.group({

        Pregnancies:[this.diabets?.Pregnancies],
        Glucose:[this.diabets?.Glucose],
        BloodPressure:[this.diabets?.BloodPressure],
        SkinThickness:[this.diabets?.SkinThickness],
        Insulin:[this.diabets?.Insulin],
        BMI:[this.diabets?.BMI],
        DiabetesPedigreeFunction:[this.diabets?.DiabetesPedigreeFunction],
        Age:[this.diabets?.Age],
      })
    }

    saveUpdate(){

      console.log(this.patientForm.value);
    }
    checkAnalysis(){
      console.log(this.analysisForm.value);
    this.homeService.checkAnaysis(this.analysisForm.value).subscribe({
      next: resp =>{
        console.log(resp);
        this.result= resp;
        if(this.result>0.5){
          alert("OMG YOU're affected by , the probability is : " +Math.round( this.result*100) )
        }{
          alert("Hopefully You're not Affected , the probability is : "+Math.round( this.result*100))
        }
      }
    })
    }
  }
