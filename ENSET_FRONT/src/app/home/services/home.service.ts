import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import {  Hyperglycemia } from '../models/Hyperglycemia';
import { Patient } from '../models/Patient';

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  checkAnaysis(diabets: Hyperglycemia):Observable<any> {
    const featuresData = [
      Number(diabets.pregnancies),
      Number(diabets.glucose),
      Number(diabets.bloodPressure),
      Number(diabets.skinThickness),
      Number(diabets.insulin),
      Number(diabets.bmi),
      Number(diabets.diabetesPedigreeFunction),
      Number(diabets.age)
    ];
  
    const data = {
      features: featuresData.map(Number)
    };
  
    const jsonData = JSON.stringify(data);
    console.log(jsonData);
    
    return this.httpClient.post<any>("http://localhost:5000/predict", jsonData);
  }
  
  saveUserAnalysis(hyperglycemia:Hyperglycemia) {
    return this.httpClient.post<Patient>(environment.host+"/hyperglycemia",hyperglycemia)
  }

  constructor(private httpClient:HttpClient) { 

  }
  savePatient(patient:Patient):Observable<Patient>{
    return this.httpClient.post<Patient>(environment.host+ "/patients", patient);
  }


}
